public class Paciente {
    private int idPaciente;
    private String nomeCompleto;
    private String cpf;
    private String dataNascimento;
    private String genero;
    private String telefone;
    private String email;
    private String endereco;
    private String convenio;
    private String historicoMedico;

    public Paciente(int idPaciente, String nomeCompleto, String cpf, String dataNascimento,
                    String genero, String telefone, String email, String endereco,
                    String convenio, String historicoMedico) {
        if (!validarCPF(cpf)) {
            throw new IllegalArgumentException("CPF inválido. Deve conter 11 dígitos numéricos.");
        }
        this.idPaciente = idPaciente;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.convenio = convenio;
        this.historicoMedico = historicoMedico;
    }

    public int getIdPaciente() { return idPaciente; }
    public void setIdPaciente(int id) { this.idPaciente = id; }
    public String getNomeCompleto() { return nomeCompleto; }
    public void setNomeCompleto(String nome) { this.nomeCompleto = nome; }
    public static boolean validarCPF(String cpf) {
        return cpf != null && cpf.matches("\d{11}");
    }

    public String toCSV() {
        return idPaciente + ";" + nomeCompleto + ";" + cpf + ";" + dataNascimento + ";" +
               genero + ";" + telefone + ";" + email + ";" + endereco + ";" +
               convenio + ";" + historicoMedico;
    }

    public static Paciente fromCSV(String linha) {
        String[] dados = linha.split(";");
        return new Paciente(
            Integer.parseInt(dados[0]), dados[1], dados[2], dados[3], dados[4],
            dados[5], dados[6], dados[7], dados[8], dados[9]
        );
    }
}
