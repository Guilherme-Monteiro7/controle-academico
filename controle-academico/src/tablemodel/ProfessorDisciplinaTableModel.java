package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.ProfessorDisciplina;

public class ProfessorDisciplinaTableModel extends AbstractTableModel {

    // Resolvido o java:S1948 marcando o campo como transient
    private transient List<ProfessorDisciplina> listaProfessorDisciplina;
    private final String[] colunas = {"Professor", "Disciplina", "Ano", "Semestre", "Dias"};

    public ProfessorDisciplinaTableModel() {
        listaProfessorDisciplina = new ArrayList<>();
    }

    public ProfessorDisciplinaTableModel(List<ProfessorDisciplina> profDisc) {
        this();
        if (profDisc != null) {
            this.listaProfessorDisciplina.addAll(profDisc);
        }
    }

    @Override
    public int getRowCount() {
        return listaProfessorDisciplina.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        ProfessorDisciplina pd = listaProfessorDisciplina.get(linha);
        switch (coluna) {
            case 0:
                return (pd.getProfessor() != null) ? pd.getProfessor().getNome() : "";
            case 1:
                return (pd.getDisciplina() != null) ? pd.getDisciplina().getNome() : "";
            case 2:
                return pd.getAno();
            case 3:
                return pd.getSemestre();
            case 4:
                return pd.getDia();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public ProfessorDisciplina getProfessorDisciplina(int linha) {
        if (linha < 0 || linha >= listaProfessorDisciplina.size()) {
            return null;
        }
        return listaProfessorDisciplina.get(linha);
    }
}