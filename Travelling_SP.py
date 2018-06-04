def next_permutation(v):
	n = len(v)
	i = n-2
	while i>=0 and v[i]>=v[i+1]:
		i-=1
	if i == -1:
		return False
	j=i+1
	while j<n and v[j]>v[i]:
		j+=1
	j-=1
	v[i],v[j] = v[j],v[i]
	left = i+1
	right = n-1
	while left < right:
		v[left],v[right] = v[right],v[left]
		left += 1
		right -= 1
	return True


def Tsp(L,s):
	v = []
	for i in range(4):
		if i != s:
			v.append(i)
	min_path=1000
	while(next_permutation(v)):
		current_weight = 0
		k = s
		for i in range(len(v)):
			current_weight += L[k][v[i]]
			k = v[i]
		current_weight += L[k][s]
		if min_path>current_weight:
			min_path = current_weight
			x = []
			for i in v:
				x.append(chr(i+97))
	x.insert(0,chr(s+97))
	x.append(chr(s+97))
	print('Travelling path --> ','-'.join(x))
	return min_path

#L = [[0,10,15,20],[10,0,35,25],[15,35,0,30],[20,25,30,0]]
#L = [[0,10,7,6],[10,0,8,5],[7,8,0,12],[6,5,12,0]]
L = []
V = int(input("Number of vertices...\n"))
print('Enter '+str(V)+'*'+str(V)+' matrices')
for i in range(V):
	I = []
	for j in range(V):
		I.append(int(input()))
	L.append(I)	
print('Graph is = ',L)
s = 0
print('Distance is ',Tsp(L,s))