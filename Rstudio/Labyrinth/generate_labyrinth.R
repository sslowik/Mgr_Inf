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

evaluator_f <- function(chr) {
  current_row <- 1
  current_column <- 1
  for(steps in 1:(length(chr)/2)) {
  
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


genalg_lab <- rbga.bin(size=80, 
                       popSize=200, 
                       iters=100, 
                       mutationChance = 0.1,
                       elitism=T, 
                       evalFunc = evaluator_f)

result <- evaluator_f(chromo)
result
steps

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



evaluate <- function(string=c()) {
  returnVal = NA;
  
  for(xx in 1:path_length) {
    this_step = string(xx)
    switch (this_step,
      0 = action
    )
  
    if this_step == 0 
    else if 
    else if
    else stop("You'd better not break the wall with the head")
      
  }
  if (length(string) == 2) {
    returnVal = abs(string[1]-pi) + abs(string[2]-sqrt(50));
  } else {
    stop("Expecting a chromosome of length 2!");
  }
  returnVal
}


lab_rbga <- rbga(stringMin = c(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1), 
     stringMax = c(4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4), 
     evalFunc=evaluator, verbose=TRUE, mutationChance=0.1, suggestions=NULL,
     popSize=200, iters=100,elitism=TRUE, monitorFunc=NULL)

summary(lab_rbga)
lab_rbga
