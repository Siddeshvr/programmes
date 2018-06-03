
import random            #Import random module...

class Genetic:

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
		self.fit = []
		for i in population:
			score = 0
			for j in range (0,len(self.target)):
				if population[i][0][j] == self.target[j]:
					score = score+1
			self.fit.append(score)


	def prepare_pool(self):                          #Preparing mating pool...
		self.matingpool = []
		k = 0
		for i in population:
			for j in range (0,self.fit[k]):
				self.matingpool.append(population[i][0])
			k = k+1


	def parent_selection(self):
		self.parent = []
		if self.matingpool != []:    # if matingpool not empty...
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
				c = c[:i] + random.choice(alp) + c[i+1:]         # Gene changing due to mutation...
		return c


alp = "abcdefghijklmnopqrstuvwxyz"

target = input("Input a target string\n")
cross = []
mutate = ""
ob = Genetic(target)

print("Gene_Transform based on Genotype\n")

z = 0
while ''.join(cross) != target and z<20000000:
	population = {}
	a = 96
	for i in range(0,26):
		a = a+1
		geno = []
		pheno = []
		for j in range(0,len(target)):
			geno.append(random.choice(alp))
			pheno.append(random.choice(alp))

		ob.values(chr(a),''.join(geno),''.join(pheno))
		ob.prepare_population()



	ob.fitness()
	ob.prepare_pool()
	ob.parent_selection()
	cross = ob.cross_over()
	mutate = ob.mutation()

	z += 1
print("Total generations : ",z)
print("Mutation at %dth generation is  "%(z),mutate)

