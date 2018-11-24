# define the function to generate random labyrinth of given size (may be insolvable)

generate_lab <- (function(y) apply(matrix(nrow = y, ncol =y), c(1,2), function(x) sample(c(0,1),1)))

# set size

labi_size <- as.integer(readline(prompt = "Podaj rozmiar labiryntu:"))

# generate labyrinth, clear  start and exit, add borders
# fill the inner part with generated random lab

{ 
  lab_x <- generate_lab(labi_size);
  lab_x[nrow(lab_x),ncol(lab_x)] <- 0; 
  lab_x[1,1] <- 0; 
  lab_xx = matrix(data = 1, 
                  nrow = labi_size + 2, 
                  ncol = labi_size + 2);
  lab_xx[2:(labi_size+1),2:(labi_size+1)] <- lab_x
  }

# correct the labyrinth manually if needed :)

lab_xx[11:14,11] <- 0
lab_xx[15,19] <- 0

# draw labyrinth with pheatmap package

install.packages("pheatmap")

library(pheatmap)

pheatmap(lab_xx, cellwidth = 10, 
         cellheight = 10, 
         cluster_row = FALSE, 
         cluster_col = FALSE, 
         color=gray.colors(2,start=1,end=0))

# You can save the labyrinth as .pdf file
{
  pdf(file = "lab20.pdf", 
      width=7,
      height=7,
      paper='a4', 
      pagecentre = T, 
      onefile = F) 
  
  pheatmap(lab_xx, cellwidth = 15, 
           cellheight = 15, 
           cluster_row = FALSE, 
           cluster_col = FALSE, 
           color=gray.colors(2,start=1,end=0))
  
  dev.off()
}

#assign generated lab to new matrix


lab20 <- lab_xx
dim(lab20)

dim(lab_xx) <- c(22,22)

dim(lab_xx)
lab_xx

#lab_xx to vector
dim(lab_xx) <- (dim(lab_xx)[1]*dim(lab_xx)[2])
