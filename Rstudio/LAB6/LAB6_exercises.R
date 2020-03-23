setwd("H:/Mgr_Inf/Rstudio/LAB6")

#zad 1

plecakdb <- data.frame(
  wiek = c(23, 25,28,22,46,50,48),
  waga = c(75, 67, 120, 65, 70, 68, 97),
  wzrost = c(176, 180, 175, 165, 187, 180, 178),
  gra = c("TRUE", "TRUE", "FALSE", "TRUE", "TRUE", "FALSE", "FALSE"))

fct_act <- function(x){
  return(1/(1+exp(-x)))
}

forwardPass <- function(wiek,waga,wzrost){
  hidden1 <- wiek* -0.46122 + waga * 0.97314 +wzrost*-0.39203 + 0.80109
  hidden2 <- wiek* -0.78548 + waga * 2.10584 +wzrost*-0.57847 + 0.43529
  hidden1 <- fct_act(hidden1)
  hidden2 <- fct_act(hidden2)
  hidden3 = hidden1*(-0.81546)
  hidden4 = hidden2*1.03775
  return(hidden3+hidden4+(-0.2368))
}

forwardPass(23,75,176)

