package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Professor;

public class ProfessorDAO {

    // Constantes para os literais duplicados (Resolvendo java:S1192)
    private static final String COL_ID = "idprofessor";
    private static final String COL_NOME = "nome";
    private static final String COL_ENDERECO = "endereco";
    private static final String COL_FONE = "fone";
    private static final String COL_EMAIL = "email";
    private static final String COL_FORMACAO = "formacao";
    private static final String COL_TITULACAO = "titulacao";
    private static final String COL_SALARIO = "salario";

    public boolean insert(Professor p) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO professor (nome, endereco, fone, email, formacao, titulacao, salario) VALUES (?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getEndereco());
            stmt.setString(3, p.getFone());
            stmt.setString(4, p.getEmail());
            stmt.setString(5, p.getFormacao());
            stmt.setString(6, p.getTitulacao());
            stmt.setDouble(7, p.getSalario());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir professor", "", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Professor> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Professor> vetor = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT idprofessor, nome, endereco, fone, email, formacao, titulacao, salario FROM professor");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Professor p = new Professor();
                p.setIdprofessor(rs.getInt(COL_ID));
                p.setNome(rs.getString(COL_NOME));
                p.setEndereco(rs.getString(COL_ENDERECO));
                p.setFone(rs.getString(COL_FONE));
                p.setEmail(rs.getString(COL_EMAIL));
                p.setFormacao(rs.getString(COL_FORMACAO));
                p.setTitulacao(rs.getString(COL_TITULACAO));
                p.setSalario(rs.getDouble(COL_SALARIO));

                vetor.add(p);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler professores", "", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return vetor;
    }

    public boolean update(Professor p) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE professor SET nome = ?, endereco = ?, fone = ?, email = ?, formacao = ?, titulacao = ?, salario = ? WHERE idprofessor = ?");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getEndereco());
            stmt.setString(3, p.getFone());
            stmt.setString(4, p.getEmail());
            stmt.setString(5, p.getFormacao());
            stmt.setString(6, p.getTitulacao());
            stmt.setDouble(7, p.getSalario());
            stmt.setLong(8, p.getIdprofessor());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar professor", "", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(Professor p) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM professor WHERE idprofessor = ?");
            stmt.setLong(1, p.getIdprofessor());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir professor", "", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Professor> getProfessoresNome(String n) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Professor> vetor = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT idprofessor, nome, endereco, fone, email, formacao, titulacao, salario FROM professor WHERE nome LIKE ? ORDER BY idprofessor");
            stmt.setString(1, "%" + n + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Professor p = new Professor();
                p.setIdprofessor(rs.getInt(COL_ID));
                p.setNome(rs.getString(COL_NOME));
                p.setEndereco(rs.getString(COL_ENDERECO));
                p.setFone(rs.getString(COL_FONE));
                p.setEmail(rs.getString(COL_EMAIL));
                p.setFormacao(rs.getString(COL_FORMACAO));
                p.setTitulacao(rs.getString(COL_TITULACAO));
                p.setSalario(rs.getDouble(COL_SALARIO));

                vetor.add(p);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler os professores por nome", "", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return vetor;
    }

    public List<Professor> getProfessoresFormacao(String formacao) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Professor> vetor = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT idprofessor, nome, endereco, fone, email, formacao, titulacao, salario FROM professor WHERE formacao = ? ORDER BY idprofessor");
            stmt.setString(1, formacao);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Professor p = new Professor();
                p.setIdprofessor(rs.getInt(COL_ID));
                p.setNome(rs.getString(COL_NOME));
                p.setEndereco(rs.getString(COL_ENDERECO));
                p.setFone(rs.getString(COL_FONE));
                p.setEmail(rs.getString(COL_EMAIL));
                p.setFormacao(rs.getString(COL_FORMACAO));
                p.setTitulacao(rs.getString(COL_TITULACAO));
                p.setSalario(rs.getDouble(COL_SALARIO));

                vetor.add(p);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler os professores por formacao", "", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return vetor;
    }

    public List<Professor> getProfessoresTitulacao(String titulacao) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Professor> vetor = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT idprofessor, nome, endereco, fone, email, formacao, titulacao, salario FROM professor WHERE titulacao = ? ORDER BY idprofessor");
            stmt.setString(1, titulacao);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Professor p = new Professor();
                p.setIdprofessor(rs.getInt(COL_ID));
                p.setNome(rs.getString(COL_NOME));
                p.setEndereco(rs.getString(COL_ENDERECO));
                p.setFone(rs.getString(COL_FONE));
                p.setEmail(rs.getString(COL_EMAIL));
                p.setFormacao(rs.getString(COL_FORMACAO));
                p.setTitulacao(rs.getString(COL_TITULACAO));
                p.setSalario(rs.getDouble(COL_SALARIO));

                vetor.add(p);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler os professores por titulacao", "", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return vetor;
    }
}