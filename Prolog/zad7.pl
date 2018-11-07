/* 
zad. 7. Proszę zdefiniować następujące predykaty dla list.

a)     last(X,L), który jest spełniony, jeżeli X jest ostatnim elementem listy L.
b)    delete(X,L1,L2), który jest spełniony, jeżeli L2 równa się L1 bez elementu X.
c)    delete(L1,L2), który jest spełniony, jeżeli L2 równa się L1 bez ostatnich trzech elementów.
d)    reverse(L1,L2), który jest spełniony, jeżeli L2 jest listą L1 w odwrotnej kolejności.
e)    evenlength(L) oraz oddlength(L), które są spełnione, jeżeli długość listy L jest parzysta oraz nieparzysta.
f)    shift(L1,L2), który jest spełniony, jeżeli L2 równa się L1 po jednej rotacji do lewej.
    
Przykład:

     ?- shift([1,2,3,4,5],L).
     L = [2,3,4,5,1] 

    quadrat(L1,L2), który jest spełniony, jeżeli L2 zawiera quadraty elementów listy L1.
    Przykład:

     ?- quadrat([1,2,3,4,5],L).
     L = [1,4,9,16,25] 

    combine(L1,L2,L3), który jest spełniony, jeżeli L3 zawiera pary elementów z list L1 i L2.
    Przykład:

     ?- combine([1,2,3,4],[a,b,c,d],L).
     L = [[1,a],[2,b],[3,c],[4,d]] 

    palindrom(L), który jest spełniony, jeżeli lista L zawiera palindrom.
    Przykłady:

     ?- palindrom([a,b,c]).
     no
     ?- palindrom([a,b,c,d,c,b,a]).
     yes 

    p(X,L,Y,Z), który jest spełniony, jeżeli Y jest poprzednikiem elementu X w liście L a Z następcą elementu X w liście L.
    Przykład:

     ?- p(3,[1,2,3,4,5],Y,Z).
     Y = 2, Z = 4 

    q(X,L1,L2), który jest spełniony, jeżeli L2 równa się początku listy L1 do podwójnego wystąpienia elementu X.
    Przykład:

     ?- q(3,[1,2,3,3,1,2,4],Z).
     Z = [1,2,3,3] 


delete1(X,L1,L2). 
delete1(X,[H|[X|T]],L2) :- delete1(X,[H|[X|T]],append([H],[T]).
*/

%inna wersja komentarza - tylko linia

last2(X ,[X]). 
last2(X ,[_|L]) :- last2(X , L). 

delete2(X , [X|L] , L). 
delete2(X , [Y|L1], [Y|L2]) :- delete2(X , L1 , L2). 

delete3([X|[_,_,_]],[X]). 
delete3([X|L1] , [X|L2]) :- delete3(L1 , L2).


 

