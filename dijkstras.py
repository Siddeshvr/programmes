def Util(distance,sptSet):
	min = 999
	for i in range(n):
		if not sptSet[i] and distance[i]<min:
			min = distance[i]
			min_index = i
	return min_index      #Return next minimum vertex...

def Dijkstras(s):
	sptSet = [False]*(n)
	distance = [999]*(n)        
	distance[s] = 0         #Distance of source vertex is 0...     

	for count in range(n-1):   #till we meet n-1 edges...
		u = Util(distance,sptSet)
		sptSet[u] = True
		for i in range(n):
			if L[u][i] and not sptSet[i] and distance[i] > distance[u]+L[u][i]:
				distance[i] = distance[u]+L[u][i]
	Print(distance)			
 
def Print(distance):
	print("Vertex distance from source...")
	for i in range(n):
		print(0," to ",i," is ",distance[i])     #distance from source vertex(0) to all other vertices...

L = []
n = int(input("Enter number of vertices : "))
for i in range(n):
	L.append([])
	for j in range(n):
		L[i].append(int(input()))
Dijkstras(int(input("Enter source vertex : ")))
