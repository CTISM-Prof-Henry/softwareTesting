# Testes em Javascript

Uma biblioteca popular para testes unitários automatizados em Javascript é [QUnit](). Este tutorial explicará como 
instalar e configurar esta biblioteca no seu computador.

## Pré-requisitos

Você precisará ter [node.js](https://nodejs.org/pt) instalado e adicionado ao PATH do seu computador. Além disso,
os comandos a serem executados pela linha de comando devem ser executados a partir da pasta-raiz do seu projeto.

## Instalação

1. Pela linha de comando, e a partir da pasta-raiz do seu projeto, digite:
   ```bash
   npm install --save-dev qunit
   ```

2. Supondo que você tenha um arquivo `src/ponto.js` com o seguinte código:
   ```javascript
   class Ponto {
    constructor (x, y) {
        this.x = x;
        this.y = y;
    }

    distancia_euclidiana(outro) {
        return Math.sqrt(
            Math.pow(this.x - outro.x, 2) +
            Math.pow(this.y - outro.y, 2)
        )
    }
   }
   
   module.exports = Ponto;
   ```

3. Em um arquivo `test/ponto.test.js`, escreva o seguinte código:

   ```javascript
    const Ponto = require("../src/ponto");

   QUnit.module("Ponto", () => {
   
       QUnit.test("distancia_euclidiana calcula corretamente", (assert) => {
           const p1 = new Ponto(0, 0);
           const p2 = new Ponto(3, 4);
   
           const correta = Math.sqrt(
               Math.pow(p1.x - p2.x, 2) +
               Math.pow(p1.y - p2.y, 2)
           );
           assert.equal(p1.distancia_euclidiana(p2), correta);
       });
   });
   ```

4. No diretório acima de `src` e `test` (por exemplo, a raiz do projeto), execute pela linha de comando:
   ```bash
   npx qunit
   ```

5. A saída esperada deve ser algo como:

   ```bash
   TAP version 13
   ok 1 Ponto > distancia_euclidiana calcula corretamente
   1..1
   # pass 1
   # skip 0
   # todo 0
   # fail 0
   ```
