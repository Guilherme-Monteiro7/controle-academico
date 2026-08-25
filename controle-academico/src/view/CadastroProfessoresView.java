package view;

import conexao.ConnectionFactory;
import controller.ProfessorController;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Professor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import regex.ValidaCampos;

public class CadastroProfessoresView extends javax.swing.JFrame {

    private final ProfessorController pc;
    private Professor professor = new Professor();
    private int idprofessor = 0;
    private boolean alterar = false;

    public CadastroProfessoresView(Professor prof) {
        initComponents();
        pc = new ProfessorController();

        if (prof != null) {
            this.professor = prof;
            preencheCampos(prof);
        } else {
            txtnome.requestFocus();
        }
    }

    public void preencheCampos(Professor p) {
        this.idprofessor = p.getIdprofessor();
        txtnome.setText(p.getNome());
        txtendereco.setText(p.getEndereco());
        txtfone.setText(p.getFone());
        txtemail.setText(p.getEmail());
        txtformacao.setText(p.getFormacao());
        txtsalario.setText(String.valueOf(p.getSalario()));
        comboboxGraduacao.setSelectedItem(p.getTitulacao());

        btnexcluir.setEnabled(true);
        btnsalvar.setEnabled(false);
        btnincluir.setEnabled(false);
        btncancelar.setEnabled(true);
        btndisciplinas.setEnabled(true);

        this.alterar = true;
    }

    public void limpar() {
        txtnome.setText("");
        txtendereco.setText("");
        txtfone.setText("");
        txtemail.setText("");
        txtformacao.setText("");
        txtsalario.setText("");
    }

    public void getListaProfessores() {
        ConsultaProfessoresView cv = new ConsultaProfessoresView();
        cv.setVisible(true);
        this.dispose();
    }

    private void registrarAlteracao() {
        if (alterar) {
            btnexcluir.setEnabled(false);
            btnsalvar.setEnabled(true);
            btnincluir.setEnabled(true);
        }
        btncancelar.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        // Declaração de variáveis locais (S1450)
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JButton btnsair = new javax.swing.JButton();
        javax.swing.JButton btnimprimir = new javax.swing.JButton();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();

        btnincluir = new javax.swing.JButton();
        btnsalvar = new javax.swing.JButton();
        btnexcluir = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btndisciplinas = new javax.swing.JButton();
        txtnome = new javax.swing.JTextField();
        txtendereco = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtsalario = new javax.swing.JTextField();
        txtfone = new javax.swing.JFormattedTextField();
        txtformacao = new javax.swing.JTextField();
        comboboxGraduacao = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Professores");

        // Uso de Lambdas (S1604)
        btnincluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png")));
        btnincluir.setText("Incluir");
        btnincluir.addActionListener(e -> btnincluirActionPerformed());

        btnsalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/save.png")));
        btnsalvar.setText("Salvar");
        btnsalvar.addActionListener(e -> btnsalvarActionPerformed());

        btnexcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete.png")));
        btnexcluir.setText("Excluir");
        btnexcluir.addActionListener(e -> btnexcluirActionPerformed());

        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png")));
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(e -> btncancelarActionPerformed());

        btnsair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/exit.png")));
        btnsair.setText("Sair");
        btnsair.addActionListener(e -> btnsairActionPerformed());

        btndisciplinas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/order.png")));
        btndisciplinas.setText("Disciplinas");
        btndisciplinas.addActionListener(e -> btndisciplinasActionPerformed());

        btnimprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/print.png")));
        btnimprimir.setText("Imprimir");
        btnimprimir.addActionListener(e -> btnimprimirActionPerformed());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnincluir, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnsalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnexcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btncancelar)
                .addGap(30, 30, 30)
                .addComponent(btnsair, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btndisciplinas)
                .addGap(27, 27, 27)
                .addComponent(btnimprimir)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnincluir)
                    .addComponent(btnsalvar)
                    .addComponent(btnexcluir)
                    .addComponent(btncancelar)
                    .addComponent(btnsair)
                    .addComponent(btndisciplinas)
                    .addComponent(btnimprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jLabel1.setText("NOME:");
        jLabel2.setText("ENDEREÇO:");
        jLabel3.setText("E-MAIL:");
        jLabel4.setText("FONE:");
        jLabel5.setText("SALÁRIO:");
        jLabel6.setText("FORMAÇÃO:");
        jLabel7.setText("TITULAÇÃO:");

        // Centralizando a lógica repetitiva (S4144) e adicionando @Override (S1161)
        java.awt.event.KeyAdapter alteracaoListener = new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                registrarAlteracao();
            }
        };

        txtnome.addKeyListener(alteracaoListener);
        txtendereco.addKeyListener(alteracaoListener);
        txtemail.addKeyListener(alteracaoListener);
        txtsalario.addKeyListener(alteracaoListener);
        txtformacao.addKeyListener(alteracaoListener);

        try {
            txtfone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            Logger.getLogger(CadastroProfessoresView.class.getName()).log(Level.SEVERE, "Erro ao formatar campo fone", ex);
        }
        txtfone.addKeyListener(alteracaoListener);

        comboboxGraduacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Graduação", "Especialização", "Mestrado", "Doutorado", "Pós Doutorado" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtnome)
                        .addComponent(txtendereco)
                        .addComponent(txtemail, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtsalario)
                            .addComponent(txtfone, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtformacao)
                            .addComponent(comboboxGraduacao, 0, 361, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtendereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtfone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(txtformacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtsalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(comboboxGraduacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    // Removido parâmetro inutilizado evt (S1172)
    private void btnsairActionPerformed() {
        getListaProfessores();
    }

    private void btnincluirActionPerformed() {
        if (validaCampos()) { // S100: Ajuste de capitalização do método
            if (!txtnome.getText().isEmpty() && !txtformacao.getText().isEmpty()) {
                if (pc.insert(txtnome.getText(), txtendereco.getText(), txtfone.getText(), txtemail.getText(),
                        txtformacao.getText(), comboboxGraduacao.getSelectedItem().toString(), Double.parseDouble(txtsalario.getText()))) {
                    limpar();
                } else {
                    JOptionPane.showMessageDialog(null, "não foi possível salvar o professor", "", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "nome e formação são obrigatórios", "", JOptionPane.WARNING_MESSAGE);
            }
            getListaProfessores();
        }
    }

    private void btnsalvarActionPerformed() {
        if (validaCampos()) {
            if (!txtnome.getText().isEmpty() && !txtformacao.getText().isEmpty()) {
                if (pc.update(idprofessor, txtnome.getText(), txtendereco.getText(), txtfone.getText(), txtemail.getText(),
                        txtformacao.getText(), comboboxGraduacao.getSelectedItem().toString(), Double.parseDouble(txtsalario.getText()))) {
                    limpar();
                } else {
                    JOptionPane.showMessageDialog(null, "não foi possível salvar o professor", "", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "nome e formação são obrigatórios", "", JOptionPane.WARNING_MESSAGE);
            }
            getListaProfessores();
        }
    }

    private void btnexcluirActionPerformed() {
        if (pc.delete(idprofessor)) {
            JOptionPane.showMessageDialog(this, "professor excluido com sucesso", "", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "não foi possível excluir", "", JOptionPane.INFORMATION_MESSAGE);
        }
        getListaProfessores();
    }

    private void btndisciplinasActionPerformed() {
        ProfessorDisciplinaView adv = new ProfessorDisciplinaView();
        adv.professor = this.professor;
        adv.setVisible(true);
        adv.txtnome.setText(txtnome.getText());
        this.dispose();
    }

    private void btnimprimirActionPerformed() {
        if (this.professor == null || this.professor.getIdprofessor() == 0) {
            JOptionPane.showMessageDialog(this, "Selecione um professor antes de imprimir.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        new Thread(() -> {
            Connection con = null;
            try {
                con = ConnectionFactory.getConnection();
                String src = "src/reports/relatorioProfessor.jasper";

                Map<String, Object> m = new HashMap<>();
                m.put("idprofessor", this.professor.getIdprofessor());

                JasperPrint jp = JasperFillManager.fillReport(src, m, con);
                JasperViewer view = new JasperViewer(jp, false);
                view.setVisible(true);

            } catch (JRException ex) {
                Logger.getLogger(CadastroProfessoresView.class.getName()).log(Level.SEVERE, "Erro ao gerar relatório de professores", ex);
                JOptionPane.showMessageDialog(null, "Erro ao gerar relatório de professores: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(CadastroProfessoresView.class.getName()).log(Level.SEVERE, "Erro ao fechar conexão", ex);
                    }
                }
            }
        }).start();
    }

    private void btncancelarActionPerformed() {
        btnincluir.setEnabled(false);
        btnexcluir.setEnabled(false);
        btncancelar.setEnabled(false);
        btnsalvar.setEnabled(false);
        alterar = false;
        limpar();
    }

    // S1197: Movendo designador de array para o tipo (String[] args)
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(CadastroProfessoresView.class.getName()).log(Level.SEVERE, null, ex);
        }

        // S1602: Remoção de chaves desnecessárias na expressão Lambda
        java.awt.EventQueue.invokeLater(() -> new CadastroProfessoresView(null).setVisible(true));
    }

    // S100: Renomeado de ValidaCampos para validaCampos
    private boolean validaCampos() {
        if (!ValidaCampos.validaNome(txtnome.getText())) {
            JOptionPane.showMessageDialog(this, "nome inválido", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!ValidaCampos.validaEndereco(txtendereco.getText())) {
            JOptionPane.showMessageDialog(this, "endereço inválido", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!ValidaCampos.validaEmail(txtemail.getText())) {
            JOptionPane.showMessageDialog(this, "e-mail inválido", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!ValidaCampos.validaFone(txtfone.getText())) {
            JOptionPane.showMessageDialog(this, "telefone inválido", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!ValidaCampos.validaFormacao(txtformacao.getText())) {
            JOptionPane.showMessageDialog(this, "formação inválido", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!ValidaCampos.validaSalario(txtsalario.getText())) {
            JOptionPane.showMessageDialog(this, "salário inválido", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // Variáveis que não sofreram alteração para manter o estado da classe
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btndisciplinas;
    private javax.swing.JButton btnexcluir;
    private javax.swing.JButton btnincluir;
    private javax.swing.JButton btnsalvar;
    private javax.swing.JComboBox<String> comboboxGraduacao;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtendereco;
    private javax.swing.JFormattedTextField txtfone;
    private javax.swing.JTextField txtformacao;
    private javax.swing.JTextField txtnome;
    private javax.swing.JTextField txtsalario;
}