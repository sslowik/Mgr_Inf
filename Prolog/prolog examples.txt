/* 
rzym2(R,D) :- rzym(R,0,D) .

rzym2( [] , D , D ) :- .
rzym2( R  , T , D ) :-
  roman2(P,V) ,
  append(P,S,R) ,
  ! ,
  T1 is T+V ,
  rzym2(S,T1,D) . 
  
  
  nwd(X1, Y1, Nwd) :-  
  
 
 
  predicates
  transform(integer)

clauses
  transform(X) :- X >= 1000, write("M"),  Y=X-1000,  transform(Y).
  transform(X) :- X >=  900, write("CM"), Y=X-900,   transform(Y).
  transform(X) :- X >=  500, write("D"),  Y=X - 500, transform(Y).
  transform(X) :- X >=  400, write("CD"), Y=X-400,   transform(Y).
  transform(X) :- X >=  100, write("C"),  Y=X-100,   transform(Y).
  transform(X) :- X >=   50, write("L"),  Y=X-50,    transform(Y).
  transform(X) :- X >=   40, write("XL"), Y=X-40,    transform(Y).
  transform(X) :- X >    9, write("X"),  Y=X-10,    transform(Y).
  transform(X) :- X =    9, write("IX"), nl.
  transform(X) :- X >    4, write("V"),  Y=X-5,     transform(Y).
  transform(X) :- X =    4, write("IV"),nl.
  transform(X) :- X >=   1, write("I"),  Y=X-1,     transform(Y).
  transform(X) :- X =    0, nl.
  transform(X) :- X <    0, write("-"), Y=-X, transform(Y).

goal
   transform(75).
*/