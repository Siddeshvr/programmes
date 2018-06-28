def find(x):
    while(parent[x]!= 'a'):
        x = parent[x]
    return x

def merge(x,y):
    if x != y:        #if x==y which forms cycle...
        parent[y] = x
        return True
    return False

def Kruskal():
    min_cost = 0
    for k in range(n):  #choosing n-1 edges...
        min = 999
        for i in range(n):
            for j in range(n):
                if L[i][j] < min:
                    min = L[i][j]
                    a = u = i
                    b = v = j
        
        u = find(u)
        v = find(v)
        if(merge(u,v)):
            print(chr(a+97),"--",chr(b+97)," = ",min)
            min_cost += min
        
        L[a][b] = L[b][a] = 999           #This edge should not be choose again...
    
    print("Minimum cost is ",min_cost)
    

L = []
n = int(input("Enter n value : "))
parent = ['a']*(n)             #Initializing array with 'a'...
for i in range(n):
    L.append([])
    for j in range(n):
        x = int(input())
        if x==0:
            L[i].append(int(999))
        else:
            L[i].append(x)

Kruskal()
