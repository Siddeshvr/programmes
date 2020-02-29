from scipy.spatial import distance
from imutils import face_utils
from imutils.video import VideoStream
from threading import Thread
import playsound
import argparse
import imutils
import dlib
import cv2
import pyglet
import time
import numpy as np
import warnings


# To connect .py and .js files...
import os,sys,signal
import time
import csv
pid = os.getpid()
with open('pid.csv','w',newline='\n') as csvfile:
    wr = csv.writer(csvfile)
    wr.writerow(['WORK1',pid])




thresh = 0.25
frame_check = 10
detector= dlib.get_frontal_face_detector()
predictor= dlib.shape_predictor("68_face_landmarks.dat")# Dat file is the crux of the code


# construct the argument parse and parse the arguments
ap = argparse.ArgumentParser()
ap.add_argument("-a", "--alarm", type=str, default="alarm.wav",help="./alarm.wav")
ap.add_argument("-w", "--webcam", type=int, default=0,help="index of webcam on system")
args = vars(ap.parse_args())
#print(args)



# play an alarm sound...
def sound_alarm(path):
    music = pyglet.resource.media('alarm.wav')
    music.play()
    pyglet.app.run()


#to compute the ratio of distances between the vertical eye landmarks and the distances between the horizontal eye landmarks...
def eye_aspect_ratio(eye):
    A = distance.euclidean(eye[1], eye[5])
    B = distance.euclidean(eye[2], eye[4])
    C = distance.euclidean(eye[0], eye[3])
    ear = (A + B) / (2.0 * C)
    return ear

def get_landmarks(im):
    warnings.simplefilter(action='ignore', category=FutureWarning)
    rects = detector(im, 1)
    if len(rects) > 1:
        return "error"
    if len(rects) == 0:
        return "error"
    return np.matrix([[p.x, p.y] for p in predictor(im, rects[0]).parts()])

def annotate_landmarks(im, landmarks):
    im = im.copy()
    for idx, point in enumerate(landmarks):
        pos = (point[0, 0], point[0, 1])
        cv2.putText(im, str(idx), pos,
                    fontFace=cv2.FONT_HERSHEY_SCRIPT_SIMPLEX,
                    fontScale=0.4,
                    color=(0, 0, 255))
        cv2.circle(im, pos, 3, color=(0, 255, 255))
    return im

def top_lip(landmarks):
    top_lip_pts = []
    for i in range(50,53):
        top_lip_pts.append(landmarks[i])
    for i in range(61,64):
        top_lip_pts.append(landmarks[i])
    top_lip_all_pts = np.squeeze(np.asarray(top_lip_pts))
    top_lip_mean = np.mean(top_lip_pts, axis=0)
    return int(top_lip_mean[:,1])

def bottom_lip(landmarks):
    bottom_lip_pts = []
    for i in range(65,68):
        bottom_lip_pts.append(landmarks[i])
    for i in range(56,59):
        bottom_lip_pts.append(landmarks[i])
    bottom_lip_all_pts = np.squeeze(np.asarray(bottom_lip_pts))
    bottom_lip_mean = np.mean(bottom_lip_pts, axis=0)
    return int(bottom_lip_mean[:,1])

def mouth_open(image):
    landmarks = get_landmarks(image)
    
    if landmarks == "error":
        return image, 0
    
    image_with_landmarks = annotate_landmarks(image, landmarks)
    top_lip_center = top_lip(landmarks)
    bottom_lip_center = bottom_lip(landmarks)
    lip_distance = abs(top_lip_center - bottom_lip_center)
    return image_with_landmarks, lip_distance

yawns = 0
yawn_status = False 

(lStart, lEnd) = face_utils.FACIAL_LANDMARKS_68_IDXS["left_eye"]
(rStart, rEnd) = face_utils.FACIAL_LANDMARKS_68_IDXS["right_eye"]
cap=cv2.VideoCapture(0)
time.sleep(1.0)
flag=0
ALARM_ON = False

while True:
    ret, frame=cap.read()
    frame = imutils.resize(frame, width=450)
    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
    subjects = detector(gray, 0)
    image_landmarks, lip_distance = mouth_open(frame)
    
    prev_yawn_status = yawn_status  
    
    if lip_distance > 20:
        yawn_status = True 
        #print("Yawn")
        cv2.putText(frame, "Subject is Yawning", (50,450), 
                    cv2.FONT_HERSHEY_COMPLEX, 1,(0,0,255),2)
        
    else:
        yawn_status = False 
         
    if prev_yawn_status == True and yawn_status == False:
        yawns += 1

    for subject in subjects:
        shape = predictor(gray, subject)
        shape = face_utils.shape_to_np(shape)#converting to NumPy Array
        leftEye = shape[lStart:lEnd]
        rightEye = shape[rStart:rEnd]
        leftEAR = eye_aspect_ratio(leftEye)
        rightEAR = eye_aspect_ratio(rightEye)
        ear = (leftEAR + rightEAR) / 2.0
        leftEyeHull = cv2.convexHull(leftEye)
        rightEyeHull = cv2.convexHull(rightEye)
        cv2.drawContours(frame, [leftEyeHull], -1, (0, 255, 0), 1)
        cv2.drawContours(frame, [rightEyeHull], -1, (0, 255, 0), 1)
        if ear < thresh:
            flag += 1
            if flag >= frame_check:
                if not ALARM_ON:
                    ALARM_ON = True
                    if args["alarm"] != "":
                        print("Alarm")
                        t = Thread(target=sound_alarm,args=(args["alarm"],))
                        t.deamon = True
                        t.start()

                cv2.putText(frame, "****************ALERT!****************", (10, 30),
                    cv2.FONT_HERSHEY_SIMPLEX, 0.7, (0, 0, 0), 2)
                #cv2.putText(frame, "****************ALERT!****************", (10,325),
                    #cv2.FONT_HERSHEY_SIMPLEX, 0.7, (0, 0, 0), 2)
        else:
            flag = 0
            ALARM_ON = False
    cv2.imshow("Frame", frame)
    cv2.imshow('Live Landmarks', image_landmarks )
    key = cv2.waitKey(1) & 0xFF
    if key == ord("q"):
        break

cap.release()
cv2.destroyAllWindows()
