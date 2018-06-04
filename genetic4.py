#By finding probability...
import random

class Genetic:
	matingpool = []
	parent = []
	child = []
	mutation_rate = 2     #Setting mutation rate...each gene of a child has 2% probability of mutating... 
	add_fit = 0

	#constructor...
	def __init__(self,target):
		self.target = target

	#Module to prepare population and and their fitness...
	def population_and_fitness(self,gene):
		self.gene = gene
		inlist = []
		fit_prob = 0
		fitness = 0
		inlist.append(self.gene)
		for i in range(len(self.target)):
			if self.gene[i] == self.target[i]:
				fitness += 1
		inlist.append(fitness)

		self.add_fit += fitness             #Adding fitness of all persons...

		if inlist[1] != 0:					#Removing zero fitness partner...
			population.append(inlist)

	#Module to find probability of selecting each person...
	def find_prob(self):
		for i in range(len(population)):
			population[i].append(population[i][1]/self.add_fit)

	#Utility module to pick random float value...
	def randrange_float(self,start,stop,step):
		return random.randint(0,int((stop-start)/step))*step+start

	#Utility module to select a precise parent...
	def pickone(self):
		index = 0
		r = self.randrange_float(0,1,0.01)     #Invoking randrange_float module...

		while r > 0 and index < len(population):
			r = r - population[index][2]
			index += 1
		index -= 1
		return population[index][0]

	#Selection of 2 parents for mating...
	def parent_selection(self):
		self.parent = []
		for i in range(10):
			a = self.pickone()
			b = self.pickone()
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
				self.child.append(self.parent[1][i])  #copying second half genes from parent2...
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
population = []                     # population list in the form [['gene',fitness,probability]]...
mutate = ""
ob = Genetic(target)

print("Gene_Transformation...")

for i in range(0,10000):              #Random preparation of population...
	geno = []
	for j in range(0,len(target)):
		geno.append(random.choice(alp))

	ob.population_and_fitness(''.join(geno))
ob.find_prob()

z = 1
#Looping till we reach our target...
while ''.join(cross) != target and z<200000:          #Here z is to terminate from infinite loop...      

	ob.parent_selection()
	cross = ob.cross_over()
	mutate = ob.mutation()
	z += 1                 #To count number of generations to reach our target...

print("Total generations : ",z)
print("Mutation at %d'th generation is "%(z),mutate)