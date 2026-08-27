package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.bean.AlunoDisciplina;

public class AlunoDisciplinaTableModel extends AbstractTableModel {

    private transient List<AlunoDisciplina> listaAlunos;
    private String[] colunas = {"Aluno", "Disciplina", "Ano", "Semestre", "Nota 1", "Nota 2", "Média", "Faltas"};

    public AlunoDisciplinaTableModel() {
        listaAlunos = new ArrayList<>();
    }

    public AlunoDisciplinaTableModel(List<AlunoDisciplina> disco) {
        this();
        this.listaAlunos.addAll(disco);
    }

    @Override
    public int getRowCount() {
        return listaAlunos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        AlunoDisciplina um = listaAlunos.get(linha);

        switch (coluna) {
            case 0:
                return um.getAluno().getNome();
            case 1:
                return um.getDisciplinas().getNome();
            case 2:
                return um.getAno();
            case 3:
                return um.getSemestre();
            case 4:
                return um.getNota1();
            case 5:
                return um.getNota2();
            case 6:
                return (um.getNota1() + um.getNota2()) / 2;
            case 7:
                return um.getFaltas();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int coluna) {
        return colunas[coluna];
    }

    public AlunoDisciplina obterDisciplinaAluno(int linha) {
        if (linha >= listaAlunos.size()) {
            return null;
        }
        return listaAlunos.get(linha);
    }
}