import java.util.*;

public class PacienteCRUD {
    private List<Paciente> pacientes;
    private Scanner scanner;

    public PacienteCRUD() {
        pacientes = PacienteRepository.carregar();
        scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n=== MENU PACIENTE ===");
            System.out.println("1. Criar novo paciente");
            System.out.println("2. Listar todos");
            System.out.println("3. Buscar por ID");
            System.out.println("4. Editar paciente");
            System.out.println("5. Excluir paciente");
            System.out.println("6. Sair");
            System.out.print("Opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1: criar(); break;
                case 2: listar(); break;
                case 3: buscar(); break;
                case 4: editar(); break;
                case 5: excluir(); break;
            }
        } while (opcao != 6);
    }

    private void criar() {
        try {
            System.out.print("Nome completo: ");
            String nome = scanner.nextLine();
            System.out.print("CPF (11 dígitos): ");
            String cpf = scanner.nextLine();
            System.out.print("Data de nascimento: ");
            String nascimento = scanner.nextLine();
            System.out.print("Gênero: ");
            String genero = scanner.nextLine();
            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Endereço: ");
            String endereco = scanner.nextLine();
            System.out.print("Convênio: ");
            String convenio = scanner.nextLine();
            System.out.print("Histórico Médico: ");
            String historico = scanner.nextLine();

            int novoId = pacientes.isEmpty() ? 1 : pacientes.get(pacientes.size() - 1).getIdPaciente() + 1;
            Paciente novo = new Paciente(novoId, nome, cpf, nascimento, genero, telefone, email, endereco, convenio, historico);
            pacientes.add(novo);
            PacienteRepository.salvar(pacientes);
            System.out.println("Paciente cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void listar() {
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente encontrado.");
        } else {
            for (Paciente p : pacientes) {
                System.out.println(p.toCSV());
            }
        }
    }

    private void buscar() {
        System.out.print("ID do paciente: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Paciente p : pacientes) {
            if (p.getIdPaciente() == id) {
                System.out.println(p.toCSV());
                return;
            }
        }
        System.out.println("Paciente não encontrado.");
    }

    private void editar() {
        System.out.print("ID do paciente: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Paciente p : pacientes) {
            if (p.getIdPaciente() == id) {
                System.out.print("Novo nome: ");
                p.setNomeCompleto(scanner.nextLine());
                PacienteRepository.salvar(pacientes);
                System.out.println("Paciente atualizado.");
                return;
            }
        }
        System.out.println("Paciente não encontrado.");
    }

    private void excluir() {
        System.out.print("ID do paciente: ");
        int id = Integer.parseInt(scanner.nextLine());
        Paciente encontrado = null;
        for (Paciente p : pacientes) {
            if (p.getIdPaciente() == id) {
                encontrado = p;
                break;
            }
        }
        if (encontrado != null) {
            pacientes.remove(encontrado);
            PacienteRepository.salvar(pacientes);
            System.out.println("Paciente removido.");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }
}
