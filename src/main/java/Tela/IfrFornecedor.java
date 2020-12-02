package Tela;

import Dao.FornecedorDAO;
import Util.Formatacao;
import Util.Validacao;
import Entidade.Fornecedor;
import Entidade.UsuarioLogado;
import Util.Log;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.hibernate.HibernateException;

public class IfrFornecedor extends javax.swing.JInternalFrame {

    int codigo = 0;

    public IfrFornecedor() {
        initComponents();
        FornecOperador(UsuarioLogado.getUsuarioLogadoPermissao());
        Formatacao.formatarCnpj(tffCNPJ);
        Formatacao.formatarTelefone(tffTelefone);
        new FornecedorDAO().popularTabela(tblFornec, "", jCheckBoxInativos.isSelected());
        Formatacao.limparjtable(tblFornec);
    }
    
    public void FornecOperador(String permissao) {
        if (permissao.equals("Operador")) {
            jTabbedPane1.setEnabledAt(0, false);
            jTabbedPane1.setSelectedIndex(1);
            btnEditar.setEnabled(false);
            btnExcluir.setEnabled(false);
            btnSalvar.setEnabled(false);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfdendereco = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfdRazaoSocial = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tffCNPJ = new javax.swing.JFormattedTextField();
        tffTelefone = new javax.swing.JFormattedTextField();
        CkbStatus = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFornec = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        tfdBusca = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jCheckBoxInativos = new javax.swing.JCheckBox();
        btnFechar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setTitle("Cadastro: Fornecedor");

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jLabel2.setText("Telefone (*)");

        jLabel3.setText("Endereço (*)");

        jLabel1.setText("Razão Social (*)");

        jLabel5.setText("CNPJ (*)");

        CkbStatus.setSelected(true);
        CkbStatus.setText("Ativo");
        CkbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CkbStatusActionPerformed(evt);
            }
        });

        jLabel6.setText("(*) Campos Obrigatórios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CkbStatus)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tfdRazaoSocial, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfdendereco, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tffTelefone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                        .addComponent(tffCNPJ, javax.swing.GroupLayout.Alignment.LEADING))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)))
                .addContainerGap(265, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfdRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tffCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tffTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdendereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CkbStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Fornecedor", jPanel1);

        tblFornec.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblFornec);

        jLabel4.setText("Busca");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jCheckBoxInativos.setText("Listar Inativos");
        jCheckBoxInativos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxInativosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jCheckBoxInativos)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBoxInativos)
                .addGap(25, 25, 25))
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
                    .addComponent(jTabbedPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(btnFechar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFechar)
                    .addComponent(btnSalvar)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
        limparCampos();
    }//GEN-LAST:event_btnFecharActionPerformed
    public void limparCampos() {
        tfdRazaoSocial.setText("");
        tffCNPJ.setText("");
        tffTelefone.setText("");
        tfdendereco.setText("");
        CkbStatus.setSelected(true);
    }

    public void razao_SocialInvalido() {
        tfdAmarelo(tfdRazaoSocial);
        tfdBranco(tffCNPJ);
        tfdBranco(tffTelefone);
        tfdBranco(tfdendereco);
        tfdRazaoSocial.requestFocus();
    }

    public void cnpjInvalido() {
        tfdBranco(tfdRazaoSocial);
        tfdAmarelo(tffCNPJ);
        tfdBranco(tffTelefone);
        tfdBranco(tfdendereco);
        tffCNPJ.requestFocus();
    }

    public void telefoneInvalido() {
        tfdBranco(tfdRazaoSocial);
        tfdBranco(tffCNPJ);
        tfdAmarelo(tffTelefone);
        tfdBranco(tfdendereco);
        tffTelefone.requestFocus();
    }

    public void enderecoInvalido() {
        tfdBranco(tfdRazaoSocial);
        tfdBranco(tffCNPJ);
        tfdBranco(tffTelefone);
        tfdAmarelo(tfdendereco);
        tfdendereco.requestFocus();
    }

    public void resetCor() {
        tfdBranco(tfdRazaoSocial);
        tfdBranco(tffCNPJ);
        tfdBranco(tffTelefone);
        tfdBranco(tfdendereco);
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


    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (Validacao.validarRazaoSocial(tfdRazaoSocial.getText()) != 0) {
            revisar();
            razao_SocialInvalido();
            /*} else if (tffCNPJ.getText().equals("  .   .   /    -  ")) {
            revisar();
            cnpjInvalido();*/
        } else if (!Validacao.validarCNPJ(Formatacao.removerFormatacao(tffCNPJ.getText()))) {
            revisar();
            cnpjInvalido();
        } else if (Validacao.validarTelefoneNovo(tffTelefone) != 0) {
            revisar();
            telefoneInvalido();
        } else if (Validacao.validarEndereco(tfdendereco.getText()) != 0) {
            revisar();
            enderecoInvalido();
        } else {

            Fornecedor f = new Fornecedor();
            FornecedorDAO fornecedorDAO = new FornecedorDAO();
            String retorno = null;

            //Popular Objeto
            f.setId(codigo);
            f.setRazao_social(tfdRazaoSocial.getText());
            f.setCnpj(tffCNPJ.getText());
            f.setTelefone(tffTelefone.getText());
            f.setEndereco(tfdendereco.getText());
            if (CkbStatus.isSelected()) {
                f.setStatus("Ativo");
            } else {
                f.setStatus("Inativo");
            }

            if (fornecedorDAO.checkExist(f)) {
                JOptionPane.showMessageDialog(null, "Campo já existe no registro!");
            } else {

                if (codigo != 0) {
                    //atualiza
                    retorno = fornecedorDAO.Atualizar(f);
                } else {
                    //insere
                    retorno = fornecedorDAO.Salvar(f);
                }

                if (retorno == null) {
                    JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");

                    // limpar os campos
                    tfdRazaoSocial.setText("");
                    tffCNPJ.setText("");
                    tffTelefone.setText("");
                    tfdendereco.setText("");

                    resetCor();

                    // posicionar cursor
                    tfdRazaoSocial.requestFocus();

                    codigo = 0;

                } else {
                 retorno = "Impossível salvar fornecedor: " + retorno;
                    JOptionPane.showMessageDialog(null, retorno);
                    Log.geraLogIfr(UsuarioLogado.getUsuarioLogadoEmail(), "IfrFornecedor", btnSalvar, retorno);
                }
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        new FornecedorDAO().popularTabela(tblFornec, tfdBusca.getText(), jCheckBoxInativos.isSelected());
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tblFornec.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um item antes de editá-lo");
        } else {

            try {
                int id = Integer.parseInt(String.valueOf(tblFornec.getValueAt(tblFornec.getSelectedRow(), 0)));
                Fornecedor fornecedor = new FornecedorDAO().consultarId(id);

                if (fornecedor != null) {
                    jTabbedPane1.setSelectedIndex(0);
                    tfdRazaoSocial.setText(fornecedor.getRazao_social());
                    tffCNPJ.setText(fornecedor.getCnpj());
                    tffTelefone.setText(fornecedor.getTelefone());
                    tfdendereco.setText(fornecedor.getEndereco());
                    if (fornecedor.getStatus().equals("Ativo")) {
                        CkbStatus.setSelected(true);
                    } else {
                        CkbStatus.setSelected(false);
                    }

                    tfdRazaoSocial.requestFocus();
                    codigo = id;
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao editar registro!");
                }
            } catch (HibernateException hibEx) {
                hibEx.printStackTrace();
                Log.geraLogIfr(UsuarioLogado.getUsuarioLogadoEmail(), "IfrFornecedor", btnEditar, hibEx.toString());
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (tblFornec.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione uma linha!");
        } else {

            int id = Integer.parseInt(String.valueOf(tblFornec.getValueAt(tblFornec.getSelectedRow(), 0)));
            String retorno = new FornecedorDAO().Excluir(id);

            if (retorno == null) {
                JOptionPane.showMessageDialog(null, "Fornecedor deletado com sucesso!");

                limparCampos();
                resetCor();
                // posicionar cursor
                tfdRazaoSocial.requestFocus();

                //atualiza tabela
                new FornecedorDAO().popularTabela(tblFornec, tfdBusca.getText(), jCheckBoxInativos.isSelected());
            }else{
                String erro = "Impossível Inativar Fornecedor: " + retorno;
                JOptionPane.showMessageDialog(null, erro);
                Log.geraLogIfr(UsuarioLogado.getUsuarioLogadoEmail(), "IfrFornecedor", btnExcluir, erro);
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        if (jTabbedPane1.getSelectedIndex() == 0) {
            btnSalvar.setEnabled(true);
            btnEditar.setEnabled(false);
            btnExcluir.setEnabled(false);
            limparCampos();
            jCheckBoxInativos.setSelected(false);
        } else if (jTabbedPane1.getSelectedIndex() == 1) {
            btnSalvar.setEnabled(false);
            btnEditar.setEnabled(true);
            btnExcluir.setEnabled(true);
            limparCampos();
            jCheckBoxInativos.setSelected(false);
        }

        Formatacao.limparjtable(tblFornec);
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void CkbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CkbStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CkbStatusActionPerformed

    private void jCheckBoxInativosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxInativosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxInativosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CkbStatus;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox jCheckBoxInativos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblFornec;
    private javax.swing.JTextField tfdBusca;
    private javax.swing.JTextField tfdRazaoSocial;
    private javax.swing.JTextField tfdendereco;
    private javax.swing.JFormattedTextField tffCNPJ;
    private javax.swing.JFormattedTextField tffTelefone;
    // End of variables declaration//GEN-END:variables
}
