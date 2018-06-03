import random

class Genetic:
	matingpool = []
	parent = []
	child = []
	mutation_rate = 2
	max_fitness = 0

	def __init__(self,target):
		self.target = target

	def population_and_fitness(self,gene):
		self.gene = gene
		inlist = []
		fitness = 0
		inlist.append(self.gene)
		for i in range(len(self.target)):
			if self.gene[i] == self.target[i]:
				fitness += 1
		inlist.append(fitness)
		if self.max_fitness < fitness:
			self.max_fitness = fitness
		if inlist[1] != 0:
			population.append(inlist)

	def prepare_pool(self):
		self.matingpool = []
		for i in range(len(population)):
			for j in range (population[i][1]):
				self.matingpool.append(population[i][0])

	def parent_selection(self):
		self.parent = []
		if self.matingpool != []:
			for i in range(0,10):
				a = random.choice(self.matingpool)
				b = random.choice(self.matingpool)
				if a != b:
					self.parent.append(a)
					self.parent.append(b)
					break

	def cross_over(self):
		self.child = []
		mid = int(len(self.target)/2)
		if self.parent != []:
			for i in range(0,mid+1):
				self.child.append(self.parent[0][i])
			for i in range(mid+1,len(self.target)):
				self.child.append(self.parent[1][i])
			return self.child
		else:
			return self.child

	def mutation(self):
		c = ''.join(self.child)
		fetch = [1,2,3,4,5,6,7,8,9,0]
		for i in range(0,len(self.target)):
			if random.choice(fetch) < self.mutation_rate:
				c = c[:i] + random.choice(alp) + c[i+1:]
		return c


alp = "abcdefghijklmnopqrstuvwxyz"

target = input("Input a target string\n")
cross = []
mutate = ""
ob = Genetic(target)

print("Gene_Transform based on Genotype\n")

z = 0
while ''.join(cross) != target and z<20000000:
	population = []

	for i in range(0,50):
		geno = []
		for j in range(0,len(target)):
			geno.append(random.choice(alp))

		ob.population_and_fitness(''.join(geno))

	ob.prepare_pool()
	ob.parent_selection()
	cross = ob.cross_over()
	mutate = ob.mutation()
	z += 1

print("Total generations : ",z)
print("Mutation at %d th generation is "%(z),mutate)
