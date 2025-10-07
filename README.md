\# Sistema de Acompanhamento de Treinos para Academia



Este projeto é um sistema de gerenciamento de treinos para uma academia, desenvolvido em Java como uma aplicação de console. O objetivo principal foi aplicar e solidificar conceitos de Programação Orientada a Objetos (POO), como encapsulamento, composição e separação de responsabilidades em camadas (Model, Service, Controller).



\## ✨ Funcionalidades



O sistema atualmente permite as seguintes operações via console:

\* \*\*Gestão de Alunos:\*\* Criar e listar alunos.

\* \*\*Gestão de Treinos:\*\* Criar e listar treinos, especificando o dia da semana.

\* \*\*Gestão de Exercícios:\*\* Criar e listar exercícios com detalhes como carga, séries e repetições.

\* \*\*Associações:\*\*

&nbsp;   \* Associar um ou mais treinos a um aluno específico.

&nbsp;   \* Associar um ou mais exercícios a um treino específico.

\* \*\*Visualização:\*\*

&nbsp;   \* Ver todos os treinos de um aluno.

&nbsp;   \* Ver todos os exercícios de um treino.



\## 🛠️ Tecnologias Utilizadas



\* \*\*Java 8+\*\* 



\## 🚀 Como Executar o Projeto



1\.  \*\*Clone o repositório:\*\*

&nbsp;   ```bash

&nbsp;   git clone \[https://github.com/seu-usuario/sistema-academia-java.git](https://github.com/seu-usuario/sistema-academia-java.git)

&nbsp;   ```

2\.  \*\*Abra em sua IDE preferida\*\* (IntelliJ IDEA, Eclipse, VS Code).

3\.  \*\*Localize o arquivo `Main.java`\*\* dentro do pacote `app`.

4\.  \*\*Execute o método `main()`\*\* para iniciar a aplicação no console.



\## 🔮 Próximos Passos e Melhorias Planejadas



Este projeto serviu como uma base sólida. Os próximos passos planejados para evoluí-lo são:



\* \[ ] \*\*Persistência de Dados:\*\* Substituir o armazenamento em memória por um banco de dados relacional (como PostgreSQL ou MySQL) utilizando \*\*Spring Data JPA\*\*.

\* \[ ] \*\*API REST:\*\* Transformar a aplicação de console em uma API REST com \*\*Spring Web\*\*, expondo endpoints para cada funcionalidade (ex: `GET /alunos`, `POST /treinos`).

\* \[ ] \*\*Segurança:\*\* Adicionar autenticação e autorização com \*\*Spring Security\*\*.

\* \[ ] \*\*Validação de Dados:\*\* Implementar validações robustas para as entradas do usuário.

\* \[ ] \*\*Testes:\*\* Criar testes unitários e de integração para garantir a qualidade do código.

