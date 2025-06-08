# CRUD de Pacientes - Sistema Java

## Como executar

1. Certifique-se de ter o Java instalado (JDK 11 ou superior).
2. No terminal, vá até a pasta onde está o arquivo .jar.
3. Execute o seguinte comando:

   java -jar CrudPaciente.jar

## Arquivos incluídos

- CrudPaciente.jar        → Executável do sistema
- Paciente.java           → Código-fonte da classe modelo
- PacienteRepository.java → Código-fonte da persistência
- PacienteCRUD.java       → Código-fonte do menu e operações CRUD
- Menu.java               → Classe principal com o método main()
- pacientes.txt           → Arquivo com dois exemplos de pacientes
- Diagrama Paciente

EXPLICAÇÃO ENTIDADE ESCOLHIDA

1. Entidade Escolhida
 Projeto Final - CRUD de Paciente
 Entidade: Paciente de Clínica Médica
 Justificativa: Pacientes são essenciais para o funcionamento de uma clínica. O controle digital de seus
 dados garante agilidade na marcação de consultas, acesso a históricos médicos e comunicação eficiente
 com a equipe da clínica.

 2. Atributos da Entidade- ID do Paciente (chave primária)- Nome Completo- CPF (com validação)- Data de Nascimento- Gênero- Telefone- E-mail- Endereço- Convênio Médico- Histórico Médico

 3. Funcionalidades Implementadas- CRUD completo em Java (console)- Validação de CPF com regex e tratamento de exceções- Persistência em arquivo texto (pacientes.txt)- Menu interativo com as opções: Criar, Listar, Buscar, Editar, Excluir e Sair

 4. Execução e Entregáveis- Projeto funcional em arquivo .jar- Código-fonte .java separado por responsabilidades- Arquivo pacientes.txt com exemplos reais
Projeto Final - CRUD de Paciente- README com instruções de uso- Diagrama UML em draw.io- Repositório GitHub recomendado para versionamento e entrega

 5. Conclusão
 O projeto foi desenvolvido com base em boas práticas de orientação a objetos, validações de dados e
 persistência. A escolha do paciente como entidade se mostrou eficaz para aplicar todos os conceitos
 estudados na disciplina.
