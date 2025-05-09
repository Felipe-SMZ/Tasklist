# 📋 TaskList App

Um aplicativo simples de gerenciamento de tarefas desenvolvido com **Java Spring Boot**, **Maven**, **MySQL** e um frontend em **HTML, CSS e JavaScript**.

## 📌 Funcionalidades

- ✅ Criar tarefas  
- 📝 Listar tarefas  
- 🔁 Atualizar tarefas  
- ❌ Deletar tarefas  
- 📂 Armazenamento persistente usando MySQL  

## 🛠️ Tecnologias Utilizadas

### Backend
- Java 17+  
- Spring Boot  
- Spring Data JPA  
- Maven  
- MySQL  

### Frontend
- HTML5  
- CSS3  
- JavaScript  

## 🚀 Como Executar o Projeto

### 1. Clone o repositório

git clone https://github.com/seu-usuario/tasklist-app.git

cd tasklist-app

2. Configure o banco de dados MySQL

Crie um banco chamado tasklist:

CREATE DATABASE tasklist;

Edite o arquivo src/main/resources/application.properties com suas credenciais do MySQL:
spring.datasource.url=jdbc:mysql://localhost:3306/tasklist
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
