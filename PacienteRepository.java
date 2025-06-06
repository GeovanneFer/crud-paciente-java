import java.io.*;
import java.util.*;

public class PacienteRepository {
    private static final String ARQUIVO = "pacientes.txt";

    public static void salvar(List<Paciente> lista) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARQUIVO))) {
            for (Paciente p : lista) {
                pw.println(p.toCSV());
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    public static List<Paciente> carregar() {
        List<Paciente> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                lista.add(Paciente.fromCSV(linha));
            }
        } catch (IOException e) {
            // arquivo pode ainda não existir
        }
        return lista;
    }
}
