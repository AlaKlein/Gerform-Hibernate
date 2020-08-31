/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tela;

import Dao.LoginDAO;
import Entidade.UsuarioLogado;
import Util.Formatacao;
import Util.Validacao;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Klein
 */
public class TelaLogin extends javax.swing.JFrame {

    public TelaLogin() {
        initComponents();
        setTitle("Login");
    }

    public void login() {
        LoginDAO loginDAO = new LoginDAO();
        String retorno = "gerform";
        UsuarioLogado u = new UsuarioLogado();

        if (!Validacao.validarEmail(tfdEmail.getText())) {
            revisar();
            EmailInvalido();
        } else if (!Validacao.validarSenha(new String(tffSenha.getPassword()))) {
            revisar();
            SenhaInvalido();
        } else {

            retorno = loginDAO.login(tfdEmail.getText(), new String(tffSenha.getPassword()));

            if (retorno == null) {
                System.out.println("Usuário Logado: ID: " + u.getUsuarioLogadoID() + ", E-mail: " + u.getUsuarioLogadoEmail());
                this.dispose();
            } else if (retorno.equals("usuarioinativo")){
                JOptionPane.showMessageDialog(null, "Usuário inativo ou excluído!");
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha incorreta!");
            }
        }
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

    public void EmailInvalido() {
        tfdAmarelo(tfdEmail);
        tfdBranco(tffSenha);
    }

    public void SenhaInvalido() {
        tfdBranco(tfdEmail);
        tfdAmarelo(tffSenha);
    }
    
    public void Branco() {
        tfdBranco(tfdEmail);
        tfdBranco(tffSenha);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelUsuario = new javax.swing.JLabel();
        jLabelSenha = new javax.swing.JLabel();
        tfdEmail = new javax.swing.JTextField();
        jButtonLogin = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        tffSenha = new javax.swing.JPasswordField();
        jLabelUsuario1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelUsuario.setText("Email:");

        jLabelSenha.setText("Senha:");

        tfdEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfdEmailKeyPressed(evt);
            }
        });

        jButtonLogin.setText("Login");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        tffSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tffSenhaKeyPressed(evt);
            }
        });

        jLabelUsuario1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabelUsuario1.setText("Bem-vindo ao GerForm!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelUsuario)
                            .addComponent(jLabelSenha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tffSenha)
                            .addComponent(tfdEmail))))
                .addGap(107, 107, 107))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelUsuario1)
                .addGap(118, 118, 118))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabelUsuario1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsuario)
                    .addComponent(tfdEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSenha)
                    .addComponent(tffSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLogin)
                    .addComponent(jButtonSair))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(416, 339));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        dispose();
        System.exit(0);
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        Branco();
        login();
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void tfdEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdEmailKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            login();
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            dispose();
            System.exit(0);
        }
    }//GEN-LAST:event_tfdEmailKeyPressed

    private void tffSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tffSenhaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            login();
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            dispose();
            System.exit(0);
        }
    }//GEN-LAST:event_tffSenhaKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JLabel jLabelUsuario1;
    private javax.swing.JTextField tfdEmail;
    private javax.swing.JPasswordField tffSenha;
    // End of variables declaration//GEN-END:variables
}
