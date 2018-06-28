def partition(l,h):
	pivot = L[l]
	i = l+1
	j = h
	while i<j:
		while L[i]<pivot and i<j :
			i += 1
		while L[j]>pivot :
			j -=1
		if i<j:	
			L[i],L[j] = L[j],L[i]
	L[j],L[l] = L[l],L[j]
	return i-1


def quick_sort(l,h):
	if l<h:
		p = partition(l,h)
		quick_sort(l,p-1)
		quick_sort(p+1,h)

L = [10,20,5,15,30,25,40]
n = len(L)
quick_sort(0,n-1)
print(L)
