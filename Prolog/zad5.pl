/*
Niech będą dane następujące predykaty:

 q1(X,Y) :- p(X,Y).                q2(X,Y) :- p(X,Z), q2(Z,Y).
 q1(X,Y) :- p(X,Z), q1(Z,Y).       q2(X,Y) :- p(X,Y).  

 q3(X,Y) :- p(X,Y).                q4(X,Y) :- q4(X,Z), p(Z,Y).  
 q3(X,Y) :- q3(X,Z), p(Z,Y).       q4(X,Y) :- p(X,Y).  

oraz baza danych dla predykat p:

 p(pam,bob).       
 p(tom,bob).
 p(tom,liz).
 p(bob,ann).      
 p(bob,pat).     
 p(pat,jim). 

Proszę zilustrować, jak Prolog odpowiada na pytania ?-qi(tom,pat). oraz ?-qi(liz,jim).

?- qi(tom,pat). 



?- q1(tom,pat). 


?- q2(tom,pat). 


?- q3(tom,pat). 


?- q4(tom,pat). 



?-q1(liz,jim).

?-q2(liz,jim).

?-q3(liz,jim).

?-q4(liz,jim).

*/