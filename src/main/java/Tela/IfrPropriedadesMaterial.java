
package Tela;

import Dao.CombosDAOMat;
import Dao.MaterialDAO;
import Dao.PropriedadesMaterialDAO;
import Entidade.PropriedadesMaterial;
import Entidade.UsuarioLogado;
import Util.ComboItem;
import Util.Formatacao;
import Util.SoNumerosEPonto;
import Util.Validacao;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.hibernate.HibernateException;


public class IfrPropriedadesMaterial extends javax.swing.JInternalFrame {

    int codigo = 0;

    
    public IfrPropriedadesMaterial() {
        initComponents();
        new CombosDAOMat().popularComboPropriedades(jComboBoxMat);
        tfdUmidade.setDocument(new SoNumerosEPonto());
        tfdGordura.setDocument(new SoNumerosEPonto());
        tfdProteina.setDocument(new SoNumerosEPonto());
        Formatacao.limparjtable(tblMat);
    }

    
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tfdUmidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxMat = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfdGordura = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfdProteina = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
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

        setTitle("Cadastro: Propriedades Material");

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

        jLabel3.setText("Umidade (*)");

        jLabel6.setText("Material (*)");

        jComboBoxMat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("(*) Campos Obrigatórios");

        jLabel8.setText("Gordura (*)");

        jLabel9.setText("Proteína (*)");

        jCheckBox1.setText("Ativo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfdUmidade, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxMat, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdGordura, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdProteina, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(430, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBoxMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfdUmidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tfdGordura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tfdProteina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Propriedades Material", jPanel1);

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

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
        limparCampos();
    }//GEN-LAST:event_btnFecharActionPerformed

    public void limparCampos() {
        tfdUmidade.setText("");
        tfdGordura.setText("");
        tfdProteina.setText("");
        jComboBoxMat.setSelectedIndex(0);
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

    public void materialInvalido() {
        tfdBranco(tfdUmidade);
        tfdBranco(tfdGordura);
        tfdBranco(tfdProteina);
        jcbAmarelo(jComboBoxMat);
        jComboBoxMat.requestFocus();
    }

    public void umidadeInvalido() {
        tfdAmarelo(tfdUmidade);
        tfdBranco(tfdGordura);
        tfdBranco(tfdProteina);
        jcbBranco(jComboBoxMat);
        tfdUmidade.requestFocus();
    }

    public void gorduraInvalido() {
        tfdBranco(tfdUmidade);
        tfdAmarelo(tfdGordura);
        tfdBranco(tfdProteina);
        jcbBranco(jComboBoxMat);
        tfdGordura.requestFocus();
    }

    public void proteinaInvalido() {
        tfdBranco(tfdUmidade);
        tfdBranco(tfdGordura);
        tfdAmarelo(tfdProteina);
        jcbBranco(jComboBoxMat);
        tfdProteina.requestFocus();
    }

    public void resetCor() {
        tfdBranco(tfdUmidade);
        tfdBranco(tfdGordura);
        tfdBranco(tfdProteina);
        jcbBranco(jComboBoxMat);
    }


    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        PropriedadesMaterial pm = new PropriedadesMaterial();
        MaterialDAO mat = new MaterialDAO();
        UsuarioLogado u = new UsuarioLogado();
        ComboItem ci = (ComboItem) jComboBoxMat.getSelectedItem();
        
        if ((jComboBoxMat.getSelectedIndex() == 0) && (jComboBoxMat.isEnabled())) {
            revisar();
            materialInvalido();
        } else if (!Validacao.validarPreco(tfdUmidade.getText())) {
            revisar();
            umidadeInvalido();
        } else if (!Validacao.validarPreco(tfdGordura.getText())) {
            revisar();
            gorduraInvalido();
        } else if (!Validacao.validarPreco(tfdProteina.getText())) {
            revisar();
            proteinaInvalido();
        } else {
            pm.setId(codigo);
            pm.setUsuario_id(u.getUsuarioLogadoID());
            pm.setMaterial_id(mat.consultarSomenteId(ci.getDescricao()));
            pm.setUmidade(Double.parseDouble(tfdUmidade.getText().replace(',', '.')));
            pm.setGordura(Double.parseDouble(tfdGordura.getText().replace(',', '.')));
            pm.setProteina(Double.parseDouble(tfdProteina.getText().replace(',', '.')));
            
            if (jCheckBox1.isSelected()) {
                pm.setStatus("Ativo");
            } else {
                pm.setStatus("Inativo");
            }

            PropriedadesMaterialDAO propriedadesMaterialDAO = new PropriedadesMaterialDAO();
            String retorno = null;

            if (codigo == 0) {
                retorno = propriedadesMaterialDAO.Salvar(pm);
                mat.definirPropriedades(mat.consultarSomenteId(ci.getDescricao()), "S");
            } else {
                retorno = propriedadesMaterialDAO.Atualizar(pm);
            }

            if (retorno == null) {
                JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");
                jComboBoxMat.setEnabled(true);

                // limpar os campos
                limparCampos();
                resetCor();

                // posicionar cursor
                jComboBoxMat.requestFocus();

                codigo = 0;

                new PropriedadesMaterialDAO().popularTabela(tblMat, tfdBusca.getText(), jCheckBoxInativos.isSelected());

                new CombosDAOMat().popularComboPropriedades(jComboBoxMat);

            } else {
                JOptionPane.showMessageDialog(null, "Deu erro: \n\nMensagem técnica:" + retorno);
            }

        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        new PropriedadesMaterialDAO().popularTabela(tblMat, tfdBusca.getText(), jCheckBoxInativos.isSelected());
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tblMat.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um item antes de editá-lo!");
        } else {

            try {
                int id = Integer.parseInt(String.valueOf(tblMat.getValueAt(tblMat.getSelectedRow(), 0)));
                PropriedadesMaterial pm = new PropriedadesMaterialDAO().consultarId(id);

                if (pm != null) {
                    new CombosDAOMat().popularComboPropriedadesEditar(jComboBoxMat, 
                            String.valueOf(tblMat.getValueAt(tblMat.getSelectedRow(), 1)));
                    jTabbedPane1.setSelectedIndex(0);
                    jComboBoxMat.setEnabled(false);
                    tfdUmidade.setText(Double.toString(pm.getUmidade()));
                    tfdGordura.setText(Double.toString(pm.getGordura()));
                    tfdProteina.setText(Double.toString(pm.getProteina()));
                    if (pm.getStatus().equals("Ativo")) {
                        jCheckBox1.setSelected(true);
                    } else {
                        jCheckBox1.setSelected(false);
                    }

                    tfdUmidade.requestFocus();
                    codigo = id;
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao editar registro!");
                }
            } catch (HibernateException hibEx) {
                hibEx.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (tblMat.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione uma linha!");
        } else {
            int id = Integer.parseInt(String.valueOf(tblMat.getValueAt(tblMat.getSelectedRow(), 0)));
            String retorno = new PropriedadesMaterialDAO().Excluir(id);

            if (retorno == null) {
                JOptionPane.showMessageDialog(null, "Propriedade inativada com sucesso!");

                limparCampos();
                resetCor();
                // posicionar cursor
                tfdUmidade.requestFocus();

                //atualiza tabela
                new PropriedadesMaterialDAO().popularTabela(tblMat, tfdBusca.getText(), jCheckBoxInativos.isSelected());
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained

    }//GEN-LAST:event_jTabbedPane1FocusGained

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
        
        Formatacao.limparjtable(tblMat);
        //new CombosDAOMat().popularCombo("material", jComboBoxMat, "N");

    }//GEN-LAST:event_jTabbedPane1StateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBoxInativos;
    private javax.swing.JComboBox<String> jComboBoxMat;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblMat;
    private javax.swing.JTextField tfdBusca;
    private javax.swing.JTextField tfdGordura;
    private javax.swing.JTextField tfdProteina;
    private javax.swing.JTextField tfdUmidade;
    // End of variables declaration//GEN-END:variables
}
