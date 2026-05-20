# ProjetoSistemaPrefeitura

# 🏛️ Sistema Prefeitura — Programa de Auxílio Social

Sistema de triagem para programas de auxílio social da prefeitura. O programa coleta dados socioeconômicos do cidadão, calcula uma pontuação e determina sua elegibilidade e prioridade na fila de atendimento.

---

## 📋 Funcionalidades

- Coleta de dados via terminal (linha de comando)
- Validação de entradas com mensagens de erro amigáveis
- Limite de tentativas para campo de renda (3 tentativas)
- Cálculo automático de pontuação por critérios sociais
- Classificação do cidadão em três categorias de elegibilidade

---

## 🧮 Critérios de Pontuação

| Critério              | Condição                        | Pontos |
|-----------------------|---------------------------------|--------|
| **Renda per capita**  | Até R$ 350,00                   | 5      |
|                       | De R$ 350,01 a R$ 500,00        | 3      |
|                       | Acima de R$ 500,00              | 0      |
| **Dependentes**       | 3 ou mais                       | 5      |
|                       | 2 dependentes                   | 3      |
|                       | 1 dependente                    | 1      |
|                       | Nenhum                          | 0      |
| **Deficiência**       | Sim                             | 5      |
|                       | Não                             | 0      |
| **Tempo desempregado**| Mais de 12 meses                | 5      |
|                       | Até 12 meses                    | 0      |
| **Risco do bairro**   | Alto                            | 5      |
|                       | Médio                           | 3      |
|                       | Baixo                           | 0      |

**Pontuação máxima possível: 25 pontos**

---

## 🏆 Resultado da Avaliação

| Pontuação Total | Resultado                                          |
|-----------------|----------------------------------------------------|
| ≥ 15 pontos     | ✅ Fila **prioritária** para o programa de auxílio |
| 8 a 14 pontos   | ⏳ Fila de **espera** para o programa de auxílio   |
| < 8 pontos      | ❌ **Não elegível** para o programa de auxílio     |

---

## ▶️ Como Executar

### Pré-requisitos

- Java JDK 8 ou superior instalado
- Terminal (Prompt de Comando, PowerShell, Bash, etc.)

### Compilação

```bash
javac SistemaPrefeitura.java
```

### Execução

```bash
java SistemaPrefeitura
```

---

## 💬 Exemplo de Uso

```
Digite sua renda per capita: 300
Digite o número de dependentes: 3
Possui deficiência? Sim ou não
sim
Qual o tempo de desemprego em meses?
14
Digite o risco do seu bairro (Alto, Médio ou Baixo):
Alto
Você faz parte da fila prioritária para o programa de auxílio.
```

---

## ⚙️ Entradas Aceitas

| Campo              | Tipo    | Valores válidos                  |
|--------------------|---------|----------------------------------|
| Renda per capita   | Decimal | Número positivo (ex: `350.00`)   |
| Dependentes        | Inteiro | Número inteiro ≥ 0               |
| Deficiência        | Texto   | `Sim` ou `Nao`                   |
| Tempo desempregado | Inteiro | Número inteiro ≥ 0 (em meses)    |
| Risco do bairro    | Texto   | `Alto`, `Medio` ou `Baixo`       |

> ⚠️ **Atenção:** Para o campo "Possui deficiência", digite `Nao` sem acento. Para o risco do bairro, `Medio` também sem acento.

---

## 🔒 Validações e Limites

- **Renda per capita:** aceita apenas valores positivos. Após **3 tentativas inválidas**, o sistema avança automaticamente com valor máximo (sem pontuação nesse critério).
- **Dependentes e tempo de desemprego:** validados em loop até entrada correta.
- **Deficiência e risco do bairro:** aceitam variações de maiúsculas/minúsculas (`SIM`, `Sim`, `sim`).

---

## 🗂️ Estrutura do Código

```
SistemaPrefeitura.java
│
├── main()                        — Fluxo principal e coleta de dados
├── calcularRendaPontuacao()      — Pontuação pela renda per capita
├── calcularDependentesPontuacao()— Pontuação pelo número de dependentes
├── calcularDeficienciaPontuacao()— Pontuação pela presença de deficiência
├── calcularDesempregoPontuacao() — Pontuação pelo tempo de desemprego
├── calcularRiscoBairroPontuacao()— Pontuação pelo risco do bairro
└── calcularPontuacaoTotal()      — Soma e exibe o resultado final
```

---

## 📄 Licença

Este projeto foi desenvolvido para fins acadêmicos e de uso público.