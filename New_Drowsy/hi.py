import os,sys,signal
import time
import csv
pid = os.getpid()
with open('pid.csv','w',newline='\n') as csvfile:
    wr = csv.writer(csvfile)
    wr.writerow(['WORK1',pid])
while(True):
    print(1)
    time.sleep(1)
