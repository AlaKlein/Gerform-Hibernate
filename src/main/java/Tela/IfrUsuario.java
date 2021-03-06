/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tela;

import Dao.UsuarioDAO;
import Util.Formatacao;
import javax.swing.JOptionPane;
import Entidade.Usuario;
import Entidade.UsuarioLogado;
import Util.Encoding;
import Util.Log;
import Util.Validacao;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author Klein
 */
public class IfrUsuario extends javax.swing.JInternalFrame {

    int codigo = 0;
    String erro = null;
    private static IfrUsuario instance;
    
    /**
     * Creates new form IfrUsuario
     */
    public IfrUsuario() {
        initComponents();
        UserOperador(UsuarioLogado.getUsuarioLogadoPermissao());
        UserAnalista(UsuarioLogado.getUsuarioLogadoPermissao());
        jComboBox1.removeAllItems();
        jComboBox1.addItem("Selecione");
        jComboBox1.addItem("Administrador");
        jComboBox1.addItem("Analista");
        jComboBox1.addItem("Operador");
        jCheckBox2.setSelected(true);
        Formatacao.limparjtable(tblUsuario);
        new UsuarioDAO().popularTabela(tblUsuario, "", jCheckBox1.isSelected());
    }
    
    public final void UserOperador(String permissao) {
        if (permissao.equals("Operador")) {
            jTabbedPane1.setEnabledAt(0, false);
            jTabbedPane1.setSelectedIndex(1);
            btnEditar.setEnabled(false);
            btnExcluir.setEnabled(false);
            btnSalvar.setEnabled(false);
        }
    }
    
    public void UserAnalista(String permissao) {
        if (permissao.equals("Analista")) {
            jTabbedPane1.setEnabledAt(0, false);
            jTabbedPane1.setSelectedIndex(1);
            btnEditar.setEnabled(false);
            btnExcluir.setEnabled(false);
            btnSalvar.setEnabled(false);
        }
    }
    
    public static IfrUsuario getInstance() {
        if (instance == null) {
            instance = new IfrUsuario();
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

        jCheckBoxInativos1 = new javax.swing.JCheckBox();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfdEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tffSenha = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jCheckBox2 = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuario = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        tfdBusca = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        btnFechar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        jCheckBoxInativos1.setText("Listar Inativos");

        setTitle("Cadastro: Usuário");

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jLabel1.setText("Email (*)");

        jLabel6.setText("Senha (*)");

        jLabel7.setText("(*) Campos Obrigatórios");

        tffSenha.setText("jPasswordField1");

        jLabel8.setText("Permissão (*)");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jCheckBox2.setText("Ativo");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox2)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfdEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tffSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfdEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tffSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Usuário", jPanel1);

        tblUsuario.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblUsuario);

        jLabel4.setText("Busca");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Listar Inativos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfdBusca)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisar))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfdBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1)
                .addGap(14, 14, 14))
        );

        jTabbedPane1.addTab("Consulta", jPanel2);

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(btnFechar))
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFechar)
                    .addComponent(btnSalvar)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Usuário");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
        instance = null;
    }//GEN-LAST:event_btnFecharActionPerformed

    public void limparCampos() {
        tfdEmail.setText("");
        tffSenha.setText("");
        jComboBox1.setSelectedIndex(0);
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

    public static void jcbAmarelo(JComboBox jcb) {
        jcb.setBackground(Color.yellow);
    }

    public static void jcbBranco(JComboBox jcb) {
        jcb.setBackground(Color.white);
    }

    public void emailInvalido() {
        tfdAmarelo(tfdEmail);
        tfdBranco(tffSenha);
        jcbBranco(jComboBox1);
        tfdEmail.requestFocus();
    }

    public void senhaInvalido() {
        tfdBranco(tfdEmail);
        tfdAmarelo(tffSenha);
        jcbBranco(jComboBox1);
        tffSenha.requestFocus();
    }

    public void PermissaoInvalido() {
        tfdBranco(tfdEmail);
        tfdBranco(tffSenha);
        jcbAmarelo(jComboBox1);
        jComboBox1.requestFocus();
    }

    public void resetCor() {
        tfdBranco(tfdEmail);
        tfdBranco(tffSenha);
        jcbBranco(jComboBox1);
    }


    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (!Validacao.validarEmail(tfdEmail.getText())) {
            revisar();
            emailInvalido();
        } else if (jComboBox1.getSelectedIndex() == 0) {
            revisar();
            PermissaoInvalido();
        } else if (!Validacao.validarSenha(new String(tffSenha.getPassword()))) {
            revisar();
            senhaInvalido();
        } else {

            Usuario u = new Usuario();
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            String retorno = null;

            //Popular Objeto
            u.setId(codigo);
            //u.setEmail(null);
            u.setEmail(tfdEmail.getText().toLowerCase());
            u.setPermissao(String.valueOf(jComboBox1.getSelectedItem()));
            u.setSenha(Encoding.encodeToMD5(new String(tffSenha.getPassword())));

            if (jCheckBox2.isSelected()) {
                u.setStatus("Ativo");
            } else {
                u.setStatus("Inativo");
            }

            if (usuarioDAO.checkExist(u)) {
                JOptionPane.showMessageDialog(null, "Este email já existe!");
            } else {

                if (codigo != 0) {
                    //atualiza
                    retorno = usuarioDAO.Atualizar(u);
                } else {
                    //insere
                    retorno = usuarioDAO.Salvar(u);
                }

                if (retorno == null) {
                    JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");

                    // limpar os campos
                    tfdEmail.setText("");
                    jComboBox1.setSelectedIndex(0);
                    tffSenha.setText("");
                    jCheckBox2.setSelected(true);

                    resetCor();

                    // posicionar cursor
                    tfdEmail.requestFocus();

                    codigo = 0;

                } else {
                    retorno = "Impossível salvar usuário: " + retorno;
                    JOptionPane.showMessageDialog(null, retorno);
                    Log.geraLogIfr(UsuarioLogado.getUsuarioLogadoEmail(), "IfrUsuario", btnSalvar, retorno);
                }
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        new UsuarioDAO().popularTabela(tblUsuario, tfdBusca.getText(), jCheckBox1.isSelected());
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tblUsuario.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um item antes de editá-lo");
        } else {

            try {
                int id = Integer.parseInt(String.valueOf(tblUsuario.getValueAt(tblUsuario.getSelectedRow(), 0)));
                Usuario usuario = new UsuarioDAO().consultarId(id);

                if (usuario != null) {
                    jTabbedPane1.setSelectedIndex(0);
                    tfdEmail.setText(usuario.getEmail());
                    jComboBox1.setSelectedItem(usuario.getPermissao());

                    if (usuario.getStatus().equals("Ativo")) {
                        jCheckBox2.setSelected(true);
                    } else {
                        jCheckBox2.setSelected(false);
                    }

                    tfdEmail.requestFocus();
                    codigo = id;
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao editar registro!");
                }
            } catch (Exception e) {
                String erro = "Erro: " + e;
                Log.geraLogIfr(UsuarioLogado.getUsuarioLogadoEmail(), "IfrUsuario", btnEditar, erro);
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        String retorno = "1";
        if (tblUsuario.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione uma linha!");
        } else {

            int id = Integer.parseInt(String.valueOf(tblUsuario.getValueAt(tblUsuario.getSelectedRow(), 0)));

            if ((id == UsuarioLogado.getUsuarioLogadoID())
                    || ((!UsuarioLogado.getUsuarioLogadoPermissao().equals("Administrador"))
                    && (tblUsuario.getValueAt(tblUsuario.getSelectedRow(), 2).equals("Administrador")))) {
                JOptionPane.showMessageDialog(null, "Esse usuário não pode ser inativado!");
            } else {
                retorno = new UsuarioDAO().Excluir(id);
            }

            if (retorno == null) {
                JOptionPane.showMessageDialog(null, "Usuário inativado com sucesso!");

                limparCampos();
                resetCor();
                // posicionar cursor
                tfdEmail.requestFocus();

                //atualiza tabela
                new UsuarioDAO().popularTabela(tblUsuario, tfdBusca.getText(), jCheckBox1.isSelected());
            } else {
                String erro = "Impossível Inativar Usuário: " + retorno;
                JOptionPane.showMessageDialog(null, erro);
                Log.geraLogIfr(UsuarioLogado.getUsuarioLogadoEmail(), "IfrUsuario", btnExcluir, erro);
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        if (jTabbedPane1.getSelectedIndex() == 0) {
            btnSalvar.setEnabled(true);
            btnEditar.setEnabled(false);
            btnExcluir.setEnabled(false);
            limparCampos();
        } else if (jTabbedPane1.getSelectedIndex() == 1) {
            btnSalvar.setEnabled(false);
            btnEditar.setEnabled(true);
            btnExcluir.setEnabled(true);
            limparCampos();
        }

        Formatacao.limparjtable(tblUsuario);
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBoxInativos1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblUsuario;
    private javax.swing.JTextField tfdBusca;
    private javax.swing.JTextField tfdEmail;
    private javax.swing.JPasswordField tffSenha;
    // End of variables declaration//GEN-END:variables
}
