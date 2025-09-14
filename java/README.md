# Testes em Java

[JUnit](https://junit.org) é o framework de testes unitários automatizados do Java.

> [!NOTE]
> Esse tutorial assume que você usa maven como gerenciador de bibliotecas do seu projeto.

Para utilizá-lo:

1. Adicione a biblioteca ao seu arquivo `pom.xml`:

   ```xml
   <dependencies>
       <dependency>
           <groupId>org.junit.jupiter</groupId>
           <artifactId>junit-jupiter</artifactId>
           <version>5.10.2</version> <!-- coloque a última versão disponível ou a última compatível com seu projeto -->
           <scope>test</scope>
       </dependency>
   </dependencies>
   ```

2. Crie uma pasta `test` dentro da pasta `src`, e dentro desta, uma pasta `java`. Para cada classe que você desejar
   testar, crie um arquivo `<nome_da_classe>Test.java`. Por exemplo, se você tem uma classe chamada `Ponto` em
   `src/main/java/org.example/Ponto.java`, crie um arquivo `PontoTest.java` em
   `src/test/java/org.example/PontoTest.java`.
3. Supondo que seu código-fonte do arquivo `Ponto.java` seja o seguinte:
   ```java
    package org.example;

    public class Ponto {
        private final float x;
        private final float y;

        public Ponto(float x, float y) {
            this.x = x;
            this.y = y;
        }

        public float getX() {
            return x;
        }

        public float getY() {
            return y;
        }

        public double distanciaEuclidiana(Ponto outro) {
            return Math.sqrt(Math.pow(this.x - outro.x, 2) + Math.pow(this.y - outro.y, 2));
        }
    }
   ```

4. Escreva o seguinte código-fonte em `PontoTest.java`:

   ```java
    package org.example;

    import org.junit.jupiter.api.Test;
    import static org.junit.jupiter.api.Assertions.assertEquals;

    public class PontoTest {
        @Test
        public void testeDistanciaEuclidiana() {
            Ponto p1 = new Ponto(0, 0);
            Ponto p2 = new Ponto(3, 4);
            double correta = Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
            assertEquals(
                correta,  // saída esperada
                p1.distanciaEuclidiana(p2),  // saída comparada
                0.01  // tolerância
            );
        }
    }
   ```

5. Seu diretório deve se parecer com isto:
   ```
   java
   ├─ src
   │  ├─ main
   │  │  └─ java
   │  │     └─ org
   │  │        └─ example
   │  │           └─ Ponto.java
   │  └─ test
   │     └─ java
   │        └─ org
   │           └─ example
   │              └─ PontoTest.java
   ├─ target
   └─ pom.xml
   ```

6. Você pode rodar os testes individualmente (executando cada classe). A saída esperada deve ser algo como:

   ![junit_single_test.png](../imagens/junit_single_test.png)

7. Você também pode criar uma configuração na IDE para rodar todos os testes do projeto de uma só vez. O exemplo abaixo
   considera a IDE Intellij IDEA:

   ![junit.gif](../imagens/junit.gif)

8. Os seguintes métodos da classe Assertions são importantes para escrever testes com JUnit. Todas elas lançam exceções
   em caso de falha:

    * `Assertions.assertEquals(expected, actual)`: Verifica se dois valores são iguais.
    * `Assertions.assertTrue(condition)`: Verifica se um item é verdadeiro.
    * `Assertions.assertFalse(condition)`: Verifica se um item é falso.
    * `Assertions.assertThrows(Exception.class, () -> { ... })`: Verifica se uma classe lança uma exceção quando uma
      condição é atendida.
    * `Assertions.assertAll(...)`: agrupa múltiplas verificações em uma chamada só.


## Cobertura

Em Java, a ferramenta para verificar a cobertura mais popular é o JaCoCo. 

Você pode configurá-la no Intellij IDEA da seguinte forma:

1. Adicione os seguintes plugins ao seu `pom.xml` (**NOTA:** as versões dos plugins e bibliotecas mudarão no futuro e 
   este tutorial ficará defasado. Consulte um tutorial mais atualizado na internet!):

   ```xml
   <build>
        <plugins>
            <plugin>
                <groupId>org.jacoco</groupId>
                <artifactId>jacoco-maven-plugin</artifactId>
                <version>0.8.13</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>prepare-agent</goal>
                        </goals>
                    </execution>
                    <execution>
                        <id>report</id>
                        <phase>verify</phase>
                        <goals>
                            <goal>report</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.2.5</version>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.13.0</version>
                <configuration>
                    <release>21</release>
                </configuration>
            </plugin>
        </plugins>
    </build>
   ```
   
2. Crie uma nova configuração de execução do Maven:
   
   ![jacoco.gif](../imagens/jacoco.gif)

   ![jacoco.png](../imagens/jacoco.png)

3. Um relatório em HTML é gerado e armazenado em [target/site/jacoco/index.html](target/site/jacoco/index.html)
 
   
