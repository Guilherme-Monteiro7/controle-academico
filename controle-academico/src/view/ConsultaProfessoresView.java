package view;

import conexao.ConnectionFactory;
import controller.ProfessorController;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Professor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import tablemodel.ProfessorTableModel;

public class ConsultaProfessoresView extends javax.swing.JFrame {

    private ProfessorTableModel tableModel;
    private transient ProfessorController pc;
    
    public ConsultaProfessoresView() {
        initComponents();
        
        pc = new ProfessorController();
        tableModel = new ProfessorTableModel(pc.read());
        tabelaProfessores.setModel(tableModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JButton btnadd = new javax.swing.JButton();
        javax.swing.JButton jButton2 = new javax.swing.JButton();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProfessores = new javax.swing.JTable();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        txtbusca = new javax.swing.JTextField();
        javax.swing.JButton btnsair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed();
            }
        });

        btnadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/insert.png"))); // NOI18N
        btnadd.setText("Adicionar");
        btnadd.addActionListener(e -> btnaddActionPerformed());

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/print.png"))); // NOI18N
        jButton2.setText("Imprimir listagem");
        jButton2.addActionListener(e -> jButton2ActionPerformed());

        tabelaProfessores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {}
        ));
        tabelaProfessores.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProfessoresMouseClicked();
            }
        });
        jScrollPane1.setViewportView(tabelaProfessores);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jLabel1.setText("Selecione o campo para busca:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum", "Nome", "Formação", "Titulação" }));
        jComboBox1.addActionListener(e -> jComboBox1ActionPerformed());

        txtbusca.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbuscaKeyTyped(evt);
            }
        });

        btnsair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/exit.png"))); // NOI18N
        btnsair.setText("Voltar");
        btnsair.addActionListener(e -> btnsairActionPerformed());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnsair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbusca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnadd)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsair))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnaddActionPerformed() {
        CadastroProfessoresView cp = new CadastroProfessoresView(null);
        cp.setVisible(true);
        this.dispose();
    }

    private void tabelaProfessoresMouseClicked() {
        tableModel = (ProfessorTableModel) tabelaProfessores.getModel();
        Professor p = tableModel.getAluno(tabelaProfessores.getSelectedRow());
        CadastroProfessoresView ca = new CadastroProfessoresView(p);
        ca.setVisible(true);
        this.dispose();
    }

    private void jComboBox1ActionPerformed() {
        txtbusca.setText("");
        if(jComboBox1.getSelectedIndex() == 0){
            tableModel = new ProfessorTableModel(pc.read());
            tabelaProfessores.setModel(tableModel);
        }
        txtbusca.requestFocus();
    }

    private void txtbuscaKeyTyped(java.awt.event.KeyEvent evt) {
        String chave = txtbusca.getText();
        if(evt.getKeyChar() != '\b'){
            chave = chave + evt.getKeyChar();
        }
        switch(jComboBox1.getSelectedIndex()){
            case 1:
                tableModel = new ProfessorTableModel(pc.getProfessoresNome(chave));
                break;
            case 2:
                tableModel = new ProfessorTableModel(pc.getProfessoresFormacao(chave));
                break;
            case 3:
                tableModel = new ProfessorTableModel(pc.getProfessoresTitulacao(chave));
                break;
            default:
                break;
        }
        tabelaProfessores.setModel(tableModel);
    }

    private void jButton2ActionPerformed() {
        Connection con = ConnectionFactory.getConnection();
        String src = "src/reports/listagemProfessores.jasper";
        
        JasperPrint jp = null;
        
        try {
            jp = JasperFillManager.fillReport(src, null, con);
        } catch (JRException ex) {
            Logger.getLogger(ConsultaProfessoresView.class.getName())
                  .log(Level.SEVERE, "Erro ao gerar relatório de professores", ex);
        }
        
        if (jp != null) {
            JasperViewer view = new JasperViewer(jp, false);
            view.setVisible(true);
        }
    }

    private void formWindowClosed() {
        // Dead commented-out code removed
    }

    private void btnsairActionPerformed() {
        ViewPrincipal v = new ViewPrincipal();
        v.setVisible(true);
        this.dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaProfessoresView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new ConsultaProfessoresView().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JTable tabelaProfessores;
    private javax.swing.JTextField txtbusca;
    // End of variables declaration//GEN-END:variables
}