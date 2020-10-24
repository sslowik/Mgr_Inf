# a)
dirty.iris <- read.csv("dirty_iris.csv", header=TRUE, sep=",")
dirty.iris[1:3]

pelne_rekordy <- nrow(subset(dirty.iris, is.finite(Sepal.Length) & is.finite(Sepal.Width) & is.finite(Petal.Length) & is.finite(Petal.Width)))

pelne_rekordy

# b)
install.packages("editrules")

library(editrules)

E <- editset(c("Sepal.Length <= 30")) ; E

# Następnie sprawdzamy ile wierszy tabeli nie spełnia tej reguły.

ve <- violatedEdits(E, dirty.iris) ; ve

# Można wyświetlić też :
summary(ve)
plot(ve)

# c) Popraw editset E , tak aby miał dodatkowo następujące reguły (możesz je wpisać ręcznie w
                                                                 komendzie, lub wczytać z pliku komendą editfile ).
# Ostatnia kolumna zawiera tylko wartości: setosa, versicolor, virginica.
# Wszystkie numeryczne wartości muszą być dodatnie.
# Petal.Length musi być minimum dwa razy większe niż Petal.Width
# Sepal jest zawsze dłuższy niż Petal.

E <- editset(expression(
  Sepal.Length <= 30, 
  Sepal.Length > 0, 
  Sepal.Width > 0, 
  Petal.Length > 0, 
  Petal.Width > 0, 
  Petal.Width > 0,
  Petal.Length > 2 * Petal.Width, 
  Sepal.Length > Petal.Length, 
  Species %in% c("setosa", "versicolor" , "virginica")
))

ve <- violatedEdits(E, dirty.iris)

summary(ve)

class(ve)

plot(ve)

# Zadanie 2 „Wymazanie błędów”

install.packages("deducorrect")

library(deducorrect)

# do uzupełnienia te rule z zadania: 

u2 <- correctionRules(expression(
  if (!is.na(Sepal.Length) & Sepal.Length >= 30) { Sepal.Lenth <- NA }
  if (!is.na(Petal.Length) & !is.na(Petal.Width)  
      if ()
        
  ))