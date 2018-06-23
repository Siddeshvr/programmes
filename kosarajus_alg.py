def DFS(X,s):
    visited = [False]*(n)
    visited[s] = True
    stack = []
    stack.append(s)
    while stack:
        x = stack.pop(len(stack)-1) #Because its DFS traversal...
        #print(x)
        for v in range(n):
            if X[x][v] and not visited[v]:
                visited[v] = True
                stack.append(v)
    for i in range(n):          #Checking for connectivity...
        if visited[i] != True:
            return False
    return True                #Strongly connected...

L = []
n = int(input("Enter n value : "))
print("Enter adj_matrix : ")
for i in range(n):
    L.append([])
    for j in range(n):
        L[i].append(int(input()))
#print(L)
a = DFS(L,0)

A = []       #Transpose of L...
u = n-1
for i in range(n):
    A.append([])
    v = n-1
    for j in range(n):
        A[i].append(L[u][v])
        v -= 1
    u -= 1    
#print(A)
b = DFS(A,0)
print(a,"First\n")
print(b,"second\n")
if a==True and b==True:
    print("Yes")      #Strongly connected...
else:
    print("No")       #Not strongly connected...