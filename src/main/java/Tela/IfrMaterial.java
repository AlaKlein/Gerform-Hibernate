/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tela;

import Util.ComboItem;
import Util.Formatacao;
import Util.Validacao;
import Util.SoNumerosEPonto;
import Dao.CombosDAOMaterial;
import Dao.MaterialDAO;
import Entidade.Material;
import Entidade.UsuarioLogado;
import Util.Log;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import org.hibernate.HibernateException;

/**
 *
 * @author ala.klein
 */
public class IfrMaterial extends javax.swing.JInternalFrame {

    int codigo = 0;
    private static IfrMaterial tela;

    /**
     * Creates new form IfrMaterial
     */
    public IfrMaterial() {
        initComponents();

        MaterialOperador(UsuarioLogado.getUsuarioLogadoPermissao());
        jComboBoxTpMat.removeAllItems();
        jComboBoxTpMat.addItem("Selecione");
        jComboBoxTpMat.addItem("Matéria Prima");
        jComboBoxTpMat.addItem("Condimento");
        new CombosDAOMaterial().popularCombo(jComboBoxFornecedor);
        tfdPrecokg.setDocument(new SoNumerosEPonto());
        new MaterialDAO().popularTabela(tblMat, "", jCheckBoxInativos.isSelected());
        Formatacao.limparjtable(tblMat);
    }

    public static IfrMaterial getInstancia() {
        if (tela == null) {
            tela = new IfrMaterial();
        }
        return tela;
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
        jLabel3 = new javax.swing.JLabel();
        tfdPrecokg = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfdDescricao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxTpMat = new javax.swing.JComboBox<>();
        jComboBoxFornecedor = new javax.swing.JComboBox<>();
        CkbStatus = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMat = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        tfdBusca = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jCheckBoxInativos = new javax.swing.JCheckBox();
        btnFechar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setTitle("Cadastro: Material");

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

        jLabel3.setText("Preço/Kg (*)");

        tfdPrecokg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdPrecokgActionPerformed(evt);
            }
        });
        tfdPrecokg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfdPrecokgKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfdPrecokgKeyTyped(evt);
            }
        });

        jLabel1.setText("Descrição (*)");

        jLabel5.setText("Fornecedor (*)");

        jLabel6.setText("Tipo Material (*)");

        jComboBoxTpMat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxTpMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTpMatActionPerformed(evt);
            }
        });

        jComboBoxFornecedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfdDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdPrecokg, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jComboBoxFornecedor, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBoxTpMat, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(259, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfdDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdPrecokg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBoxTpMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CkbStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Material", jPanel1);

        tblMat.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblMat);

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

    public void MaterialOperador(String permissao) {
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
        tfdPrecokg.setText("");
        jComboBoxTpMat.setSelectedIndex(0);
        jComboBoxFornecedor.setSelectedIndex(0);
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
        tfdBranco(tfdPrecokg);
        jcbBranco(jComboBoxTpMat);
        jcbBranco(jComboBoxFornecedor);
        tfdDescricao.requestFocus();
    }

    public void precoInvalido() {
        tfdBranco(tfdDescricao);
        tfdAmarelo(tfdPrecokg);
        jcbBranco(jComboBoxTpMat);
        jcbBranco(jComboBoxFornecedor);
        tfdPrecokg.requestFocus();
    }

    public void tipo_MaterialInvalido() {
        tfdBranco(tfdDescricao);
        tfdBranco(tfdPrecokg);
        jcbAmarelo(jComboBoxTpMat);
        jcbBranco(jComboBoxFornecedor);
        jComboBoxTpMat.requestFocus();
    }

    public void fornecedorInvalido() {
        tfdBranco(tfdDescricao);
        tfdBranco(tfdPrecokg);
        jcbBranco(jComboBoxTpMat);
        jcbAmarelo(jComboBoxFornecedor);
        jComboBoxFornecedor.requestFocus();
    }

    public void resetCor() {
        tfdBranco(tfdDescricao);
        tfdBranco(tfdPrecokg);
        jcbBranco(jComboBoxTpMat);
        jcbBranco(jComboBoxFornecedor);
    }


    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Material m = new Material();
        MaterialDAO materialDAO = new MaterialDAO();
        String retorno = null;
        //ComboItem ci = (ComboItem) jComboBoxTpMat.getSelectedItem();
        ComboItem ci2 = (ComboItem) jComboBoxFornecedor.getSelectedItem();

        if (!Validacao.validarDescricao(tfdDescricao.getText())) {
            revisar();
            descricaoInvalido();
        } else if (!Validacao.validarPreco(tfdPrecokg.getText())) {
            revisar();
            precoInvalido();
        } else if (jComboBoxTpMat.getSelectedIndex() == 0) {
            revisar();
            tipo_MaterialInvalido();
        } else if (jComboBoxFornecedor.getSelectedIndex() == 0) {
            revisar();
            fornecedorInvalido();
        } else {
                //Popular Objeto
                m.setId(codigo);
                m.setDescricao(tfdDescricao.getText());
                m.setPrecokg(Double.parseDouble(tfdPrecokg.getText().replace(',', '.')));
                if (jComboBoxTpMat.getSelectedItem().equals("Matéria Prima")) {
                    m.setTipoMaterialId(1);
                } else if (jComboBoxTpMat.getSelectedItem().equals("Condimento")) {
                    m.setTipoMaterialId(2);
                }
                m.setFornecedor(Integer.parseInt(String.valueOf(ci2.getCodigo())));
                m.setStatus(CkbStatus.isSelected() ? "Ativo" : "Inativo");
                if (codigo != 0) {
                m.setTemPropriedades('S');
                }else{ 
                m.setTemPropriedades('N');
                }

                if (materialDAO.checkExist(m)) {
                JOptionPane.showMessageDialog(null, "Material Já Registrado!");
                descricaoInvalido();
                tfdDescricao.requestFocus();
            } else {
                
                if (codigo != 0) {
                    //atualiza
                    retorno = materialDAO.Atualizar(m);
                } else {
                    //insere
                    retorno = materialDAO.Salvar(m);
                }

                if (retorno == null) {
                    JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");

                    // limpar os campos
                    limparCampos();
                    resetCor();

                    // posicionar cursor
                    tfdDescricao.requestFocus();

                    codigo = 0;

                } else {
                    retorno = "Impossível salvar usuário: " + retorno;
                    JOptionPane.showMessageDialog(null, retorno);
                    Log.geraLogIfr(UsuarioLogado.getUsuarioLogadoEmail(), "IfrMaterial", btnSalvar, retorno);
                }
            }
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        new MaterialDAO().popularTabela(tblMat, tfdBusca.getText(), jCheckBoxInativos.isSelected());
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tblMat.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um item antes de editá-lo");
        } else {

            try {
                int id = Integer.parseInt(String.valueOf(tblMat.getValueAt(tblMat.getSelectedRow(), 0)));
                Material material = new MaterialDAO().consultarId(id);
                MaterialDAO materialDAO = new MaterialDAO();

                if (material != null) {
                    jTabbedPane1.setSelectedIndex(0);
                    tfdDescricao.setText(material.getDescricao());
                    tfdPrecokg.setText(String.valueOf(material.getPrecokg()));

                    ComboItem item = new ComboItem();
                    item.setCodigo(material.getTipoMaterialId());
                    
                    if (material.getTipoMaterialId() == 1) {
                        jComboBoxTpMat.setSelectedIndex(1);
                    }else if (material.getTipoMaterialId() == 2) {
                        jComboBoxTpMat.setSelectedIndex(2);
                    }

                    item.setCodigo(material.getFornecedor());
                    new CombosDAOMaterial().definirItemCombo(jComboBoxFornecedor, item);
                    if (material.getStatus().equals("Ativo")) {
                        CkbStatus.setSelected(true);
                    } else {
                        CkbStatus.setSelected(false);
                    }
                    tfdDescricao.requestFocus();
                    codigo = id;
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao editar registro!");
                }
            } catch (HibernateException hibEx) {
                hibEx.printStackTrace();
                Log.geraLogIfr(UsuarioLogado.getUsuarioLogadoEmail(), "IfrMaterial", btnEditar, hibEx.toString());
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (tblMat.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um item antes de excluí-lo");
        } else {

            int id = Integer.parseInt(String.valueOf(tblMat.getValueAt(tblMat.getSelectedRow(), 0)));
            String retorno = new MaterialDAO().Excluir(id);

            if (retorno == null) {
                JOptionPane.showMessageDialog(null, "Material inativado com sucesso!");

                limparCampos();
                resetCor();
            } else {
                String erro = "Impossível Inativar Material: " + retorno;
                JOptionPane.showMessageDialog(null, erro);
                Log.geraLogIfr(UsuarioLogado.getUsuarioLogadoEmail(), "IfrMaterial", btnExcluir, erro);
            }

            //atualiza tabela
            new MaterialDAO().popularTabela(tblMat, tfdBusca.getText(), jCheckBoxInativos.isSelected());
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jComboBoxTpMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTpMatActionPerformed

    }//GEN-LAST:event_jComboBoxTpMatActionPerformed

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

        Formatacao.limparjtable(tblMat);
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void CkbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CkbStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CkbStatusActionPerformed

    private void tfdPrecokgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdPrecokgKeyPressed
    }//GEN-LAST:event_tfdPrecokgKeyPressed

    private void tfdPrecokgKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdPrecokgKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != ',') {
            evt.consume();
        }
        if (evt.getKeyChar() == ',' && tfdPrecokg.getText().contains(",")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfdPrecokgKeyTyped

    private void tfdPrecokgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdPrecokgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdPrecokgActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CkbStatus;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox jCheckBoxInativos;
    private javax.swing.JComboBox<String> jComboBoxFornecedor;
    private javax.swing.JComboBox<String> jComboBoxTpMat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblMat;
    private javax.swing.JTextField tfdBusca;
    private javax.swing.JTextField tfdDescricao;
    private javax.swing.JTextField tfdPrecokg;
    // End of variables declaration//GEN-END:variables
}
