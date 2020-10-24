gcd1 n m = 
    if n /= m
    then if n < m 
        then gcd1 n (m - n) 
        else gcd1 (n - m) m
    else n

smaller n m = 
    n < m
    
greater n m = 
    smaller n m

equal x y = 
    if smaller x y 
        then False
    else if greater x y
        then False
    else True

smaller_equal x y = 
    not (greater x y)

greater_equal x y = 
  not (smaller x y)

not_equal x y = 
  not (equal x y)
