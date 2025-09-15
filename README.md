# Software Testing

Esse repositório traz exemplos de como realizar testes unitários em Java, Python e Javascript, bem como verificar a 
cobertura dos testes no código-fonte.

Os tutoriais estão disponíveis nas seguintes páginas:

* [Java](java/README.md)
* [Python](python/README.md)
* [Javascript](javascript/README.md)

## Exercícios

Para cada um dos exercícios abaixo, você deve criar uma classe que encapsule a lógica de negócio, e testes unitários
automatizados para verificar as funcionalidades.

1. **Sistema de Biblioteca (Java)**

   - Crie uma classe `Livro` com os atributos `titulo`, `autor`, `isbn` e `disponivel`.
   - Crie uma classe `Usuario` com os atributos `nome` e `idUsuario`.
   - Crie uma classe `Biblioteca` que gerencie empréstimos, implementando:
     - `emprestarLivro(Livro livro, Usuario usuario)` — só permita empréstimos se o livro estiver disponível.
     - `devolverLivro(Livro livro)` — marque o livro como disponível.
     - Mantenha um histórico de empréstimos.
   - Escreva testes unitários para:
     - Empréstimos de livros disponíveis e indisponíveis.
     - Devolução de livros.
     - Integridade do histórico de empréstimos.

2. **Sistema de Carrinho de Compras (Python)**

   - Crie uma classe `Produto` com os atributos `nome` e `preco`.
   - Crie uma classe `Carrinho` que gerencie produtos, implementando:
     - `adicionar_produto(produto)`
     - `remover_produto(produto)`
     - `calcular_total()` — aplique descontos progressivos:
       - 3 ou mais produtos → 5% de desconto.
       - Total acima de 500 → 10% de desconto.
     - Permita produtos duplicados.
   - Escreva testes unitários para:
     - Diferentes combinações de descontos.
     - Adição e remoção de produtos, recalculando o total.
     - Comportamento com carrinho vazio.

3. **Gerenciador de Contas Bancárias (Java)**

   - Crie uma classe `ContaBancaria` com os atributos `titular`, `numeroConta` e `saldo`.
   - Implemente métodos:
     - `depositar(double valor)`
     - `sacar(double valor)` — lance exceção se o saldo for insuficiente.
     - `transferir(ContaBancaria destino, double valor)` — atualize o saldo das duas contas.
   - Escreva testes unitários para:
     - Saques maiores que o saldo.
     - Transferências entre contas.
     - Depósitos.
     - Integridade do saldo após múltiplas operações.

4. **Sistema de Pedidos com Estados (Java ou Python)**

   - Crie uma classe `Pedido` com os estados `CRIADO`, `PAGO`, `ENVIADO`, `ENTREGUE` e `CANCELADO`.
   - Implemente métodos de transição: `pagar()`, `enviar()`, `entregar()`, `cancelar()`.
   - Lance exceções para transições inválidas.
   - Escreva testes unitários para:
     - Todas as transições válidas.
     - Transições inválidas lançando exceção.
     - Estado final do pedido após múltiplas operações.

