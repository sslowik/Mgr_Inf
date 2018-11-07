generate_lab <- (function(y) apply(matrix(nrow = y, ncol =y), c(1,2), function(x) sample(c(0,1),1)))

lab_size <- as.integer(readline(prompt = "Podaj rozmiar labiryntu:"))

labyrinth <- generate_lab(lab_size)

set_exit <- function(x) {x[nrow(x),ncol(x)] <- 0 ;x}

set_exit(labyrinth)

path_length <- lab_size * 4 


# from genalg

install.packages('genalg')
library('genalg')


  
chromo <- round(runif(path_length,1,4), 0)
chromo


current_row <- 1
current_column <- 1

for(steps in 1:path_length) { 
    if 
      (
      (current_row == 1 && chromo[steps] ==  2) || 
      (current_row == lab_size && chromo[steps] ==  1) ||
      (current_column == 1 && chromo[steps] ==  4) ||
      (current_column == lab_size && chromo[steps] ==  3) ||
      (steps != 1 && labyrinth[current_row , current_column] == 1)
      ) 
    { break
    } else if (chromo[steps] == 1) {
      (current_row <- current_row +1) 
    } else if (chromo[steps] == 2) { 
      (current_row <- current_row - 1) 
    } else if (chromo[steps] == 3) { 
      (current_column <- current_column + 1)
    } else if (chromo[steps] == 4) {
      (current_column <- current_column - 1)
  }  
}

to_exit <- (lab_size * 2) - (current_column + current_row)
steps; current_row; current_column; to_exit
chromo
labyrinth

chromo[1]=3

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