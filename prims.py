def Util(key,mstSet):
	min = 999
	for i in range(n):
		if not mstSet[i] and key[i]<min:
			min = key[i]
			min_index = i
	return min_index      #Return next minimum vertex...

def Prims():
	key = [999]*(n)
	mstSet = [False]*(n)
	parent = [0]*(n)
	key[0] = 0         #distance of starting vertex is 0...
	parent[0] = -1     #parent of starting vertex is -1...

	for count in range(n-1):   #till we meet n-1 edges...
		u = Util(key,mstSet)
		mstSet[u] = True
		for i in range(n):
			if L[u][i] and not mstSet[i] and L[u][i]<key[i]:
				parent[i] = u
				key[i] = L[u][i]
	Print(parent)			
 
def Print(parent):
	print(" Edge     Weight")
	for i in range(1,n):
		print(parent[i],"---",i,"   ",L[i][parent[i]])

L = []
n = int(input("Enter number of vertices : "))
for i in range(n):
	L.append([])
	for j in range(n):
		L[i].append(int(input()))
Prims()
