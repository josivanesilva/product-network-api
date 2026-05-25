# product-network-api
API de gerenciamento de estoque e transferência de produtos entre fábrica e loja, com geração de nota fiscal e auditoria de movimentações. 
Desenvolvido com Spring Boot, JPA e arquitetura em camadas.

    Objetivo do Projeto

Este projeto simula uma arquitetura de microsserviços utilizada em empresas de varejo e logística.

O sistema possui:

✅ Fabricação de produtos
✅ Controle de estoque
✅ Movimentações de estoque
✅ Geração de nota fiscal
✅ Transferência entre serviços
✅ Comunicação entre microsserviços via REST API
✅ Persistência em PostgreSQL
✅ Arquitetura modular Maven

    Microsserviços

    1️ - fabrica-nike

Responsável por:

Produção de produtos
Controle de estoque da fábrica
Movimentações
Transferências
Emissão de notas fiscais
Comunicação com loja-service


    2 - loja-service

Responsável por:

Receber produtos transferidos da fábrica
Manter estoque da loja
Persistir produtos recebidos

    Tecnologias Utilizadas
Backend
Java 17
Spring Boot 4
Spring Web
Spring Data JPA
Hibernate
PostgreSQL
Maven
Lombok
MapStruct

    Estrutura do Projeto
product-network-api
│
├── fabrica-nike
│
├── loja-service
│
└── api

    Comunicação Entre Microsserviços

A comunicação ocorre via:

RestTemplate

Quando uma transferência é realizada:

fabrica-nike
    ↓
POST /loja/receber
    ↓
loja-service

    Fluxo da Transferência
1 - Produto é produzido na fábrica

    ↓

2 - Transferência é criada

    ↓

3 - Nota fiscal é gerada

    ↓

4 - Movimentação de estoque é registrada

    ↓

5 - Microsserviço loja recebe produto

    ↓

6 - Produto é salvo no banco da loja

    Endpoints — fabrica-nike
Produtos
Criar produto

POST /produtos/produzir 

Body
JSON

    {
        "descricao": "Tênis Nike Air",
        "marca": "Nike",
        "modelo": "Air Max",
        "cor": "Preto",
        "genero": "MASCULINO",
        "tamanho": 42,
        "quantidade": 10,
        "precoCusto": 200,
        "precoVenda": 450
    }

    Testando no Postman

Estrutura recomendada:

Fabrica-Nike
│
├── Produtos
├── Transferencias
├── Notas Fiscais
└── Movimentacoes

Loja
│
└── Produtos Loja

    Conceitos Aplicados

-Microsserviços
-REST APIs
-Comunicação síncrona
-DTO Pattern
-Repository Pattern
-Service Layer
-MapStruct
-Tratamento global de exceções
-Transações
-Arquitetura modular
-PostgreSQL
-JPA/Hibernate

    Autor

Desenvolvido por Josivane Aparecido.

Projeto para fins educacionais e estudo de arquitetura de microsserviços.