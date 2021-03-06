import pygame,sys           #importing files...
import random

pygame.init()         # Initiating pygame...
clock = pygame.time.Clock()

screen = pygame.display.set_mode((800,800),0,32)      #creating screen...
pygame.display.set_caption("Heap Sort")
font = pygame.font.SysFont('Times new Roman',30)      #font to insert value inside circle..."Times new Roman" is a font name...

#Module to draw a circle...
def drawcircle(x,y,color):
	pygame.draw.circle(screen,color,[x,y],20)
	
#module to insert a specified value to specified circle...
def value(i,a,b):
	x = font.render(str(i) , 1 , (0,0,128))       #insertin value...
	screen.blit(x , (a,b))						  #pygame renders text as image...so need to blit...
	
#Creating branches between two nodes...
def drawline(a,b,x,y):
	pygame.draw.lines(screen,(255,255,255),False,[(a,b),(x,y)],1)

	
#Module to create full tree...
def create_tree(L,m,a,b):
	for i in range(m):
		if L[i]==a or L[i]==b:
			drawcircle(A[i][0] , A[i][1] , (255,105,180))
		else:
			drawcircle(A[i][0] , A[i][1] , (255,255,255))
		value(L[i] , A[i][0]-12 , A[i][1]-13)
	k = 1
	i = 0
	while i<10 and k < m:
		j = 0
		while j<2 and k<m:
			drawline(A[i][0],A[i][1] , A[k][0],A[k][1])
			k += 1
			j += 1
		i += 1



def Heapsort(L,n,m):
	for i in range(int(m/2-1),-1,-1):
		clock.tick(0.5)
		max_heapify(L,m,i)
		clock.tick(0.5)

	for i in range(n-1,-1,-1):
		screen.fill((0,0,0))
		pygame.display.update()
		L[0],L[i] = L[i],L[0]        #Swapping root node and last leaf...
		create_tree(L,m,L[0],L[i])
		pygame.display.update()
		clock.tick(0.5)
		max_heapify(L,i,0)
		m = m-1
		create_tree(L,m,1000,2000)
		pygame.display.update()
		clock.tick(0.5)


def max_heapify(L,m,i):
	largest = i
	l = 2*i +1
	r = 2*i +2
	if l<m and L[l]>L[largest]:
		largest = l
	if r<m and L[r]>L[largest]:
		largest = r

	if largest != i:
		clock.tick(0.5)
		L[i],L[largest] = L[largest],L[i]
		screen.fill((0,0,0))
		max_heapify(L,m,largest)
		create_tree(L,m,L[i],L[largest])
		pygame.display.update()
		clock.tick(0.5)



def coordinates():
	B = []
	x = 400
	a = x
	b = x
	k = 1
	y = 1
	for i in range(n):
		for j in range(k):
			B.append(a)
			B.append(b)
			x = int(B[0]/(k*2))
			a = B[y-1]
			b = a+x
			a = a-x
			y = y+1
		k = k*2
		if B[1]==B[0]:     #Pop only 2nd element...
			B.pop(1)

	R = []
	a = 50
	k = 1
	for i in range(n):
		for j in range(k):
			R.append(a)
		a += 150	
		k = k*2

	A = []
	for i in range(n):
		A.append([])
		A[i].append(B[i])
		A[i].append(R[i])
	return A


L = []

n = int(input("Number of elements\n"))
A = coordinates()

for i in range(n):
	L.append(random.randrange(1,100))    #Random generation of input...
m = len(L)
create_tree(L,len(L),1000,2000)
pygame.display.update()
Heapsort(L,n,m)
screen.fill((0,0,0))
pygame.display.update()
print("Press (X) mark in the pygame window to exit")


while True:
	for event in pygame.event.get():
		if event.type == pygame.QUIT :  #when closing window...
			pygame.quit(); sys.exit(); #To exit from pygame window...
