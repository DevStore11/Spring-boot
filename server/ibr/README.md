# Guia de Desenvolvimento — Spring Boot + MySQL

Este documento reúne os comandos essenciais para executar, testar e trabalhar no projecto Spring Boot através do CMD do Windows.

## 1. Abrir o projecto no CMD

Entra na pasta onde está o projecto:

```cmd
cd /d C:\Emerson-Projetos\Especializacao\Spring-Boot
```

Confirma os ficheiros:

```cmd
dir
```

Deves encontrar `mvnw.cmd`, `pom.xml` e a pasta `src`.

> Se o projecto estiver noutra pasta, utiliza o caminho correcto.

## 2. Verificar o Java

```cmd
java -version
```

Verifica também se o Maven Wrapper existe:

```cmd
dir mvnw.cmd
```

O Maven Wrapper permite executar o Maven sem depender de uma instalação global.

## 3. Iniciar o MySQL

O serviço MySQL deste ambiente chama-se `MySQL94`.

Abre o CMD como administrador e executa:

```cmd
net start MySQL94
```

Para verificar o estado:

```cmd
sc query MySQL94
```

Procura `STATE : 4 RUNNING`.

Para parar o serviço:

```cmd
net stop MySQL94
```

## 4. Entrar no MySQL

```cmd
mysql -u root -p
```

Introduz a palavra-passe quando for solicitada.

Se o comando `mysql` não for reconhecido, utiliza o caminho completo para o executável `mysql.exe` da tua instalação.

## 5. Criar e seleccionar a base de dados

```sql
CREATE DATABASE IF NOT EXISTS espetaculos;

USE espetaculos;
```

Confirma a base de dados seleccionada:

```sql
SELECT DATABASE();
```

O nome deve corresponder ao configurado no ficheiro `application.properties`.

## 6. Configurar a ligação ao MySQL

Ficheiro: `src/main/resources/application.properties`

```properties
spring.application.name=sistema-espectaculos

spring.datasource.url=jdbc:mysql://localhost:3306/espetaculos
spring.datasource.username=root
spring.datasource.password=COLOCA_A_TUA_SENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

Substitui `COLOCA_A_TUA_SENHA` pela tua palavra-passe local.

**Importante:** não publiques credenciais reais no GitHub.

### O que significa cada configuração?

- `spring.datasource.url`: endereço da base de dados.
- `spring.datasource.username`: utilizador do MySQL.
- `spring.datasource.password`: palavra-passe do MySQL.
- `spring.jpa.hibernate.ddl-auto=update`: permite ao Hibernate actualizar o esquema das tabelas ao iniciar.
- `spring.jpa.show-sql=true`: apresenta as instruções SQL no terminal.

A opção `update` não garante todas as alterações possíveis ao esquema. Em projectos profissionais, considera usar Flyway ou Liquibase para gerir migrações.

## 7. Executar o Spring Boot

No CMD, dentro da pasta onde está o ficheiro `mvnw.cmd`:

```cmd
mvnw.cmd spring-boot:run
```

Mantém esse terminal aberto enquanto a aplicação estiver em execução.

Para parar a aplicação:

```text
Ctrl + C
```

Se aparecer um erro, verifica as últimas linhas do terminal.

## 8. Ver as bases de dados

Dentro do MySQL:

```sql
SHOW DATABASES;
```

Seleccionar a base de dados:

```sql
USE espetaculos;
```

## 9. Ver as tabelas

```sql
SHOW TABLES;
```

Ver a estrutura da tabela `utilizador`:

```sql
DESCRIBE utilizador;
```

Ver a estrutura da tabela `cliente`:

```sql
DESCRIBE cliente;
```

Ver a definição completa:

```sql
SHOW CREATE TABLE utilizador;
```

```sql
SHOW CREATE TABLE cliente;
```

Os nomes devem corresponder às anotações `@Table` das entidades Java.

## 10. Consultar os registos

### Ver todos os utilizadores

```sql
SELECT * FROM utilizador;
```

### Ver todos os clientes

```sql
SELECT * FROM cliente;
```

### Ver apenas nome e email

```sql
SELECT id, nome, email
FROM utilizador;
```

### Contar os utilizadores

```sql
SELECT COUNT(*) AS total_utilizadores
FROM utilizador;
```

### Contar os clientes

```sql
SELECT COUNT(*) AS total_clientes
FROM cliente;
```

### Procurar um utilizador pelo email

```sql
SELECT id, nome, email
FROM utilizador
WHERE email = 'teste@example.com';
```

### Consultar a coluna senha

```sql
SHOW COLUMNS FROM utilizador LIKE 'senha';
```

Evita mostrar senhas em consultas desnecessárias. Na aplicação real, guarda hashes seguros das senhas, por exemplo com BCrypt ou Argon2, e nunca texto simples.

## 11. Consultar os campos herdados com JOIN

A classe `Utilizador` tem os campos `id`, `nome`, `email` e `senha`.

A classe `Cliente` herda esses campos e acrescenta `telefone`.

Como estás a utilizar:

```java
@Inheritance(strategy = InheritanceType.JOINED)
```

os campos comuns ficam na tabela `utilizador`, enquanto os campos específicos ficam na tabela `cliente`.

Para consultar os dados combinados:

```sql
SELECT
    u.id,
    u.nome,
    u.email,
    c.telefone
FROM utilizador AS u
INNER JOIN cliente AS c
    ON u.id = c.id_cliente;
```

A consulta pressupõe que a coluna de junção se chama `id_cliente`, conforme a tua anotação `@PrimaryKeyJoinColumn(name = "id_cliente")`.

## 12. Inserir dados de teste directamente no MySQL

Para testar uma consulta, podes inserir um utilizador fictício:

```sql
INSERT INTO utilizador (nome, email, senha)
VALUES (
    'Utilizador de Teste',
    'teste@example.com',
    'HASH_DE_TESTE'
);
```

Depois, consulta:

```sql
SELECT id, nome, email
FROM utilizador;
```

Este exemplo serve apenas para testar a base de dados. Numa aplicação real, cria utilizadores através do backend, com validação e hash seguro da senha.

A inserção directa na tabela `utilizador` não cria automaticamente um registo correspondente na tabela `cliente`.

## 13. Actualizar o esquema das tabelas

Se adicionares um campo à classe Java, por exemplo:

```java
@Column(nullable = false, length = 100)
private String endereco;
```

e tiveres `spring.jpa.hibernate.ddl-auto=update`, o Hibernate poderá adicionar a coluna ao iniciar a aplicação.

Executa novamente:

```cmd
mvnw.cmd spring-boot:run
```

Depois confirma:

```sql
DESCRIBE utilizador;
```

**Atenção:** não uses `create` ou `create-drop` numa base de dados com dados importantes sem compreender as consequências, pois podem eliminar dados existentes.

## 14. Problemas comuns

### MySQL não inicia

```cmd
sc query MySQL94
```

Confirma o nome do serviço e lê a mensagem de erro.

### A aplicação não consegue ligar ao MySQL

Verifica:

1. Se o serviço MySQL está em execução.
2. Se a porta configurada está correcta.
3. Se o nome da base de dados existe.
4. Se o utilizador e a palavra-passe estão correctos.

### A coluna `senha` não aparece

```sql
USE espetaculos;
SHOW COLUMNS FROM utilizador;
```

Confirma se estás na base de dados correcta e se o Hibernate conseguiu iniciar sem erros.

### As tabelas existem, mas não têm dados

```sql
SELECT * FROM utilizador;
```

Um resultado `Empty set` significa que a consulta não encontrou registos. A criação das tabelas não insere dados automaticamente.

## 15. Fluxo diário de trabalho

1. Abrir o CMD na pasta do projecto.
2. Iniciar o MySQL, se estiver parado.
3. Executar `mvnw.cmd spring-boot:run`.
4. Abrir outro CMD para consultar o MySQL.
5. Executar `mysql -u root -p`.
6. Seleccionar a base de dados com `USE espetaculos;`.
7. Consultar tabelas e dados com as queries deste documento.
8. Parar a aplicação com `Ctrl + C` quando terminares.

---

**Nota:** este guia foi preparado para Windows, CMD, Maven Wrapper, Spring Boot, MySQL e entidades JPA com herança `JOINED`. Ajusta os caminhos, nomes das tabelas e credenciais à configuração real do projecto.