package view;

import conexao.ConnectionFactory;
import controller.DisciplinasController;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Disciplinas;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import regex.ValidaCampos;

public class CadastroDisciplinasView extends javax.swing.JFrame {

    private final DisciplinasController dc = new DisciplinasController();
    private Disciplinas disco;
    private int idDisc = 0;
    private boolean alterar = false;

    public CadastroDisciplinasView(Disciplinas disco) {
        initComponents();

        if (disco != null) {
            preencheCampos(disco);
            this.disco = disco;
            btnimprimir.setEnabled(true);
        } else {
            txtnomedisc.requestFocus();
        }
    }

    public void limparCampos() {
        txtnomedisc.setText("");
        txtcargahoraria.setText("");
        txtcode.setText("");
    }

    public void preencheCampos(Disciplinas d) {
        this.idDisc = d.getId();
        txtnomedisc.setText(d.getNome());
        txtcode.setText(d.getCodigo());
        txtcargahoraria.setText(String.valueOf(d.getCargaHoraria()));

        btnexcluir.setEnabled(true);
        btnincluir.setEnabled(false);
        btnsalvar.setEnabled(false);
        btncancelar.setEnabled(true);
        btndisciplinas.setEnabled(true);

        this.alterar = true;
    }

    public void obterListaDisc() {
        ConsultaDisciplinasView cv = new ConsultaDisciplinasView();
        cv.setVisible(true);
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnincluir = new javax.swing.JButton();
        btnsalvar = new javax.swing.JButton();
        btnexcluir = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnsair = new javax.swing.JButton();
        btndisciplinas = new javax.swing.JButton();
        btnimprimir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtnomedisc = new javax.swing.JTextField();
        txtcode = new javax.swing.JTextField();
        txtcargahoraria = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed();
            }
        });

        btnincluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/adicionar.png"))); // NOI18N
        btnincluir.setText("Incluir");
        btnincluir.addActionListener(e -> btnincluirActionPerformed());

        btnsalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        btnsalvar.setText("Salvar");
        btnsalvar.setEnabled(false);
        btnsalvar.addActionListener(e -> btnsalvarActionPerformed());

        btnexcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        btnexcluir.setText("Excluir");
        btnexcluir.setEnabled(false);
        btnexcluir.addActionListener(e -> btnexcluirActionPerformed());

        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.setEnabled(false);
        btncancelar.addActionListener(e -> btncancelarActionPerformed());

        btnsair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/sair.png"))); // NOI18N
        btnsair.setText("Sair");
        btnsair.addActionListener(e -> btnsairActionPerformed());

        btndisciplinas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/order.png"))); // NOI18N
        btndisciplinas.setText("Disciplina");
        btndisciplinas.addActionListener(e -> btndisciplinasActionPerformed());

        btnimprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/print.png"))); // NOI18N
        btnimprimir.setText("Imprimir");
        btnimprimir.setEnabled(false);
        btnimprimir.addActionListener(e -> btnimprimirActionPerformed());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnincluir)
                .addGap(39, 39, 39)
                .addComponent(btnsalvar)
                .addGap(43, 43, 43)
                .addComponent(btnexcluir)
                .addGap(47, 47, 47)
                .addComponent(btncancelar)
                .addGap(37, 37, 37)
                .addComponent(btnsair, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btndisciplinas)
                .addGap(18, 18, 18)
                .addComponent(btnimprimir)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnincluir, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsalvar)
                    .addComponent(btnexcluir)
                    .addComponent(btncancelar)
                    .addComponent(btnsair)
                    .addComponent(btndisciplinas)
                    .addComponent(btnimprimir))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jLabel1.setText("NOME:");
        jLabel2.setText("CÓDIGO:");
        jLabel3.setText("CARGA HORÁRIA:");

        txtnomedisc.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnomediscKeyTyped();
            }
        });

        txtcode.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodeKeyTyped();
            }
        });

        txtcargahoraria.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcargahorariaKeyTyped();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtcode, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtcargahoraria))
                            .addComponent(txtnomedisc, javax.swing.GroupLayout.PREFERRED_SIZE, 803, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(72, 72, 72)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnomedisc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcargahoraria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnincluirActionPerformed() {
        if (validaCamposDisciplina()) {
            if (!txtnomedisc.getText().isEmpty() && !txtcargahoraria.getText().isEmpty()) {
                if (dc.inserir(txtnomedisc.getText(), txtcode.getText(), Integer.parseInt(txtcargahoraria.getText()))) {
                    limparCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível salvar a disciplina", "", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nome e carga horária são obrigatórios", "", JOptionPane.WARNING_MESSAGE);
            }
            obterListaDisc();
        }
    }

    private void btnsalvarActionPerformed() {
        if (validaCamposDisciplina()) {
            if (!txtnomedisc.getText().isEmpty() && !txtcargahoraria.getText().isEmpty()) {
                if (dc.atualizar(idDisc, txtnomedisc.getText(), txtcode.getText(), Integer.parseInt(txtcargahoraria.getText()))) {
                    limparCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível salvar a disciplina", "", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nome e carga horária são obrigatórios", "", JOptionPane.WARNING_MESSAGE);
            }
            obterListaDisc();
        }
    }

    private void btnexcluirActionPerformed() {
        if (dc.excluir(idDisc)) {
            JOptionPane.showMessageDialog(this, "Disciplina excluída com sucesso", "", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir", "", JOptionPane.INFORMATION_MESSAGE);
        }
        obterListaDisc();
    }

    private void btncancelarActionPerformed() {
        btnincluir.setEnabled(false);
        btnexcluir.setEnabled(false);
        btncancelar.setEnabled(false);
        btnsalvar.setEnabled(false);
        alterar = false;
        limparCampos();
    }

    private void btnsairActionPerformed() {
        obterListaDisc();
    }

    private void txtnomediscKeyTyped() {
        if (alterar) {
            btnsalvar.setEnabled(true);
            btnexcluir.setEnabled(false);
        }
        btncancelar.setEnabled(true);
    }

    private void formWindowClosed() {
        // Intencionalmente vazio conforme original
    }

    private void btndisciplinasActionPerformed() {
        AlunoDisciplinaView adv = new AlunoDisciplinaView(null);
        adv.setVisible(true);
        this.dispose();
    }

    private void txtcodeKeyTyped() {
        if (alterar) {
            btnsalvar.setEnabled(true);
            btnexcluir.setEnabled(false);
        }
        btncancelar.setEnabled(true);
    }

    private void txtcargahorariaKeyTyped() {
        if (alterar) {
            btnsalvar.setEnabled(true);
            btnexcluir.setEnabled(false);
        }
        btncancelar.setEnabled(true);
    }

    private void btnimprimirActionPerformed() {
        Connection com = ConnectionFactory.getConnection();
        String src = "src/reports/relatorioDisciplinas.jasper";

        JasperPrint jp = null;
        Map<String, Object> m = new HashMap<>();
        m.put("iddisciplinar", this.disco.getId());

        try {
            jp = JasperFillManager.fillReport(src, m, com);
        } catch (JRException ex) {
            Logger.getLogger(CadastroDisciplinasView.class.getName()).log(Level.SEVERE, "Erro ao gerar relatório de disciplinas", ex);
        }

        if (jp != null) {
            JasperViewer visualizar = new JasperViewer(jp, false);
            visualizar.setVisible(true);
        }
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
            Logger.getLogger(CadastroDisciplinasView.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new CadastroDisciplinasView(null).setVisible(true));
    }

    private boolean validaCamposDisciplina() {
        if (!ValidaCampos.validaNomeDisciplina(txtnomedisc.getText())) {
            JOptionPane.showMessageDialog(this, "Nome de disciplina inválido", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!ValidaCampos.validaCodigoDisciplina(txtcode.getText())) {
            JOptionPane.showMessageDialog(this, "Código inválido", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!ValidaCampos.validaCargaHoraria(txtcargahoraria.getText())) {
            JOptionPane.showMessageDialog(this, "Carga inválida", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btndisciplinas;
    private javax.swing.JButton btnexcluir;
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton btnincluir;
    private javax.swing.JButton btnsair;
    private javax.swing.JButton btnsalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtcargahoraria;
    private javax.swing.JTextField txtcode;
    private javax.swing.JTextField txtnomedisc;
    // End of variables declaration//GEN-END:variables
}