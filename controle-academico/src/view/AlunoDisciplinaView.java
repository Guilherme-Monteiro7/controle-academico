package view;

import connection.ConnectionFactory;
import controller.AlunoDisciplinaController;
import controller.DisciplinasController;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public AlunoDisciplinaTableModel em;
    public boolean alteracao = false;

    public AlunoDisciplinaView(Aluno a) {
        this.aluno = a;
        initComponents();
        ac = new AlunoDisciplinaController();
        btnimprimir.setEnabled(true);
        if (aluno != null) {
            Txtnome.setText(aluno.getNome());
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
        em = new AlunoDisciplinaTableModel(ac.read(aluno));
        tabelAlunoDisciplinas.setModel(em);
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
        Txtano.setText("");
        TXnota1.setText("");
        txtnota2.setText("");
        estatisticas.setText("");
        midia.setText("");
        comboDisciplinas.setSelectedIndex(0);
        Txtano.requestFocus();
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
        javax.swing.JDialog jDialog1 = new javax.swing.JDialog();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        comboDisciplinas = new javax.swing.JComboBox<>();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        Txtano = new javax.swing.JTextField();
        TXnota1 = new javax.swing.JTextField();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
        txtnota2 = new javax.swing.JTextField();
        javax.swing.JLabel jLabel8 = new javax.swing.JLabel();
        midia = new javax.swing.JTextField();
        jRadioButtonPrimeiro = new javax.swing.JRadioButton();
        jRadioButtonSegundo = new javax.swing.JRadioButton();
        javax.swing.JLabel jLabel9 = new javax.swing.JLabel();
        estatisticas = new javax.swing.JTextField();
        javax.swing.JPanel jPanel2 = new javax.swing.JPanel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabelAlunoDisciplinas = new javax.swing.JTable();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        Txtnome = new javax.swing.JTextField();
        javax.swing.JPanel jPanel3 = new javax.swing.JPanel();
        btinserir = new javax.swing.JButton();
        btnsalvar = new javax.swing.JButton();
        btnexcluir = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnsair = new javax.swing.JButton();
        btnimprimir = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened();
            }
        });

        jLabel2.setText("DISCIPLINA:");
        jLabel3.setText("ANO:");
        jLabel4.setText("SEMESTRE:");

        Txtano.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                registrarAlteracao();
            }
        });

        TXnota1.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                registrarAlteracao();
            }
        });

        jLabel5.setText("NOTAS E FALTAS:");
        jLabel6.setText("Nota 1:");
        jLabel7.setText("Nota 2:");

        txtnota2.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnota2FocusLost();
            }
        });
        txtnota2.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                registrarAlteracao();
            }
        });

        jLabel8.setText("Média:");
        midia.setEditable(false);
        jRadioButtonPrimeiro.setText("Primeiro");
        jRadioButtonSegundo.setText("Segundo");
        jLabel9.setText("Faltas:");

        estatisticas.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                registrarAlteracao();
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(Txtano, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonPrimeiro)
                            .addComponent(jRadioButtonSegundo)
                            .addComponent(jLabel4))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TXnota1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(estatisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(36, 36, 36)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnota2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(midia, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(comboDisciplinas, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboDisciplinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TXnota1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(txtnota2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(midia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButtonPrimeiro)
                        .addComponent(Txtano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(estatisticas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addComponent(jRadioButtonSegundo))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        tabelAlunoDisciplinas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {}
        ));
        tabelAlunoDisciplinas.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelAlunoDisciplinasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelAlunoDisciplinas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 813, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel1.setText("ALUNO:");

        Txtnome.setEditable(false);
        Txtnome.setEnabled(false);

        btinserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png")));
        btinserir.setText("Inserir");
        btinserir.addActionListener(e -> btinserirActionPerformed());

        btnsalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/save.png")));
        btnsalvar.setText("Salvar");
        btnsalvar.setEnabled(false);
        btnsalvar.addActionListener(e -> btnsalvarActionPerformed());

        btnexcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete.png")));
        btnexcluir.setText("Exclusão");
        btnexcluir.setEnabled(false);
        btnexcluir.addActionListener(e -> btnexcluirActionPerformed());

        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png")));
        btncancelar.setText("Cancelar");
        btncancelar.setEnabled(false);
        btncancelar.addActionListener(e -> btncancelarActionPerformed());

        btnsair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/exit.png")));
        btnsair.setText("Sair");
        btnsair.addActionListener(e -> btnsairActionPerformed());

        btnimprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/print.png")));
        btnimprimir.setText("Imprimir");
        btnimprimir.setEnabled(false);
        btnimprimir.addActionListener(e -> btnimprimirActionPerformed());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btinserir)
                .addGap(30, 30, 30)
                .addComponent(btnsalvar)
                .addGap(35, 35, 35)
                .addComponent(btnexcluir)
                .addGap(26, 26, 26)
                .addComponent(btncancelar)
                .addGap(28, 28, 28)
                .addComponent(btnsair, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnimprimir)
                .addGap(38, 38, 38))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btinserir)
                    .addComponent(btnsalvar)
                    .addComponent(btnexcluir)
                    .addComponent(btncancelar)
                    .addComponent(btnsair)
                    .addComponent(btnimprimir))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(Txtnome))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void formWindowOpened() {
        getListaDisciplinas();
        getDisciplinasDoAluno();
    }

    private void tabelAlunoDisciplinasMouseClicked(java.awt.event.MouseEvent evt) {
        if (tabelAlunoDisciplinas.getSelectedRow() >= 0) {
            em = (AlunoDisciplinaTableModel) tabelAlunoDisciplinas.getModel();
            AlunoDisciplina adicionar = em.getAlunoDisciplina(tabelAlunoDisciplinas.getSelectedRow());

            if (adicionar.getSemestre() == 1) {
                jRadioButtonPrimeiro.setSelected(true);
                jRadioButtonSegundo.setSelected(false);
            } else if (adicionar.getSemestre() == 2) {
                jRadioButtonSegundo.setSelected(true);
                jRadioButtonPrimeiro.setSelected(false);
            }

            Txtano.setText(tabelAlunoDisciplinas.getValueAt(tabelAlunoDisciplinas.getSelectedRow(), 2).toString());
            TXnota1.setText(tabelAlunoDisciplinas.getValueAt(tabelAlunoDisciplinas.getSelectedRow(), 4).toString());
            txtnota2.setText(tabelAlunoDisciplinas.getValueAt(tabelAlunoDisciplinas.getSelectedRow(), 5).toString());
            midia.setText(tabelAlunoDisciplinas.getValueAt(tabelAlunoDisciplinas.getSelectedRow(), 6).toString());
            estatisticas.setText(tabelAlunoDisciplinas.getValueAt(tabelAlunoDisciplinas.getSelectedRow(), 7).toString());

            String disco = tabelAlunoDisciplinas.getValueAt(tabelAlunoDisciplinas.getSelectedRow(), 1).toString();

            for (int i = 0; i < comboDisciplinas.getItemCount(); i++) {
                Disciplinas d = (Disciplinas) comboDisciplinas.getItemAt(i);
                if (d.getNome().equals(disco)) {
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

    private void btinserirActionPerformed() {
        if (validaCampos()) {
            Disciplinas d = (Disciplinas) comboDisciplinas.getSelectedItem();
            ac.insert(this.aluno, d, jRadioButtonPrimeiro.isSelected() ? 1 : 2, Integer.parseInt(Txtano.getText()),
                    Double.parseDouble(TXnota1.getText()), Double.parseDouble(txtnota2.getText()), Integer.parseInt(estatisticas.getText()));
            getDisciplinasDoAluno();
        }
    }

    private void btncancelarActionPerformed() {
        btinserir.setSelected(true);
        btnexcluir.setSelected(false);
        btncancelar.setSelected(false);
        btnsalvar.setSelected(false);
        alteracao = false;
        limpar();
    }

    private void btnsairActionPerformed() {
        ConsultaAlunosView cv = new ConsultaAlunosView();
        cv.setVisible(true);
        this.dispose();
    }

    private void btnsalvarActionPerformed() {
        if (validaCampos()) {
            if (ac.update(this.aluno, (Disciplinas) comboDisciplinas.getSelectedItem(), jRadioButtonPrimeiro.isSelected() ? 1 : 2,
                    Integer.parseInt(Txtano.getText()), Double.parseDouble(TXnota1.getText()), Double.parseDouble(txtnota2.getText()),
                    Integer.parseInt(estatisticas.getText()))) {
                JOptionPane.showMessageDialog(null, "atualizado com sucesso", "", JOptionPane.INFORMATION_MESSAGE);
                btnsalvar.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "erro ao atualizar", "", JOptionPane.ERROR_MESSAGE);
            }
            getDisciplinasDoAluno();
        }
    }

    private void btnexcluirActionPerformed() {
        Disciplinas disciplina = (Disciplinas) comboDisciplinas.getSelectedItem();
        if (ac.delete(aluno, disciplina)) {
            JOptionPane.showMessageDialog(null, "apagado com sucesso", "", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "erro exclui", "", JOptionPane.ERROR_MESSAGE);
        }
        getDisciplinasDoAluno();
    }

    private void txtnota2FocusLost() {
        if (!TXnota1.getText().trim().isEmpty() && !txtnota2.getText().trim().isEmpty()) {
            double mediaCalc = (Double.parseDouble(TXnota1.getText()) + Double.parseDouble(txtnota2.getText())) / 2;
            midia.setText(String.valueOf(mediaCalc));
        }
    }

    private void btnimprimirActionPerformed() {
        Connection con = ConnectionFactory.getConnection();
        String src = "src/reports/DisciplinasDoAluno.jasper";
        JasperPrint jp = null;
        Map<String, Object> m = new HashMap<>();
        m.put("idaluno", this.aluno.getId());

        try {
            jp = JasperFillManager.fillReport(src, m, con);
        } catch (JRException ex) {
            LOGGER.log(Level.SEVERE, "erro ao gerar relatório de disciplinas", ex);
        }

        JasperViewer viewer = new JasperViewer(jp, false);
        viewer.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlunoDisciplinaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new AlunoDisciplinaView(null).setVisible(true));
    }

    private boolean validaCampos() {
        if (!ValidaCampos.validaAno(Txtano.getText())) {
            JOptionPane.showMessageDialog(this, "ano inválido", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!ValidaCampos.validaNota(TXnota1.getText())) {
            JOptionPane.showMessageDialog(this, "nota inválida", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!ValidaCampos.validaNota(txtnota2.getText())) {
            JOptionPane.showMessageDialog(this, "nota inválida", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!ValidaCampos.validaFaltas(estatisticas.getText())) {
            JOptionPane.showMessageDialog(this, "faltas inválidas", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnexcluir;
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton btinserir;
    private javax.swing.JButton btnsair;
    private javax.swing.JButton btnsalvar;
    private javax.swing.JComboBox<Object> comboDisciplinas;
    private javax.swing.JRadioButton jRadioButtonPrimeiro;
    private javax.swing.JRadioButton jRadioButtonSegundo;
    private javax.swing.JTable tabelAlunoDisciplinas;
    private javax.swing.JTextField Txtano;
    private javax.swing.JTextField estatisticas;
    private javax.swing.JTextField midia;
    public javax.swing.JTextField Txtnome;
    private javax.swing.JTextField TXnota1;
    private javax.swing.JTextField txtnota2;
}