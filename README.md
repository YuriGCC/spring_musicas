# 🎵 Sistema de Gerenciamento de Músicas com Spring Boot

Projeto desenvolvido com Spring Boot para cadastro e gerenciamento de músicas, artistas e álbuns em um banco de dados relacional.

![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.1.5-green.svg)
![Java](https://img.shields.io/badge/Java-17-orange.svg)
![H2](https://img.shields.io/badge/Database-H2-blue.svg)

## 📋 Funcionalidades
- **CRUD completo** de músicas, artistas e álbuns
- Relacionamentos entre entidades (JPA/Hibernate)
- API REST com endpoints documentados
- Banco de dados H2 (embutido para desenvolvimento)

## 🛠️ Tecnologias Utilizadas
- **Backend**: Spring Boot 3, Spring Data JPA, Spring Web
- **Banco de Dados**: H2 (dev) / MySQL (pronta configuração para produção)
- **Ferramentas**: Maven, Lombok

## 🚀 Como Executar
### Pré-requisitos
- Java 17
- Maven 3.8+

### Passos para Execução
1. Clone o repositório:
```bash
git clone https://github.com/YuriGCC/spring_musicas.git
cd spring_musicas

2. Compile e execute com Maven: mvn spring-boot:run
3. Acesse a API em: http://localhost:8080
4. Acesse o console do H2 Database (se habilitado): http://localhost:8080/h2-console
```

📌 Endpoints Principais
```bash
GET /musicas - Lista todas as músicas
POST /musicas - Cadastra nova música
GET /artistas - Lista todos os artistas
GET /albuns - Lista todos os álbuns
```
Projeto desenvolvido para fins educacionais demonstrando o uso de Spring Boot para APIs REST.
