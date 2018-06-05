import pygame,sys           #importing files...
from pygame.locals import *

pygame.init()         # Initiating pygame...

screen = pygame.display.set_mode((800,600),0,32)      #creating screen...
pygame.display.set_caption("Heap Sort")
font = pygame.font.SysFont('Times new Roman',18)      #font to insert value inside circle...

#Module to draw a circle...
def drawcircle(a,b):
	pygame.draw.circle(screen,(255,255,255),[a,b],20)
	
#module to insert a specified value to specified circle...
def value(i,a,b):
	x = font.render(str(i) , 1 , (0,0,128))
	screen.blit(x , (a,b))
	
#Creating branches between two nodes...
def drawline(a,b,x,y):
	pygame.draw.lines(screen,(255,255,255),False,[(a,b),(x,y)],1)

	
#Module to create full tree...
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




def Heapsort(L,n):
	for i in range(int(n/2-1),-1,-1):
		max_heapify(L,n,i)

	for i in range(n-1,-1,-1):
		L[0],L[i] = L[i],L[0]
		max_heapify(L,i,0)
		create_tree(L,n)
		pygame.display.update()

def max_heapify(L,n,i):
	largest = i
	l = 2*i +1
	r = 2*i +2
	if l<n and L[l]>L[largest]:
		largest = l
	if r<n and L[r]>L[largest]:
		largest = r

	if largest != i:
		L[i],L[largest] = L[largest],L[i]
		max_heapify(L,n,largest)
		create_tree(L,n)
		pygame.display.update()



L = []
n = int(input("Number of elements\n"))
print("Enter ",str(n)," elements : ")
for i in range(n):
	L.append(int(input()))
create_tree(L,len(L))
pygame.display.update()
Heapsort(L,n)
print("Exit from Pygame window")

while True:
	for event in pygame.event.get():
		if event.type == pygame.QUIT:
			pygame.quit(); sys.exit(); #To exit from pygame window...

