generate_lab <- (function(y) apply(matrix(nrow = y, ncol =y), c(1,2), function(x) sample(c(0,1),1)))
lab_size <- as.integer(readline(prompt = "Podaj rozmiar labiryntu:"))

labyrinth <- generate_lab(lab_size)

labyrinth[nrow(labyrinth),ncol(labyrinth)] <- 0

round
set_exit <- function(x) {x[nrow(x),ncol(x)] <- 0 ;x}
set_exit(labyrinth)
labyrinth[10,10] <- 0
          
labyrinth[2,10] <- 0
round(1.49)


clear_start_and_exit <- function(x) {x[nrow(x),ncol(x)] <- 0 ; x[1,1] <- 0}
clear_start_and_exit(labyrinth)

labyrinth[5:6,8] <- 1; labyrinth
labyrinth


path_length <- lab_size * 4 
lab_size


# from genalg

install.packages('genalg')
library('genalg')

labyrinth
  
chromo <- round(runif(path_length*2,0,1), 0)
chromo

path_length



#step down - 00
#step up - 01
#step right - 10
#step left - 11

string=chromo
length(string)

evaluate <- function(string=c()) {
  current_row <- 1; 
  current_column <- 1;
  returnVal = NA; 
  
  for(step in 1:(length(chromosome))) {
  
    if 
      (
      (current_row == 1 && chr[(steps*2-1):(steps*2)] ==  c(0,1)) || 
      (current_row == length(chr)/4 && chr[(steps*2-1):(steps*2)] ==  c(0,0)) ||
      (current_column == 1 && chr[(steps*2-1):(steps*2)] ==  c(1,1)) ||
      (current_column == length(chr)/4 && chr[(steps*2-1):(steps*2)] ==  c(1,0))
      ) { break
    } else if (chr[(steps*2-1):(steps*2)] == c(0,0)) {
      (current_row <- current_row +1) 
    } else if (chr[(steps*2-1):(steps*2)] == c(0,1)) { 
      (current_row <- current_row - 1) 
    } else if (chr[(steps*2-1):(steps*2)] == c(1,0)) { 
      (current_column <- current_column + 1)
    } else if (chr[(steps*2-1):(steps*2)] == c(1,1)) {
      (current_column <- current_column - 1)
    }
  }
  return(length(chr)/4 - current_column + current_row + (steps/2))
}




# funkcja ewaluacji

evaluate1 <- function(string=c()) {
  xx <- 2; 
  yy <- 2; 
  
  for(step in 1:40) {
    
    if 			(round(string[step] == 1) && labyrinth[xx - 1 , yy] == 0 ) { 
      xx <- xx - 1; 
    } else if 	(round(string[step] == 1) && labyrinth[xx - 1 , yy] == 1 ) {
      break; 
    } else if 	(round(string[step] == 2) && labyrinth[xx + 1 , yy] == 0 ) { 
      xx <- xx + 1; 
    } else if 	(round(string[step] == 2) && labyrinth[xx + 1 , yy] == 1 ) {
      break;
    } else if 	(round(string[step] == 3) && labyrinth[xx , yy + 1] == 0 ) { 
      yy <- yy + 1; 
    } else if 	(round(string[step] == 3) && labyrinth[xx , yy + 1] == 1 ) {
      break;
    } else if 	(round(string[step] == 4) && labyrinth[xx , yy - 1] == 0 ) { 
      yy <- yy - 1; 
    } else if 	(round(string[step] == 4) && labyrinth[xx + 1 , yy] == 1 ) {
      break;
    }
    returnVal <- (22 - xx - yy);
  }
  returnVal
}


# genalg
genalg_lab1 <- rbga(stringMin=vMin, stringMax=vMax,
     suggestions=NULL,
     popSize=200, iters=100,
     mutationChance=0.1,
     elitism=TRUE,
     monitorFunc=NULL, evalFunc=evaluate1,
     showSettings=FALSE, verbose=FALSE)

# funkcja ewaluacji 2

evaluate2 <- function(string=c()) {
  x <- 2; 
  y <- 2; 
  returnVal2 = NA;
  for(step in 1:40) {
    
    if 	(round(string[step],0) == 1 & labyrinth[x - 1 , y] == 0) { 
      x <- x - 1;
      returnVal2 <- (22 - x - y);	
    } else if 	
    (round(string[step],0) == 2 & labyrinth[x + 1 , y] == 0) { 
      x <- x + 1; 
      returnVal2 <- (22 - x - y);
    } else if 	
    (round(string[step],0) == 3 & labyrinth[x , y + 1] == 0) { 
      y <- y + 1; 
      returnVal2 <- (2 - x - y);
    } else if 	
    (round(string[step],0) == 4 & labyrinth[x , y - 1] == 0) { 
      y <- y - 1; 
      returnVal2 <- (22 - x - y);
    } else if 
    (x == 11 && y == 11) {
      break;
    }
  }	
  returnVal2
}

# genalg2
genalg_lab2 <- rbga(stringMin=vMin, stringMax=vMax,
                    suggestions=NULL,
                    popSize=200, iters=100,
                    mutationChance=0.2,
                    elitism=NA,
                    monitorFunc=NULL, evalFunc=evaluate2,
                    showSettings=FALSE, verbose=FALSE)

summary(genalg_lab2, echo=T)

plot(genalg_lab2)

genalg_lab2$best

genalg_lab2









chromo
c(1,0)
steps
chromo[1:2] == c(1,0)

to_exit <- (lab_size * 2) - (current_column + current_row)
steps; current_row; current_column; to_exit
chromo
labyrinth

chromo[(steps*2-1):(steps*2)]==c(1,1)

labyrinth[step_down - step_up , step_right - step_left]

labyrinth[1,1]
labyrinth






