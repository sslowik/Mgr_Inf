# define the function to generate random labyrinth of given size (may be insolvable)

lab_size <- as.integer(readline(prompt = "Podaj rozmiar labiryntu:"))

generate_lab <- (function(y) apply(matrix(nrow = y, ncol =y), c(1,2), function(x) sample(c(0,1),1)))

lab_x <- generate_lab(lab_size)

#clear the start and exit 
{ 
lab_x[nrow(lab_x),ncol(lab_x)] <- 0; 
lab_x[1,1] <- 0
}

#add borders

lab_xx = matrix(data = 1, 
                nrow = lab_size + 2, 
                ncol = lab_size + 2)

# fill the inner part with generated lab

lab_xx[2:11,2:11] <- lab_x

lab4 <- lab_xx

#create the matrix for given labyrinths 10x10 and add borders (result is matrix(12:12) )

lab1 <- matrix(nrow=12,ncol=12)
lab1[1,] <- 1; lab1[12,] <- 1; lab1[,1] <- 1; lab1[,12] <- 1
lab1

#fill the inner of the labyrinth from example

{
lab1[2, 2:11] <- c(0,0,0,1,0,0,0,1,0,0) 
lab1[3, 2:11] <- c(1,1,0,0,0,1,0,1,1,0) 
lab1[4, 2:11] <- c(0,0,0,1,0,1,0,0,0,0)
lab1[5, 2:11] <- c(0,1,0,1,1,0,0,1,1,0)
lab1[6, 2:11] <- c(0,0,1,1,0,0,0,1,0,0)
lab1[7, 2:11] <- c(0,0,0,0,0,1,0,0,0,1)
lab1[8, 2:11] <- c(0,1,0,0,1,1,0,1,0,0)
lab1[9, 2:11] <- c(0,1,1,1,0,0,0,1,1,0)
lab1[10,2:11] <- c(0,1,0,1,1,0,1,0,1,0)
lab1[11,2:11] <- c(0,1,0,0,0,0,0,0,0,0)
}


{ #Create lab2
  lab2 <- matrix(nrow=12,ncol=12);
  lab2[1,] <- 1; lab2[12,] <- 1; lab2[,1] <- 1; lab2[,12] <- 1;

  lab2[2, 2:11] <- c(0,0,0,1,0,0,0,1,0,0) 
  lab2[3, 2:11] <- c(1,1,0,0,0,1,0,1,1,0) 
  lab2[4, 2:11] <- c(0,0,0,1,0,1,0,0,0,0)
  lab2[5, 2:11] <- c(0,1,0,1,1,0,0,1,1,0)
  lab2[6, 2:11] <- c(0,0,1,1,0,0,0,1,0,0)
  lab2[7, 2:11] <- c(0,0,0,0,0,1,0,0,0,1)
  lab2[8, 2:11] <- c(0,1,0,0,1,1,0,1,0,0)
  lab2[9, 2:11] <- c(0,1,1,1,0,0,0,1,1,0)
  lab2[10,2:11] <- c(0,1,0,1,1,0,1,0,1,0)
  lab2[11,2:11] <- c(0,1,0,0,0,0,0,0,0,0)
}



# set the source labyrinth (execute only one of lines)

labyrinth <- lab1
labyrinth <- lab2
labyrinth <- lab3
labyrinth <- lab4
labyrinth <- lab5

# set the size of the labyrinth, according to it's actual dimensions
lab_size <- nrow(labyrinth) - 2; lab_size


# draw labyrinth with pheatmap package

install.packages("pheatmap")

library(pheatmap)

pheatmap(labyrinth, cellwidth = 20, 
         cellheight = 20, 
         cluster_row = FALSE, 
         cluster_col = FALSE, 
         color=gray.colors(2,start=1,end=0))

pheatmap(lab5, cellwidth = 20, 
         cellheight = 20, 
         cluster_row = FALSE, 
         cluster_col = FALSE, 
         color=gray.colors(2,start=1,end=0))

# correct the labyrinth manually if needed :)

labyrinth[8,9] <- 0

#save corrected labyrinth if needed
lab4 <- labyrinth


# You can save the labyrinth as .pdf file
{
pdf(file = "labyrinth.pdf", 
    width=5,
    height=5,
    paper='a4', 
    pagecentre = T, 
    onefile = F) 

pheatmap(labyrinth, cellwidth = 20, 
         cellheight = 20, 
         cluster_row = FALSE, 
         cluster_col = FALSE, 
         color=gray.colors(2,start=1,end=0))

dev.off()
}


# evaluation function
# fuction takes the float chromosome and rounds each gene to integer. 
# possible rounded values are 1,2,3,4. Each int is treated like step in one of 4 directions: 
#step up - int 1
#step down - int 2
#step right - int 3
#step left - int 4
# than function loops the chromosome and for each step \
# if the step is possible sets coordinates x,y according to the this move.
# impossible step does not affect the coordinates. 
# at the beginning of each iteration function chackes if the exit is reached
# - if so it breaks the loop and returns the value of the function. 
# value of the function is calculated as the coordinates of the exit (
# (placed in right-down corner) minus x coordinate - y coordinate, so it evaluate 
# the distance from the exit.  
# In other versions function evaluated also the number of steps divided by 10,
# so it promoted the resolutions with less step numbers, but enalg.rbga function 
# was less efficient with this approach (more generations needed to resolve problem)

evaluate3 <- function(string=c()) {
  x <- 2; 
  y <- 2; 
  exit_coordinates <- lab_size * 2 + 2; 
  returnVal3 <- exit_coordinates;
  
  for(step in 1:40) { if (x==11 & y==11) { returnVal2 = 0; break
  } else if (round(string[step],0)==1 & labyrinth[x-1,y]==0) { x <- (x - 1)	
  } else if (round(string[step],0)==2 & labyrinth[x+1,y]==0) { x <- (x + 1) 
  } else if (round(string[step],0)==3 & labyrinth[x,y+1]==0) { y <- (y + 1) 
  } else if (round(string[step],0)==4 & labyrinth[x,y-1]==0) { y <- (y - 1) 
  } else next 
  }
  returnVal3 <- (exit_coordinates - x - y); 
  returnVal3
}	

# test the function with v_exit vector for lab1 - result should be 0

v_exit_lab1 <- c(3,4,1,2,3,3,2,3,3,1,3,3,2,2,2,2,2,3,3,2,3,2,2,2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3)
length(v_exit_lab1)
evaluate3(v_exit_lab1)

# set the min and max values for the genes of float chromosome
# for rbga function 

vMin <- rep(0.51, lab_size * 4); vMax <- rep(4.49, lab_size * 4)

# install package "genalg" and execute rbga function for given labyrinth 
# and evaluate3 fitness function

install.packages("genalg")
library(genalg)

genalg4_labyrinth <- rbga(stringMin=vMin, stringMax=vMax,
                    suggestions=NULL,
                    popSize=lab_size*10, iters=lab_size*10,
                    mutationChance=0.1,
                    elitism=T,
                    monitorFunc=NULL, evalFunc=evaluate3,
                    showSettings=FALSE, verbose=FALSE)

summary(genalg4_labyrinth, echo=T)

plot(genalg4_labyrinth)

genalg4_labyrinth$best

#evaluate the system time for given genetic algorithm

system.time(
  rbga(stringMin=vMin, stringMax=vMax,
       suggestions=NULL,
       popSize=lab_size*10, iters=lab_size*10,
       mutationChance=0.1,
       elitism=T,
       monitorFunc=NULL, evalFunc=evaluate3,
       showSettings=FALSE, verbose=FALSE)
)

# evaluate for different population and number of generations:  

for (i in 1:lab_size) {
cat("Population size and iterations = ", i * lab_size)
cat("\n")    
cat(system.time(
  rbga(stringMin=vMin, stringMax=vMax,
       suggestions=NULL,
       popSize=lab_size*i, iters=lab_size*i,
       mutationChance=0.1,
       elitism=T,
       monitorFunc=NULL, evalFunc=evaluate3,
       showSettings=FALSE, verbose=FALSE)
))
cat("\n")  
}


# or create matrix with results for different popsize and iterations number
{
rbga_results <- (matrix(data = NA, nrow = lab_size, ncol = 6))
colnames(rbga_results) <- c("pop&iter", "user", "system", "time", '5', '6' )


for (i in 1:lab_size) {
rbga_results[i,] <- c(i * lab_size, system.time(
    rbga(stringMin=vMin, stringMax=vMax,
         suggestions=NULL,
         popSize=lab_size*i, iters=lab_size*i,
         mutationChance=0.1,
         elitism=T,
         monitorFunc=NULL, evalFunc=evaluate3,
         showSettings=FALSE, verbose=FALSE)
  ))
}
rbga_results
}

# plot the results 
plot(rbga_results[,c(1,4)],
     type = "b", 
     col = "red",
     main = "Genethic algorithm efficiency according to population size and iterations number", 
     xlab = "Population size and iterations number for rbga method"
     )

# save diagram to pdf file

{
  pdf(file = "genalg_results.pdf", 
#      width=6,
      height=4,
      paper='a4r', 
      pagecentre = T, 
      onefile = F) 
  
  plot(rbga_results[,c(1,4)],
       type = "b", 
       col = "red",
       main = "Genalg efficiency according to population size and iterations number", 
       xlab = "Population size and iterations number for rbga method"
  )  
  
dev.off()
}


