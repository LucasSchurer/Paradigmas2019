localizado_em(santa_maria, rs).
localizado_em(salvador, bahia).
localizado_em(rs, brasil).
localizado_em(bahia, brasil).
localizado_em(paris, franca).
localizado_em(franca, europa).

nasceu_em(andre, santa_maria).
nasceu_em(joao, salvador).
nasceu_em(joana, salvador).
nasceu_em(michel, paris).

nasceu_em(X, Y) :- localizado_em(Z, Y), nasceu_em(X, Z).

mora_em(andre, paris).
mora_em(joao, salvador).
mora_em(X, Y) :- localizado_em(Z, Y), mora_em(X, Z).

idade(andre, 25).
idade(joao, 32).

idade(joana, 22).
idade(michel, 40).

maisVelho(X, Y) :- idade(X, Z), idade(Y, P), Z > P.
anoNasc(P, A) :- idade(P, X), A is 2019-X.

gaucho(X) :- nasceu_em(X, rs).
brasileiro(X) :- nasceu_em(X, brasil).
europeu(X) :- nasceu_em(X, europa).


isVowel(X) :- member(X, [a, i, u, e, o]).
