package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {

    // Instanciação do Logger para substituir o System.err (java:S106)
    private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());

    private static final String URL = "jdbc:postgresql://localhost:5432/dbControleAcademicoMateus";
    private static final String USUARIO = "postgres";

    // Construtor privado para evitar instanciação da classe utilitária
    private ConnectionFactory() {
        throw new IllegalStateException("Classe utilitária de conexão");
    }

    private static String getSenha() {
        // Busca a senha de uma variável de ambiente ou propriedade do sistema
        String senhaEnv = System.getenv("DB_PASSWORD");
        if (senhaEnv != null && !senhaEnv.isEmpty()) {
            return senhaEnv;
        }
        return System.getProperty("db.password", "1234");
    }

    public static Connection getConnection() {
        try {
            // Removido Class.forName() pois é obsoleto (java:S4925)
            return DriverManager.getConnection(URL, USUARIO, getSenha());
        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao conectar com o banco de dados", ex);
        }
    }

    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                // Uso do Logger no lugar de System.err (java:S106)
                LOGGER.log(Level.SEVERE, "Erro ao fechar a conexão", ex);
            }
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Erro ao fechar o PreparedStatement", ex);
            }
        }
        closeConnection(con);
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Erro ao fechar o ResultSet", ex);
            }
        }
        closeConnection(con, stmt);
    }
}