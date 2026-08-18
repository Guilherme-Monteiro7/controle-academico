package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Aluno;

public class AlunoDAO {
    
    // Constantes para evitar duplicação de literais de colunas e mensagens (Regras do SonarQube)
    private static final String COL_ID_ALUNO = "idaluno";
    private static final String COL_ENDERECO = "endereco";
    private static final String COL_EMAIL = "email";
    private static final String COL_MATRICULA = "matrícula";
    private static final String COL_CURSO = "curso";
    private static final String MSG_ERRO_LEITURA = "erro ao ler os alunos";
    
    Connection con = ConnectionFactory.getConnection();
        
    public boolean insert(Aluno a) {
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO aluno (nome, endereco, fone, email, matrícula, curso) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getEndereco());
            stmt.setString(3, a.getTelefone());
            stmt.setString(4, a.getEmail());
            stmt.setString(5, a.getMatricula());
            stmt.setString(6, a.getCurso());
            
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro ao inserir aluno", "", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Aluno> read() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Aluno> vetorAlunos = new java.util.ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT idaluno, nome, endereco, fone, email, matrícula, curso FROM aluno");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Aluno a = new Aluno();
                a.setId(rs.getInt(COL_ID_ALUNO));
                a.setNome(rs.getString("nome"));
                a.setEndereco(rs.getString(COL_ENDERECO));
                a.setTelefone(rs.getString("fone"));
                a.setEmail(rs.getString(COL_EMAIL));
                a.setMatricula(rs.getString(COL_MATRICULA));
                a.setCurso(rs.getString(COL_CURSO));
                
                vetorAlunos.add(a);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, MSG_ERRO_LEITURA, "", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return vetorAlunos;
    }
    
    public boolean update(Aluno a) {
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE aluno SET nome = ?, endereco = ?, fone = ?, email = ?, matrícula = ?, curso = ? WHERE idaluno = ?");
            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getEndereco());
            stmt.setString(3, a.getTelefone());
            stmt.setString(4, a.getEmail());
            stmt.setString(5, a.getMatricula());
            stmt.setString(6, a.getCurso());
            stmt.setLong(7, a.getId());
            
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro ao atualizar aluno", "", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean delete(Aluno a) {
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM aluno WHERE idaluno = ?");
            stmt.setLong(1, a.getId());
            
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro ao excluir o aluno", "", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Aluno> getAlunosNome(String n) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Aluno> vetor = new java.util.ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT idaluno, nome, endereco, fone, email, matrícula, curso FROM aluno WHERE nome LIKE ? ORDER BY idaluno");
            stmt.setString(1, "%" + n + "%");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Aluno a = new Aluno();
                a.setId(rs.getInt(COL_ID_ALUNO));
                a.setNome(rs.getString("nome"));
                a.setEndereco(rs.getString(COL_ENDERECO));
                a.setTelefone(rs.getString("fone"));
                a.setEmail(rs.getString(COL_EMAIL));
                a.setMatricula(rs.getString(COL_MATRICULA));
                a.setCurso(rs.getString(COL_CURSO));
                
                vetor.add(a);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MSG_ERRO_LEITURA, "", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return vetor;
    }
    
    public List<Aluno> getAlunosMatr(String matr) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Aluno> vetor = new java.util.ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT idaluno, nome, endereco, fone, email, matrícula, curso FROM aluno WHERE matrícula = ? ORDER BY idaluno");
            stmt.setString(1, matr);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Aluno a = new Aluno();
                a.setId(rs.getInt(COL_ID_ALUNO));
                a.setNome(rs.getString("nome"));
                a.setEndereco(rs.getString(COL_ENDERECO));
                a.setTelefone(rs.getString("fone"));
                a.setEmail(rs.getString(COL_EMAIL));
                a.setMatricula(rs.getString(COL_MATRICULA));
                a.setCurso(rs.getString(COL_CURSO));
                
                vetor.add(a);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MSG_ERRO_LEITURA, "", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return vetor;
    }
    
    public List<Aluno> getAlunosCurso(String c) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Aluno> vetor = new java.util.ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT idaluno, nome, endereco, fone, email, matrícula, curso FROM aluno WHERE curso = ? ORDER BY idaluno");
            stmt.setString(1, c);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Aluno a = new Aluno();
                a.setId(rs.getInt(COL_ID_ALUNO));
                a.setNome(rs.getString("nome"));
                a.setEndereco(rs.getString(COL_ENDERECO));
                a.setTelefone(rs.getString("fone"));
                a.setEmail(rs.getString(COL_EMAIL));
                a.setMatricula(rs.getString(COL_MATRICULA));
                a.setCurso(rs.getString(COL_CURSO));
                
                vetor.add(a);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MSG_ERRO_LEITURA, "", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return vetor;
    }
}