#zad 1 grupowanie

#krok1 - rozrzucone dane
#krok2 - klastry
#krok3 - w pętli - sprawdzamy odległość do grupoidów i przypisujemy do odpowiedniego
#krok4 - znikają stare centra i pojawia się nowy grupoid jako średnia dla punktów z klastra. punkty są weryfikowane czy zmieniły klaster
#krok5 - weryfikowanie, czy sytuacja sie ustabilizowała - punkty nie zmieniają klastrów

#zad 2

iris.log <- log(iris[,1:4])
iris.stand <- scale(iris.log, center=TRUE)
iris.pca <- prcomp(iris.stand)
iris.final <- predict(iris.pca)[,1:2]

require(graphics)

#b) wyrysowanie dwukolumnowej tabeli z podziałem na 3 klastry i wyrysowaniem centrów

{
cl <- kmeans(iris.final, 4, nstart = 1); cl
plot(iris.final, col = cl$cluster)
points(cl$centers, col = 1:2, pch = 8, cex = 2)
}

#c) 

plot(iris.final, col=c("virgnica", "setosa", "versicolor") == iris$Species)
plot(iris.final, col=match(iris$Species, c("virgnica", "setosa", "versicolor")))




#wyniki zad 3
   SUP   CON
A2 0,4  0,444      
A3 0,5  0,71
A4 0,5  1
A5 0,2  1


# kontent podany jako przykład w zadaniu 2, link: 
# https://stat.ethz.ch/R-manual/R-devel/library/stats/html/kmeans.html


# a 2-dimensional example
x <- rbind(matrix(rnorm(100, sd = 0.3), ncol = 2),
           matrix(rnorm(100, mean = 1, sd = 0.3), ncol = 2))
colnames(x) <- c("x", "y")
(cl <- kmeans(x, 2,))
plot(x, col = cl$cluster)
points(cl$centers, col = 1:2, pch = 8, cex = 2)

# sum of squares
ss <- function(x) sum(scale(x, scale = FALSE)^2)

## cluster centers "fitted" to each obs.:
fitted.x <- fitted(cl);  head(fitted.x)
resid.x <- x - fitted(cl)

## Equalities : ----------------------------------
cbind(cl[c("betweenss", "tot.withinss", "totss")], # the same two columns
      c(ss(fitted.x), ss(resid.x),    ss(x)))
stopifnot(all.equal(cl$ totss,        ss(x)),
          all.equal(cl$ tot.withinss, ss(resid.x)),
          ## these three are the same:
          all.equal(cl$ betweenss,    ss(fitted.x)),
          all.equal(cl$ betweenss, cl$totss - cl$tot.withinss),
          ## and hence also
          all.equal(ss(x), ss(fitted.x) + ss(resid.x))
)

kmeans(x,1)$withinss # trivial one-cluster, (its W.SS == ss(x))

## random starts do help here with too many clusters
## (and are often recommended anyway!):
(cl <- kmeans(x, 5, nstart = 25))
plot(x, col = cl$cluster)
points(cl$centers, col = 1:5, pch = 8)