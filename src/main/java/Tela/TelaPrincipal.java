/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import Dao.FornecedorDAO;
import Dao.ReportDAO;
import Entidade.UsuarioLogado;
import Tela.IfrUsuario;
import Tela.IfrFornecedor;
import Tela.IfrMaterial;
import Tela.IfrAuditoria;
import Tela.IfrAudit;
import Tela.IfrPropriedadesMaterial;
import Tela.IfrProduto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author klein
 */
public class TelaPrincipal extends javax.swing.JFrame {

    public static boolean ligaAuditoria = true;

    /**
     * Creates new form FrmPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        operador(UsuarioLogado.getUsuarioLogadoPermissao());
        analista(UsuarioLogado.getUsuarioLogadoPermissao());
        this.setExtendedState(MAXIMIZED_BOTH);
        checkBoxAuditoria.setSelected(true);
    }

    private void centralizarJInternalFrame(JInternalFrame frame) {
        int lDesk = jDesktopPane1.getWidth();
        int aDesk = jDesktopPane1.getHeight();
        int lIFrame = frame.getWidth();
        int aIFrame = frame.getHeight();

        frame.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);
    }

    public void operador(String permissao) {
        if (permissao.equals("Operador")) {
            jMenu2.setEnabled(false);
            checkBoxAuditoria.setEnabled(false);
        }
    }

    public void analista(String permissao) {
        if (permissao.equals("Analista")) {
            jMenu2.setEnabled(false);
            checkBoxAuditoria.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        checkBoxAuditoria = new javax.swing.JCheckBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GerForm");

        checkBoxAuditoria.setText("Auditoria");
        checkBoxAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxAuditoriaActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(checkBoxAuditoria, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(617, Short.MAX_VALUE)
                .addComponent(checkBoxAuditoria)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(452, Short.MAX_VALUE)
                .addComponent(checkBoxAuditoria)
                .addContainerGap())
        );

        jMenu1.setText("Cadastros");

        jMenuItem4.setText("Usuário");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem1.setText("Fornecedor");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Material");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Propriedades");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem5.setText("Produto");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Auditoria");

        jMenuItem8.setText("Auditar");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Relatórios");

        jMenuItem9.setText("Fornecedores");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuItem10.setText("Material");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem10);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        IfrUsuario ifrUsuario = new IfrUsuario();
        jDesktopPane1.add(ifrUsuario);
        centralizarJInternalFrame(ifrUsuario);
        ifrUsuario.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        IfrFornecedor ifrFornecedor = new IfrFornecedor();
        jDesktopPane1.add(ifrFornecedor);
        centralizarJInternalFrame(ifrFornecedor);
        ifrFornecedor.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        IfrMaterial ifrMaterial = new IfrMaterial();
        jDesktopPane1.add(ifrMaterial);
        centralizarJInternalFrame(ifrMaterial);
        ifrMaterial.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        IfrPropriedadesMaterial ifrPropriedadesMaterial = new IfrPropriedadesMaterial();
        jDesktopPane1.add(ifrPropriedadesMaterial);
        centralizarJInternalFrame(ifrPropriedadesMaterial);
        ifrPropriedadesMaterial.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        IfrAudit ifrAudit = new IfrAudit();
        jDesktopPane1.add(ifrAudit);
        centralizarJInternalFrame(ifrAudit);
        ifrAudit.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void checkBoxAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxAuditoriaActionPerformed
        ligaAuditoria = !ligaAuditoria;
    }//GEN-LAST:event_checkBoxAuditoriaActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        IfrProduto ifrProduto = new IfrProduto();
        jDesktopPane1.add(ifrProduto);
        centralizarJInternalFrame(ifrProduto);
        ifrProduto.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        new Thread() {
            @Override
            public void run() {
                try {
                    // Compila o relatorio
                    JasperReport relatorio = JasperCompileManager.compileReport("src/main/java/Relatorio/RelatorioFornecedor.jrxml");
                    // Executa relatoio
                    JasperPrint impressao = JasperFillManager.fillReport(relatorio, null, ReportDAO.getInstance().getConnection());

                    // Exibe resultado em video
                    JasperViewer.viewReport(impressao, false);

                } catch (Exception e) {
                    System.out.println("Erro ao gerar relatório: " + e);
                }
            }
        }.start();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        new Thread() {
            @Override
            public void run() {
                try {
                    // Compila o relatorio
                    JasperReport relatorio = JasperCompileManager.compileReport("src/main/java/Relatorio/RelatorioMaterial.jrxml");
                    // Executa relatoio
                    JasperPrint impressao = JasperFillManager.fillReport(relatorio, null, ReportDAO.getInstance().getConnection());

                    // Exibe resultado em video
                    JasperViewer.viewReport(impressao, false);

                } catch (Exception e) {
                    System.out.println("Erro ao gerar relatório: " + e);
                }
            }
        }.start();
    }//GEN-LAST:event_jMenuItem10ActionPerformed
    /**
     * *
     * /
     *
     **
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TelaPrincipal().setVisible(true);
//            }
//        });
//
//    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkBoxAuditoria;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration//GEN-END:variables
}
