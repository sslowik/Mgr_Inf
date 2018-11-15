#create the labyrinth 10x10 with borders -> matrix(12:12)

lab1 <- matrix(nrow=12,ncol=12)
lab1[1,] <- 1; lab1[12,] <- 1; lab1[,1] <- 1; lab1[,12] <- 1
lab1

#fill the labyrinth

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


# draw labyrinth > pheatmap
install.packages("pheatmap")
library(pheatmap)

pheatmap(lab1, cellwidth = 20, 
         cellheight = 20, 
         cluster_row = FALSE, 
         cluster_col = FALSE, 
         color=gray.colors(2,start=1,end=0))

# evaluation functions

evaluate3 <- function(string=c()) {
  x <- 2; 
  y <- 2; 
  returnVal3 <- 22;
  
  for(step in 1:40) { if (x==11 & y==11) { returnVal2 = 0; break
  } else if (round(string[step],0)==1 & lab1[x-1,y]==0) { x <- (x - 1)	
  } else if (round(string[step],0)==2 & lab1[x+1,y]==0) { x <- (x + 1) 
  } else if (round(string[step],0)==3 & lab1[x,y+1]==0) { y <- (y + 1) 
  } else if (round(string[step],0)==4 & lab1[x,y-1]==0) { y <- (y - 1) 
  } else next 
  }
  returnVal3 <- (22 - x - y); 
  returnVal3
}	





#step up - 1
#step down - 2
#step right - 3
#step left - 4

v_exit <- c(3,4,1,2,3,3,2,3,3,1,3,3,2,2,2,2,2,3,3,2,3,2,2  ,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1)
length(v_exit)

evaluate3(v_exit)


vMin <- rep(0.51, 40); vMax <- rep(4.49, 40)


# genalg
genalg_lab1 <- rbga(stringMin=vMin, stringMax=vMax,
                    suggestions=NULL,
                    popSize=200, iters=100,
                    mutationChance=0.1,
                    elitism=TRUE,
                    monitorFunc=NULL, evalFunc=evaluate3,
                    showSettings=FALSE, verbose=FALSE)

summary(genalg_lab1, echo=T)
plot(genalg_lab1)
genalg_lab1$best



genalg_lab4 <- rbga(stringMin=vMin, stringMax=vMax,
                    suggestions=NULL,
                    popSize=50, iters=50,
                    mutationChance=0.2,
                    elitism=T,
                    monitorFunc=NULL, evalFunc=evaluate3,
                    showSettings=FALSE, verbose=FALSE)

summary(genalg_lab4, echo=T)
plot(genalg_lab4)
genalg_lab4$best
labyrinth
lab2 <- lab1
lab2
lab1 <- labyrinth
labyrinth
lab1 <- lab2
lab1
summary

summary(genalg_lab1, echo=T)
