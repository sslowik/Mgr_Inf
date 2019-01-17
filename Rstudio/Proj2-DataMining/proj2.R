getwd()
setwd("D:/Mgr_Inf/Rstudio/Proj2-DataMining")

#1. I decided to use database: aac_shelter_cat_outcome_eng.csv with information about what happened with cats in shelter.  
#   Interesting factor is what specifies adopted the cats. 

#2. Przetwarzanie / obróbka / ³¹czenie / dzielenie baz danych

#2.1.Clear the environment 

rm(list=ls())

#2.2. read csv database and put first 10k rows into data.frame "cats". I decided to get only 10k records from database containing almost 30k.

cats <- read.csv("aac_shelter_cat_outcome_eng.csv", header=T, sep=",", na.strings="NA", nrows=10000)
cats[1,]

#display the header columns names and "cats" class type: 

names(cats)
class(cats)

#2.3.  removing redundant columns -different methods

#  2.3.1. By specific column name

cats$age_upon_outcome <- NULL

#  2.3.2. By columns numbers

cats[,c(1,2)] <- list(NULL)

#   2.3.3. by columns names, #vector with columns to delete: 

redundant <- c("age_upon_outcome",
               "animal_id", 
               "animal_type",
               "breed",
               "color",
               "date_of_birth",
               "dob_year", 
               "dob_month",
               "datetime",
               "monthyear",
               "outcome_subtype",
               "sex_upon_outcome",
               "count",
               "Periods",
               "Period.Range",
               "sex_age_outcome",
               "dob_monthyear",
               "breed2",
               "domestic_breed",
               "coat_pattern",
               "color2",
               "outcome_age_.years.",
               "outcome_year",
               "outcome_hour"
               )

cats[,redundant] <- list(NULL)

# list the headers 
names(cats)
head(cats)

cats[cats$breed=="siamese",]

#2.4. looking for the interesting values by checking columns levels

levels(cats$age_group)
levels(cats$outcome_type)

cats[cats$outcome_type=="Return to Owner"]

#2.5. Adding level 'noname' to names - if cat has name looks like important factor to me. 

levels(cats$name) <- c(levels(cats$name), "noname")

#2.6. Adding "noname" value for cats which have no name given

cats$name[cats$name==""] <- "noname"

#2.7. Deleting "*" char in "name" values using >dsub

cats$name <- gsub( "[*]","", cats$name)

#2.8. Check actual columns in "cats" dataframe

names(cats)
nrow(cats)
ncol(cats)

#2.9. add column which specify if cat was adopted or returned to owner

# cbind(Adopted = "yes", cats)  - didn't worked? why? 

cats <- data.frame(adopted = "NA", cats)

levels(cats$adopted) <- c(levels(cats$adopted), "yes", "no")
  
cats$adopted[cats$outcome_type=="Adoption"] <- "yes"
cats$adopted[cats$adopted!="yes"] <- "no"  

#czyszczenie danych przy u¿yciu pakietu "editrules"
library("editrules")

# W przypadku wybranej bazy danych wybrane parametry maj¹ typ "string" i sa poprawne, zatem wykorzystanie biblioteki okaza³o siê zbêdne  

#2.10 normalizacja kolumny z wiekiem wyjœcia w dniach

# Create `normalize()` function

install.packages("class")
library(class)

normalize <- function(x) {
  up <- x - min(x)
  down <- max(x) - min(x)
  return (up/down)
}

cats_norm <- data.frame(cats[1:5], apply(cats[6],2, normalize), cats[7:14])

#or cbind(cats[1:4], apply(cats[6],2, normalize), cats[7:14])

names(cats_norm)


install.packages("ggvis")
library(ggvis)


#3. Klasyfikatory i ich ewaluacja

#3.a. dzielimy na bazê treningowa i testow¹
set.seed(1234)
ind <- sample(2, nrow(cats_norm), replace=TRUE, prob=c(0.8, 0.2))
cats_training <- cats_norm[ind==1, 1:14]
cats_test <- cats_norm[ind==2, 1:14]


#3.a.2. Wykorzystanie pakietu "caret", pozwalaj¹cego  na pracê z wieloma klasyfikatorami.

install.packages("caret")
library("caret")

ind1 <- createDataPartition(cats_norm$adopted, p=0.8, list=FALSE)

cats_training1 <- cats_norm[ind1,]
cats_test1 <- cats_norm[-ind1,]

#3.b.1. kNN

cats_knn <- train(cats_training1[,2:14], cats_training1[,1], method="knn")

cats_training1[cats_training1=='NA'] <- NA

cats_na <- cats_training1[rowSums(is.na(cats_training1)) > 0,]


# i na tym etapie dochodze do wniosku, ¿e b³êdem by³ wybór bazy danych typu string. 




