### Primeira parte

Copie o código Prolog abaixo para um arquivo .pl.
```
b(2).
b(3).
c(4).
c(5).
regra1(X, Y) :- b(X), c(Y).
regra2(X, Y) :- b(X), !, c(Y).
```

Considerando o programa acima, qual será o resultado da seguinte consulta?
```
?- regra1(X,Y).
```
X = 2, Y = 4
X = 2, Y = 5
X = 3, Y = 4
X = 3, Y = 5

Ainda considerando o mesmo programa, qual será o resultado da seguinte consulta?
```
?- regra2(X,Y).
```
X = 2, Y = 4
X = 3, Y = 4

### Segunda parte
Baixe o programa fatoriais.pl e carregue-o no SWI-Prolog.

Execute a consulta abaixo e use ; para verificar se há outras respostas possíveis.
```
?- fatv1(3,N).
```

A consulta acima deve ter gerado um erro depois que for digitado ;. Você consegue identificar o motivo deste erro?

Para melhor entender o erro acima, ative o modo trace e re-execute a consulta:
```
?- trace.
true.
[trace]  ?- fatv1(3,N).
```
Dica: quando você cansar de rastrear a execução passo-a-passo, digite a (abort) no lugar de Enter.

Analise o código em fatoriais.pl, comparando os predicados fatv2 e fatv3 com o predicado fatv1.

Execute as consultas abaixo, digitando ; após cada resposta. Compare os resultados com os da consulta anterior (fatv1).
```
?- fatv2(3,N).
?- fatv3(3,N).
```
Ative o modo trace e re-execute as consultas acima, acompanhando suas execuções.

Você consegue identificar alguma vantagem de fatv2 sobre fatv3?
fatv2 vai ignorar os resultados além do primeiro obtido, o que é útil, já que o fatorial de um número possui apenas uma resposta, e quando obter aluma verdadeira, já pode cancelar a busca de mais respostas.
