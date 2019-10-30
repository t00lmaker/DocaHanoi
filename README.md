# DocaHanoi (Desafio Técnico)

Esse projeto é simplesmente um desafio técnico para a criação de uma 
API para resolver um problema com o carregamento e descarregamento de 
caminhões em uma doca obedecendo as seguintes regras:

 - Exitem 3 zonas, zona de abastecimento [A], zona de transferência [T] e zona do caminhão [C];
 
 - Todas as zonas possuem espaço somente para pacotes empilhados e somente uma pilha pode ser formada em cada zona (inclusive no caminhão);
 
- Somente um pacote pode ser movimentado por vez;

- Nunca um pacote mais pesado deve ser colocado sobre um pacote mais leve;

- Os pacotes podem ser movimentadas diversas vezes entre todas as zonas desde que obedeçam as regras acima.

## O que encontra nesse pacote?

- Uma implementação de uma API com o framework spark.

- Implmentação de testes com Spock.

- Uma implementação para solução de um problema de Torre de Hanoi.
 
## A API
 
 A api basicamente possui dois endpoints:
 
 
## Cadastro de Entreguas
 
 ```json
 POST /delivery
{
“vehicle” : “123456”,
“deliveryId” : “1234567890”
“packages” : [
{ "id": “1”, “weight”: “14.50”},
{ "id": “2”, “weight”: “12.15”},
{ "id": “3”, “weight”: “19.50”}
]
}

---
201 CREATED

```

### Movimentos para o carregamento de um pacote

```json

GET /delivery/{deliveryId}/step
[
{ "step" : 1, "packageId": 2, "from": "zona de abastecimento", "to": "zona do caminhão" },
{ "step" : 2, "packageId": 1, "from": "zona de abastecimento", "to": "zona de transferência" },
{ "step" : 3, "packageId": 2, "from": "zona do caminhão", "to": "zona de transferência" },
{ "step" : 4, "packageId": 3, "from": "zona de abastecimento", "to": "zona do caminhão" },
{ "step" : 5, "packageId": 2, "from": "zona de transferência", "to": "zona de abastecimento" },
{ "step" : 6, "packageId": 1, "from": "zona de transferência", "to": "zona de caminhão" },
{ "step" : 7, "packageId": 2, "from": "zona de abastecimento", "to": "zona de caminhão" }
]

---
200 OK

```
