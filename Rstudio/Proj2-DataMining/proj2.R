getwd()
cats <- read.csv("aac_shelter_cat_outcome.csv", header=F, sep=",")
cats[1,]
cats_header <- as.vector(cats[1,])

class(cats_header)
cats_h <- as.vector(cats_header, mode = "numeric")
class(cats_h)

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
