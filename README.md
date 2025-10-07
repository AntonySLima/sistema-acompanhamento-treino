# Sistema de Acompanhamento de Treinos para Academia

Este projeto é um sistema de gerenciamento de treinos para uma academia, desenvolvido em **Java** como uma aplicação de console. O objetivo principal é aplicar e consolidar conceitos de **Programação Orientada a Objetos (POO)** e experimentar o padrão **MVC (Model-View-Controller)** para organizar melhor as responsabilidades do sistema.

## ✨ Funcionalidades

O sistema atualmente permite as seguintes operações via console:

### Gestão de Alunos

* Criar alunos
* Listar alunos

### Gestão de Treinos

* Criar treinos, especificando o dia da semana
* Listar treinos

### Gestão de Exercícios

* Criar exercícios com detalhes como carga, séries e repetições
* Listar exercícios

### Associações

* Associar um ou mais treinos a um aluno específico
* Associar um ou mais exercícios a um treino específico

### Visualização

* Ver todos os treinos de um aluno
* Ver todos os exercícios de um treino

## 📂 Estrutura do Projeto

O projeto está organizado seguindo uma tentativa de implementar **MVC**, separando responsabilidades em pacotes:

```
sistema-acompanhamento-treino/
│
├─ src/
│  ├─ app/
│  │  └─ Main.java
│  │
│  ├─ controller/
│  │  └─ AcademiaController.java
│  │
│  ├─ model/
│  │  ├─ Aluno.java
│  │  ├─ DiaDaSemana.java
│  │  ├─ DiaDeTreino.java
│  │  ├─ Exercicio.java
│  │  ├─ TipoDia.java
│  │  └─ Treino.java
│  │
│  ├─ service/
│  │  ├─ AlunoService.java
│  │  ├─ DiaDeTreinoService.java
│  │  ├─ ExercicioService.java
│  │  └─ TreinoService.java
│  │
│  ├─ repository/      (futuro uso para persistência)
│  └─ util/            (classes utilitárias)
│
├─ .gitignore
└─ README.md
```

## 🛠️ Tecnologias Utilizadas

* **Java 8+**

## 🚀 Como Executar o Projeto

1. **Clone o repositório:**

```bash
git clone https://github.com/seu-usuario/sistema-academia-java.git
```

2. **Abra o projeto em sua IDE preferida** (IntelliJ IDEA, Eclipse, VS Code).

3. **Localize o arquivo `Main.java`** dentro do pacote `app`.

4. **Execute o método `main()`** para iniciar a aplicação no console.

## 🔮 Próximos Passos e Melhorias Planejadas

* [ ] **Persistência de Dados:** Substituir o armazenamento em memória por um banco de dados relacional (PostgreSQL ou MySQL) utilizando **Spring Data JPA**.
* [ ] **API REST:** Transformar a aplicação de console em uma API REST com **Spring Web**, expondo endpoints como `GET /alunos` e `POST /treinos`.
* [ ] **Segurança:** Adicionar autenticação e autorização com **Spring Security**.
* [ ] **Validação de Dados:** Implementar validações robustas para entradas do usuário.
* [ ] **Testes:** Criar testes unitários e de integração para garantir a qualidade do código.
