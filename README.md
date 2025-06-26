# 🔗 Encurtador de URLs

Um serviço simples de encurtamento de URLs desenvolvido com **Java + Spring Boot**. Ideal para transformar links longos em URLs curtas, fáceis de compartilhar.

---

## 🚀 Funcionalidades

- Recebe uma URL longa e retorna uma versão encurtada.
- Geração de códigos com 5 a 10 caracteres alfanuméricos.
- Redireciona URLs curtas para seus destinos originais.
- Armazena URLs com tempo de expiração (ex: 30 dias).
- Retorna 404 caso a URL esteja expirada ou não exista.
- Console web para visualização do banco de dados em memória (H2).

---

## 📦 Tecnologias utilizadas

- Java 17
- Spring Boot
  - Spring Web
  - Spring Data JPA
- H2 Database (em memória)
- Lombok

---

## 📌 Requisitos

- JDK 17+
- Maven ou Gradle

---

## 🛠️ Como executar

1. Clone o projeto:
   ```bash
   git clone https://github.com/SEU_USUARIO/url-shortener.git
   cd url-shortener
