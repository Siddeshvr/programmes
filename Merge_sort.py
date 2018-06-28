def merge(l,mid,h):
	n1 = mid-l+1
	n2 = h - mid
	p=[0]*(n1)
	q=[0]*(n2)
	for i in range(n1):
		p[i] = L[l+i]
	for i in range(n2):
		q[i] = L[mid+1+i]
	i=0
	j=0
	k = l
	while i<n1 and j<n2:
		if p[i]<=q[j]:
			L[k] = p[i]
			i += 1
		else:
			L[k] = q[j]
			j += 1
		k += 1	
	while i<n1:
		L[k] = p[i]
		i += 1
		k += 1
	while j<n2:
		L[k] = q[j]
		j += 1
		k += 1

def merge_sort(l,h):
	if l<h:
		mid = int((l+(h-1))/2)
		merge_sort(l,mid)
		merge_sort(mid+1,h)
		merge(l,mid,h)


L = [50,40,30,20,10]
n = len(L)
merge_sort(0,n-1)
print(L)