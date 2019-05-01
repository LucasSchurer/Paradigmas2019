% 1 -
odd(N) :-
 X is mod(N, 2),
 X =:= 1.

% 2 -
hasN([_|T], N) :-
 N > 0,
 T \= [],
 N1 is N - 1,
 hasN(T, N1);
 N =:= 1,
 T = [].

% 3 -
inc99([], []).
inc99([H1|T1], [H2|T2]) :-
 H2 is H1 + 99,
 inc99(T1, T2).

% 4 -
incN([], [], _).
incN([H1|T1], [H2|T2], N) :-
 H2 is H1 + N,
 incN(T1, T2, N).

% 5 -
comment([], []).
comment([H1|T1], [H2|T2]) :-
 string_concat("%%", H1, H2),
 comment(T1, T2).

% 6 -
even(N) :-
 X is mod(N, 2),
 X =:= 0.

onlyEven([], []).
onlyEven([H1|T1], [H2|T2]) :-
 H2 is H1,
 even(H1),
 onlyEven(T1, T2).

onlyEven([H1|T1], [H2|T2]) :-
  odd(H1),
  onlyEven(T1, [H2|T2]).


% 7 -
countDown(_, []).
countDown(N, [H|T]) :-
  N > 0,
  H is N,
  N1 is N - 1,
  countDown(N1, T).
