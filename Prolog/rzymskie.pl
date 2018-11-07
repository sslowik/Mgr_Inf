/*
rozkład wg wzoru: 
MCLXIV = 1000(M) + 100(C) + 50(L) + 10(X) – 1(I) + 5(V) = 1164

*/

rzym([], 1).
rzym([i], 5).
rzym([x], 10).
rzym([l], 50).
rzym([c], 100).
rzym([d], 500).
rzym([m], 1000).

rzym([A[B|C,X) :-  X is . 
rzym([A[B|C),Y :- Y is . 
