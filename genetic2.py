
import random

class person:

	fit = []
	matingpool = []
	parent = []
	child = []
	mutation_rate = 2

	def __init__(self,target):
		self.target = target

	def values(self,key,genotype,phenotype):
		self.key = key
		self.genotype = genotype
		self.phenotype = phenotype

	
	def prepare_population(self):
		for i in self.key:
			population.setdefault(i,[])
			population[i].append(self.genotype)
			population[i].append(self.phenotype)

	def fitness(self):	
		for i in population:
			score = 0
			for j in range (0,7):
				if population[i][0][j] == self.target[j]:
					score = score+1
			self.fit.append(score) 
		#print(self.fit)

	'''def fitness(self):
		distance = 0
		for i in population:
			distance = self.target - population[i][0]
			v = (1/distance)
			x = int(v*100)
			self.fit.append(x)
		print(self.fit)      '''

	def prepare_pool(self):
		k = 0
		for i in population:
			for j in range (0,self.fit[k]):
				self.matingpool.append(population[i][0])
			k = k+1
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

	def mutation(self):
		c = ''.join(self.child)
		fetch = [1,2,3,4,5,6,7,8,9,0]
		for i in range(0,7):
			if random.choice(fetch) < self.mutation_rate:
				c = c[:i] + random.choice(alp) + c[i+1:]
		return c


alp = "abcdefghijklmnopqrstuvwxyz"
ob = person("unicorn")
a = 96
population = {}
for i in range(0,26):
	a = a+1
	#print(chr(a))
	geno = []
	pheno = []
	for j in range(0,7):
		geno.append(random.choice(alp))
		pheno.append(random.choice(alp))

	ob.values(chr(a),''.join(geno),''.join(pheno))
	ob.prepare_population()
ob.fitness()
#print(population)

ob.prepare_pool()
ob.parent_selection()
print("Gene_Transform based on Genotype\n")
print("cross_over result : ",''.join(ob.cross_over()))
print("mutation_result : ",ob.mutation())