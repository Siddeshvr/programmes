import queue

def DF_search(s,G):

	v = [False]*(len(G))              #Initializing all nodes as unvisited...

	L = []
	v[s] = 1
	L.append(s)
	while L :
		x = L.pop(len(L)-1)
		print(x)
		for i in range(len(G)):
			if G[x][i] == 1 and v[i] == 0:
				v[i] = 1
				L.append(i)	


def BF_search(s,G):
	v = [False]*(len(G))          #Initializing all nodes as unvisited...

	L = []
	v[s] = 1
	L.append(s)
	while L :
		x = L.pop(0)
		print(x)
		for i in range(len(G)):
			if G[x][i] == 1 and v[i] == 0:
				v[i] = 1
				L.append(i)	
		

G = [[0,1,1,0],[0,0,1,0],[1,0,0,1],[0,0,0,1]]
s = 2
print("BFS traversal is")
BF_search(s,G)	
print("DFS traversal is")
DF_search(s,G)