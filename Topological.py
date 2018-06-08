def Util(s,visited):
	visited[s] = True
	for i in range(len(L)):
		if L[s][i] and not visited[i]:
			Util(i,visited)
	S.insert(0,s)		


def T_sort():
	visited = [False]*(len(L))
	for i in range(len(L)):
		if not visited[i]:
			Util(i,visited)


n = int(input("Number of vertices : "))
L = []
print("Enter adjacency matrix...")
for i in range(n):
	L.append([])
	for j in range(n):
		L[i].append(int(input()))
S = []
T_sort()
print(S)