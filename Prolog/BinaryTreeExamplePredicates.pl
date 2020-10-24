countNodes(nil,0).
countNode(t(_,Left,Right),N) :-
   countNode(Left,NLeft),
   countNode(Right,NRight),
   N is NLeft + NRight + 1.

searchTree(t(N,_,_),N).
searchTree(t(_,Left,Right), N) :- 
    searchTree(Left, N); 
    searchTree(Right, N). 

maxTree(nil,0). 
maxTree(t(N,nil,nil),N). 
maxTree(t(_,L,R),N) :- maxTree(L, NL), maxTree(R,NR), NL > NR, !, N = NL. 
maxTree(t(_,L,R),N) :- maxTree(L, NL), maxTree(R,NR), NR > NL, N = NR. 

treeTimes(_,nil,0). 
treeTimes(N,t(Root,nil,nil),D2) :- D2 is Root * N. 
treeTimes(N,t(Root,L,R),D3) :- treeTimes(N,L,DL), treeTimes(N,R,DR), D3 is DL + DR + (N * Root). 

treePreorder(nil,[]). 
treePreorder(t(X, L, R), [X|T]) :- 
    treePreorder(L, LT),
    treePreorder(R, RT),
    append(LT, RT, T).