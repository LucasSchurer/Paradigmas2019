% 1 - Retorna se um número N é ímpar.
odd(N) :-
 X is mod(N, 2),
 X =:= 1.

% 2 - Retorna se a quantidade de elementos de uma lista L é igual ao valor N.
hasN([_|T], N) :-
 N > 0,
 T \= [],
 N1 is N - 1,
 hasN(T, N1),
 !;
 N =:= 1,
 T = [], 
 !.

% 3 - Adiciona 99 para todos os elementos de uma lista.
inc99([], []).
inc99([H1|T1], [H2|T2]) :-
 H2 is H1 + 99,
 inc99(T1, T2).

% 4 - Adiciona N para todos os elementos de uma lista.
incN([], [], _).
incN([H1|T1], [H2|T2], N) :-
 H2 is H1 + N,
 incN(T1, T2, N).

% 5 - Adiciona o prefixo "%%" para todos os elementos de uma lista.
comment([], []).
comment([H1|T1], [H2|T2]) :-
 string_concat("%%", H1, H2),
 comment(T1, T2).

% 6 - Retorna apenas os elementos pares de uma lista.
onlyEven([], []).

onlyEven([H1|T1], L2) :-
  odd(H1),
  onlyEven(T1, L2).

onlyEven([H1|T1], [H2|T2]) :-
 even(H1),
 H2 = H1,
 onlyEven(T1, T2).

% Retorna se um número N é par.
even(N) :-
 X is mod(N, 2),
 X =:= 0.

% 7 - Retorna uma lista com os números [N, N-1, N-2 .., 1], sendo que N>0. 
countDown(0, []).

countDown(N, [H|T]) :-
  N > 0,
  H = N,
  N1 is N - 1,
  countDown(N1, T), 
  !.

% 8 - Retorna uma lista com N números gerados aleatoriamente.
% Os valores vão ser aleatórios dentro do intervalo de 0 - 100.
nRandoms(0, []).

nRandoms(N, [H|T]) :-
 N > 0,
 H is random(100),
 N1 is N - 1,
 nRandoms(N1, T),
 !.

 % 9 - Retorna uma lista com as potências de 2, com expoentes de N a 0.
 potN0(0, []).

 potN0(N, [H|T]) :-
  N > 0,
  H is 2^N,
  N1 is N - 1,
  potN0(N1, T), 
  !.

% 10 - Retorna uma lista com os produtos dos valores de mesma posição de duas listas L1 e L2, considerando que as listas possuem o mesmo tamanho.
zipmult([], [], []).

zipmult([H1|T1], [H2|T2], [H3|T3]) :-
 Mult is H1*H2,
 H3 = Mult,
 zipmult(T1, T2, T3).

% 11 - Retorna uma lista com as potências de 2, com expoentes de 0 a N.
potencias(N, L) :-
 potenciasAux(N, L, 0).

potenciasAux(N, [], N).
potenciasAux(N, [H|T], I) :-
 I < N,
 H is 2^I,
 I1 is I + 1,
 potenciasAux(N, T, I1),
 !.