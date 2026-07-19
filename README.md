# ScreenSound Java

Aplicacao console para cadastro e gestao de artistas musicais com banco de dados PostgreSQL.

## Descricao

Aplicacao Spring Boot para cadastrar artistas (solo, dupla, banda) e suas musicas. Inclui integracao opcional com a API Hugging Face para pesquisa de dados sobre artistas.

## Funcionalidades

- Cadastrar artistas (nome + tipo: SOLO, DUPLA, BANDA)
- Cadastrar musicas para artistas
- Listar todas as musicas
- Buscar musicas por artista
- Pesquisa sobre artistas via IA (Hugging Face - Gemma-2B)

## Tecnologias

- **Linguagem:** Java 17
- **Framework:** Spring Boot 3.3.4
- **ORM:** Spring Data JPA
- **Banco de Dados:** PostgreSQL
- **IA:** Hugging Face API (Gemma-2B)
- **Build:** Maven

## Como Rodar

```bash
# Crie o banco PostgreSQL
CREATE DATABASE screensound_java;

# Execute
./mvnw spring-boot:run

# (Opcional) Configure a API do Hugging Face
export HUGGING_FACE_TOKEN="seu_token_aqui"
```

## Menu

```
1 - Cadastrar artistas
2 - Cadastrar musicas
3 - Listar musicas
4 - Buscar musicas por artista
5 - Pesquisar sobre um artista
9 - Sair
```

## Estrutura

```
src/main/java/.../
├── model/
│   ├── Artista.java       # Entidade (artistas)
│   ├── Musica.java        # Entidade (musicas)
│   └── TipoArtista.java   # Enum: SOLO, DUPLA, BANDA
├── repository/
│   └── ArtistaRepository.java
└── service/
    └── ServiceApi.java    # Integracao Hugging Face
```

## Licenca

MIT License - Diego Vieira
