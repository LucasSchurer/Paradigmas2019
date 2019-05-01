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
