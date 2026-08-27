# Trabalho Prático: Análise e Refatoração de Qualidade de Software com Apoio de IA

Repositório dedicado ao trabalho prático da disciplina de **Qualidade de Software (QA)** do Instituto Federal do Ceará (IFCE) - Campus Tauá. O objetivo principal é analisar a qualidade de um projeto de software corporativo/acadêmico, identificar code smells, vulnerabilidades de segurança e problemas de desempenho, aplicando refatorações massivas com auxílio de Inteligência Artificial e comparando os resultados obtidos.

---

## 👥 Integrantes
* **Marília da Silva Feitosa**
* **Guilherme Monteiro de Sousa**

## 📚 Informações Acadêmicas
* **Instituição:** Instituto Federal do Ceará (IFCE) — Campus Tauá
* **Curso:** Análise e Desenvolvimento de Sistemas (ADS)
* **Cadeira:** Qualidade de Software (QA)
* **Professor:** Me. Júlio Martins

---

## 🚀 Sobre o Projeto
* **Objetivo do Sistema:** Sistema acadêmico e de gestão para controle de alunos, professores, disciplinas e vinculações, contando com persistência JDBC e emissão de relatórios dinâmicos.
* **Tecnologias Utilizadas:** 
  * Linguagem: Java
  * Interface Gráfica: Java Swing / AWT
  * Banco de Dados / Persistência: JDBC, DAOs dedicados
  * Relatórios: JasperReports
  * Ferramentas de Qualidade: SonarQube / SonarLint

---

## 🛠️ Ferramentas de Análise de Qualidade
Para a avaliação estática e contínua do código-fonte, foram aplicadas as seguintes frentes:
* **SonarQube / SonarLint:** Identificação rigorosa de code smells, vulnerabilidades (ex: *Catastrophic Backtracking* em regex, exposição de credenciais), duplicação de código e débitos técnicos.
* **Análise de Métricas Estruturais:** Avaliação de complexidade ciclomática, acoplamento de classes DAO/View e conformidade com padrões de codificação Java.

---

## 📋 Principais Refatorações Realizadas

O processo de melhoria contínua envolveu dezenas de commits direcionados a diferentes camadas do sistema:

1. **Camada de Persistência (DAOs) e Segurança de Consultas**
   * Substituição generalizada de `ArrayList` por interfaces genéricas `List` (`java:S1319`).
   * Eliminação de consultas ineficientes do tipo `SELECT *` (`java:S6905`) por projeções direcionadas.
   * Extração de strings duplicadas e literais para constantes (ex: ID de aluno em `AlunoDAO`).
   * Correção de vazamentos de conexão e remoção de caracteres invisíveis corrompidos em arquivos de banco de dados (`DisciplinasDAO`, `ProfessorDisciplinaDAO`).

2. **Tratamento de Expressores Regulares e Vulnerabilidades de Regex**
   * Correção de falhas críticas de *Catastrophic Backtracking* e vulnerabilidades de *Stack Overflow* em rotinas de validação de e-mails (`validaEmail` / `ValidaCampos`).
   * Padronização de padrões de nomenclatura e regras de validação orientadas pelo SonarLint.

3. **Modernização e Limpeza das Views (Java Swing)**
   * Eliminação de métodos idênticos duplicados e remoção de código morto (`dead code`) nas telas principais (`CadastroDisciplinasView`, `AlunoDisciplinaView`, `ProfessorDisciplinaView`, `ConsultaAlunosView`, `ViewPrincipal`).
   * Substituição de classes anônimas verbosas por **expressões Lambda** em ouvintes de eventos e botões.
   * Remoção sistemática de parâmetros `evt` não utilizados e isolamento de variáveis locais em escopos adequados.
   * Substituição de rastros de pilha legados (`e.printStackTrace()`) por **Java Util Logging (`Logger`)** em classes críticas e de conexão.

4. **Correção de Débitos de Configuração e Credenciais**
   * Remoção de classes obsoletas (`Class.forName`) e isolamento seguro de parâmetros de infraestrutura.
   * Adequação de regras estáticas do SonarQube para evitar exposição de tokens e dados sensíveis no repositório.

---

## 📊 Comparativo Inicial vs. Final (Resumo)

| Indicador de Qualidade | Antes da Refatoração | Depois da Refatoração | Variação / Status |
| :--- | :--- | :--- | :--- |
| **Code Smells / Alertas** | Elevado (métodos extensos, variáveis órfãs e parâmetros redundantes) | Reduzido drasticamente | Melhoria expressiva na manutenibilidade e legibilidade |
| **Duplicação de Código** | Presente em múltiplos DAOs e ouvintes de interface | Centralizado e modularizado | Eliminação de redundâncias estruturais |
| **Vulnerabilidades de Segurança** | Falhas em Regex e tratamento inadequado de exceções | Corrigidas (Regex segura e uso de Logger) | Mitigação de riscos de falha sistêmica |
| **Padrão de Coleções (DAOs)** | Uso estrito de implementações concretas (`ArrayList`) | Adoção de boas práticas com interfaces `List` | Redução do acoplamento de código |

---

## 📄 Próximos Passos
* Finalização do **Relatório Técnico em PDF** com a documentação detalhada dos prompts, métricas exatas e discussões críticas.
* Conclusão dos slides e preparação para a **Apresentação** oficial do trabalho prático.