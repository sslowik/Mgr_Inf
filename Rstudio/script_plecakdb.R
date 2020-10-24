plecakdb <- data.frame(
przedmiot = c("zegar", "obraz-pejzaz","obraz-portret", "radio", "laptop", "lampka nocna", "srebrne sztucce", "porcelana", "figura z brazu", "skórzana
  torebka", "odkurzacz"),
  wartosc = c(100, 300, 200, 40, 500, 70, 100, 250, 300,280,300),
  waga = c(7, 7, 6, 2, 5, 6, 1, 3, 10, 3, 15))
plecaklimit <- 25

chromosome = c(0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1)
plecakdb[chromosome == 1, ]
cat(chromosome %*% plecakdb$wartosc)

fitnessFunc <- function(chr) {
  calkowita_wartosc_chr <- chr %*% plecakdb$wartosc
  calkowita_waga_chr <- chr %*% plecakdb$waga
  if (calkowita_waga_chr > plecaklimit)
    return(0) else return(-calkowita_wartosc_chr)
}

plecakGenAlg <- rbga.bin(size = 11, popSize = 200, iters = 100,
                         mutationChance = 0.05, elitism = T, evalFunc = fitnessFunc)
summary(plecakGenAlg, echo=TRUE)

chromosome_best = c(0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0)

fitnessFunc(chromosome_best)

plecakGenAlg$best

-plecakGenAlg$best

wek <- -plecakGenAlg$best    #najlepsze rozwizanie
wek2 <- -plecakGenAlg$mean   #srednia

plot(wek, type="l")

plot(-plecakGenAlg$best, type="l", col="red", xlim=range(c(0,50)), main="Najlepszy plecak", xlab="pokolenie", ylab="wartosc")
lines(wek2, type="l", col="blue")

legend("bottomright", legend=c("max", "srednia"))
legend("bottomright", legend=c("max", "srednia"), col=c("green", "blue"), lty=1:2, cex=0.7)

  

