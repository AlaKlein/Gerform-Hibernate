/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tela;

import Dao.AuditDAO;
import Util.CSV;
import Util.Formatacao;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Klein
 */
public class IfrAudit extends javax.swing.JInternalFrame {

    AuditDAO auditDAO = new AuditDAO();
    int codigo = 0;
    String dataIni = "01/01/0001";
    String dataFim = "01/01/5000";
    private static IfrAudit instance;

    /**
     * Creates new form IfrMaterial
     */
    public IfrAudit() {
        this.setTitle("Auditoria");
        initComponents();

        auditDAO.popularTabela(tblAuditoria, "", "", "", dataIni, dataFim);
        auditDAO.popEmail(tblEmail);
        auditDAO.popTabela(tblTabela);
        auditDAO.popAcao(tblAcao);
        Formatacao.limparjtable(tblAuditoria);
        desabilitarEdicaoJDC(jDateChooserIni);
        desabilitarEdicaoJDC(jDateChooserFim);

    }

    public static IfrAudit getInstance() {
        if (instance == null) {
            instance = new IfrAudit();
        }
        return instance;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblAuditoria = new javax.swing.JTable();
        btnPesquisar = new javax.swing.JButton();
        btnfechar1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEmail = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTabela = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblAcao = new javax.swing.JTable();
        btnLimparSelecoes = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAuditoria2 = new javax.swing.JButton();
        btnAuditoria3 = new javax.swing.JButton();
        btnAuditoria4 = new javax.swing.JButton();
        jDateChooserIni = new com.toedter.calendar.JDateChooser();
        jDateChooserFim = new com.toedter.calendar.JDateChooser();

        setTitle("Auditoria");

        tblAuditoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblAuditoria);

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnfechar1.setText("Fechar");
        btnfechar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfechar1ActionPerformed(evt);
            }
        });

        tblEmail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Título 2"
            }
        ));
        jScrollPane2.setViewportView(tblEmail);
        if (tblEmail.getColumnModel().getColumnCount() > 0) {
            tblEmail.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        tblTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Título 2"
            }
        ));
        jScrollPane3.setViewportView(tblTabela);

        tblAcao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Título 2"
            }
        ));
        jScrollPane4.setViewportView(tblAcao);

        btnLimparSelecoes.setText("Limpar Seleções");
        btnLimparSelecoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparSelecoesActionPerformed(evt);
            }
        });

        jLabel3.setText("Data Inicial Período:");

        jLabel4.setText("Data Final Período:");

        btnAuditoria2.setText("Logs");
        btnAuditoria2.setMaximumSize(new java.awt.Dimension(79, 23));
        btnAuditoria2.setMinimumSize(new java.awt.Dimension(79, 23));
        btnAuditoria2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAuditoria2ActionPerformed(evt);
            }
        });

        btnAuditoria3.setText("Logs2");
        btnAuditoria3.setMaximumSize(new java.awt.Dimension(79, 23));
        btnAuditoria3.setMinimumSize(new java.awt.Dimension(79, 23));
        btnAuditoria3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAuditoria3ActionPerformed(evt);
            }
        });

        btnAuditoria4.setText("CSV");
        btnAuditoria4.setMaximumSize(new java.awt.Dimension(79, 23));
        btnAuditoria4.setMinimumSize(new java.awt.Dimension(79, 23));
        btnAuditoria4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAuditoria4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAuditoria4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAuditoria3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAuditoria2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnfechar1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLimparSelecoes)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jDateChooserIni, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(34, 34, 34)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(53, 53, 53)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jDateChooserFim, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4))
                    .addComponent(jDateChooserIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooserFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLimparSelecoes)
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnPesquisar)
                        .addComponent(btnAuditoria2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAuditoria3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAuditoria4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnfechar1))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void desabilitarEdicaoJDC(JDateChooser j) {
        JTextFieldDateEditor editor = (JTextFieldDateEditor) j.getDateEditor();
        editor.setEditable(false);
    }

    public static void jdcAmarelo(JDateChooser j) {
        for (Component c : j.getComponents()) {
            ((JComponent) c).setBackground(Color.YELLOW);
        }
    }

    public static void jdcBranco(JDateChooser j) {
        for (Component c : j.getComponents()) {
            ((JComponent) c).setBackground(Color.WHITE);
        }
    }


    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        DefaultTableModel modelEmail = (DefaultTableModel) tblEmail.getModel();
        DefaultTableModel modelAcao = (DefaultTableModel) tblAcao.getModel();
        DefaultTableModel modelTabela = (DefaultTableModel) tblTabela.getModel();
        String selectedEmail = null;
        String selectedAcao = null;
        String selectedTabela = null;

        if (Formatacao.JcalendarNull(jDateChooserIni) && !Formatacao.JcalendarNull(jDateChooserFim)) {
            JOptionPane.showMessageDialog(null, "A data inicial deve ser informada!");
            jdcAmarelo(jDateChooserIni);
            jdcBranco(jDateChooserFim);
            jDateChooserIni.requestFocusInWindow();
        } else if ((!Formatacao.JcalendarNull(jDateChooserIni) && Formatacao.JcalendarNull(jDateChooserFim))) {
            JOptionPane.showMessageDialog(null, "A data final deve ser informada!");
            jdcAmarelo(jDateChooserFim);
            jdcBranco(jDateChooserIni);
            jDateChooserFim.requestFocusInWindow();
        } else {
            if (tblEmail.getSelectedRow() == -1) {
                selectedEmail = "";
            } else {
                selectedEmail = String.valueOf(modelEmail.getValueAt(tblEmail.getSelectedRow(), 1));
            }
            if (tblTabela.getSelectedRow() == -1) {
                selectedTabela = "";
            } else {
                selectedTabela = String.valueOf(modelTabela.getValueAt(tblTabela.getSelectedRow(), 2));
            }
            if (tblAcao.getSelectedRow() == -1) {
                selectedAcao = "";
            } else {
                selectedAcao = String.valueOf(modelAcao.getValueAt(tblAcao.getSelectedRow(), 4));
            }
            if (Formatacao.JcalendarNull(jDateChooserIni) && Formatacao.JcalendarNull(jDateChooserFim)) {
                auditDAO.popularTabela(tblAuditoria, selectedEmail, selectedTabela, selectedAcao, dataIni, dataFim);
            } else {
                jdcBranco(jDateChooserIni);
                jdcBranco(jDateChooserFim);
                dataIni = Formatacao.formatarJcaledar(jDateChooserIni);
                dataFim = Formatacao.formatarJcaledar(jDateChooserFim);
                auditDAO.popularTabela(tblAuditoria, selectedEmail, selectedTabela, selectedAcao, dataIni, dataFim);
            }
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnfechar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfechar1ActionPerformed
        dispose();
    }//GEN-LAST:event_btnfechar1ActionPerformed

    private void btnLimparSelecoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparSelecoesActionPerformed
        tblEmail.getSelectionModel().clearSelection();
        tblTabela.getSelectionModel().clearSelection();
        tblAcao.getSelectionModel().clearSelection();
        jDateChooserIni.setCalendar(null);
        jDateChooserFim.setCalendar(null);
        dataIni = "01/01/0001";
        dataFim = "01/01/5000";
    }//GEN-LAST:event_btnLimparSelecoesActionPerformed

    private void btnAuditoria2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAuditoria2ActionPerformed
        try {
            Desktop.getDesktop().open(new java.io.File("logs.txt"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo solicitado: " + e);
        }
    }//GEN-LAST:event_btnAuditoria2ActionPerformed

    private void btnAuditoria3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAuditoria3ActionPerformed
        try {
            Desktop.getDesktop().open(new java.io.File("log.log"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo solicitado: " + e);
        }
    }//GEN-LAST:event_btnAuditoria3ActionPerformed

    private void btnAuditoria4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAuditoria4ActionPerformed
        try {
            CSV csv = new CSV();
            csv.geraCSV(tblAuditoria);
            Desktop.getDesktop().open(new java.io.File("teste.csv"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo solicitado: " + e);
        }
    }//GEN-LAST:event_btnAuditoria4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAuditoria2;
    private javax.swing.JButton btnAuditoria3;
    private javax.swing.JButton btnAuditoria4;
    private javax.swing.JButton btnLimparSelecoes;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnfechar1;
    private com.toedter.calendar.JDateChooser jDateChooserFim;
    private com.toedter.calendar.JDateChooser jDateChooserIni;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblAcao;
    private javax.swing.JTable tblAuditoria;
    private javax.swing.JTable tblEmail;
    private javax.swing.JTable tblTabela;
    // End of variables declaration//GEN-END:variables
}
