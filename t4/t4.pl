% Características de cada pessoa.

vitima(anita).

pobre(bia).
pobre(bernardo).
pobre(pedro).
pobre(maria).

insano(maria).
insano(adriano).

% Relacionamento entre pessoas.

relacionamento(anita, bernardo).
relacionamento(anita, pedro).

relacionamento(bernardo, anita).
relacionamento(bernardo, caren).

relacionamento(caren, bernardo).
relacionamento(caren, adriano).

relacionamento(pedro, anita).
relacionamento(pedro, alice).

relacionamento(alice, pedro).
relacionamento(alice, henrique).

relacionamento(henrique, alice).
relacionamento(henrique, maria).

relacionamento(maria, henrique).
relacionamento(maria, adriano).

relacionamento(adriano, caren).
relacionamento(adriano, maria).

% Localização de cada pessoa dado um dia da semana.

localizacao(bia, segunda, apt).
localizacao(bia, terca, poa).
localizacao(bia, quarta, poa).
localizacao(bia, quinta, sm).
localizacao(bia, sexta, apt).

localizacao(bernardo, segunda, sm).
localizacao(bernardo, terca, sm).
localizacao(bernardo, quarta, poa).
localizacao(bernardo, quinta, sm).
localizacao(bernardo, sexta, apt).

localizacao(caren, segunda, poa).
localizacao(caren, terca, poa).
localizacao(caren, quarta, poa).
localizacao(caren, quinta, sm).
localizacao(caren, sexta, apt).

localizacao(pedro, segunda, sm).
localizacao(pedro, terca, sm).
localizacao(pedro, quarta, poa).
localizacao(pedro, quinta, sm).
localizacao(pedro, sexta, apt).

localizacao(alice, segunda, apt).
localizacao(alice, terca, poa).
localizacao(alice, quarta, poa).
localizacao(alice, quinta, apt).
localizacao(alice, sexta, apt).

localizacao(henrique, segunda, apt).
localizacao(henrique, terca, poa).
localizacao(henrique, quarta, apt).
localizacao(henrique, quinta, apt).
localizacao(henrique, sexta, apt).

localizacao(maria, segunda, apt).
localizacao(maria, terca, sm).
localizacao(maria, quarta, sm).
localizacao(maria, quinta, sm).
localizacao(maria, sexta, apt).

localizacao(adriano, segunda, apt).
localizacao(adriano, terca, apt).
localizacao(adriano, quarta, sm).
localizacao(adriano, quinta, apt).
localizacao(adriano, sexta, apt).

% O suspeito poderia obter a arma para realizar o crime?

armado(S) :- 
 localizacao(S, quarta, sm) ;
 localizacao(S, quinta, poa) .

armado(S) :-
 localizacao(S, quarta, apt) ;
 localizacao(S, quinta, apt).

% O suspeito possui motivos para matar Anita?

motivo(S) :-
 insano(S) ;
 pobre(S) ;
 ciumes(S).

ciumes(S) :-
 relacionamento(anita, P), relacionamento(S, P). 

% O suspeito conseguiu entrar no quarto de Anita sem arrombar a porta, roubando a chave?

chave(S) :-
 localizacao(S, segunda, sm) ;
 localizacao(S, terca, poa).

assassino(S) :-
 chave(S), motivo(S), armado(S), localizacao(S, quinta, apt), !.

assassino(S) :-
 chave(S), motivo(S), armado(S), localizacao(S, sexta, apt), !.