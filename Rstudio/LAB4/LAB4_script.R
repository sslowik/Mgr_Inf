#manual: 
# https://www.datacamp.com/community/tutorials/machine-learning-in-r#r


getwd()
setwd("H:/Mgr_Inf/Rstudio/LAB4")

# Read in `iris` data
iris <- read.csv(url("http://archive.ics.uci.edu/ml/machine-learning-databases/iris/iris.data"), 
                 header = FALSE) 

# Print first lines
head(iris)

# Add column names
names(iris) <- c("Sepal.Length", "Sepal.Width", "Petal.Length", "Petal.Width", "Species")

# Check the result
iris

install.packages("ggvis")
library(ggvis)

# Iris scatter plot
iris %>% ggvis(~Sepal.Length, ~Sepal.Width, fill = ~Species) %>% layer_points()


# ZAD 2)

# Build your own `normalize()` function
install.packages("class")
library(class)

normalize <- function(x) {
  up <- x - min(x)
  down <- max(x) - min(x)
  return (up/down)
}


iris_norm <- as.data.frame(lapply(iris[1:4], normalize))
set.seed(1234)
ind <- sample(2, nrow(iris), replace=TRUE, prob=c(0.67, 0.33))
iris.training <- iris[ind==1, 1:4]
iris.test <- iris[ind==2, 1:4]
iris.trainLabels <- iris[ind==1,5]
iris.testLabels <- iris[ind==2, 5]
iris_pred <- knn(train = iris.training, test = iris.test, cl = iris.trainLabels, k=3)
irisTestLabels <- data.frame(iris.testLabels)

# `iris.testLabels` ->  data frame
irisTestLabels <- data.frame(iris.testLabels)

# Merge `iris_pred` and `iris.testLabels` 
merge <- data.frame(iris_pred, iris.testLabels)

# Specify column names for `merge`
names(merge) <- c("Predicted Species", "Observed Species")

# Inspect `merge` 
merge

install.packages("gmodels")
library(gmodels)

CrossTable(x = iris.testLabels, y = iris_pred, prop.chisq=FALSE)

F_KNNC_results <- function(dataset) {
  rows <- nrow(dataset)
  counter <- 0
  for(i in 1:rows) {
    if(dataset[i,1] == dataset[i,2])
    {
      counter <- counter + 1
    }
  }
  passrate <- counter/rows * 100
  out <- paste("Population of test group ", rows, "True:", counter, "False: ", rows-counter, "Passrate: ", passrate, "%", sep=" ")
  return(out)
}

test_result <- F_KNNC_results(merge)
test_result

# OUTPUT: [1] "Population of test group  40 True: 38 False:  2 Passrate:  95 %"

# ZAD 3)
install.packages("e1071")
library(e1071)

iris.training$Species <- iris.trainLabels
model <- naiveBayes(Species ~ ., data = iris)
predictions=predict(model,iris.test)
merge <- data.frame(predictions, iris.testLabels)
merge
F_KNNC_results(merge)

# OUTPUT: [1] "Population of test group  40 True: 38 False:  2 Passrate:  95 %"

bayesTable <- CrossTable(x = iris.testLabels, y = predictions, prop.chisq=FALSE)

# ZAD 4)

install.packages("party")
library("party")

iris_ctree <- ctree(Species ~ Sepal.Length + Sepal.Width + Petal.Length + Petal.Width, data=iris.training)
predictionstree=predict(iris_ctree,iris.test)
tree <- data.frame(predictionstree, iris.testLabels)
tree_output <- F_KNNC_results(tree)
tree_output

# [1] "Total ammount of tests: 40 Passed: 38 Failed: 2 Passrate: 95 %"
