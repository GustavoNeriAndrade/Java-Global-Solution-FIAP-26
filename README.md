# 🌱 EcoLoop

## 📖 Sobre o Projeto

O **EcoLoop** é um sistema desenvolvido em Java com o objetivo de simular o monitoramento de áreas de desmatamento e a estimativa das emissões de carbono decorrentes dessas ocorrências.

O projeto foi desenvolvido como atividade acadêmica do curso de **Análise e Desenvolvimento de Sistemas da FIAP**, aplicando conceitos de Programação Orientada a Objetos (POO), tratamento de exceções, encapsulamento, composição entre objetos e interação com o usuário através de interfaces gráficas utilizando **JOptionPane**.

---

## 🎯 Objetivo

O sistema permite cadastrar informações relacionadas ao monitoramento ambiental e gerar uma estimativa das emissões de CO₂ provenientes do desmatamento, simulando parte do fluxo utilizado por órgãos de fiscalização ambiental.

---

## ⚙️ Funcionalidades

* 🌍 Cadastro de Regiões
* 🛰️ Cadastro de Satélites
* 📡 Registro de Coletas de Dados
* 👨‍💼 Cadastro de Analistas
* 🚨 Registro de Alertas de Desmatamento
* 📊 Classificação automática da severidade do desmatamento
* 🌱 Estimativa das emissões de carbono (CO₂)
* 📄 Geração de Relatório de Carbono

---

## 🛠️ Tecnologias Utilizadas

* Java

## 📂 Estrutura do Projeto

```
EcoLoop/
│
├── ecoloop/
│   ├── src/
│   │   └── br.com.fiap/
│   │       ├── bean/
│   │       │   ├── Alerta.java
│   │       │   ├── Analista.java
│   │       │   ├── Coleta.java
│   │       │   ├── Regiao.java
│   │       │   ├── RelatorioCarbono.java
│   │       │   └── Satelite.java
│   │       │
│   │       └── main/
│   │           └── Main.java
│   │
│   ├── out/
│   └── EcoLoop.iml
│
└── README.md
```

---

## 🧩 Fluxo do Sistema

1. O usuário inicia o sistema.
2. É apresentado um menu principal.
3. O usuário pode:

   * cadastrar uma região;
   * cadastrar um satélite;
   * registrar uma coleta;
   * cadastrar um analista;
   * registrar um alerta.
4. Após o registro do alerta, o sistema:

   * classifica automaticamente a severidade;
   * confirma o alerta;
   * calcula a emissão estimada de CO₂;
   * gera um relatório resumido.

---

## 💻 Conceitos de Programação Aplicados

Durante o desenvolvimento foram utilizados diversos conceitos estudados em Programação Orientada a Objetos:

* Classes e Objetos
* Encapsulamento
* Construtores
* Métodos
* Getters e Setters
* Composição entre Objetos
* Tratamento de Exceções
* Estruturas de Repetição
* Estruturas Condicionais
* Manipulação de Datas com LocalDate

---

## 📈 Possíveis Melhorias Futuras

* Integração com banco de dados (Oracle/MySQL)
* Persistência dos cadastros
* Interface gráfica utilizando JavaFX
* Login de usuários
* Consulta e edição de registros
* Exportação de relatórios em PDF
* Dashboard com gráficos
* Integração com APIs de monitoramento ambiental

---

## 👨‍💻 Desenvolvido por

Projeto desenvolvido como atividade acadêmica do curso de **Análise e Desenvolvimento de Sistemas da FIAP**.

**Integrantes:**

- Gustavo Neri Andrade
- Miguel Vieira Martins
- Carlos Americo Machado Brambilla
- Thiago Vendrami Luca
