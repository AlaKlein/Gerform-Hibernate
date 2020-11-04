/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tela;

import Entidade.UsuarioLogado;
import Util.Log;
import Util.Validacao;
import java.awt.Color;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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

    ArrayList<String> anexo = new ArrayList();

    public IfrEmail() {
        this.setTitle("E-mail");
        initComponents();
        tfdAnexo.setEditable(false);
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
        jLabel3 = new javax.swing.JLabel();
        tfdDestinatario = new javax.swing.JTextField();
        tfdAssunto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaMensagem = new javax.swing.JTextArea();
        btnAnexo = new javax.swing.JButton();
        tfdAnexo = new javax.swing.JTextField();

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

        jLabel3.setText("Destinatário:");

        jLabel4.setText("Assunto:");

        jLabel5.setText("Mensagem:");

        jtaMensagem.setColumns(20);
        jtaMensagem.setRows(5);
        jScrollPane1.setViewportView(jtaMensagem);

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnfechar1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfdAssunto, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
                            .addComponent(tfdDestinatario))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAnexo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfdAnexo, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdAssunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdAnexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnexo))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnfechar1)
                    .addComponent(btnEnviar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void limparCampos() {
        tfdAssunto.setText(null);
        tfdDestinatario.setText(null);
        jtaMensagem.setText(null);
        tfdAnexo.setText(null);
    }

    public void Branco() {
        tfdBranco(tfdDestinatario);
        tfdBranco(tfdAssunto);
        tfdBranco(jtaMensagem);
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

    public static void tfdAmarelo(JTextArea c) {
        c.setBackground(Color.yellow);
    }

    public static void tfdBranco(JTextArea c) {
        c.setBackground(Color.white);
    }


    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        if (!Validacao.validarVariosEmails(tfdDestinatario.getText())) {
            revisar();
            tfdAmarelo(tfdDestinatario);
            tfdBranco(tfdAssunto);
            tfdBranco(jtaMensagem);
            tfdDestinatario.requestFocus();
        } else if (!Validacao.validarDescricao(tfdAssunto.getText())) {
            revisar();
            tfdAmarelo(tfdAssunto);
            tfdBranco(tfdDestinatario);
            tfdBranco(jtaMensagem);
            tfdAssunto.requestFocus();
        } else if (!Validacao.validarDescricao(jtaMensagem.getText())) {
            revisar();
            tfdAmarelo(jtaMensagem);
            tfdBranco(tfdDestinatario);
            tfdBranco(tfdAssunto);
            jtaMensagem.requestFocus();
        } else {
            new Thread() {
                @Override
                public void run() {
                    try {
                        String retorno = Util.email.enviar(tfdAssunto.getText(), tfdDestinatario.getText(), jtaMensagem.getText(), anexo, UsuarioLogado.getUsuarioLogadoEmail());
                        JOptionPane.showMessageDialog(null, retorno);
                        limparCampos();
                        Branco();
                    } catch (UnsupportedEncodingException ex) {
                        String retorno = ex.toString();
                        JOptionPane.showMessageDialog(null, "Não foi possível enviar o e-mail " + retorno);
                        Log.geraLogIfr(UsuarioLogado.getUsuarioLogadoEmail(), "IfrEmail", btnEnviar, retorno);
                    }
                }
            }.start();
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnfechar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfechar1ActionPerformed
        dispose();
    }//GEN-LAST:event_btnfechar1ActionPerformed

    private void btnAnexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnexoActionPerformed
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        jfc.setMultiSelectionEnabled(true);
        jfc.setDialogTitle("Selecione o arquivo que deseja anexar: ");
        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            File file = jfc.getSelectedFile();
            anexo.add(selectedFile.getAbsolutePath());
            if (tfdAnexo.getText().isEmpty()) {
                tfdAnexo.setText(selectedFile.getName());
            } else {
                tfdAnexo.setText(tfdAnexo.getText() + ", " + selectedFile.getName());
            }
        }
    }//GEN-LAST:event_btnAnexoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnexo;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnfechar1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jtaMensagem;
    private javax.swing.JTextField tfdAnexo;
    private javax.swing.JTextField tfdAssunto;
    private javax.swing.JTextField tfdDestinatario;
    // End of variables declaration//GEN-END:variables
}
