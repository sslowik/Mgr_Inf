getwd()
setwd("D:/Mgr_Inf/Rstudio/Proj2-DataMining")

#clear the environment 

rm(list=ls())

#read csv database and put first 10k rows into data.frame "cats"

cats <- read.csv("aac_shelter_cat_outcome_eng.csv", header=T, sep=",", na.strings="NA", nrows=10000)
cats[1,]

#display the header columns names: 
names(cats)

#removing redundant columns -different methods

# by specific column name

cats$age_upon_outcome <- NULL

#by columns numbers

cats[,c(1,2)] <- list(NULL)

#by columns names, #vector with columns to delete: 

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
names(cats)

cats[cats$breed=="siamese",]

#looking for the interesting values by checking columns levels

levels(cats$age_group)
levels(cats$outcome_type)

cats[cats$outcome_type=="Return to Owner"]

# adding level 'noname' to names
levels(cats$name) <- c(levels(cats$name), "noname")

#adding "noname" value for cats which have no name given

cats$name[cats$name==""] <- "noname"

#getting rid of "*" char in "name" column using >dsub
cats$name <- gsub( "[*]","", cats$name)


class(cats)


cats <- cats[-c(1),]

cats[1,] <- lapply(cats[1,], as.character)

colnames(cats) = cats[1,]
colnames(cats)

cats[1,]

class(cats)
names(cats)


ccc <- c(1,2,3)
class(ccc)

ncol(cats)
nrow(cats)

length(cats_header)

cats$animal_id <- NULL
cats$animal_type <- NULL
cats[1,]
cats[1:2,]

cats_training <- cats[1:1000,]
class(cats_training)
nrow(cats_training)
ncol(cats_training)


cats_selected <- cats_training[c(1,3,5)]

nrow(cats_selected)
ncol(cats_selected)

cats_selected$breed <- cats_training$breed
cats_selected
cats_selected[,5:7] <- cats_training[,25:27]

cats_selected[1,]
