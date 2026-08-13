package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Aluno;
import model.bean.AlunoDisciplina;
import model.bean.Disciplinas;

public class AlunoDisciplinaDAO {

    private final Connection con = ConnectionFactory.getConnection();

    public boolean insert(AlunoDisciplina ad) {
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(
                "INSERT INTO aluno_disciplina (idaluno, iddisciplina, semestre, ano, nota1, nota2, faltas) VALUES (?, ?, ?, ?, ?, ?, ?)"
            );
            stmt.setInt(1, ad.getAluno().getId());
            stmt.setInt(2, ad.getDisciplinas().getId());
            stmt.setInt(3, ad.getSemestre());
            stmt.setInt(4, ad.getAno());
            stmt.setDouble(5, ad.getNota1());
            stmt.setDouble(6, ad.getNota2());
            stmt.setInt(7, ad.getFaltas());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro ao inserir", "", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean update(AlunoDisciplina ad) {
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE aluno_disciplina SET semestre=?, ano=?, nota1=?, nota2=?, faltas=? WHERE idaluno=? AND iddisciplina=?");
            stmt.setInt(1, ad.getSemestre());
            stmt.setInt(2, ad.getAno());
            stmt.setDouble(3, ad.getNota1());
            stmt.setDouble(4, ad.getNota2());
            stmt.setInt(5, ad.getFaltas());
            stmt.setInt(6, ad.getAluno().getId());
            stmt.setInt(7, ad.getDisciplinas().getId());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro ao atualizar", "", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(AlunoDisciplina a) {
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM aluno_disciplina WHERE idaluno = ? AND iddisciplina = ?");
            stmt.setInt(1, a.getAluno().getId());
            stmt.setInt(2, a.getDisciplinas().getId());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro ao excluir", "", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<AlunoDisciplina> read(Aluno alunoFiltro) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<AlunoDisciplina> vetor = new ArrayList<>();

        try {
            stmt = con.prepareStatement(
                "SELECT idaluno, nome, iddisciplina, disciplina, semestre, ano, nota1, nota2, faltas FROM view_aluno_disciplina WHERE idaluno = ?"
            );
            stmt.setInt(1, alunoFiltro.getId());
            rs = stmt.executeQuery();

            while (rs.next()) {
                AlunoDisciplina a = new AlunoDisciplina();
                a.setSemestre(rs.getInt("semestre"));
                a.setAno(rs.getInt("ano"));
                a.setNota1(rs.getDouble("nota1"));
                a.setNota2(rs.getDouble("nota2"));
                a.setFaltas(rs.getInt("faltas"));

                Aluno al = new Aluno();
                al.setId(rs.getInt("idaluno"));
                al.setNome(rs.getString("nome"));

                Disciplinas d = new Disciplinas();
                d.setId(rs.getInt("iddisciplina"));
                d.setNome(rs.getString("disciplina"));

                a.setAluno(al);
                a.setDisciplinas(d);

                vetor.add(a);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro ao ler", "", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return vetor;
    }
}