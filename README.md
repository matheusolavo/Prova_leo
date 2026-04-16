# App de Cadastro de Produtos

Aplicativo Android desenvolvido em Java utilizando Android Studio, com o objetivo de realizar o cadastro e listagem de produtos com armazenamento local utilizando Room Database.

---

## Funcionalidades

✔ Cadastro de produtos  
✔ Validação de campos obrigatórios  
✔ Validação de preço (número positivo com até 2 casas decimais)  
✔ Validação de quantidade (número inteiro positivo)  
✔ Armazenamento local com Room  
✔ Listagem de produtos com RecyclerView  
✔ Navegação entre telas  
✔ Interface moderna com CardView  

---

## Tecnologias Utilizadas

- Java  
- Android Studio  
- Room Database  
- RecyclerView  
- CardView  
- XML (Layouts)

---

## Estrutura do Projeto

- `MainActivity` → Tela de cadastro  
- `ListaProdutoActivity` → Tela de listagem  
- `Produto` → Entidade do banco  
- `ProdutoDao` → Interface de acesso aos dados  
- `ProdutoDatabase` → Configuração do banco Room  
- `ProdutoAdapter` → Adapter do RecyclerView  

---

## Regras de Validação

- Nenhum campo pode ficar vazio  
- Preço:
  - Deve ser positivo  
  - Máximo de 2 casas decimais  
- Quantidade:
  - Deve ser número inteiro  
  - Deve ser positiva  

---

## Banco de Dados

O aplicativo utiliza o **Room Database** para armazenamento local dos dados, com:

- Entidade: `Produto`
- DAO: `ProdutoDao`
- Database: `ProdutoDatabase`

---

## Interface

- Tela de cadastro com campos de entrada  
- Tela de listagem com RecyclerView  
- Itens exibidos em formato de **CardView (shadowbox)**  
- Navegação simples e intuitiva  

---

## Como Executar

1. Abrir o projeto no Android Studio  
2. Aguardar o Gradle sincronizar  
3. Executar em um emulador ou dispositivo físico  
4. Utilizar o app normalmente  

---

## Objetivo

Este projeto foi desenvolvido como atividade acadêmica com o objetivo de aplicar conceitos de:

- Persistência de dados com Room  
- Desenvolvimento de interfaces Android  
- Validação de dados  
- Uso de RecyclerView  

---

## Video de Demonstração 
[Screen_recording_20260415_212118.webm](https://github.com/user-attachments/assets/aa5e807d-7f11-47ca-9864-c646c438f2e7)






