def distance(A,i,j):
	return ((A[i][0]-A[j][0])**2 + (A[i][1]-A[j][1])**2)**(1/2)        #distance formula...

def Min(x,y):
	return x if x<y else y        #return minimum...

def partition(A,l,h,k):        #Utility function for Quick_sort...
	pivot = A[l][k]
	i = l+1
	j = h
	while i<j:
		while A[i][k]<pivot and i<j:
			i += 1
		while A[j][k]>pivot:
			j -= 1
		if i<j:
			A[i],A[j] = A[j],A[i]
	A[j],A[l] = A[l],A[j]
	return i-1

def Sorting(A,l,h,k):     # k indicates sort according to x or y co-ordinates...
	if l<h:
		p = partition(A,l,h,k)
		Sorting(A,l,p-1,0)
		Sorting(A,p+1,h,0)


def Strip_closest(Strip,d):       #processing Strip...
	min = d
	Sorting(Strip,0,len(Strip)-1,1)    #Sorting according to y co-ordinate...
	for i in range(len(Strip)):
		for j in range(i+1,len(Strip)):
			dis = distance(Strip,i,j)
			if (Strip[j][1] - Strip[i][1]) < min  and  dis < min:
				min = dis
	return min				


def Brute_force(A):    #Selection sort method...
	dmin = 100         #like Infinite...
	for i in range(n-1):
		for j in range(i+1,n):
			d = distance(A,i,j)
			if d<dmin:
				dmin = d
	return dmin

def closest_pair(A,n):
	if n<=3:
		return Brute_force(A)

	mid = n//2
	midpoint = A[mid]
	dl = closest_pair(A,mid)
	dr = closest_pair(A,n-mid)
	d = Min(dl,dr)
	Strip = []
	for i in range(n):
		if abs(A[i][0] - midpoint[0]) < d:
			Strip.append(A[i])

	return Min(d,Strip_closest(Strip,d))
		


L = []
n = int(input("Number of vertices : "))
print("Enter ",str(n)," axis...	")
for i in range(n):
	L.append([])
	for j in range(2):
		L[i].append(int(input()))
Sorting(L,0,n-1,0)
Minimum_distance = closest_pair(L,n)
print("Minimum_distance is ",Minimum_distance)