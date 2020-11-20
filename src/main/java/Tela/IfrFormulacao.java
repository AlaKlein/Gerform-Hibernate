/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tela;

import Util.ComboItem;
import Util.Formatacao;
import Util.SoNumerosEPonto;
import Entidade.UsuarioLogado;
import Dao.CombosDAOForm;
import Dao.FormulacaoDAO;
import Dao.ItemFormulacaoDAO;
import Entidade.Formulacao;
import Entidade.ItemFormulacao;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import tela.TelaPrincipal;

/**
 *
 * @author klein
 */
public class IfrFormulacao extends javax.swing.JInternalFrame {

    FormulacaoDAO formulacaoDAO = new FormulacaoDAO();
    ItemFormulacaoDAO itemFormulacaoDAO = new ItemFormulacaoDAO();
    private DefaultListModel modeloListaEsquerdaMP = new DefaultListModel<String>();
    int idAtualizar;
    int formID;

    /**
     * Creates new form IfrMaterial
     */
    public IfrFormulacao() {
        initComponents();
        inicializarTabelaMP();
        inicializarTabelaCond();
        tfdBatelada.setDocument(new SoNumerosEPonto());
        tfdPercentualMP.setDocument(new SoNumerosEPonto());
        tfdPercentualCond.setDocument(new SoNumerosEPonto());
        desabilitarTudo();
        new CombosDAOForm().popularCombo("produto", cmbProduto, "N");
        tffDataLancamento.setText(Formatacao.getDataHoraAtual());
        tffDataLancamento.setEditable(false);

        tfdSomaPercentualMP.setEditable(false);
        tfdSomaKgMP.setEditable(false);
        tfdSomaR$KgMP.setEditable(false);
        tfdSomaR$KgProdMP.setEditable(false);
        tfdSomaUmidadeMP.setEditable(false);
        tfdSomaGorduraMP.setEditable(false);
        tfdSomaProteinaMP.setEditable(false);

        tfdSomaPercentualCond.setEditable(false);
        tfdSomaKgCond.setEditable(false);
        tfdSomaR$KgCond.setEditable(false);
        tfdSomaR$KgProdCond.setEditable(false);
        tfdSomaUmidadeCond.setEditable(false);
        tfdSomaGorduraCond.setEditable(false);
        tfdSomaProteinaCond.setEditable(false);

        tfdSomaPercentualTotal.setEditable(false);
        tfdSomaKgTotal.setEditable(false);
        tfdSomaR$KgTotal.setEditable(false);
        tfdSomaR$KgProdTotal.setEditable(false);
        tfdSomaUmidadeTotal.setEditable(false);
        tfdSomaGorduraTotal.setEditable(false);
        tfdSomaProteinaTotal.setEditable(false);

        tfdSomaPercentualMP1.setEditable(false);
        tfdSomaKgMP1.setEditable(false);
        tfdSomaR$KgMP1.setEditable(false);
        tfdSomaR$KgProdMP1.setEditable(false);
        tfdSomaUmidadeMP1.setEditable(false);
        tfdSomaGorduraMP1.setEditable(false);
        tfdSomaProteinaMP1.setEditable(false);

        tfdSomaPercentualCond1.setEditable(false);
        tfdSomaKgCond1.setEditable(false);
        tfdSomaR$KgCond1.setEditable(false);
        tfdSomaR$KgProdCond1.setEditable(false);
        tfdSomaUmidadeCond1.setEditable(false);
        tfdSomaGorduraCond1.setEditable(false);
        tfdSomaProteinaCond1.setEditable(false);

        tfdSomaPercentualTotal1.setEditable(false);
        tfdSomaKgTotal1.setEditable(false);
        tfdSomaR$KgTotal1.setEditable(false);
        tfdSomaR$KgProdTotal1.setEditable(false);
        tfdSomaUmidadeTotal1.setEditable(false);
        tfdSomaGorduraTotal1.setEditable(false);
        tfdSomaProteinaTotal1.setEditable(false);

        tblFormulacaoMP1.setEnabled(false);
        tblFormulacaoCond1.setEnabled(false);

        somaSubTotaisMP();
        somaSubTotaisCond();
        somaTotais();

        somaSubTotaisMP2();
        somaSubTotaisCond2();
        somaTotais2();

        tfdBatelada.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfdPercentualMP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfdPercentualCond.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tffDataLancamento.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    }

    public int getIdAtualizar() {
        return idAtualizar;
    }

    public void desabilitarTudo() {
        tfdBatelada.setEditable(false);
        tfdPercentualMP.setEditable(false);
        tfdPercentualCond.setEditable(false);
        btnAddMP.setEnabled(false);
        btnAddCond.setEnabled(false);
        btnRemMP.setEnabled(false);
        btnRemCond.setEnabled(false);
        tfdBuscaMP.setEnabled(false);
        tfdBuscaCond.setEnabled(false);
        tblEsquerdaMP.setEnabled(false);
        tblEsquerdaCond.setEnabled(false);
        tblFormulacaoMP.setEnabled(false);
        tblFormulacaoCond.setEnabled(false);
        btnFiltroMP.setEnabled(false);
        btnFiltroCond.setEnabled(false);
        btnSalvar.setEnabled(false);
    }

    public void habilitarTudo() {
        tfdBatelada.setEditable(true);
        tfdPercentualMP.setEditable(true);
        tfdPercentualCond.setEditable(true);
        btnAddMP.setEnabled(true);
        btnAddCond.setEnabled(true);
        btnRemMP.setEnabled(true);
        btnRemCond.setEnabled(true);
        tfdBuscaMP.setEnabled(true);
        tfdBuscaCond.setEnabled(true);
        tblEsquerdaMP.setEnabled(true);
        tblEsquerdaCond.setEnabled(true);
        tblFormulacaoMP.setEnabled(true);
        tblFormulacaoCond.setEnabled(true);
        btnFiltroMP.setEnabled(true);
        btnFiltroCond.setEnabled(true);
        btnSalvar.setEnabled(true);
    }

    private void inicializarTabelaMP() {
        itemFormulacaoDAO.popularTabelaEsquerda(tblEsquerdaMP, 1, "Matéria Prima", "('')", "");
    }

    private void inicializarTabelaCond() {
        itemFormulacaoDAO.popularTabelaEsquerda(tblEsquerdaCond, 1, "Condimentos", "('')", "");
    }

    private void somaSubTotaisMP() {
        itemFormulacaoDAO.somaSubtotal(tblFormulacaoMP, tfdSomaPercentualMP, 2);
        itemFormulacaoDAO.somaSubtotal(tblFormulacaoMP, tfdSomaKgMP, 3);
        itemFormulacaoDAO.somaSubtotal(tblFormulacaoMP, tfdSomaR$KgMP, 4);
        itemFormulacaoDAO.somaSubtotal(tblFormulacaoMP, tfdSomaR$KgProdMP, 5);
        itemFormulacaoDAO.somaSubtotal(tblFormulacaoMP, tfdSomaUmidadeMP, 6);
        itemFormulacaoDAO.somaSubtotal(tblFormulacaoMP, tfdSomaGorduraMP, 7);
        itemFormulacaoDAO.somaSubtotal(tblFormulacaoMP, tfdSomaProteinaMP, 8);
    }

    private void somaSubTotaisCond() {
        itemFormulacaoDAO.somaSubtotal(tblFormulacaoCond, tfdSomaPercentualCond, 2);
        itemFormulacaoDAO.somaSubtotal(tblFormulacaoCond, tfdSomaKgCond, 3);
        itemFormulacaoDAO.somaSubtotal(tblFormulacaoCond, tfdSomaR$KgCond, 4);
        itemFormulacaoDAO.somaSubtotal(tblFormulacaoCond, tfdSomaR$KgProdCond, 5);
        itemFormulacaoDAO.somaSubtotal(tblFormulacaoCond, tfdSomaUmidadeCond, 6);
        itemFormulacaoDAO.somaSubtotal(tblFormulacaoCond, tfdSomaGorduraCond, 7);
        itemFormulacaoDAO.somaSubtotal(tblFormulacaoCond, tfdSomaProteinaCond, 8);
    }

    private void somaTotais() {
        itemFormulacaoDAO.somaTotal(tfdSomaPercentualTotal, tfdSomaPercentualMP, tfdSomaPercentualCond);
        itemFormulacaoDAO.somaTotal(tfdSomaKgTotal, tfdSomaKgMP, tfdSomaKgCond);
        itemFormulacaoDAO.somaTotal(tfdSomaR$KgTotal, tfdSomaR$KgMP, tfdSomaR$KgCond);
        itemFormulacaoDAO.somaTotal(tfdSomaR$KgProdTotal, tfdSomaR$KgProdMP, tfdSomaR$KgProdCond);
        itemFormulacaoDAO.somaTotal(tfdSomaUmidadeTotal, tfdSomaUmidadeMP, tfdSomaUmidadeCond);
        itemFormulacaoDAO.somaTotal(tfdSomaGorduraTotal, tfdSomaGorduraMP, tfdSomaGorduraCond);
        itemFormulacaoDAO.somaTotal(tfdSomaProteinaTotal, tfdSomaProteinaMP, tfdSomaProteinaCond);
    }

    private void somaSubTotaisMP2() {
        itemFormulacaoDAO.somaSubtotal(tblFormulacaoMP1, tfdSomaPercentualMP1, 2);
        itemFormulacaoDAO.somaSubtotal(tblFormulacaoMP1, tfdSomaKgMP1, 3);
        itemFormulacaoDAO.somaSubtotal(tblFormulacaoMP1, tfdSomaR$KgMP1, 4);
        itemFormulacaoDAO.somaSubtotal(tblFormulacaoMP1, tfdSomaR$KgProdMP1, 5);
        itemFormulacaoDAO.somaSubtotal(tblFormulacaoMP1, tfdSomaUmidadeMP1, 6);
        itemFormulacaoDAO.somaSubtotal(tblFormulacaoMP1, tfdSomaGorduraMP1, 7);
        itemFormulacaoDAO.somaSubtotal(tblFormulacaoMP1, tfdSomaProteinaMP1, 8);
    }

    private void somaSubTotaisCond2() {
        itemFormulacaoDAO.somaSubtotal(tblFormulacaoCond1, tfdSomaPercentualCond1, 2);
        itemFormulacaoDAO.somaSubtotal(tblFormulacaoCond1, tfdSomaKgCond1, 3);
        itemFormulacaoDAO.somaSubtotal(tblFormulacaoCond1, tfdSomaR$KgCond1, 4);
        itemFormulacaoDAO.somaSubtotal(tblFormulacaoCond1, tfdSomaR$KgProdCond1, 5);
        itemFormulacaoDAO.somaSubtotal(tblFormulacaoCond1, tfdSomaUmidadeCond1, 6);
        itemFormulacaoDAO.somaSubtotal(tblFormulacaoCond1, tfdSomaGorduraCond1, 7);
        itemFormulacaoDAO.somaSubtotal(tblFormulacaoCond1, tfdSomaProteinaCond1, 8);
    }

    private void somaTotais2() {
        itemFormulacaoDAO.somaTotal(tfdSomaPercentualTotal1, tfdSomaPercentualMP1, tfdSomaPercentualCond1);
        itemFormulacaoDAO.somaTotal(tfdSomaKgTotal1, tfdSomaKgMP1, tfdSomaKgCond1);
        itemFormulacaoDAO.somaTotal(tfdSomaR$KgTotal1, tfdSomaR$KgMP1, tfdSomaR$KgCond1);
        itemFormulacaoDAO.somaTotal(tfdSomaR$KgProdTotal1, tfdSomaR$KgProdMP1, tfdSomaR$KgProdCond1);
        itemFormulacaoDAO.somaTotal(tfdSomaUmidadeTotal1, tfdSomaUmidadeMP1, tfdSomaUmidadeCond1);
        itemFormulacaoDAO.somaTotal(tfdSomaGorduraTotal1, tfdSomaGorduraMP1, tfdSomaGorduraCond1);
        itemFormulacaoDAO.somaTotal(tfdSomaProteinaTotal1, tfdSomaProteinaMP1, tfdSomaProteinaCond1);
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

    public static void tblBranco(JTable tbl) {
        tbl.setBackground(Color.white);
    }

    public static void tblAmarelo(JTable tbl) {
        tbl.setBackground(Color.yellow);
    }

    public void produtoInvalido() {
        jcbAmarelo(cmbProduto);
        cmbProduto.requestFocus();
    }

    public void bateladaInvalido() {
        tfdAmarelo(tfdBatelada);
        tfdBranco(tfdBuscaMP);
        tfdBranco(tfdBuscaCond);
        tblBranco(tblEsquerdaMP);
        tblBranco(tblEsquerdaCond);
        tfdBatelada.requestFocus();
    }

    public void percentualMpInvalido() {
        tfdBranco(tfdBatelada);
        tfdAmarelo(tfdPercentualMP);
        tfdBranco(tfdPercentualCond);
        tblBranco(tblEsquerdaMP);
        tblBranco(tblEsquerdaCond);
        tfdPercentualMP.requestFocus();
    }

    public void percentualCondInvalido() {
        tfdBranco(tfdBatelada);
        tfdBranco(tfdPercentualMP);
        tfdAmarelo(tfdPercentualCond);
        tblBranco(tblEsquerdaMP);
        tblBranco(tblEsquerdaCond);
        tfdPercentualCond.requestFocus();
    }

    public void percentualTotalInvalido(JTextField jt) {
        tfdBranco(tfdBatelada);
        tfdBranco(tfdPercentualMP);
        tfdBranco(tfdPercentualCond);
        tblBranco(tblEsquerdaMP);
        tblBranco(tblEsquerdaCond);
        tfdAmarelo(tfdSomaPercentualTotal);
        tfdAmarelo(jt);
        jt.requestFocus();
    }

    public void TabelaEsqMPInvalido() {
        tfdBranco(tfdBatelada);
        tfdBranco(tfdPercentualMP);
        tfdBranco(tfdPercentualCond);
        tblAmarelo(tblEsquerdaMP);
        tblBranco(tblEsquerdaCond);
        tblEsquerdaMP.requestFocus();
    }

    public void TabelaEsqCondInvalido() {
        tfdBranco(tfdBatelada);
        tfdBranco(tfdPercentualMP);
        tfdBranco(tfdPercentualCond);
        tblBranco(tblEsquerdaMP);
        tblAmarelo(tblEsquerdaCond);
        tblEsquerdaCond.requestFocus();
    }

    public void TabelaFormulacaoMPInvalido() {
        tblBranco(tblFormulacaoCond);
        tblAmarelo(tblFormulacaoMP);
        tblFormulacaoMP.requestFocus();
    }

    public void TabelaFormulacaoCondInvalido() {
        tblBranco(tblFormulacaoMP);
        tblAmarelo(tblFormulacaoCond);
        tblFormulacaoCond.requestFocus();
    }

    public void resetCor() {
        tfdBranco(tfdBatelada);
        tfdBranco(tfdPercentualMP);
        tfdBranco(tfdPercentualCond);
        tblBranco(tblEsquerdaMP);
        tblBranco(tblEsquerdaCond);
        tblBranco(tblFormulacaoCond);
        tblBranco(tblFormulacaoMP);
        tfdSomaPercentualTotal.setBackground(null);
    }

    public void limparCamposFormulacao() {
        tfdBatelada.setText("");

        inicializarTabelaMP();
        inicializarTabelaCond();
        DefaultTableModel model = (DefaultTableModel) tblFormulacaoMP.getModel();
        model.setRowCount(0);
        DefaultTableModel model2 = (DefaultTableModel) tblFormulacaoCond.getModel();
        model2.setRowCount(0);
        somaSubTotaisMP();
        somaSubTotaisCond();
        somaTotais();
    }

    public void desabilitarCriarFomulacao() {
        cmbProduto.setEnabled(false);
        btnCriarFormulacao.setEnabled(false);
    }

    public void habilitarCriarFomulacao() {
        cmbProduto.setEnabled(true);
        btnCriarFormulacao.setEnabled(true);
    }

    public String getValoresColunaMP() {
        ArrayList<String> materiais = new ArrayList<String>();
        DefaultTableModel model = (DefaultTableModel) tblFormulacaoMP.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            materiais.add("('" + String.valueOf(model.getValueAt(i, 1)) + "')");
        }
        String a = materiais.toString().substring(1, materiais.toString().length() - 1);
        System.out.println("Materiais presentes na tabela de Formulação MP: " + a);
        return a;
    }

    public String getValoresColunaCond() {
        ArrayList<String> materiais = new ArrayList<String>();
        DefaultTableModel model = (DefaultTableModel) tblFormulacaoCond.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            materiais.add("('" + String.valueOf(model.getValueAt(i, 1)) + "')");
        }
        String a = materiais.toString().substring(1, materiais.toString().length() - 1);

        System.out.println("Materiais presentes na tabela de Formulação Cond: " + a);
        return a;
    }

    public boolean maiorQue100(String a, String b) {
        boolean f = true;
        double c = Double.parseDouble(a);
        double d = Double.parseDouble(b);
        double e = c + d;
        if (e > 100) {
            f = false;
        }
        return f;
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
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        tffDataLancamento = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbProduto = new javax.swing.JComboBox<>();
        btnCriarFormulacao = new javax.swing.JButton();
        btnAddMP = new javax.swing.JButton();
        tfdPercentualMP = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblEsquerdaMP = new javax.swing.JTable();
        tfdBuscaMP = new javax.swing.JTextField();
        btnFiltroMP = new javax.swing.JButton();
        btnRemMP = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tfdBatelada = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblFormulacaoMP = new javax.swing.JTable();
        btnFechar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblEsquerdaCond = new javax.swing.JTable();
        tfdBuscaCond = new javax.swing.JTextField();
        btnFiltroCond = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfdPercentualCond = new javax.swing.JTextField();
        btnAddCond = new javax.swing.JButton();
        btnRemCond = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblFormulacaoCond = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        tfdSomaPercentualCond = new javax.swing.JTextField();
        tfdSomaKgCond = new javax.swing.JTextField();
        tfdSomaR$KgCond = new javax.swing.JTextField();
        tfdSomaR$KgProdCond = new javax.swing.JTextField();
        tfdSomaUmidadeCond = new javax.swing.JTextField();
        tfdSomaGorduraCond = new javax.swing.JTextField();
        tfdSomaProteinaCond = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfdSomaPercentualTotal = new javax.swing.JTextField();
        tfdSomaKgTotal = new javax.swing.JTextField();
        tfdSomaR$KgTotal = new javax.swing.JTextField();
        tfdSomaR$KgProdTotal = new javax.swing.JTextField();
        tfdSomaUmidadeTotal = new javax.swing.JTextField();
        tfdSomaGorduraTotal = new javax.swing.JTextField();
        tfdSomaProteinaTotal = new javax.swing.JTextField();
        tfdSomaPercentualMP = new javax.swing.JTextField();
        tfdSomaKgMP = new javax.swing.JTextField();
        tfdSomaR$KgMP = new javax.swing.JTextField();
        tfdSomaR$KgProdMP = new javax.swing.JTextField();
        tfdSomaUmidadeMP = new javax.swing.JTextField();
        tfdSomaGorduraMP = new javax.swing.JTextField();
        tfdSomaProteinaMP = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblFormulacaoMP1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        tfdSomaPercentualMP1 = new javax.swing.JTextField();
        tfdSomaKgMP1 = new javax.swing.JTextField();
        tfdSomaR$KgMP1 = new javax.swing.JTextField();
        tfdSomaR$KgProdMP1 = new javax.swing.JTextField();
        tfdSomaUmidadeMP1 = new javax.swing.JTextField();
        tfdSomaGorduraMP1 = new javax.swing.JTextField();
        tfdSomaProteinaMP1 = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblFormulacaoCond1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        tfdSomaPercentualCond1 = new javax.swing.JTextField();
        tfdSomaKgCond1 = new javax.swing.JTextField();
        tfdSomaR$KgCond1 = new javax.swing.JTextField();
        tfdSomaR$KgProdCond1 = new javax.swing.JTextField();
        tfdSomaUmidadeCond1 = new javax.swing.JTextField();
        tfdSomaGorduraCond1 = new javax.swing.JTextField();
        tfdSomaProteinaCond1 = new javax.swing.JTextField();
        tfdSomaProteinaTotal1 = new javax.swing.JTextField();
        tfdSomaGorduraTotal1 = new javax.swing.JTextField();
        tfdSomaUmidadeTotal1 = new javax.swing.JTextField();
        tfdSomaR$KgProdTotal1 = new javax.swing.JTextField();
        tfdSomaR$KgTotal1 = new javax.swing.JTextField();
        tfdSomaKgTotal1 = new javax.swing.JTextField();
        tfdSomaPercentualTotal1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblConsultaFormulacao = new javax.swing.JTable();
        btnPopularTBL = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnFechar1 = new javax.swing.JButton();
        tfdFiltraForm = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnFechar2 = new javax.swing.JButton();

        setTitle("Inserir Formulação");

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(2232, 1100));

        jLabel4.setText("Data:");

        jLabel5.setText("Produto: (*)");

        cmbProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnCriarFormulacao.setText("Criar Formulação");
        btnCriarFormulacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarFormulacaoActionPerformed(evt);
            }
        });

        btnAddMP.setText(">>");
        btnAddMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMPActionPerformed(evt);
            }
        });

        jLabel1.setText("Percentual: (*)");

        tblEsquerdaMP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Título 1"
            }
        ));
        jScrollPane7.setViewportView(tblEsquerdaMP);

        btnFiltroMP.setText("Filtrar");
        btnFiltroMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltroMPActionPerformed(evt);
            }
        });

        btnRemMP.setText("<<");
        btnRemMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemMPActionPerformed(evt);
            }
        });

        jLabel3.setText("Batelada: (*)");

        jLabel6.setText("SubTotal Matéria Prima");

        tblFormulacaoMP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descricão", "Percentual", "KG", "R$/KG", "R$/KG Prod", "Umidade", "Gordura", "Proteína"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblFormulacaoMP);
        if (tblFormulacaoMP.getColumnModel().getColumnCount() > 0) {
            tblFormulacaoMP.getColumnModel().getColumn(0).setResizable(false);
            tblFormulacaoMP.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblFormulacaoMP.getColumnModel().getColumn(1).setResizable(false);
            tblFormulacaoMP.getColumnModel().getColumn(1).setPreferredWidth(170);
            tblFormulacaoMP.getColumnModel().getColumn(2).setResizable(false);
            tblFormulacaoMP.getColumnModel().getColumn(3).setResizable(false);
            tblFormulacaoMP.getColumnModel().getColumn(4).setResizable(false);
            tblFormulacaoMP.getColumnModel().getColumn(5).setResizable(false);
            tblFormulacaoMP.getColumnModel().getColumn(6).setResizable(false);
            tblFormulacaoMP.getColumnModel().getColumn(7).setResizable(false);
            tblFormulacaoMP.getColumnModel().getColumn(8).setResizable(false);
        }

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

        jLabel13.setText("(*) Campos Obrigatórios");

        tblEsquerdaCond.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Título 1"
            }
        ));
        jScrollPane8.setViewportView(tblEsquerdaCond);

        btnFiltroCond.setText("Filtrar");
        btnFiltroCond.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltroCondActionPerformed(evt);
            }
        });

        jLabel2.setText("Percentual: (*)");

        btnAddCond.setText(">>");
        btnAddCond.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCondActionPerformed(evt);
            }
        });

        btnRemCond.setText("<<");
        btnRemCond.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemCondActionPerformed(evt);
            }
        });

        tblFormulacaoCond.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descricão", "Percentual", "KG", "R$/KG", "R$/KG Prod", "Umidade", "Gordura", "Proteína"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblFormulacaoCond);
        if (tblFormulacaoCond.getColumnModel().getColumnCount() > 0) {
            tblFormulacaoCond.getColumnModel().getColumn(0).setResizable(false);
            tblFormulacaoCond.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblFormulacaoCond.getColumnModel().getColumn(1).setResizable(false);
            tblFormulacaoCond.getColumnModel().getColumn(1).setPreferredWidth(170);
            tblFormulacaoCond.getColumnModel().getColumn(2).setResizable(false);
            tblFormulacaoCond.getColumnModel().getColumn(3).setResizable(false);
            tblFormulacaoCond.getColumnModel().getColumn(4).setResizable(false);
            tblFormulacaoCond.getColumnModel().getColumn(5).setResizable(false);
            tblFormulacaoCond.getColumnModel().getColumn(6).setResizable(false);
            tblFormulacaoCond.getColumnModel().getColumn(7).setResizable(false);
            tblFormulacaoCond.getColumnModel().getColumn(8).setResizable(false);
        }

        jLabel7.setText("SubTotal Condimentos");

        jLabel8.setText("Total");

        tfdSomaPercentualTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdSomaPercentualTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCriarFormulacao, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tffDataLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnFechar))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(tfdBuscaCond, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(btnFiltroCond))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(tfdPercentualCond)
                                                .addComponent(btnAddCond, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnRemCond, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                            .addGap(8, 8, 8)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(tfdSomaPercentualTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(tfdSomaKgTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(tfdSomaR$KgTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(tfdSomaR$KgProdTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(tfdSomaUmidadeTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(tfdSomaGorduraTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(tfdSomaProteinaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel7)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(tfdSomaPercentualCond, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(tfdSomaKgCond, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(tfdSomaR$KgCond, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(tfdSomaR$KgProdCond, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(tfdSomaUmidadeCond, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(tfdSomaGorduraCond, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(tfdSomaProteinaCond, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(tfdBuscaMP, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnFiltroMP)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfdBatelada, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tfdPercentualMP)
                                            .addComponent(btnAddMP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnRemMP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(8, 8, 8)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(tfdSomaPercentualMP, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tfdSomaKgMP, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tfdSomaR$KgMP, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tfdSomaR$KgProdMP, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tfdSomaUmidadeMP, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tfdSomaGorduraMP, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tfdSomaProteinaMP, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(999, 999, 999))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tffDataLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCriarFormulacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdBuscaMP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltroMP)
                    .addComponent(tfdBatelada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfdPercentualMP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAddMP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemMP))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfdSomaProteinaMP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfdSomaGorduraMP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfdSomaUmidadeMP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfdSomaR$KgProdMP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfdSomaR$KgMP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfdSomaKgMP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfdSomaPercentualMP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdBuscaCond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltroCond))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfdSomaProteinaCond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdSomaGorduraCond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdSomaUmidadeCond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdSomaR$KgProdCond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdSomaR$KgCond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdSomaKgCond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdSomaPercentualCond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfdPercentualCond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAddCond)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemCond))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdSomaProteinaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdSomaGorduraTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdSomaUmidadeTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdSomaR$KgProdTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdSomaR$KgTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdSomaKgTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdSomaPercentualTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFechar)
                    .addComponent(btnSalvar)
                    .addComponent(jLabel13))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Inserir", jPanel1);

        tblFormulacaoMP1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descricão", "Percentual", "KG", "R$/KG", "R$/KG Prod", "Umidade", "Gordura", "Proteína"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblFormulacaoMP1);
        if (tblFormulacaoMP1.getColumnModel().getColumnCount() > 0) {
            tblFormulacaoMP1.getColumnModel().getColumn(0).setResizable(false);
            tblFormulacaoMP1.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblFormulacaoMP1.getColumnModel().getColumn(1).setResizable(false);
            tblFormulacaoMP1.getColumnModel().getColumn(1).setPreferredWidth(170);
            tblFormulacaoMP1.getColumnModel().getColumn(2).setResizable(false);
            tblFormulacaoMP1.getColumnModel().getColumn(3).setResizable(false);
            tblFormulacaoMP1.getColumnModel().getColumn(4).setResizable(false);
            tblFormulacaoMP1.getColumnModel().getColumn(5).setResizable(false);
            tblFormulacaoMP1.getColumnModel().getColumn(6).setResizable(false);
            tblFormulacaoMP1.getColumnModel().getColumn(7).setResizable(false);
            tblFormulacaoMP1.getColumnModel().getColumn(8).setResizable(false);
        }

        jLabel9.setText("SubTotal Matéria Prima");

        tblFormulacaoCond1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Percentual", "KG", "R$/KG", "R$/KG Prod", "Umidade", "Gordura", "Proteína"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(tblFormulacaoCond1);
        if (tblFormulacaoCond1.getColumnModel().getColumnCount() > 0) {
            tblFormulacaoCond1.getColumnModel().getColumn(0).setResizable(false);
            tblFormulacaoCond1.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblFormulacaoCond1.getColumnModel().getColumn(1).setResizable(false);
            tblFormulacaoCond1.getColumnModel().getColumn(1).setPreferredWidth(170);
            tblFormulacaoCond1.getColumnModel().getColumn(2).setResizable(false);
            tblFormulacaoCond1.getColumnModel().getColumn(3).setResizable(false);
            tblFormulacaoCond1.getColumnModel().getColumn(4).setResizable(false);
            tblFormulacaoCond1.getColumnModel().getColumn(6).setResizable(false);
            tblFormulacaoCond1.getColumnModel().getColumn(7).setResizable(false);
            tblFormulacaoCond1.getColumnModel().getColumn(8).setResizable(false);
        }

        jLabel10.setText("SubTotal Condimentos");

        jLabel11.setText("Total");

        tblConsultaFormulacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título 1", "Título 2", "Título 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane10.setViewportView(tblConsultaFormulacao);
        if (tblConsultaFormulacao.getColumnModel().getColumnCount() > 0) {
            tblConsultaFormulacao.getColumnModel().getColumn(0).setResizable(false);
            tblConsultaFormulacao.getColumnModel().getColumn(1).setResizable(false);
            tblConsultaFormulacao.getColumnModel().getColumn(2).setResizable(false);
        }

        btnPopularTBL.setText("Pesquisar");
        btnPopularTBL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPopularTBLActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Visualizar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAtualizar.setText("Editar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnFechar1.setText("Fechar");
        btnFechar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFechar1ActionPerformed(evt);
            }
        });

        jLabel12.setText("Filtrar");

        btnFechar2.setText("Fechar");
        btnFechar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFechar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnFechar2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnPopularTBL, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnExcluir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfdFiltraForm, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(284, 284, 284))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane9)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(18, 18, 18)
                            .addComponent(tfdSomaPercentualMP1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(tfdSomaKgMP1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(tfdSomaR$KgMP1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(tfdSomaR$KgProdMP1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(tfdSomaUmidadeMP1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(tfdSomaGorduraMP1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(tfdSomaProteinaMP1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(9, 9, 9))
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(tfdSomaPercentualCond1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfdSomaKgCond1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfdSomaR$KgCond1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfdSomaR$KgProdCond1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfdSomaUmidadeCond1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfdSomaGorduraCond1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfdSomaProteinaCond1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(tfdSomaPercentualTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfdSomaKgTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfdSomaR$KgTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfdSomaR$KgProdTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfdSomaUmidadeTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfdSomaGorduraTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfdSomaProteinaTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(8, 8, 8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 922, Short.MAX_VALUE)
                .addComponent(btnFechar1)
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPopularTBL)
                    .addComponent(tfdFiltraForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAtualizar))
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfdSomaPercentualMP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(tfdSomaKgMP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfdSomaProteinaMP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfdSomaGorduraMP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfdSomaUmidadeMP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfdSomaR$KgProdMP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfdSomaR$KgMP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdSomaProteinaCond1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdSomaGorduraCond1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdSomaUmidadeCond1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdSomaR$KgProdCond1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdSomaR$KgCond1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdSomaKgCond1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdSomaPercentualCond1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdSomaProteinaTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdSomaGorduraTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdSomaUmidadeTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdSomaR$KgProdTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdSomaR$KgTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdSomaKgTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdSomaPercentualTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFechar1)
                    .addComponent(btnFechar2))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consultar", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 2229, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
        );

        setBounds(0, 0, 1251, 648);
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        formulacaoDAO.popularTabela(tblConsultaFormulacao, "gerform");
        tblConsultaFormulacao.removeAll();
        DefaultTableModel modelTblFormMP1 = (DefaultTableModel) tblFormulacaoMP1.getModel();
        modelTblFormMP1.setRowCount(0);

        new CombosDAOForm().popularCombo("produto", cmbProduto, "N");

        DefaultTableModel modelTblFormCond1 = (DefaultTableModel) tblFormulacaoCond1.getModel();
        modelTblFormCond1.setRowCount(0);
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void btnFechar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFechar1ActionPerformed
        dispose();
    }//GEN-LAST:event_btnFechar1ActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        if (tblConsultaFormulacao.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um item antes de Atualiza-lo");
            tblConsultaFormulacao.setBackground(Color.yellow);
        } else {
            tblConsultaFormulacao.setBackground(Color.white);
            habilitarTudo();
            desabilitarCriarFomulacao();

            DefaultTableModel model = (DefaultTableModel) tblConsultaFormulacao.getModel();
            int id = Integer.parseInt(model.getValueAt(tblConsultaFormulacao.getSelectedRow(), 0).toString());
            idAtualizar = id;
            System.out.println("ID da formulação a ser atualizada: " + id);

            formulacaoDAO.popularTabelaConsultaFormulacao(tblFormulacaoMP, id, "", 1);
            formulacaoDAO.popularTabelaConsultaFormulacao(tblFormulacaoCond, id, "", 2);
            inicializarTabelaMP();
            inicializarTabelaCond();

            somaSubTotaisMP();
            somaSubTotaisCond();
            somaTotais();
            tfdBatelada.setText(tfdSomaKgTotal.getText());
            jTabbedPane1.setSelectedIndex(0);

            itemFormulacaoDAO.popularTabelaEsquerda(tblEsquerdaMP, 1, "Matéria Prima", getValoresColunaMP(), "");
            itemFormulacaoDAO.popularTabelaEsquerda(tblEsquerdaCond, 2, "Condimentos", getValoresColunaCond(), "");
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        String codigoS;
        if (tblConsultaFormulacao.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um item antes de excluí-lo");
            tblConsultaFormulacao.setBackground(Color.yellow);
        } else {

            tblConsultaFormulacao.setBackground(Color.white);
            codigoS = String.valueOf(tblConsultaFormulacao.getValueAt(tblConsultaFormulacao.getSelectedRow(), 0));

            itemFormulacaoDAO.Excluir(Integer.parseInt(codigoS));
            String retorno = formulacaoDAO.Excluir(Integer.parseInt(codigoS));

            if (retorno == null) {
                JOptionPane.showMessageDialog(null, "Formulação excluída com sucesso!");

                formulacaoDAO.popularTabela(tblConsultaFormulacao, "");
                DefaultTableModel modelTblFormMP1 = (DefaultTableModel) tblFormulacaoMP1.getModel();
                modelTblFormMP1.setRowCount(0);
                formulacaoDAO.definirFormulacao(Integer.parseInt(codigoS), "N");
                new CombosDAOForm().popularCombo("produto", cmbProduto, "N");

                DefaultTableModel modelTblFormCond1 = (DefaultTableModel) tblFormulacaoCond1.getModel();
                modelTblFormCond1.setRowCount(0);

                somaSubTotaisMP2();
                somaSubTotaisCond2();
                somaTotais2();
                
                TelaPrincipal.getInstance().atualizaGrafEsquerda();
                TelaPrincipal.getInstance().atualizaGrafDireita();

            } else {
                JOptionPane.showMessageDialog(null, "Erro ao excluir Formulação!");
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        if (tblConsultaFormulacao.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um item antes de prosseguir");
            tblConsultaFormulacao.setBackground(Color.yellow);
        } else {

            tblConsultaFormulacao.setBackground(Color.white);
            DefaultTableModel model = (DefaultTableModel) tblConsultaFormulacao.getModel();
            int id = Integer.parseInt(model.getValueAt(tblConsultaFormulacao.getSelectedRow(), 0).toString());

            formulacaoDAO.popularTabelaConsultaFormulacao(tblFormulacaoMP1, id, "", 1);
            formulacaoDAO.popularTabelaConsultaFormulacao(tblFormulacaoCond1, id, "", 2);
            somaSubTotaisMP2();
            somaSubTotaisCond2();
            somaTotais2();
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnPopularTBLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPopularTBLActionPerformed
        formulacaoDAO.popularTabela(tblConsultaFormulacao, tfdFiltraForm.getText());
        DefaultTableModel modelTblFormMP1 = (DefaultTableModel) tblFormulacaoMP1.getModel();
        modelTblFormMP1.setRowCount(0);

        DefaultTableModel modelTblFormCond1 = (DefaultTableModel) tblFormulacaoCond1.getModel();
        modelTblFormCond1.setRowCount(0);

        somaSubTotaisMP2();
        somaSubTotaisCond2();
        somaTotais2();
    }//GEN-LAST:event_btnPopularTBLActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        if (Double.parseDouble(tfdSomaPercentualTotal.getText()) == 100.0) {

            DefaultTableModel modelMP = (DefaultTableModel) tblFormulacaoMP.getModel();
            DefaultTableModel modelCond = (DefaultTableModel) tblFormulacaoCond.getModel();

            String retorno = "gerform";
            // populado objeto
            Formulacao f = new FormulacaoDAO().consultarId((getIdAtualizar()));
            ItemFormulacaoDAO itemFormulacaoDAO = new ItemFormulacaoDAO();

            if (f != null) {
                //atualiza

                new FormulacaoDAO().Excluir(getIdAtualizar());
                for (int lin = 0; lin < modelMP.getRowCount(); lin++) {
                    ItemFormulacao itemFormulacao = new ItemFormulacao();

                    itemFormulacao.setMaterialID(Integer.parseInt(modelMP.getValueAt(lin, 0).toString()));
                    itemFormulacao.setPercentual(Double.parseDouble(modelMP.getValueAt(lin, 2).toString()));
                    itemFormulacao.setKg(Double.parseDouble(modelMP.getValueAt(lin, 3).toString()));
                    itemFormulacao.setPrecoKg(Double.parseDouble(modelMP.getValueAt(lin, 4).toString()));
                    itemFormulacao.setPrecoKgProd(Double.parseDouble(modelMP.getValueAt(lin, 5).toString()));
                    itemFormulacao.setUmidade(Double.parseDouble(modelMP.getValueAt(lin, 6).toString()));
                    itemFormulacao.setGordura(Double.parseDouble(modelMP.getValueAt(lin, 7).toString()));
                    itemFormulacao.setProteina(Double.parseDouble(modelMP.getValueAt(lin, 8).toString()));
                    itemFormulacao.setProdutoID(getIdAtualizar());
                    itemFormulacao.setFormulacao_ver(1);

                    retorno = new ItemFormulacaoDAO().Salvar(itemFormulacao);
                }
                for (int lin = 0; lin < modelCond.getRowCount(); lin++) {
                    ItemFormulacao itemFormulacao = new ItemFormulacao();

                    itemFormulacao.setMaterialID(Integer.parseInt(modelCond.getValueAt(lin, 0).toString()));
                    itemFormulacao.setPercentual(Double.parseDouble(modelCond.getValueAt(lin, 2).toString()));
                    itemFormulacao.setKg(Double.parseDouble(modelCond.getValueAt(lin, 3).toString()));
                    itemFormulacao.setPrecoKg(Double.parseDouble(modelCond.getValueAt(lin, 4).toString()));
                    itemFormulacao.setPrecoKgProd(Double.parseDouble(modelCond.getValueAt(lin, 5).toString()));
                    itemFormulacao.setUmidade(Double.parseDouble(modelCond.getValueAt(lin, 6).toString()));
                    itemFormulacao.setGordura(Double.parseDouble(modelCond.getValueAt(lin, 7).toString()));
                    itemFormulacao.setProteina(Double.parseDouble(modelCond.getValueAt(lin, 8).toString()));
                    itemFormulacao.setProdutoID(getIdAtualizar());
                    itemFormulacao.setFormulacao_ver(1);

                    retorno = new ItemFormulacaoDAO().Salvar(itemFormulacao);
                }
//                for (int lin = 0; lin < modelMP.getRowCount(); lin++) {
//
//                    itemFormulacao.setMaterialID(Integer.parseInt(modelMP.getValueAt(lin, 0).toString()));
//                    itemFormulacao.setPercentual(Double.parseDouble(modelMP.getValueAt(lin, 2).toString()));
//                    itemFormulacao.setKg(Double.parseDouble(modelMP.getValueAt(lin, 3).toString()));
//                    itemFormulacao.setPrecoKg(Double.parseDouble(modelMP.getValueAt(lin, 4).toString()));
//                    itemFormulacao.setPrecoKgProd(Double.parseDouble(modelMP.getValueAt(lin, 5).toString()));
//                    itemFormulacao.setUmidade(Double.parseDouble(modelMP.getValueAt(lin, 6).toString()));
//                    itemFormulacao.setGordura(Double.parseDouble(modelMP.getValueAt(lin, 7).toString()));
//                    itemFormulacao.setProteina(Double.parseDouble(modelMP.getValueAt(lin, 8).toString()));
//                    itemFormulacao.setProdutoID(getIdAtualizar());
//                    itemFormulacao.setFormulacao_ver(1);
//
//                    retorno = itemFormulacaoDAO.atualizar(itemFormulacao, 1);
//                }
//
//                for (int lin = 0; lin < modelCond.getRowCount(); lin++) {
//                    itemFormulacao.setMaterialID(Integer.parseInt(modelCond.getValueAt(lin, 0).toString()));
//                    itemFormulacao.setPercentual(Double.parseDouble(modelCond.getValueAt(lin, 2).toString()));
//                    itemFormulacao.setKg(Double.parseDouble(modelCond.getValueAt(lin, 3).toString()));
//                    itemFormulacao.setPrecoKg(Double.parseDouble(modelCond.getValueAt(lin, 4).toString()));
//                    itemFormulacao.setPrecoKgProd(Double.parseDouble(modelCond.getValueAt(lin, 5).toString()));
//                    itemFormulacao.setUmidade(Double.parseDouble(modelCond.getValueAt(lin, 6).toString()));
//                    itemFormulacao.setGordura(Double.parseDouble(modelCond.getValueAt(lin, 7).toString()));
//                    itemFormulacao.setProteina(Double.parseDouble(modelCond.getValueAt(lin, 8).toString()));
//                    itemFormulacao.setProdutoID(getIdAtualizar());
//                    itemFormulacao.setFormulacao_ver(1);
//
//                    retorno = itemFormulacaoDAO.atualizar(itemFormulacao, 2);
//                }

                formulacaoDAO.adicionarCusto(getIdAtualizar(), Double.parseDouble(tfdSomaR$KgProdTotal.getText()));

            } else {
                //insere

                for (int lin = 0; lin < modelMP.getRowCount(); lin++) {
                    ItemFormulacao itemFormulacao = new ItemFormulacao();

                    itemFormulacao.setMaterialID(Integer.parseInt(modelMP.getValueAt(lin, 0).toString()));
                    itemFormulacao.setPercentual(Double.parseDouble(modelMP.getValueAt(lin, 2).toString()));
                    itemFormulacao.setKg(Double.parseDouble(modelMP.getValueAt(lin, 3).toString()));
                    itemFormulacao.setPrecoKg(Double.parseDouble(modelMP.getValueAt(lin, 4).toString()));
                    itemFormulacao.setPrecoKgProd(Double.parseDouble(modelMP.getValueAt(lin, 5).toString()));
                    itemFormulacao.setUmidade(Double.parseDouble(modelMP.getValueAt(lin, 6).toString()));
                    itemFormulacao.setGordura(Double.parseDouble(modelMP.getValueAt(lin, 7).toString()));
                    itemFormulacao.setProteina(Double.parseDouble(modelMP.getValueAt(lin, 8).toString()));
                    itemFormulacao.setProdutoID(formID);
                    itemFormulacao.setFormulacao_ver(1);

                    retorno = new ItemFormulacaoDAO().Salvar(itemFormulacao);
                }

                for (int lin = 0; lin < modelCond.getRowCount(); lin++) {
                    ItemFormulacao itemFormulacao = new ItemFormulacao();

                    itemFormulacao.setMaterialID(Integer.parseInt(modelCond.getValueAt(lin, 0).toString()));
                    itemFormulacao.setPercentual(Double.parseDouble(modelCond.getValueAt(lin, 2).toString()));
                    itemFormulacao.setKg(Double.parseDouble(modelCond.getValueAt(lin, 3).toString()));
                    itemFormulacao.setPrecoKg(Double.parseDouble(modelCond.getValueAt(lin, 4).toString()));
                    itemFormulacao.setPrecoKgProd(Double.parseDouble(modelCond.getValueAt(lin, 5).toString()));
                    itemFormulacao.setUmidade(Double.parseDouble(modelCond.getValueAt(lin, 6).toString()));
                    itemFormulacao.setGordura(Double.parseDouble(modelCond.getValueAt(lin, 7).toString()));
                    itemFormulacao.setProteina(Double.parseDouble(modelCond.getValueAt(lin, 8).toString()));
                    itemFormulacao.setProdutoID(formID);
                    itemFormulacao.setFormulacao_ver(1);

                    retorno = new ItemFormulacaoDAO().Salvar(itemFormulacao);
                }
                formulacaoDAO.adicionarCusto(formID, Double.parseDouble(tfdSomaR$KgProdTotal.getText()));
            }

            System.out.println(retorno);
            if (retorno == null) {
                JOptionPane.showMessageDialog(null, "Itens adicionados à formulação!");

                limparCamposFormulacao();
                habilitarCriarFomulacao();
                new CombosDAOForm().popularCombo("produto", cmbProduto, "N");
                desabilitarTudo();
                tffDataLancamento.setText(Formatacao.getDataHoraAtual());
                inicializarTabelaMP();
                inicializarTabelaCond();
                resetCor();
                jTabbedPane1.setEnabled(true);
                btnFechar.setEnabled(true);
                
                TelaPrincipal.getInstance().atualizaGrafEsquerda();
                TelaPrincipal.getInstance().atualizaGrafDireita();

            } else {
                JOptionPane.showMessageDialog(null, "Erro ao adicionar os itens à formulação!");
            }

        } else {
            JOptionPane.showMessageDialog(null, "O percentual Total deve ser igual a 100%!\n\nPercentual atual: " + tfdSomaPercentualTotal.getText() + "%!");
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnRemMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemMPActionPerformed
        DefaultTableModel modelMP = (DefaultTableModel) tblFormulacaoMP.getModel();

        if (tblFormulacaoMP.getSelectedRow() == -1) {
            TabelaFormulacaoMPInvalido();
            JOptionPane.showMessageDialog(null, "Você deve selecionar um item da lista antes de removê-lo");
        } else {
            int linha = tblFormulacaoMP.getSelectedRow();

            modelMP.removeRow(linha);

            if (modelMP.getRowCount() == 0) {
                itemFormulacaoDAO.popularTabelaEsquerda(tblEsquerdaMP, 1, "Matéria Prima", "('')", "");
            } else {
                itemFormulacaoDAO.popularTabelaEsquerda(tblEsquerdaMP, 1, "Matéria Prima", getValoresColunaMP(), "");
            }

            //Faz a soma do subtotal da tabela de condimentos
            somaSubTotaisMP();

            //Faz a soma dos dois subtotais
            somaTotais();

            resetCor();

        }
    }//GEN-LAST:event_btnRemMPActionPerformed

    private void btnFiltroMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltroMPActionPerformed
        DefaultTableModel modelMP = (DefaultTableModel) tblFormulacaoMP.getModel();
        if (modelMP.getRowCount() == 0) {
            itemFormulacaoDAO.popularTabelaEsquerda(tblEsquerdaMP, 1, "Matéria Prima", "('')", tfdBuscaMP.getText());
        } else {
            itemFormulacaoDAO.popularTabelaEsquerda(tblEsquerdaMP, 1, "Matéria Prima", getValoresColunaMP(), tfdBuscaMP.getText());
        }
    }//GEN-LAST:event_btnFiltroMPActionPerformed

    private void btnAddMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMPActionPerformed
        //verifica se os campos obrigatórios estão preenchidos
        if (tfdBatelada.getText().isEmpty()) {
            bateladaInvalido();
            JOptionPane.showMessageDialog(null, "Você deve informar o peso da batelada");
        } else if (tblEsquerdaMP.getSelectedRow() == -1) {
            TabelaEsqMPInvalido();
            JOptionPane.showMessageDialog(null, "Você deve selecionar um item da lista antes de inserir");
        } else if (tfdPercentualMP.getText().isEmpty()) {
            percentualMpInvalido();
            JOptionPane.showMessageDialog(null, "Você deve informar o percentual antes de inserir a matéria prima");
        } else if (Double.parseDouble(tfdPercentualMP.getText().replace(',', '.')) > 80.0) {
            percentualMpInvalido();
            JOptionPane.showMessageDialog(null, "O percentual deve ser no máximo 80,00%!");
        } else if (!maiorQue100(tfdPercentualMP.getText().replace(',', '.'), tfdSomaPercentualTotal.getText())) {
            percentualTotalInvalido(tfdPercentualMP);
            JOptionPane.showMessageDialog(null, "O percentual total não deve ser maior que 100%!\n\nPercentual atual: " + tfdSomaPercentualTotal.getText() + "%!");
        } else {
            // consulta o id do item selecionado na tabela esquerda
            int id = itemFormulacaoDAO.getId(String.valueOf(itemFormulacaoDAO.getSelection(tblEsquerdaMP)));
            System.out.println("Id do Material Selecionado na tabela esquerda: " + id);

            //calcula o peso total da matéria prima de acordo com o peso da batelada
            double percent = Double.parseDouble(tfdPercentualMP.getText().replace(',', '.'));
            double kg = Double.parseDouble(tfdBatelada.getText().replace(',', '.')) / 100 * percent;

            //adiciona o item da tabela esquerda na tabela de formulacao
            itemFormulacaoDAO.popularTabela(tblFormulacaoMP, id, percent, kg);
            //limpa o campo para o próximo item
            tfdPercentualMP.setText("");
            resetCor();

            //atualiza tabela esquerda
            itemFormulacaoDAO.popularTabelaEsquerda(tblEsquerdaMP, 1, "Matéria Prima", getValoresColunaMP(), "");
            //Faz a soma do subtotal da tabela de condimentos
            somaSubTotaisMP();

            //Faz a soma dos dois subtotais
            somaTotais();

            //limpa o campo de filtro
            tfdBuscaMP.setText("");
        }
    }//GEN-LAST:event_btnAddMPActionPerformed

    private void btnCriarFormulacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarFormulacaoActionPerformed
        Formulacao formulacao = new Formulacao();
        UsuarioLogado u = new UsuarioLogado();

        if (cmbProduto.getSelectedIndex() == 0) {
            jcbAmarelo(cmbProduto);
            cmbProduto.requestFocus();
            revisar();
        } else {

            ComboItem ci1 = (ComboItem) cmbProduto.getSelectedItem();
            formulacao.setProdutoID(ci1.getCodigo());
            formID = ci1.getCodigo();

            formulacao.setData(Formatacao.StringToDate(tffDataLancamento.getText()));
            formulacao.setUserID(u.getUsuarioLogadoID());
            formulacao.setVersao(1);

            String retorno = formulacaoDAO.Salvar(formulacao);
            jTabbedPane1.setEnabled(false);
            btnFechar.setEnabled(false);

            if (retorno == null) {
                JOptionPane.showMessageDialog(null, "Formulação criada!");

                tffDataLancamento.setText("");
                cmbProduto.setSelectedIndex(0);
                jcbBranco(cmbProduto);

                formulacaoDAO.definirFormulacao(ci1.getCodigo(), "S");
                habilitarTudo();
                desabilitarCriarFomulacao();

                TelaPrincipal.getInstance().atualizaGrafEsquerda();
                TelaPrincipal.getInstance().atualizaGrafDireita();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao criar formulacao!");
            }
        }
    }//GEN-LAST:event_btnCriarFormulacaoActionPerformed

    private void btnFiltroCondActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltroCondActionPerformed
        DefaultTableModel modelCond = (DefaultTableModel) tblFormulacaoCond.getModel();
        if (modelCond.getRowCount() == 0) {
            itemFormulacaoDAO.popularTabelaEsquerda(tblEsquerdaCond, 2, "Condimentos", "('')", tfdBuscaCond.getText());
        } else {
            itemFormulacaoDAO.popularTabelaEsquerda(tblEsquerdaCond, 2, "Condimentos", getValoresColunaCond(), tfdBuscaCond.getText());
        }
    }//GEN-LAST:event_btnFiltroCondActionPerformed

    private void btnAddCondActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCondActionPerformed
        //verifica se os campos obrigatórios estão preenchidos
        Double valor = Util.Validacao.validarLimites(itemFormulacaoDAO.getSelection(tblEsquerdaCond));
        
        if (tfdBatelada.getText().isEmpty()) {
            bateladaInvalido();
            JOptionPane.showMessageDialog(null, "Você deve informar o peso da batelada");
        } else if (tblEsquerdaCond.getSelectedRow() == -1) {
            TabelaEsqCondInvalido();
            JOptionPane.showMessageDialog(null, "Você deve selecionar um item da lista antes de inserir");
        } else if (tfdPercentualCond.getText().isEmpty()) {
            percentualCondInvalido();
            JOptionPane.showMessageDialog(null, "Você deve informar o percentual antes de inserir o condimento");
        } else if (valor != null && Double.parseDouble(tfdPercentualCond.getText().replace(',', '.')) > valor) {
            percentualCondInvalido();
            JOptionPane.showMessageDialog(null, "O percentual deve ser no máximo " + valor +"!");
        } else if (!maiorQue100(tfdPercentualCond.getText().replace(',', '.'), tfdSomaPercentualTotal.getText())) {
            percentualTotalInvalido(tfdPercentualCond);
            JOptionPane.showMessageDialog(null, "O percentual total não deve ser maior que 100%!\n\nPercentual atual: " + tfdSomaPercentualTotal.getText() + "%!");
        } else {
            // consulta o id do item selecionado na lista
            int id = itemFormulacaoDAO.getId(String.valueOf(itemFormulacaoDAO.getSelection(tblEsquerdaCond)));

            //calcula o peso total da matéria prima de acordo com o peso da batelada
            double percent = Double.parseDouble(tfdPercentualCond.getText().replace(',', '.'));
            double kg = Double.parseDouble(tfdBatelada.getText().replace(',', '.')) / 100 * percent;

            //adiciona o item da lista na JTable
            itemFormulacaoDAO.popularTabela(tblFormulacaoCond, id, percent, kg);
            tfdPercentualCond.setText("");
            resetCor();

            //atualiza tabela esquerda
            itemFormulacaoDAO.popularTabelaEsquerda(tblEsquerdaCond, 2, "Condimentos", getValoresColunaCond(), "");
            //Faz a soma do subtotal da tabela de condimentos
            somaSubTotaisCond();

            //Faz a soma dos dois subtotais
            somaTotais();

            //limpa o campo de filtro
            tfdBuscaCond.setText("");
        }
    }//GEN-LAST:event_btnAddCondActionPerformed

    private void btnRemCondActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemCondActionPerformed
        DefaultTableModel modelCond = (DefaultTableModel) tblFormulacaoCond.getModel();

        if (tblFormulacaoCond.getSelectedRow() == -1) {
            TabelaFormulacaoCondInvalido();
            JOptionPane.showMessageDialog(null, "Você deve selecionar um item da lista antes de removê-lo");
        } else {
            int linha = tblFormulacaoCond.getSelectedRow();

            modelCond.removeRow(linha);

            if (modelCond.getRowCount() == 0) {
                itemFormulacaoDAO.popularTabelaEsquerda(tblEsquerdaCond, 2, "Condimentos", "('')", "");
            } else {
                itemFormulacaoDAO.popularTabelaEsquerda(tblEsquerdaCond, 2, "Condimentos", getValoresColunaCond(), "");
            }

            //Faz a soma do subtotal da tabela de condimentos
            somaSubTotaisCond();

            //Faz a soma dos dois subtotais
            somaTotais();

            resetCor();

        }
    }//GEN-LAST:event_btnRemCondActionPerformed

    private void btnFechar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFechar2ActionPerformed
        dispose();
    }//GEN-LAST:event_btnFechar2ActionPerformed

    private void tfdSomaPercentualTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdSomaPercentualTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdSomaPercentualTotalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCond;
    private javax.swing.JButton btnAddMP;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCriarFormulacao;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnFechar1;
    private javax.swing.JButton btnFechar2;
    private javax.swing.JButton btnFiltroCond;
    private javax.swing.JButton btnFiltroMP;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnPopularTBL;
    private javax.swing.JButton btnRemCond;
    private javax.swing.JButton btnRemMP;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblConsultaFormulacao;
    private javax.swing.JTable tblEsquerdaCond;
    private javax.swing.JTable tblEsquerdaMP;
    private javax.swing.JTable tblFormulacaoCond;
    private javax.swing.JTable tblFormulacaoCond1;
    private javax.swing.JTable tblFormulacaoMP;
    private javax.swing.JTable tblFormulacaoMP1;
    private javax.swing.JTextField tfdBatelada;
    private javax.swing.JTextField tfdBuscaCond;
    private javax.swing.JTextField tfdBuscaMP;
    private javax.swing.JTextField tfdFiltraForm;
    private javax.swing.JTextField tfdPercentualCond;
    private javax.swing.JTextField tfdPercentualMP;
    private javax.swing.JTextField tfdSomaGorduraCond;
    private javax.swing.JTextField tfdSomaGorduraCond1;
    private javax.swing.JTextField tfdSomaGorduraMP;
    private javax.swing.JTextField tfdSomaGorduraMP1;
    private javax.swing.JTextField tfdSomaGorduraTotal;
    private javax.swing.JTextField tfdSomaGorduraTotal1;
    private javax.swing.JTextField tfdSomaKgCond;
    private javax.swing.JTextField tfdSomaKgCond1;
    private javax.swing.JTextField tfdSomaKgMP;
    private javax.swing.JTextField tfdSomaKgMP1;
    private javax.swing.JTextField tfdSomaKgTotal;
    private javax.swing.JTextField tfdSomaKgTotal1;
    private javax.swing.JTextField tfdSomaPercentualCond;
    private javax.swing.JTextField tfdSomaPercentualCond1;
    private javax.swing.JTextField tfdSomaPercentualMP;
    private javax.swing.JTextField tfdSomaPercentualMP1;
    private javax.swing.JTextField tfdSomaPercentualTotal;
    private javax.swing.JTextField tfdSomaPercentualTotal1;
    private javax.swing.JTextField tfdSomaProteinaCond;
    private javax.swing.JTextField tfdSomaProteinaCond1;
    private javax.swing.JTextField tfdSomaProteinaMP;
    private javax.swing.JTextField tfdSomaProteinaMP1;
    private javax.swing.JTextField tfdSomaProteinaTotal;
    private javax.swing.JTextField tfdSomaProteinaTotal1;
    private javax.swing.JTextField tfdSomaR$KgCond;
    private javax.swing.JTextField tfdSomaR$KgCond1;
    private javax.swing.JTextField tfdSomaR$KgMP;
    private javax.swing.JTextField tfdSomaR$KgMP1;
    private javax.swing.JTextField tfdSomaR$KgProdCond;
    private javax.swing.JTextField tfdSomaR$KgProdCond1;
    private javax.swing.JTextField tfdSomaR$KgProdMP;
    private javax.swing.JTextField tfdSomaR$KgProdMP1;
    private javax.swing.JTextField tfdSomaR$KgProdTotal;
    private javax.swing.JTextField tfdSomaR$KgProdTotal1;
    private javax.swing.JTextField tfdSomaR$KgTotal;
    private javax.swing.JTextField tfdSomaR$KgTotal1;
    private javax.swing.JTextField tfdSomaUmidadeCond;
    private javax.swing.JTextField tfdSomaUmidadeCond1;
    private javax.swing.JTextField tfdSomaUmidadeMP;
    private javax.swing.JTextField tfdSomaUmidadeMP1;
    private javax.swing.JTextField tfdSomaUmidadeTotal;
    private javax.swing.JTextField tfdSomaUmidadeTotal1;
    private javax.swing.JFormattedTextField tffDataLancamento;
    // End of variables declaration//GEN-END:variables
}
