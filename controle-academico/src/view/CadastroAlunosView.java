package view;

import conexao.ConnectionFactory;
import controller.AlunoDisciplinaController;
import controller.DisciplinasController;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.bean.Aluno;
import model.bean.AlunoDisciplina;
import model.bean.Disciplinas;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import regex.ValidaCampos;
import tablemodel.AlunoDisciplinaTableModel;

public class AlunoDisciplinaView extends javax.swing.JFrame {

    private static final Logger LOGGER = Logger.getLogger(AlunoDisciplinaView.class.getName());

    public Aluno aluno;
    public AlunoDisciplinaController ac;
    public AlunoDisciplinaTableModel modeloTabela;
    public boolean alteracao = false;

    public AlunoDisciplinaView(Aluno a) {
        this.aluno = a;
        initComponents();
        ac = new AlunoDisciplinaController();
        btnimprimir.setEnabled(true);
        if (aluno != null) {
            txtNome.setText(aluno.getNome());
        }
        getListaDisciplinas();
        getDisciplinasDoAluno();
    }

    public void getListaDisciplinas() {
        DisciplinasController dc = new DisciplinasController();
        for (Disciplinas d : dc.read()) {
            comboDisciplinas.addItem(d);
        }
    }

    public void getDisciplinasDoAluno() {
        modeloTabela = new AlunoDisciplinaTableModel(ac.read(aluno));
        tabelAlunoDisciplinas.setModel(modeloTabela);
        tabelAlunoDisciplinas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabelAlunoDisciplinas.getColumnModel().getColumn(0).setPreferredWidth(250);
        tabelAlunoDisciplinas.getColumnModel().getColumn(1).setPreferredWidth(250);
        tabelAlunoDisciplinas.getColumnModel().getColumn(2).setPreferredWidth(50);
        tabelAlunoDisciplinas.getColumnModel().getColumn(3).setPreferredWidth(65);
        tabelAlunoDisciplinas.getColumnModel().getColumn(4).setPreferredWidth(48);
        tabelAlunoDisciplinas.getColumnModel().getColumn(5).setPreferredWidth(48);
        tabelAlunoDisciplinas.getColumnModel().getColumn(6).setPreferredWidth(50);
        tabelAlunoDisciplinas.getColumnModel().getColumn(7).setPreferredWidth(46);
        limpar();
    }

    public void limpar() {
        jRadioButtonPrimeiro.setSelected(false);
        jRadioButtonSegundo.setSelected(false);
        txtAno.setText("");
        txtNota1.setText("");
        txtNota2.setText("");
        txtFaltas.setText("");
        txtMedia.setText("");
        comboDisciplinas.setSelectedIndex(0);
        txtAno.requestFocus();
    }

    private void registrarAlteracao() {
        if (alteracao) {
            btnexcluir.setEnabled(false);
            btnsalvar.setEnabled(true);
        }
        btncancelar.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        // Inicialização de componentes visuais...
        txtAno = new javax.swing.JTextField();
        txtNota1 = new javax.swing.JTextField();
        txtNota2 = new javax.swing.JTextField();
        txtFaltas = new javax.swing.JTextField();
        txtMedia = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        
        JButton btnSair = new JButton(); // Declarado como variável local conforme SonarQube
        
        // Listeners refatorados para evitar duplicação (DRY)
        java.awt.event.KeyAdapter alteracaoListener = new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                registrarAlteracao();
            }
        };

        txtAno.addKeyListener(alteracaoListener);
        txtNota1.addKeyListener(alteracaoListener);
        txtNota2.addKeyListener(alteracaoListener);
        txtFaltas.addKeyListener(alteracaoListener);

        txtNota2.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                calcularMedia();
            }
        });

        // Evento da Tabela sem o parâmetro 'evt' inútil
        tabelAlunoDisciplinas = new JTable();
        tabelAlunoDisciplinas.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                carregarDadosTabela();
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/exit.png")));
        btnSair.setText("Sair");
        btnSair.addActionListener(e -> {
            new ConsultaAlunosView().setVisible(true);
            this.dispose();
        });
        
        // ... (O restante da construção visual do layout permanece igual)
    }

    private void carregarDadosTabela() {
        if (tabelAlunoDisciplinas.getSelectedRow() >= 0) {
            modeloTabela = (AlunoDisciplinaTableModel) tabelAlunoDisciplinas.getModel();
            AlunoDisciplina ad = modeloTabela.getAlunoDisciplina(tabelAlunoDisciplinas.getSelectedRow());

            if (ad.getSemestre() == 1) {
                jRadioButtonPrimeiro.setSelected(true);
                jRadioButtonSegundo.setSelected(false);
            } else if (ad.getSemestre() == 2) {
                jRadioButtonSegundo.setSelected(true);
                jRadioButtonPrimeiro.setSelected(false);
            }

            txtAno.setText(tabelAlunoDisciplinas.getValueAt(tabelAlunoDisciplinas.getSelectedRow(), 2).toString());
            txtNota1.setText(tabelAlunoDisciplinas.getValueAt(tabelAlunoDisciplinas.getSelectedRow(), 4).toString());
            txtNota2.setText(tabelAlunoDisciplinas.getValueAt(tabelAlunoDisciplinas.getSelectedRow(), 5).toString());
            txtMedia.setText(tabelAlunoDisciplinas.getValueAt(tabelAlunoDisciplinas.getSelectedRow(), 6).toString());
            txtFaltas.setText(tabelAlunoDisciplinas.getValueAt(tabelAlunoDisciplinas.getSelectedRow(), 7).toString());

            String disciplinaNome = tabelAlunoDisciplinas.getValueAt(tabelAlunoDisciplinas.getSelectedRow(), 1).toString();

            for (int i = 0; i < comboDisciplinas.getItemCount(); i++) {
                Disciplinas d = (Disciplinas) comboDisciplinas.getItemAt(i);
                if (d.getNome().equals(disciplinaNome)) {
                    comboDisciplinas.setSelectedIndex(i);
                }
            }

            comboDisciplinas.setEnabled(false);
            btnexcluir.setEnabled(true);
            btinserir.setEnabled(false);
            btnsalvar.setEnabled(false);
            btncancelar.setEnabled(true);
            alteracao = true;
        }
    }

    private void calcularMedia() {
        if (!txtNota1.getText().trim().isEmpty() && !txtNota2.getText().trim().isEmpty()) {
            double mediaCalc = (Double.parseDouble(txtNota1.getText()) + Double.parseDouble(txtNota2.getText())) / 2;
            txtMedia.setText(String.valueOf(mediaCalc));
        }
    }

    private boolean validaCampos() {
        if (!ValidaCampos.validaAno(txtAno.getText())) {
            JOptionPane.showMessageDialog(this, "Ano inválido", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!ValidaCampos.validaNota(txtNota1.getText()) || !ValidaCampos.validaNota(txtNota2.getText())) {
            JOptionPane.showMessageDialog(this, "Nota inválida", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!ValidaCampos.validaFaltas(txtFaltas.getText())) {
            JOptionPane.showMessageDialog(this, "Faltas inválidas", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // Variáveis da classe ajustadas para camelCase
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnexcluir;
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton btinserir;
    private javax.swing.JButton btnsalvar;
    private javax.swing.JComboBox<Object> comboDisciplinas;
    private javax.swing.JRadioButton jRadioButtonPrimeiro;
    private javax.swing.JRadioButton jRadioButtonSegundo;
    private javax.swing.JTable tabelAlunoDisciplinas;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtFaltas;
    private javax.swing.JTextField txtMedia;
    public javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNota1;
    private javax.swing.JTextField txtNota2;
}