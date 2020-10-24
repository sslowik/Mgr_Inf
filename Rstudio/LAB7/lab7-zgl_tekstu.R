getwd()

setwd("H:/Mgr_Inf/Rstudio/LAB7")
.libPaths()

Needed <- c("tm", "SnowballCC", "RColorBrewer", "ggplot2", "wordcloud", "biclust", 
            "cluster", "igraph", "fpc")
install.packages(Needed, dependencies = TRUE)

install.packages("Rcampdf", repos = "http://datacube.wu.ac.at/", type = "source")

# On a PC, save the folder to your C: drive and use the following code chunk:
cname <- file.path(getwd(), "texts")   
cname   
dir(cname) 

#Load the R package for text mining and then load your texts into R.

library(tm)

###

docs <- VCorpus(DirSource(cname))   
summary(docs)

#For details about documents in the corpus, use the inspect(docs) command.

inspect(docs[1])
inspect(docs[2])

#If you so desire, you can read your documents in the R terminal 
#using writeLines(as.character(docs)). 
#Or, if you prefer to look at only one of the documents you loaded, 
#then you can specify which one using something like:
  
writeLines(as.character(docs[1]))

#1.b. Preprocessing

#1.b.1. Removing punctuation:

docs <- tm_map(docs,removePunctuation)  

# writeLines(as.character(docs[1])) # Check to see if it worked.
# The 'writeLines()' function is commented out to save space.

#1.b.2. If necesasry, such as when working with standardized documents or emails, 
#you can remove special characters.

for (j in seq(docs)) {
  docs[[j]] <- gsub("/", " ", docs[[j]])
  docs[[j]] <- gsub("@", " ", docs[[j]])
  docs[[j]] <- gsub("\\|", " ", docs[[j]])
  docs[[j]] <- gsub("\u2028", " ", docs[[j]])
  }

# This is an ascii character that did not translate, so it had to be removed.
# writeLines(as.character(docs[1])) # You can check a document (in this case
# the first) to see if it worked.

#1.b.3. Removing numbers:
  
docs <- tm_map(docs, removeNumbers)   

# writeLines(as.character(docs[1])) # Check to see if it worked.

#1.b.4. Converting to lowercase:

docs <- tm_map(docs, tolower)   
docs <- tm_map(docs, PlainTextDocument)
DocsCopy <- docs

# writeLines(as.character(docs[1])) # Check to see if it worked.

#1.b.5. Removing “stopwords” (common words) that usually have no analytic value.
#In every text, there are a lot of common, and uninteresting words 
# (a, and, also, the, etc.). Such words are frequent by their nature, 
#and will confound your analysis if they remain in the text.

# For a list of the stopwords, see: 
length(stopwords("english"))
stopwords("english")
stopwords("polish")   

docs <- tm_map(docs, removeWords, stopwords("english"))   
docs <- tm_map(docs, PlainTextDocument)

# writeLines(as.character(docs[1])) # Check to see if it worked.

#1.b.6. Removing particular words:
# Just remove the words "syllogism" and "tautology". 

docs <- tm_map(docs, removeWords, c("syllogism", "tautology"))   

# These words don't actually exist in these texts. But this is how you would remove them if they had.

# removing my own words
# i decided to paste poish.dat file into library folder: 
.libPaths()
# \\NAS1\home\sslowik\Documents\R\win-library\3.5\tm\stopwords

# For a list of the stopwords, see: 
length(stopwords("english"))
stopwords("english")
stopwords("polish")   

docs <- tm_map(docs, removeWords, stopwords("polish"))   
docs <- tm_map(docs, PlainTextDocument)

#1.b.7. removing specific words: 
#vector with my words: wywal_je <- c("my","custom","words")

wywal_je <- c("my","custom","words")

docs <- tm_map(docs, removeWords, wywal_je)
docs <- tm_map(docs, PlainTextDocument)

# it's english not polish! so lets use package for stopwords

install.packages("stopwords")
library(stopwords)

wywal_je <- as.vector(stopwords(language = "en", source = "smart"))

wywal_je  

docs <- tm_map(docs, removeWords, wywal_je)
docs <- tm_map(docs, PlainTextDocument)

inspect(docs[1])
inspect(docs[2])

wywal_je <- as.vector(stopwords("english", source = "stopwords-iso"))

docs <- tm_map(docs, removeWords, wywal_je)
docs <- tm_map(docs, PlainTextDocument)

inspect(docs[1])
inspect(docs[2])

wywal_je <- as.vector(stopwords("english", source = "snowball"))
wywal_je

docs <- tm_map(docs, removeWords, wywal_je)
docs <- tm_map(docs, PlainTextDocument)

inspect(docs[1])
inspect(docs[2])

writeLines(as.character(docs[1]))

docs <- tm_map(docs, removeWords, c("()", ")", "(", " = ","musã©","â\200“"))
docs <- tm_map(docs, PlainTextDocument)

# Combining words that should stay together
for (j in seq(docs)) {
  docs[[j]] <- gsub("fake news", "fake_news", docs[[j]])
  docs[[j]] <- gsub("inner city", "inner-city", docs[[j]])
  docs[[j]] <- gsub("politically correct", "politically_correct", docs[[j]])
}

docs <- tm_map(docs, PlainTextDocument)

docs_st <- tm_map(docs, stemDocument)   
docs_st <- tm_map(docs_st, PlainTextDocument)
writeLines(as.character(docs_st[1]))

docs_stc <- tm_map(docs_st, stemCompletion, dictionary = DocsCopy, lazy=TRUE)
docs_stc <- tm_map(docs_stc, PlainTextDocument)
writeLines(as.character(docs_stc[1]))

tdm <- TermDocumentMatrix(docs)   
tdm  


#1.c.1.  Stwórz macierz dtm

dtm <- DocumentTermMatrix(docs)   
dtm 

ord <- order(freq) 

m <- as.matrix(dtm)   
dim(m)   

write.csv(m, file="DocumentTermMatrix.csv") 

dtms <- removeSparseTerms(dtm, 0.2)
dtms

freq <- colSums(as.matrix(dtm))   
length(freq)

head(table(freq), 20)

tail(table(freq), 20) 

freq <- colSums(as.matrix(dtms))   
freq  

freq <- sort(colSums(as.matrix(dtm)), decreasing=TRUE)   
head(freq, 14)  

findFreqTerms(dtm, lowfreq=50)

wf <- data.frame(word=names(freq), freq=freq)   
head(wf)  

library(ggplot2)   

p <- ggplot(subset(wf, freq>50), aes(x = reorder(word, -freq), y = freq)) +
  geom_bar(stat = "identity") + 
  theme(axis.text.x=element_text(angle=45, hjust=1))

p

#frequency > 10

p2 <- ggplot(subset(wf, freq>10), aes(x = reorder(word, -freq), y = freq)) +
  geom_bar(stat = "identity") + 
  theme(axis.text.x=element_text(angle=45, hjust=1))

p2


#1.e) Sprawdź jaka korelacja zachodzimi między termami: computer, life, programming, language.
#Rozdział Term Correlations.

#If words always appear together, then correlation=1.0.

findAssocs(dtm, c("programming" , "languages"), corlimit=0.85) 
# specifying a correlation limit of 0.85

findAssocs(dtm, "human", corlimit=0.77) # specifying a correlation limit of 0.77


#f) Stwórz chmury słów (word clouds). Ustaw min.freq na taką wartość, by chmura była
#interesująca. Rozdział Word Clouds.

library(RColorBrewer)

set.seed(142)   
wordcloud::wordcloud(names(freq), freq, min.freq=25)  

#g) Słowa (termy) są podobne, gdy często wystepują w tym samym dokumencie. Kuszące jest, by
#sprawdzić czy algorytmy do klasteryzacji pogrupują je w klastry odpowiadające dokumentom, w
#których wystepują.
#Stwórz dendrogram i sprawdź, czy słowa siedzące na wspólnej gałęzi są ze sobą powiązane 
#tematycznie.
#Nastepnie korzystając z algorytmu K-Means, dokonaj grupowania słów na kilka klastrów. Sprawdź
#jak algorytm działa dla k=2,3,4,5,6.
