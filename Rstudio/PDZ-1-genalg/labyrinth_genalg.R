# set the source labyrinths lab10, lab15 and lab20 (inner size without borders)

{
  lab10 <- matrix(nrow=12,ncol=12);
  lab10[1,] <- 1; lab10[12,] <- 1; lab10[,1] <- 1; lab10[,12] <- 1;
  
  #fill the inner of the labyrinth from example
  
  lab10[2, 2:11] <- c(0,0,0,1,0,0,0,1,0,0) 
  lab10[3, 2:11] <- c(1,1,0,0,0,1,0,1,1,0) 
  lab10[4, 2:11] <- c(0,0,0,1,0,1,0,0,0,0)
  lab10[5, 2:11] <- c(0,1,0,1,1,0,0,1,1,0)
  lab10[6, 2:11] <- c(0,0,1,1,0,0,0,1,0,0)
  lab10[7, 2:11] <- c(0,0,0,0,0,1,0,0,0,1)
  lab10[8, 2:11] <- c(0,1,0,0,1,1,0,1,0,0)
  lab10[9, 2:11] <- c(0,1,1,1,0,0,0,1,1,0)
  lab10[10,2:11] <- c(0,1,0,1,1,0,1,0,1,0)
  lab10[11,2:11] <- c(0,1,0,0,0,0,0,0,0,0)
}


{
lab15_v <- c(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,0,0,0,0,1,1,1,0,1,0,0,0,1,1,0,0,0,1,1,0,0,1,1,1,0,0,0,1,0,1,1,1,1,0,1,0,0,1,0,1,1,1,1,0,1,0,1,1,0,0,0,0,0,0,1,1,1,1,1,1,0,1,1,1,1,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1,1,0,1,0,1,0,1,0,0,0,1,1,1,0,1,1,1,1,0,1,1,1,0,0,0,1,1,1,1,1,0,1,0,1,1,0,0,0,1,1,0,1,0,1,0,0,0,0,0,0,1,1,0,1,0,0,1,0,1,1,1,0,0,1,1,0,1,1,1,0,1,0,1,1,0,0,0,1,0,1,1,0,1,1,1,1,0,0,1,0,0,1,1,1,1,0,1,1,0,0,1,1,1,0,0,0,1,1,0,0,0,0,0,0,0,0,1,1,1,1,0,0,1,0,0,0,1,1,1,0,0,1,0,1,1,1,1,1,0,0,0,1,1,1,1,0,0,1,0,0,1,1,1,1,0,0,1,0,1,1,0,1,1,0,0,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)
lab15 <- matrix(data=lab15_v, nrow = 17, ncol = 17)
}

{
lab20 <- c(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,0,0,0,1,0,0,1,0,1,1,1,1,0,0,1,1,1,0,0,0,1,1,0,0,0,0,0,0,0,1,1,1,1,0,0,1,0,1,1,1,1,0,0,0,0,0,1,1,1,0,0,1,0,0,0,0,0,0,0,1,1,0,1,1,1,0,1,1,1,1,1,0,0,1,0,0,0,1,0,0,1,1,1,1,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,1,1,0,0,0,0,1,1,0,0,1,1,1,0,1,1,1,1,1,0,0,0,0,1,1,1,1,1,0,0,0,0,1,0,1,1,1,1,1,0,0,0,1,0,0,0,0,0,1,1,1,0,1,0,0,1,0,1,0,1,1,0,1,1,1,0,1,0,0,0,1,0,1,1,0,1,1,1,1,1,0,1,1,1,0,0,0,1,0,0,1,0,0,0,0,0,0,1,1,1,0,1,0,1,1,1,0,1,0,1,0,1,0,1,1,0,1,1,0,1,1,0,1,1,0,1,1,1,0,0,0,0,0,0,1,1,0,1,1,0,0,1,0,0,1,0,1,1,1,1,0,1,1,1,0,0,1,0,0,0,1,1,0,0,0,0,0,1,0,1,1,0,1,0,1,1,0,1,0,1,0,0,0,1,1,1,1,1,1,0,1,1,1,0,0,0,1,1,0,1,1,0,0,1,0,1,1,1,0,0,0,1,0,1,1,1,0,1,0,0,0,1,1,0,0,0,0,0,0,0,1,1,0,1,1,1,1,0,1,0,0,0,0,0,0,0,0,1,1,1,1,0,1,1,0,0,1,1,1,1,1,0,1,1,0,1,1,1,1,0,0,0,0,0,0,0,0,0,1,1,1,0,1,1,0,1,0,0,0,0,1,0,0,1,1,0,1,0,1,1,1,1,1,1,1,1,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)  
dim(lab20) <- c(22,22)  
}

# choose the labyrinth for genalg 

labyrinth <- lab10
labyrinth <- lab15
labyrinth <- lab20

# draw labirynth with pheatmap
install.packages("pheatmap")

library(pheatmap)

pheatmap(labyrinth, cellwidth = 15, 
         cellheight = 15, 
         cluster_row = FALSE, 
         cluster_col = FALSE, 
         color=gray.colors(2,start=1,end=0))


# set the variable for the size of choosen labyrinth
lab_size <- nrow(labyrinth) - 2; lab_size

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
  exit_coordinates_sum <- lab_size * 2 + 2; 
  returnVal3 <- exit_coordinates_sum;
  
  for(step in 1:length(string)) { if (x==lab_size + 1 & y==lab_size + 1) { returnVal2 = 0; break
  } else if (round(string[step],0)==1 & labyrinth[x-1,y]==0) { x <- (x - 1)	
  } else if (round(string[step],0)==2 & labyrinth[x+1,y]==0) { x <- (x + 1) 
  } else if (round(string[step],0)==3 & labyrinth[x,y+1]==0) { y <- (y + 1) 
  } else if (round(string[step],0)==4 & labyrinth[x,y-1]==0) { y <- (y - 1) 
  } else next 
  }
  returnVal3 <- (exit_coordinates_sum - x - y); 
  returnVal3
}	

# set the min and max values for the genes of float chromosome
# for rbga function 

vMin <- rep(0.51, lab_size * 4); vMax <- rep(4.49, lab_size * 4)

# install package "genalg" and execute rbga function for given labyrinth 
# and evaluate3 fitness function


install.packages("genalg")
library(genalg)

genalg_labyrinth <- rbga(stringMin=vMin, stringMax=vMax,
                          suggestions=NULL,
                          popSize=200, iters=200,
                          mutationChance=0.1,
                          elitism=T,
                          monitorFunc=NULL, evalFunc=evaluate3,
                          showSettings=FALSE, verbose=FALSE)

summary(genalg_labyrinth, echo=T)

plot(genalg_labyrinth)

genalg_labyrinth$best




genalg2_labyrinth <- rbga(stringMin=vMin, stringMax=vMax,
                    suggestions=NULL,
                    popSize=lab_size*10, iters=lab_size*10,
                    mutationChance=0.1,
                    elitism=T,
                    monitorFunc=NULL, evalFunc=evaluate3,
                    showSettings=FALSE, verbose=FALSE)

summary(genalg2_labyrinth, echo=T)

plot(genalg2_labyrinth)

genalg2_labyrinth$best

#evaluate the system time for given genetic algorithm

system.time(
  rbga(stringMin=vMin, stringMax=vMax,
       suggestions=NULL,
       popSize=200, iters=200,
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
  pdf(file = "genalg_results_lab15.pdf", 
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


