dirty.iris <- read.csv("dirty_iris.csv", header=TRUE, sep=",")
install.packages("editrules")
library(editrules)

a = subset(dirty.iris, is.finite(Sepal.Length) & is.finite(Sepal.Width) & is.finite(Petal.Length) & is.finite(Petal.Width))
nrow(a)[1] 95

E <- editset(c("Sepal.Length <= 30", "Species %in% c('setosa','versicolor','virginica')"))

E <- editset(c("Sepal.Length <= 30", "Species %in% c('setosa','versicolor','virginica')", "Sepal.Length>0", "Sepal.Width>0", "Petal.Length > 0", "Petal.Width>0", "Petal.Length >= 2* Petal.Width", "Sepal.Length > Petal.Length"))
E

ve <- violatedEdits(E, dirty.iris) ; ve

summary(ve)
plot(ve)

#zadanie 2.

install.packages("deducorrect")
library(deducorrect)

#rules.txt:

# if (!is.na(Petal.Width) & Petal.Width != 'Inf' & Petal.Width <= 0){
#	 Petal.Width <- NA
# }
#if (!is.na(Petal.Length) & Petal.Length <= 0){
#	Petal.Length <- NA
#}
#if (!is.na(Sepal.Width) & Sepal.Width <= 0){
#	Sepal.Width <- NA
#}
#if (!is.na(Sepal.Length) & (Sepal.Length <= 0 | Sepal.Length > 30)){
#	Sepal.Length <- NA
#}
#if (!is.na(Petal.Width) & !is.na(Petal.Length) & 2*Petal.Width >= Petal.Length){
#	Petal.Length <- NA
#}
#if (!is.na(Petal.Length) & !is.na(Sepal.Length) & Petal.Length >= Sepal.Length) {
#	Sepal.Length <- NA
#}
	
R <- correctionRules("rules.txt")
corrected.dirty.iris <- correctWithRules(R, dirty.iris)
iris_corrected <- corrected.dirty.iris$corrected
iris_corrected

# zadanie 3.

#a)  
  
install.packages("Hmisc")
library(Hmisc)
cbind.data.frame(Sepal.Length=impute(corrected$Sepal.Length, mean), Sepal.Width=impute(corrected$Sepal.Width, mean), Petal.Length=impute(corrected$Petal.Length, mean), Petal.Width=impute(corrected$Petal.Width, mean), corrected$Species)
  
#b) 
install.packages("VIM")

library(VIM)
clean.iris.knn <- kNN(corrected)
clean.iris.knn.2 <- kNN(corrected)[1:5]



#zadanie.4.

# a) 
iris

# b) 
log

iris.log <- cbind.data.frame(Sepal.Length=log(iris$Sepal.Length), Sepal.Width=log(iris$Sepal.Width), Petal.Length=log(iris$Petal.Length), Petal.Width=log(iris$Petal.Width), Speciesiris$Species)






#c)  
iris.log.scale <- cbind.data.frame(Sepal.Length=scale(iris.log$Sepal.Length), Sepal.Width=scale(iris.log$Sepal.Width), Petal.Length=scale(iris.log$Petal.Length), Petal.Width=scale(iris.log$Petal.Width), Species=iris.log$Species)

sd(iris.log.scale$Petal.Length) = 1
mean(iris.log.scale$Petal.Length) ?0


#zadanie 5.

#a) 
  
iris.log.scale <- subset(iris.log.scale, select = -c(Species))

# or 

iris.log.scale <- iris.log.scale[,-5]

#b) 
iris.pca <- prcomp(iris.log.scale)

#c)
iris.pca

# Sdev1 = 1.7124583 
# Sdev2 = 0.9523797 
# Sdev3 = 0.3647029 
# Sdev4 = 0.1656840

#d) 
iris.predict <- predict(iris.pca)
iris.predict <- subset(iris.predict, select = -c(PC3))
iris.predict <- subset(iris.predict, select = -c(PC4))
iris.predict <- cbind.data.frame(iris.predict, Species=iris.log$Species)

#zadanie.6.

plot(iris.predict$PC1, iris.predict$PC2, type="p", col="red", xlab="PC1", ylab="PC2")
points(iris.predict$PC1[iris.predict$Species=="versicolor"], iris.predict$PC2[iris.predict$Species=="versicolor"], type="p", col="red")
points(iris.predict$PC1[iris.predict$Species=="virginica"], iris.predict$PC2[iris.predict$Species=="virginica"], type="p", col="blue")
legend("topleft", c("setosa","versicolor", "virginica"), col=c("red","blue", "green"), lty=1:1)
