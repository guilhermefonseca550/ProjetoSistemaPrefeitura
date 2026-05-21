# ProjetoSistemaPrefeitura

# 🏛️ Sistema Prefeitura — Programa de Auxílio Social

Sistema de triagem automatizada para elegibilidade em programas de auxílio social da prefeitura. O programa coleta dados socioeconômicos do cidadão, calcula uma pontuação e determina se ele é elegível, está na fila de espera ou não se qualifica para o benefício. Criado para fins acadêmicos.

---

## 📋 Funcionalidades

- Coleta de dados via terminal (Scanner)
- Validação de entradas com limite de tentativas
- Cálculo de pontuação baseado em critérios sociais
- Classificação automática em três categorias de resultado

---

## 🧮 Critérios de Pontuação

| Critério              | Condição                        | Pontos |
|-----------------------|---------------------------------|--------|
| **Renda per capita**  | Até R$ 350,00                   | 5      |
|                       | R$ 350,01 a R$ 500,00           | 3      |
|                       | Acima de R$ 500,00              | 0      |
| **Dependentes**       | 3 ou mais                       | 5      |
|                       | 2 dependentes                   | 3      |
|                       | 1 dependente                    | 1      |
|                       | Nenhum                          | 0      |
| **Deficiência**       | Sim                             | 5      |
|                       | Não                             | 0      |
| **Tempo de desemprego** | Mais de 12 meses              | 5      |
|                       | 12 meses ou menos               | 0      |
| **Risco do bairro**   | Alto (2)                        | 5      |
|                       | Médio (1)                       | 3      |
|                       | Baixo (0)                       | 0      |

**Pontuação máxima possível: 25 pontos**

---

## 🏆 Resultado

| Pontuação Total | Resultado                              |
|-----------------|----------------------------------------|
| ≥ 15 pontos     | ✅ Elegível para o programa de auxílio |
| 10 a 14 pontos  | ⏳ Na fila de espera                   |
| < 10 pontos     | ❌ Não elegível                        |

---

## ▶️ Como Executar

### Pré-requisitos
- Java JDK 8 ou superior instalado
- Terminal / prompt de comando

### Compilação e execução

```bash
# Compilar
javac SistemaPrefeitura.java

# Executar
java SistemaPrefeitura
```

### Exemplo de uso

```
Digite sua renda per capita: 300
Digite o número de dependentes: 3
Possui deficiência? S para SIM ou N para NÃO
n
Qual o tempo de desemprego em meses?
15
Digite o risco do seu bairro sendo 0 para Baixo, 1 para Médio e 2 para Alto:
2

Parabéns! Você é elegível para o programa de auxílio. Sua pontuação total é: 20.0
```

---

## 🛡️ Validações

- **Valores negativos**: o programa solicita nova entrada; após 2 tentativas inválidas, usa um valor de fallback e prossegue.
- **Campo deficiência**: aceita apenas `s` ou `n` (maiúsculo ou minúsculo); após 2 tentativas inválidas, assume `n` automaticamente.

---

## 🗂️ Estrutura do Código

```
SistemaPrefeitura.java
│
├── main()                          → Fluxo principal e coleta de dados
├── calcularRendaPontuacao()        → Pontuação por renda per capita
├── calcularDependentesPontuacao()  → Pontuação por número de dependentes
├── calcularDeficienciaPontuacao()  → Pontuação por deficiência
├── calcularDesempregoPontuacao()   → Pontuação por tempo de desemprego
├── calcularRiscoBairroPontuacao()  → Pontuação pelo risco do bairro
├── calcularPontuacaoTotal()        → Soma de todos os pontos
└── limitador()                     → Validação de entradas numéricas
```

---

## 📌 Observações

- O programa roda inteiramente no terminal, sem interface gráfica.
- Todas as entradas são lidas via `Scanner` do `System.in`.
- Projeto desenvolvido para fins educacionais / acadêmicos.