- Defina um predicado odd(N) que seja verdadeiro se N for um número ímpar. Exemplo de uso:
```
?- impar(2).
false.
?- impar(3).
true.
```

- Defina um predicado recursivo hasN(L,N) que seja verdadeiro se L for uma lista de N elementos.

- Defina um predicado recursivo inc99(L1,L2), de forma que L2 seja uma lista com todos os elementos de L1 acrescidos da constante 99.

- Defina um predicado recursivo incN(L1,L2,N), de forma que L2 seja uma lista com todos os elementos de L1 acrescidos da constante N.

- Defina um predicado recursivo comment(L1,L2), de forma que L1 seja uma lista de strings e L2 tenha todos os elementos de L1 concatenados com o prefixo "%%". Dica: consulte predicados Prolog para manipulação de strings.

- Defina um predicado recursivo onlyEven(L1,L2), de forma que L2 seja uma lista só com os elementos pares de L1, conforme o exemplo abaixo:

-- Defina um predicado recursivo countdown(N,L), de forma que L seja uma lista com os números [N, N-1, N-2, .., 1], sendo N um número positivo. Exemplo:
