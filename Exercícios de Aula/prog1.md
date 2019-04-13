# Prolog Aula 1

### Exercício 1
 - europeu(andre) -> false
 - gaucho(andre) -> true
 - brasileiro(X) -> andre ; joao

### Exercício 2
 -"Joana nasceu em Salvador."
 -"Joana tem 22 anos."
 -"Michel nasceu em Paris e tem 40 anos."

```
nasceu_em(joana, salvador).
nasceu_em(michel, paris).

idade(joana, 22).
idade(michel, 40).
```

### Exercício 3
 -"José nasceu no Brasil?"
 -"Quais são as pessoas nascidas na Europa?"
 -"Quais são as pessoas com mais de 30 anos?"
 -"Quem são os brasileiros com menos de 30 anos?"

```
brasileiro(jose).
europeu(X).
idade(X, Y), Y > 30
brasileiro(X), idade(X, Y), Y < 30.
```

### Exercício 4
 - Crie um predicado maisVelho(A,B) que permita deduzir se a pessoa A é mais velha que a pessoa B. Use o predicado idade. Exemplo de uso:

```
maisVelho(X, Y) :- idade(X, Z), idade(Y, P), Z > P.
```

### Exercício 5
 - Em Prolog, o operador is serve para calcular uma expressão aritmética e atribuir seu valor a uma variável, como nos exemplos abaixo:
 ```
 soma(A,B,C) :- C is A + B.
 pred(A,B,C) :- X is (A+B)^2, C is X*2+1.
 ```
 - Verifique os seguintes casos:
 - ?- soma(8,5,S). -> 8 + 5 = 13
 - ?- pred(3,2,X). -> (3+2)^2 = 25, 25*2+1 = 51

### Exercício 6
 - Usando o operador is, crie um predicado anoNasc(P,A) que permita deduzir o ano aproximado de nascimento (A) de uma pessoa (P). Use o predicado idade e o ano corrente como referência.

```
anoNasc(P, A) :- idade(P, X), A is 2019-X.
```


### Exercício 7
 - Teste das seguintes consultas:
```
?- member(a, [a,b,c]). -> true
?- member(x, [a,b,c]). -> false
?- member(A, [a,b,c]). -> A = a ; A = b ; A = c
?- member(a, [a,b,c,a]). -> true ; true
?- length([a,b,c], L). -> L = 3
?- length([], X). -> X = 0
?- length(a, X). -> Erro, já que 'a' não é uma lista.
?- length([a,b,c], 2). -> false
?- nextto(1, 2, [1,2,3]). -> true
?- nextto(2, Y, [1,2,3]). -> 3 ; false
?- nextto(4, X, [1,2,3]). -> false
?- nextto(1, 2, [1,2,3,1,2]). -> true ; true ; false
```

### Exercício 8
 - Usando lista em Prolog, crie um predicado isVowel(X) que verifique se um dado símbolo X é uma vogal. Dica: você vai precisar de uma lista de vogais possíveis.


```
isVowel(X) :- member(X, [a, i, u, e, o]).
```
