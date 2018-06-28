def Bellman(s):
    dist = [999]*(n)
    dist[s] = 0
    for i in range(n-1):
        for u in range(n):
            for v in range(n):
                if dist[v] > dist[u]+L[u][v]:
                    dist[v] = dist[u]+L[u][v]
        
    for u in range(n):
        for v in range(n):
            if dist[v] > dist[u]+L[u][v]:
                #dist[v] = dist[u]+L[u][v]
                print("Found -ve cycle")

    for i in range(n):
        print(i , " -- " ,dist[i])


L = []
n = int(input("Enter n value : "))
print("Enter adj_matrix : ")
for i in range(n):
    L.append([])
    for j in range(n):
        L[i].append(int(input()))
s = int(input("Enter a source vertex : ")) 
Bellman(s)

