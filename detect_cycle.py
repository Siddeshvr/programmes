def DFS(s):
    visited = [False]*(n)
    visited[s]=True
    stack = []
    S = []
    stack.append(s) 
    S.append(s)
    while stack:
        x = stack.pop(len(stack)-1)
        print(x)
        for v in range(n):
            if L[x][v]:
                if v in S:              #If visiting vertex is already in S , cycle present...
                    return True
                elif not visited[v]:
                    visited[v] = True
                    stack.append(v) 
                    S.append(s)
    return False

L = []
n = int(input("Enter n value : "))
print("Enter a adj_matrix :")
for i in range(n):
    L.append([])
    for j in range(n):
        L[i].append(int(input()))

s = int(input("Enter starting vertex : ")) 
if DFS(s):
    print("Present")
else:
    print("Not present")
