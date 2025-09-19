# Testes em Javascript

Uma biblioteca popular para testes unitários automatizados em Javascript é [QUnit](). Este tutorial explicará como 
instalar e configurar esta biblioteca no seu computador.

> [!NOTE]
> Esse tutorial assume que você já tenha baixado e instalado o [node.js](https://nodejs.org/pt) no seu computador, e 
> adicionado o diretório de instalação à variável PATH do computador. Além disso, os comandos da linha de comando 
> devem ser executados a partir da pasta-raiz do projeto.

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

## Cobertura

Existem diversas bibliotecas para calcular a cobertura em Javascript. Neste tutorial, usaremos a 
biblioteca [Istanbul](https://istanbul.js.org/).

1. Pela linha de comando, instale a biblioteca QUnit :

   ```bash
   npm install --save-dev qunit nyc
   ```
   
2. Será criado um arquivo `package.json` no diretório onde o comando foi executado. Abra-o e insira as seguintes linhas:

   ```json
    "scripts": {
        "test": "nyc qunit"
    },
     "nyc": {
         "reporter": ["text", "html"],
         "include": ["src/**/*.js"],
         "exclude": ["test/**/*.js"],
         "all": true
     }
   ```

3. Seu arquivo `package.json` se parecerá com isso:

   ```json
   {
       "devDependencies": {
           "nyc": "^17.1.0",
           "qunit": "^2.24.1"
       },
       "scripts": {
           "test": "nyc qunit"
       },
        "nyc": {
            "reporter": ["text", "html"],
            "include": ["src/**/*.js"],
            "exclude": ["test/**/*.js"],
            "all": true
        }
   }
   ```
   
4. Pela linha de comando, execute os testes com:

   ```bash
   npm test
   ```
   
5. A saída do console se parecerá com isso:
   
   ```bash
   > test
   > nyc qunit
   
   TAP version 13
   ok 1 Ponto > distancia_euclidiana calcula corretamente
   1..1
   # pass 1
   # skip 0
   # todo 0
   # fail 0
   ----------|---------|----------|---------|---------|-------------------
   File      | % Stmts | % Branch | % Funcs | % Lines | Uncovered Line #s
   ----------|---------|----------|---------|---------|-------------------
   All files |     100 |      100 |     100 |     100 |                  
    ponto.js |     100 |      100 |     100 |     100 |                  
   ----------|---------|----------|---------|---------|-------------------
   ```
   
6. Além disso, um relatório HTML gerá gerado em [coverage/index.html](coverage/index.html).
