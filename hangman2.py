import random
import string
wordlist_filename = "words.txt"    #importing word.txt file...

def loadwords():
	print("Loading word list from file...")
	inFile = open(wordlist_filename,'r')          #opening word.txt file...
	line = inFile.readline()
	wordlist = line.split()						  #split long string in several strings...
	print("  ",len(wordlist),"words loaded.")
	return wordlist


def chooseword(wordlist):
	return random.choice(wordlist)				  # choosing secret word...



def iswordguessed(secretword,lettersguessed):
	for char in secretword:
		if char not in lettersguessed:
			return False
	return True

def getgussedword(secretword,lettersguessed):
	resStr = ' '
	for char in secretword:
		if char in lettersguessed:
			resStr += char+' '
		else:
			resStr += '__'
	return resStr

def getavailableletters(lettersguessed):
	resStr = string.ascii_lowercase        #invoking a to z lowercase...
	for char in lettersguessed:
		resStr = str.replace(resStr,char,'')
	return resStr

def hangman(secretword):
	lettersguessed = []
	availableletters = []
	maxmistakes = 20
	mistakesmade = 0

	print('Welcome to game, Hangman!')
	print('I am thinking of the word that is ' + str(len(secretword)) + ' letters long.')

	for letter in string.ascii_lowercase:
		availableletters.append(letter)

	while ((mistakesmade < maxmistakes) and (not iswordguessed(secretword,lettersguessed))):
		print('you have '+ str(maxmistakes-mistakesmade)+' guesses left.')
		print('available letters :'+ getavailableletters(lettersguessed))
		guess = input('please enter a letter : ').lower()

		if(guess not in string.ascii_lowercase):
			print('Oops ! you have entered an invalid letter')
		elif(guess in availableletters):
			lettersguessed.append(guess)
			availableletters.remove(guess)
			if(guess in secretword):
				print('Good guess!')
			else:
				mistakesmade += 1
				print('Oops! That letter is not in my word')
		elif(guess in lettersguessed):
			print('Oops! you have already guessed that letter')
		print(getgussedword(secretword,lettersguessed))

	if(iswordguessed(secretword,lettersguessed)):
		print('Congratulation! you Won')
	else:
		print('Sorry, you lost. The word was : '+secretword)


wordlist = loadwords()
secretword = chooseword(wordlist).lower()
hangman(secretword)