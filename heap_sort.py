import pygame,math,sys
from pygame.locals import *

pygame.init()

screen = pygame.display.set_mode((800,600),0,32)
pygame.display.set_caption("Heap Sort")
font = pygame.font.SysFont('Times new Roman',18)


def drawcircle(a,b):
	pygame.draw.circle(screen,(255,255,255),[a,b],20)
	

def value(i,a,b):
	x = font.render(str(i) , 1 , (0,0,128))
	screen.blit(x , (a,b))
	

def drawline(a,b,x,y):
	pygame.draw.lines(screen,(255,255,255),False,[(a,b),(x,y)],1)
	

def create_tree(L,n):
	A = [[400,50],[250,200],[550,200],[175,350],[325,350],[475,350],[625,350],[137,500],[213,500],[287,500],[363,500],[437,500]]
	for i in range(n):
		drawcircle(A[i][0] , A[i][1])
		value(L[i] , A[i][0]-8 , A[i][1]-8)
	k = 1
	i = 0
	while i<10 and k < n:
		j = 0
		while j<2 and k<n:
			drawline(A[i][0],A[i][1] , A[k][0],A[k][1])
			k += 1
			j += 1
		i += 1

L = []
n = int(input("Number of elements\n"))
print("Enter ",str(n)," elements : ")
for i in range(n):
	L.append(int(input()))
create_tree(L,len(L))
pygame.display.update()
print("Exit from Pygame window")

while True:
	for event in pygame.event.get():
		if event.type == pygame.QUIT:
			pygame.quit(); sys.exit();

