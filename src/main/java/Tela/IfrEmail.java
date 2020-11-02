/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tela;

import Util.Validacao;
import java.awt.Color;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Klein
 */
public class IfrEmail extends javax.swing.JInternalFrame {

    String anexo;

    /**
     * Creates new form IfrMaterial
     */
    public IfrEmail() {
        this.setTitle("E-mail");
        initComponents();
        tfdanexo.setEditable(false);
    }

    public void revisar() {
        JOptionPane.showMessageDialog(null, "Revise se os campos estão preenchidos corretamente.");
    }

    public static void tfdAmarelo(JTextField c) {
        c.setBackground(Color.yellow);
    }

    public static void tfdBranco(JTextField c) {
        c.setBackground(Color.white);
    }

    public static void txtAmarelo(JTextArea c) {
        c.setBackground(Color.yellow);
    }

    public static void txtBranco(JTextArea c) {
        c.setBackground(Color.white);
    }

    public void Branco() {
        tfdBranco(tfdDestinatario);
        tfdBranco(tfdAssunto);
        txtBranco(txtaMensagem);
    }
    
    public void limparCampos() {
    tfdDestinatario.setText(null);
    tfdAssunto.setText(null);
    txtaMensagem.setText(null);
    tfdanexo.setText(null);
    anexo = null;
}
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEnviar = new javax.swing.JButton();
        btnfechar1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfdDestinatario = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaMensagem = new javax.swing.JTextArea();
        tfdAssunto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAnexo = new javax.swing.JButton();
        tfdanexo = new javax.swing.JTextField();

        setTitle("E-mail");

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        btnfechar1.setText("Fechar");
        btnfechar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfechar1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Destinatário:");

        txtaMensagem.setColumns(20);
        txtaMensagem.setRows(5);
        jScrollPane1.setViewportView(txtaMensagem);

        jLabel2.setText("Assunto:");

        jLabel3.setText("Mensagem:");

        btnAnexo.setText("Anexo");
        btnAnexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnexoActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfdAssunto, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfdDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(388, 402, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnAnexo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfdanexo, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(btnfechar1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfdDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfdAssunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnexo)
                    .addComponent(tfdanexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnfechar1)
                    .addComponent(btnEnviar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        if (!Validacao.validarEmail(tfdDestinatario.getText())) {
            revisar();
            tfdAmarelo(tfdDestinatario);
            tfdDestinatario.requestFocus();
        } else if (!Validacao.validarDescricao(tfdAssunto.getText())) {
            revisar();
            tfdAmarelo(tfdAssunto);
            tfdBranco(tfdDestinatario);
            txtBranco(txtaMensagem);
            tfdAssunto.requestFocus();
        } else if (!Validacao.validarDescricao(txtaMensagem.getText())) {
            revisar();
            tfdBranco(tfdDestinatario);
            tfdBranco(tfdAssunto);
            txtAmarelo(txtaMensagem);
            txtaMensagem.requestFocus();
        } else {
            Branco();
            new Thread() {
                @Override
                public void run() {
                    String retorno = Util.email.mail(tfdDestinatario.getText(), tfdAssunto.getText(), txtaMensagem.getText(), anexo);
                    JOptionPane.showMessageDialog(null, retorno);
                    limparCampos();
                }
            }.start();
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnfechar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfechar1ActionPerformed
        dispose();
    }//GEN-LAST:event_btnfechar1ActionPerformed

    private void btnAnexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnexoActionPerformed
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Selecione o arquivo que deseja anexar:");
        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            tfdanexo.setText(selectedFile.getName());
            anexo = (selectedFile.getAbsolutePath());
        }
    }//GEN-LAST:event_btnAnexoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnexo;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnfechar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tfdAssunto;
    private javax.swing.JTextField tfdDestinatario;
    private javax.swing.JTextField tfdanexo;
    private javax.swing.JTextArea txtaMensagem;
    // End of variables declaration//GEN-END:variables
}
