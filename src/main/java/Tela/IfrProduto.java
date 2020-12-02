package Tela;

import Util.ComboItem;
import Util.Formatacao;
import javax.swing.JOptionPane;
import Util.Validacao;
import Dao.ProdutoDAO;
import Entidade.Produto;
import Entidade.UsuarioLogado;
import Util.Log;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import org.hibernate.HibernateException;

public class IfrProduto extends javax.swing.JInternalFrame {

    int codigo = 0;
    boolean temForm = false;
    private static IfrProduto tela;

    public IfrProduto() {
        initComponents();
        ProdOperador(UsuarioLogado.getUsuarioLogadoPermissao());
        jComboBoxTpProd.removeAllItems();
        jComboBoxTpProd.addItem("Selecione");
        jComboBoxTpProd.addItem("Congelado");
        jComboBoxTpProd.addItem("Resfriado");
        CkbStatus.setSelected(true);
        new ProdutoDAO().popularTabela(tblProd, "", jCheckBoxInativos.isSelected());
        Formatacao.limparjtable(tblProd);
        tfdDescricao.requestFocus();
    }
    
    public static IfrProduto getInstancia() {
        if (tela == null) {
            tela = new IfrProduto();
        }
        return tela;
    }

    @SuppressWarnings("unchecked")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfdDescricao = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxTpProd = new javax.swing.JComboBox<>();
        CkbStatus = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProd = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        tfdBusca = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jCheckBoxInativos = new javax.swing.JCheckBox();
        btnFechar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setTitle("Cadastro: Produto");

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });
        jTabbedPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedPane1FocusGained(evt);
            }
        });

        jLabel1.setText("Descrição (*)");

        jLabel6.setText("Tipo Material (*)");

        jComboBoxTpProd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxTpProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTpProdActionPerformed(evt);
            }
        });

        CkbStatus.setSelected(true);
        CkbStatus.setText("Ativo");
        CkbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CkbStatusActionPerformed(evt);
            }
        });

        jLabel7.setText("(*) Campos Obrigatórios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CkbStatus)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfdDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxTpProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(259, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfdDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBoxTpProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CkbStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Produto", jPanel1);

        tblProd.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblProd);

        jLabel4.setText("Busca");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jCheckBoxInativos.setText("Listar Inativos");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxInativos)
                .addGap(30, 30, 30))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void ProdOperador(String permissao) {
        if (permissao.equals("Operador")) {
            jTabbedPane1.setEnabledAt(0, false);
            jTabbedPane1.setSelectedIndex(1);
            btnEditar.setEnabled(false);
            btnExcluir.setEnabled(false);
            btnSalvar.setEnabled(false);
        }
    }
    
    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
        limparCampos();
    }//GEN-LAST:event_btnFecharActionPerformed

    public void limparCampos() {
        tfdDescricao.setText("");
        jComboBoxTpProd.setSelectedIndex(0);
        CkbStatus.setSelected(true);
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

    public void descricaoInvalido() {
        tfdAmarelo(tfdDescricao);
        jcbBranco(jComboBoxTpProd);
        tfdDescricao.requestFocus();
    }

    public void tipoProdutoInvalido() {
        tfdBranco(tfdDescricao);
        jcbAmarelo(jComboBoxTpProd);
        jComboBoxTpProd.requestFocus();
    }

    public void resetCor() {
        tfdBranco(tfdDescricao);
        jcbBranco(jComboBoxTpProd);
    }


    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (!Validacao.validarDescricao(tfdDescricao.getText())) {
            revisar();
            descricaoInvalido();
        } else if (jComboBoxTpProd.getSelectedIndex() == 0) {
            revisar();
            tipoProdutoInvalido();
        } else {

            Produto p = new Produto();
            ProdutoDAO produtoDAO = new ProdutoDAO();
            String retorno = null;

            //Popular Objeto
            p.setId(codigo);
            p.setDescricao(tfdDescricao.getText());
            p.setTipo_produto_id(jComboBoxTpProd.getSelectedIndex());
            p.setTem_formulacao('S');
            
            if (temForm) {
                p.setTem_formulacao('S');
            } else {
                p.setTem_formulacao('N');
            }
            
            p.setStatus("Ativo");
            if (!CkbStatus.isSelected()) {
                p.setStatus("Inativo");
            }

            if (produtoDAO.checkExist(p)) {
                JOptionPane.showMessageDialog(null, "Campo já existe no registro!");
            } else {

                if (codigo != 0) {
                    //atualiza
                    retorno = produtoDAO.Atualizar(p);
                } else {
                    //insere
                    retorno = produtoDAO.Salvar(p);
                }

                if (retorno == null) {
                    JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");
                    
                    temForm = false;

                    limparCampos();
                    resetCor();

                    // posicionar cursor
                    tfdDescricao.requestFocus();

                    codigo = 0;
                } else {
                    retorno = "Impossível salvar produto: " + retorno;
                    JOptionPane.showMessageDialog(null, retorno);
                    Log.geraLogIfr(UsuarioLogado.getUsuarioLogadoEmail(), "IfrProduto", btnSalvar, retorno);
                }
            }
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        new ProdutoDAO().popularTabela(tblProd, tfdBusca.getText(), jCheckBoxInativos.isSelected());
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tblProd.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um item antes de editá-lo");
        } else {
            try {
                int id = Integer.parseInt(String.valueOf(tblProd.getValueAt(tblProd.getSelectedRow(), 0)));
                Produto produto = new ProdutoDAO().consultarId(id);

                if (produto != null) {
                    jTabbedPane1.setSelectedIndex(0);
                    tfdDescricao.setText(produto.getDescricao());
                    jComboBoxTpProd.setSelectedIndex(produto.getTipo_produto_id());
                    CkbStatus.setSelected(true);
                    if (produto.getStatus().equals("Inativo")) {
                        CkbStatus.setSelected(false);
                    }
                    
                    if (produto.getTem_formulacao() == 'S') {
                        temForm = true;
                    } else {
                        temForm = false;
                    }

                    tfdDescricao.requestFocus();
                    codigo = id;
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao editar registro!");
                }
            } catch (HibernateException hibEx) {
                hibEx.printStackTrace();
                Log.geraLogIfr(UsuarioLogado.getUsuarioLogadoEmail(), "IfrProduto", btnEditar, hibEx.toString());
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (tblProd.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione uma linha!");
        } else {

            int id = Integer.parseInt(String.valueOf(tblProd.getValueAt(tblProd.getSelectedRow(), 0)));
            String retorno = new ProdutoDAO().Excluir(id);

            if (retorno == null) {
                JOptionPane.showMessageDialog(null, "Produto inativado com sucesso!");

                limparCampos();
                resetCor();
                // posicionar cursor
                tfdDescricao.requestFocus();

                //atualiza tabela
                new ProdutoDAO().popularTabela(tblProd, tfdBusca.getText(), jCheckBoxInativos.isSelected());
            }else{
                String erro = "Impossível Inativar Produto: " + retorno;
                JOptionPane.showMessageDialog(null, erro);
                Log.geraLogIfr(UsuarioLogado.getUsuarioLogadoEmail(), "IfrProduto", btnExcluir, erro);
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jComboBoxTpProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTpProdActionPerformed

    }//GEN-LAST:event_jComboBoxTpProdActionPerformed

    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained

    }//GEN-LAST:event_jTabbedPane1FocusGained

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

        Formatacao.limparjtable(tblProd);
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void CkbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CkbStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CkbStatusActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CkbStatus;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox jCheckBoxInativos;
    private javax.swing.JComboBox<String> jComboBoxTpProd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblProd;
    private javax.swing.JTextField tfdBusca;
    private javax.swing.JTextField tfdDescricao;
    // End of variables declaration//GEN-END:variables
}
