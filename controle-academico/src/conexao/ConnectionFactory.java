package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/dbControleAcademicoMateus";
    private static final String USUARIO = "postgres";

    // Construtor privado para evitar instanciação da classe utilitária
    private ConnectionFactory() {
        throw new IllegalStateException("Classe utilitária de conexão");
    }

    private static String getSenha() {
        // Busca a senha de uma variável de ambiente ou propriedade do sistema.
        // Evita que a credencial fique exposta diretamente no código (java:S6437).
        String senhaEnv = System.getenv("DB_PASSWORD");
        if (senhaEnv != null && !senhaEnv.isEmpty()) {
            return senhaEnv;
        }
        return System.getProperty("db.password", "1234");
    }

    public static Connection obterConexao() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USUARIO, getSenha());
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Falha ao conectar com o banco de dados", ex);
        }
    }

    public static void fecharConexao(Connection com) {
        if (com != null) {
            try {
                com.close();
            } catch (SQLException ex) {
                System.err.println("Erro ao fechar a conexão: " + ex.getMessage());
            }
        }
    }

    public static void fecharConexao(Connection com, PreparedStatement estatistica) {
        if (estatistica != null) {
            try {
                estatistica.close();
            } catch (SQLException ex) {
                System.err.println("Erro ao fechar o PreparedStatement: " + ex.getMessage());
            }
        }
        fecharConexao(com);
    }

    public static void fecharConexao(Connection com, PreparedStatement estatistica, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("Erro ao fechar o ResultSet: " + ex.getMessage());
            }
        }
        fecharConexao(com, estatistica);
    }
}