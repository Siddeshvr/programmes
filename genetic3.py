import random

class Genetic:
	matingpool = []
	parent = []
	child = []
	mutation_rate = 2     #Setting mutation rate...each gene of a child has 2% probability of mutating... 
	max_fitness = 0

	#constructor...
	def __init__(self,target):
		self.target = target

	#Module to prepare population and and their fitness...
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
		if inlist[1] != 0:					#Removing zero fitness partner...
			population.append(inlist)

	#Utility module for sort function...		
	def util(self,ele):
		return ele[1]

	#sorting the population according to their fitness...
	def sorting(self):
		population.sort(key = self.util)
		population.reverse()

	#Module to prepare Matingpool...
	def prepare_pool(self):
		self.matingpool = []
		for i in range(len(population)):      
			for j in range (population[i][1]):
				self.matingpool.append(population[i][0])

	#Selection of 2 parents for mating...
	def parent_selection(self):
		self.parent = []
		for i in range(10):
			a = random.choice(self.matingpool)
			b = random.choice(self.matingpool)
			if a != b:                        #Selecting 2 different parents...
				self.parent.append(a)
				self.parent.append(b)
				break

	#Module where cross_over(Matting) between two different parent occur...
	def cross_over(self):
		self.child = []
		mid = random.randrange(len(self.target))   #Random selection of midpoint from lenght of target...
		if self.parent != []:
			for i in range(0,mid+1):
				self.child.append(self.parent[0][i])  #copying first half genes from parent1...
			for i in range(mid+1,len(self.target)):
				self.child.append(self.parent[1][i])  #copyting second half genes from parent2...
			return self.child
		else:
			return self.child

	#Module for mutation according to mutation rate...
	def mutation(self):
		c = ''.join(self.child)
		fetch = [1,2,3,4,5,6,7,8,9,0]
		for i in range(0,len(self.target)):
			if random.choice(fetch) < self.mutation_rate:     
				c = c[:i] + random.choice(alp) + c[i+1:]      #Gene changing due to mutation...
		return c


alp = "abcdefghijklmnopqrstuvwxyz"

target = input("Input a target string : ")
cross = []
mutate = ""
ob = Genetic(target)

print("Gene_Transformation...")

z = 1
#Looping till we reach our target...
while ''.join(cross) != target and z<2000000:          #Here z is to terminate from infinite loop...      
	population = []

	for i in range(0,400):              #Random preparation of 400 population for each generation...
		geno = []
		for j in range(0,len(target)):
			geno.append(random.choice(alp))

		ob.population_and_fitness(''.join(geno))

	ob.sorting()
	ob.prepare_pool()
	ob.parent_selection()
	cross = ob.cross_over()
	mutate = ob.mutation()
	z += 1                 #To count number of generations to reach our target...

print("Total generations : ",z)
print("Mutation at %d'th generation is "%(z),mutate)