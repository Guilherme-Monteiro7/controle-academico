package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.Disciplinas;

public class DisciplinaTableModel extends AbstractTableModel {

    // Resolvido o java:S1948 marcando o campo como transient
    private transient List<Disciplinas> listaDisc;
    private final String[] colunas = {"Nome", "Código", "Carga Horária"};

    public DisciplinaTableModel() {
        listaDisc = new ArrayList<>();
    }

    public DisciplinaTableModel(List<Disciplinas> disc) {
        this();
        if (disc != null) {
            this.listaDisc.addAll(disc);
        }
    }

    @Override
    public int getRowCount() {
        return listaDisc.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Disciplinas d = listaDisc.get(linha);
        switch (coluna) {
            case 0:
                return d.getNome();
            case 1:
                return d.getCodigo();
            case 2:
                return d.getCargaHoraria();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    // Corrigido o nome do método que retornava "Aluno" em uma tabela de Disciplinas
    public Disciplinas getDisciplina(int linha) {
        if (linha >= listaDisc.size() || linha < 0) {
            return null;
        }
        return listaDisc.get(linha);
    }
}