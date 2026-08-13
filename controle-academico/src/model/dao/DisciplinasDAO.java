package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Disciplinas;

public class DisciplinasDAO {

    private final Connection con = ConnectionFactory.getConnection();

    public boolean insert(Disciplinas d) {
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO disciplina (nome, codigo, cargahoraria) VALUES (?, ?, ?)");
            stmt.setString(1, d.getNome());
            stmt.setString(2, d.getCodigo());
            stmt.setInt(3, d.getCargaHoraria());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro ao inserir disciplina", "", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Disciplinas> read() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Disciplinas> vetorDisc = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT iddisciplina, nome, codigo, cargahoraria FROM disciplina");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Disciplinas d = new Disciplinas();
                d.setId(rs.getInt("iddisciplina"));
                d.setNome(rs.getString("nome"));
                d.setCodigo(rs.getString("codigo"));
                d.setCargaHoraria(rs.getInt("cargahoraria"));

                vetorDisc.add(d);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro ao ler as disciplinas", "", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return vetorDisc;
    }

    public boolean update(Disciplinas d) {
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE disciplina SET nome = ?, codigo = ?, cargahoraria = ? WHERE iddisciplina = ?");
            stmt.setString(1, d.getNome());
            stmt.setString(2, d.getCodigo());
            stmt.setInt(3, d.getCargaHoraria());
            stmt.setInt(4, d.getId());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro ao atualizar disciplina", "", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(Disciplinas d) {
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM disciplina WHERE iddisciplina = ?");
            stmt.setLong(1, d.getId());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro ao excluir disciplina", "", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}