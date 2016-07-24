import sys, json

def hw():
    print 'Hello, world!'

def lines(fp):
    print str(len(fp.readlines()))

#def parseSentFile(fileName):


	#print scores.items() # Print every (term, score) pair in the dictionary

def parseTweetFile(tweet_file):
	afinnfile = open("AFINN-111.txt")
	scores = {} # initialize an empty dictionary
	for line in afinnfile:
	  term, score  = line.split("\t")  # The file is tab-delimited. "\t" means "tab character"
	  scores[term] = int(score)  # Convert the score to an integer.


	for line in tweet_file:
		tweetJson = json.loads(line)
		afinnScore = 0
		text = ''
		if 'text' in tweetJson:
			#print(tweetJson['text'])
			text = tweetJson['text']
			for word in text.split():
				if word in scores:
					afinnScore += scores[word]
					#print(scores[word])
		print(text + ' ' +  str(afinnScore))


def main():
    sent_file = open(sys.argv[1])
    tweet_file = open(sys.argv[2])
    hw()
    #parseSentFile(sent_file)
    parseTweetFile(tweet_file)
    lines(sent_file)
    lines(tweet_file)

if __name__ == '__main__':
    main()
