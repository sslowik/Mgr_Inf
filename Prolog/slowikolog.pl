ismember(X, [Y|Z]) :- X==Y ; ismember(X,Z).

fib(0, 0).
fib(1, 1).
fib(N, Result) :- N1 is N - 1, N2 is N - 2, fib(N1, Result1), fib(N2, Result2), Result is Result1 + Result2.

sil(0,F) :- F is 1.
sil(N1,F1) :- N1 > 0,
              N2 is N1-1,
                silnia(N2,F2),
                F1 is N1*F2.

f(1,one).
f(s(1),two).
f(s(s(1)),three).
f(s(s(s(X))),N) :- f(X,N). 

rzymskie(i, 1).
rzymskie(v, 5).
rzymskie(x, 10).
rzymskie(l, 50).
rzymskie(c, 100).
rzymskie(d, 500).
rzymskie(m, 1000).

rzym(Sum, _, [], Sum).
 
rzym(LastSum, LastValue, [Digit|Rest], NextSum) :-
   rzymskie(Digit, Value),
   Value < LastValue,
   Sum is LastSum - Value,
   rzym(Sum, Value, Rest, NextSum).
 
rzym(LastSum, LastValue, [Digit|Rest], NextSum) :-
   rzymskie(Digit, Value),
   Value >= LastValue,
   Sum is LastSum + Value,
   rzym(Sum, Value, Rest, NextSum).
 
rzym(Atom, Value) :-
   atom_chars(Atom, String),
   reverse(String, [Last|Rest]),
   rzymskie(Last, Start),
   rzym(Start, Start, Rest, Value).
 
 
female(ala).
female(ola).
female(ula).
female(ela).
female(maria). 
female(anna).
female(krysia).

male(marek).
male(lukasz). 
male(jan). 
male(mateusz).
male(piotr). 
male(pawel). 
male(jerzy). 

parent(maria, jan). 
parent(ola, marek). 
parent(ola, mateusz). 
parent(mateusz, ula). 
parent(piotr, pawel). 
parent(ala, pawel). 
parent(lukasz, ola).
parent(lukasz, piotr).
parent(anna, maria). 
parent(krysia, anna). 
parent(jerzy, krysia). 


child(X,Y) :- parent(Y, X).
 
sister(X,Y) :- 	parent(Z,X), 
				parent(Z,Y), 
				female(X).
				
mother(X,Y) :- 	parent(X,Y), 
				female(X).
				
hasachild(X) :- parent(X,_).

grandparent(X,Y) :- parent(X,Z), 
					parent(Z,Y). 
 
predecessor(X,Y) :- parent(X,Y). 
predecessor(X,Z) :- parent(X,Y), predecessor(Y,Z).


nwd(X, X, X) :- X > 0.
nwd(X, Y, Z) :- Y > 0, X > Y, W is X - Y, nwd(Y, W, Z).
nwd(X, Y, Z) :- X > 0, X < Y, W is Y - X, nwd(X, W, Z).

