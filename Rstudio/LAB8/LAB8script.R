setwd("H:/Mgr_Inf/Rstudio/LAB8")
getwd()
path
mnist <- file(file.path(getwd(),"mnist/t10k-images-idx3-ubyte"), "rb")
mnist <- file("t10k-images-idx3-ubyte", "rb")

# Load the MNIST digit recognition dataset into R
# http://yann.lecun.com/exdb/mnist/
# assume you have all 4 files and gunzip'd them
# creates train$n, train$x, train$y  and test$n, test$x, test$y
# e.g. train$x is a 60000 x 784 matrix, each row is one digit (28x28)
# call:  show_digit(train$x[5,])   to see a digit.
# brendan o'connor - gist.github.com/39760 - anyall.org

load_mnist <- function() {
  
  load_image_file <- function(filename) {
    ret = list()
    f = file(filename, 'rb')
    readBin(f,'integer',n=1,size=4,endian='big')
    ret$n = readBin(f,'integer',n=1,size=4,endian='big')
    nrow = readBin(f,'integer',n=1,size=4,endian='big')
    ncol = readBin(f,'integer',n=1,size=4,endian='big')
    x = readBin(f,'integer',n=ret$n*nrow*ncol,size=1,signed=F)
    ret$x = matrix(x, ncol=nrow*ncol, byrow=T)
    close(f)
    ret
  }
  
  load_label_file <- function(filename) {
    f = file(filename,"rb")
    readBin(f,'integer',n=1,size=4,endian='big')
    n = readBin(f,'integer',n=1,size=4,endian='big')
    y = readBin(f,'integer',n=n,size=1,signed=F)
    close(f)
    y
  }
  
  train_db <<- load_image_file('train-images.idx3-ubyte')
  test_db <<- load_image_file('t10k-images.idx3-ubyte')
  
  train_db$y <<- load_label_file('train-labels.idx1-ubyte')
  test_db$y <<- load_label_file('t10k-labels.idx1-ubyte')  
}

show_digit <- function(arr784, col=gray(12:1/12), ...) {
  image(matrix(arr784, nrow=28)[,28:1], col=col, ...)
}



# funkcje ze srodka

load_image_file <- function(filename) {
  ret = list()
  f = file(filename, 'rb')
  readBin(f,'integer',n=1,size=4,endian='big')
  ret$n = readBin(f,'integer',n=1,size=4,endian='big')
  nrow = readBin(f,'integer',n=1,size=4,endian='big')
  ncol = readBin(f,'integer',n=1,size=4,endian='big')
  x = readBin(f,'integer',n=ret$n*nrow*ncol,size=1,signed=F)
  ret$x = matrix(x, ncol=nrow*ncol, byrow=T)
  close(f)
  ret
}

load_label_file <- function(filename) {
  f = file(filename,"rb")
  readBin(f,'integer',n=1,size=4,endian='big')
  n = readBin(f,'integer',n=1,size=4,endian='big')
  y = readBin(f,'integer',n=n,size=1,signed=F)
  close(f)
  y
}


load_mnist()


show_digit <- function(arr784, col=gray(12:1/12), ...) {
  image(matrix(arr784, nrow=28)[,28:1], col=col, ...)
}

show_digit(train_db$x[99,])


##########################

train <- read.csv("mnist_train.csv")
test <- read.csv("mnist_test.csv")

dim(train_db)
dim(test_db)

############################
# version with data in csv files

install.packages("tensorflow")
library(tensorflow)
library(data.table)

train <- as.data.frame(fread("mnist-csv/mnist_train.csv"))
train$label <- as.factor(as.character(train$label))
test <- as.data.frame(fread("mnist-csv/mnist_test.csv"))


dim(train)
dim(test)
table(train$label)

#Visualise the images in the dataset

rotate <- function(x) t(apply(x, 2, rev))


m = rotate(matrix(unlist(train[1,-1]),nrow = 28,byrow = T))
image(m,col=grey.colors(255))

m1 = rotate(matrix(unlist(train[40462,-1]),nrow = 28,byrow = T))
image(m1,col=grey.colors(255))

#Try a K-NN model first

library(class)

t0 <- Sys.time()
knn.model <- knn(train[, 1:785], test, cl = train[,1], k = 5)
print(Sys.time() - t0)
submit <- data.frame(ImageId = seq(1,28000), Label = knn.model)
write.csv(submit, file = "simpleKnn.csv", row.names=F)






# Create the model
x <- tf$placeholder(tf$float32, shape(NULL, 784L))
W <- tf$Variable(tf$zeros(shape(784L, 10L)))
b <- tf$Variable(tf$zeros(shape(10L)))

y <- tf$nn$softmax(tf$matmul(x, W) + b)

# Define loss and optimizer

y_ <- tf$placeholder(tf$float32, shape(NULL, 10L))
cross_entropy <- tf$reduce_mean(-tf$reduce_sum(y_ * log(y), reduction_indices=1L))
train_step <- tf$train$GradientDescentOptimizer(0.5)$minimize(cross_entropy)

# Create session and initialize  variables
sess <- tf$Session()
sess$run(tf$global_variables_initializer())

# Load mnist data    )
datasets <- tf$contrib$learn$datasets
mnist <- datasets$mnist$read_data_sets("MNIST-data", one_hot = TRUE)

# Train
for (i in 1:1000) {
  batches <- mnist$train$next_batch(100L)
  batch_xs <- batches[[1]]
  batch_ys <- batches[[2]]
  sess$run(train_step,
           feed_dict = dict(x = batch_xs, y_ = batch_ys))
}

# Test trained model
correct_prediction <- tf$equal(tf$argmax(y, 1L), tf$argmax(y_, 1L))
accuracy <- tf$reduce_mean(tf$cast(correct_prediction, tf$float32))
sess$run(accuracy,
         feed_dict = dict(x = mnist$test$images, y_ = mnist$test$labels))

