getwd()
setwd("D:/Mgr_Inf/Rstudio/Proj2-DataMining")

#read csv database and put it into data.frame "cats"

cats_f <- read.csv("aac_shelter_cat_outcome_eng.csv", header=T, sep=",", na.strings="NA", nrows=10000)
nrow(cats)
cats_f[1,]

#display the header columns names: 
names(cats_f)

# input cats_f into target data_frame - it's easier to repeat steps
cats <- cats_f
names(cats)
#removing redundant columns -different methods

# by specific column name
cats$animal_id <- NULL

#by columns numbers
cats[,c(1,2,3)] <- list(NULL)

#by columns names, #vector with columns to delete: 
redundant <- c("date_of_birth",
               "datetime",
               "monthyear",
               "outcome_subtype",
               "coat_pattern", 
               "color2", 
               "Periods", 
               "Period.Range", 
               "outcome_age_.years.", 
               "breed1", 
               "breed2")

cats[,redundant] <- list(NULL)
names(cats)

#looking for the interesting values by checking columns levels

levels(cats$sex_upon_outcome)
levels(cats$age_group)
levels(cats$outcome_subtype)

# adding level to names, but i's not needed probably because there are no factors
levels(cats$name) <- c(levels(cats$name), "noname")

#adding "noname" value for cats which have no name given

cats$name[cats$name==""] <- "noname"

#getting rid of "*" char in "name" column using >dsub
cats$name <- gsub( "[*]","", cats$name)


class(cats)



y <- gl(2, 4, 8)
levels(y) <- c("low", "high")
y




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
