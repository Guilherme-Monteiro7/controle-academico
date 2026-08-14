package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.Professor;

public class ProfessorTableModel extends AbstractTableModel {

    // Adicionado 'transient' para evitar problemas com java:S1948
    private transient List<Professor> listaProfessores;
    private final String[] colunas = {"Nome", "Endereço", "Telefone", "E-mail", "Formação", "Titulação", "Salário"};

    public ProfessorTableModel() {
        listaProfessores = new ArrayList<>();
    }

    // Corrigido java:S117 - Parâmetro renomeado de 'Professor' para 'professores'
    public ProfessorTableModel(List<Professor> professores) {
        this();
        if (professores != null) {
            this.listaProfessores.addAll(professores);
        }
    }

    @Override
    public int getRowCount() {
        return listaProfessores.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Professor p = listaProfessores.get(linha);
        switch (coluna) {
            case 0:
                return p.getNome();
            case 1:
                return p.getEndereco();
            case 2:
                return p.getFone();
            case 3:
                return p.getEmail();
            case 4:
                return p.getFormacao();
            case 5:
                return p.getTitulacao();
            case 6:
                return p.getSalario();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    // Corrigido o nome do método de getAluno para getProfessor
    public Professor getProfessor(int linha) {
        if (linha < 0 || linha >= listaProfessores.size()) {
            return null;
        }
        return listaProfessores.get(linha);
    }
}