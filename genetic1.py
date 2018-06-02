import random

class genetic:
	
	fitscore = []
	matingpool = []
	parent = []
	child = []
	population = ['unijorm','pancake','umidosm','popcorn']

	def __init__(self,target,mutation_rate):
		self.target = target                           
		self.mutation_rate = mutation_rate   


	'''	def population():                         # random creation of population...
		for i in range(0,10):
			l1 = []
			for j in range(0,7):
				l1.append(random.choice(self.fetch))
			self.population.append(''.join(l1))'''          


	def fitness(self):	
		for i in range (0,4):
			score = 0
			for j in range (0,7):
				if self.population[i][j] == self.target[j]:
					score = score+1
			self.fitscore.append(score) 
		#print(self.fitscore)

	def prepare_pool(self):
		for i in range (0,4):
			for j in range (0,self.fitscore[i]):
				self.matingpool.append(self.population[i])
		#print(self.matingpool)

	def parent_selection(self):
		for i in range(0,10):
			a = random.choice(self.matingpool)
			b = random.choice(self.matingpool)
			if a != b:
				self.parent.append(a)
				self.parent.append(b)
				break

	def cross_over(self):
		mid = int(7/2)
		for i in range(0,mid+1):
			self.child.append(self.parent[0][i])
		for i in range(mid+1,7):
			self.child.append(self.parent[1][i])
		return self.child

	'''def mutation(self):
		fetch = "abcdefghijklmnopqrstuvwxyz"
		for i in range(0,len(self.child)):
			a = random.choice(self.child)
			if a < self.mutation_rate :
				self.child.replace(self.child,self.child[i],random.choice(fetch))
		return self.child  '''

	def mutation(self):
		c = ''.join(self.child)
		fetch = [1,2,3,4,5,6,7,8,9,0]
		fetch_alp = "abcdefghijklmnopqrstuvwxyz"
		for i in range(0,7):
			if random.choice(fetch) < self.mutation_rate:
				c = c[:i] + random.choice(fetch_alp) + c[i+1:]
		return c


ob = genetic('unicorn',1)
ob.fitness()
ob.prepare_pool()
ob.parent_selection()

print ('Cross_over result - ',''.join(ob.cross_over()))

print('Mutated result - ',ob.mutation())
