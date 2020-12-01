/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entidade.ItemFormulacao;
import Entidade.Material;
import Entidade.MaterialTable;
import Entidade.PropriedadesMaterialTable;
import Entidade.UsuarioLogado;
import Util.Audita;
import static Util.HibernateUtil.sessionFactory;
import Util.Log;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import Tela.TelaPrincipal;

/**
 *
 * @author Klein
 */
public class ItemFormulacaoDAO implements IDAO_T<ItemFormulacao> {

    FormulacaoDAO formulacao = new FormulacaoDAO();

    @Override
    public String Salvar(ItemFormulacao o) {
        Session sessao = null;
        sessao = Util.HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();

        try {
            sessao = Util.HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            sessao.save(o);
            transacao.commit();

            if (TelaPrincipal.ligaAuditoria) {
                Audita.salvarAuditoria("Insert", "formulacao", UsuarioLogado.getUsuarioLogadoID());
            }

        } catch (HibernateException hibEx) {
            transacao.rollback();
            Log.geraLogBD(UsuarioLogado.getUsuarioLogadoEmail(), "Insert", hibEx.toString());
            hibEx.printStackTrace();
            return hibEx.toString();
        } finally {
            sessao.close();
        }
        return null;
    }

    public String atualizar(ItemFormulacao i, int tpMaterial) {
        Session sessao = null;
        List resultado = null;
        sessao = Util.HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        //org.hibernate.Query query = sessao.createQuery("FROM ItemFormulacao WHERE formulacao_produto_id = " + i.getProdutoID());
        org.hibernate.Query query = sessao.createQuery("FROM item_formulacao i JOIN Material m ON i.material_id=m.id"
                + " WHERE formulacao_produto_id = " + i.getProdutoID() + " AND tipo_material_id=" + tpMaterial);

        try {
            resultado = query.list();
            for (Object obj : resultado) {
                ItemFormulacao itemFormulacao = (ItemFormulacao) obj;

                itemFormulacao.setMaterialID(i.getMaterialID());
                itemFormulacao.setPercentual(i.getPercentual());
                itemFormulacao.setKg(i.getKg());
                itemFormulacao.setPrecoKg(i.getPrecoKg());
                itemFormulacao.setPrecoKgProd(i.getPrecoKgProd());
                itemFormulacao.setUmidade(i.getUmidade());
                itemFormulacao.setGordura(i.getGordura());
                itemFormulacao.setProteina(i.getProteina());
                itemFormulacao.setProdutoID(i.getProdutoID());
                itemFormulacao.setFormulacao_ver(i.getFormulacao_ver());
                sessao.update(itemFormulacao);
            }
            transacao.commit();

            if (TelaPrincipal.ligaAuditoria) {
                Audita.salvarAuditoria("Update", "itemFormulacao", UsuarioLogado.getUsuarioLogadoID());
            }

        } catch (HibernateException hibEx) {
            transacao.rollback();
            hibEx.printStackTrace();
            Log.geraLogBD(UsuarioLogado.getUsuarioLogadoEmail(), "Update", hibEx.toString());
            return hibEx.toString();
        } finally {
            sessao.close();
        }
        return null;
    }

    @Override
    public String Excluir(int id) {
        List resultado = null;
        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = Util.HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            org.hibernate.Query query = sessao.createQuery("FROM ItemFormulacao WHERE formulacao_produto_id = " + id);

            resultado = query.list();
            for (Object obj : resultado) {
                ItemFormulacao itemFormulacao = (ItemFormulacao) obj;
                sessao.delete(itemFormulacao);
            }
            transacao.commit();
        } catch (HibernateException hibEx) {
            transacao.rollback();
            Log.geraLogBD(UsuarioLogado.getUsuarioLogadoEmail(), "Exclude", hibEx.toString());
            hibEx.printStackTrace();
        }
        return null;
    }

    public String getSelection(JTable tabela) {
        int column = 0;
        int row = tabela.getSelectedRow();
        String value = tabela.getModel().getValueAt(row, column).toString();
        return value;
    }

    public void popularTabelaEsquerda(JTable tabela, int tipo, String s, String materiais, String criterio) {
        String sql = "";

        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[1];
        cabecalho[0] = s;

        switch (s) {
            case "Matéria Prima":
                tipo = 1;
                break;
            case "Condimentos":
                tipo = 2;
                break;
        }

        sql = "SELECT * FROM material WHERE tipo_material_id = " + tipo + " AND descricao NOT LIKE ALL "
                + "(VALUES" + materiais + ") AND descricao ILIKE '%" + criterio + "%' AND temPropriedades = 'S' "
                + "AND status LIKE 'Ativo'";

        Session sessao = null;
        try {

            sessao = Util.HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction transacao = sessao.beginTransaction();

            List<MaterialTable> mt = (List<MaterialTable>) sessionFactory
                    .getCurrentSession()
                    .createSQLQuery(sql)
                    .setResultTransformer(Transformers.aliasToBean(MaterialTable.class))
                    .list();

            dadosTabela = new Object[mt.size()][1];

            for (int i = 0; i < mt.size(); i++) {
                dadosTabela[i][0] = mt.get(i).getDescricao();
            }

        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            Log.geraLogBD(UsuarioLogado.getUsuarioLogadoEmail(), "query", hibEx.toString());
        } finally {
            sessao.close();
        }

        // configuracoes adicionais no componente tabela
        tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
            @Override
            // quando retorno for FALSE, a tabela nao é editavel
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            // alteracao no metodo que determina a coluna em que o objeto ImageIcon devera aparecer
            @Override
            public Class getColumnClass(int column) {

                if (column == 2) {
                    //return ImageIcon.class;
                }
                return Object.class;
            }
        });

        // permite seleção de apenas uma linha da tabela
        tabela.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < tabela.getColumnCount(); i++) {
            column = tabela.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(17);
                    break;
                case 1:
                    column.setPreferredWidth(140);
                    break;
            }
        }

    }

    public void popularTabela(JTable tabela, int id, double percentual, double kg) {
        String sql = "";
        Object[] row = new Object[9];
        Object[] col = new Object[9];
        Object[][] dadosTabela = null;
        dadosTabela = null;;

        col[0] = "Código";
        col[1] = "Descricão";
        col[2] = "Percentual";
        col[3] = "KG";
        col[4] = "R$/KG";
        col[5] = "R$/KG Prod";
        col[6] = "Umidade";
        col[7] = "Gordura";
        col[8] = "Proteína";

        if (tabela.getRowCount() < 1) {
            tabela.setModel(new DefaultTableModel(dadosTabela, col) {
                @Override
                // quando retorno for FALSE, a tabela nao é editavel
                public boolean isCellEditable(int row, int column) {
                    return false;
                }

                // alteracao no metodo que determina a coluna em que o objeto ImageIcon devera aparecer
                @Override
                public Class
                        getColumnClass(int column) {

                    if (column == 2) {
                        //                    return ImageIcon.class;
                    }
                    return Object.class;
                }
            });
        }

        sql = "SELECT m.id, m.descricao, m.precokg, p.umidade, p.gordura, p.proteina "
                + "FROM material m JOIN propriedades_material p "
                + "ON m.id=p.material_id "
                + "WHERE m.id= " + "'" + id + "'"
                + "ORDER BY m.id";

        Session sessao = null;
        try {

            sessao = Util.HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction transacao = sessao.beginTransaction();

            List<PropriedadesMaterialTable> mt = (List<PropriedadesMaterialTable>) sessionFactory
                    .getCurrentSession()
                    .createSQLQuery(sql)
                    .setResultTransformer(Transformers.aliasToBean(PropriedadesMaterialTable.class))
                    .list();

            dadosTabela = new Object[mt.size()][1];

            for (int i = 0; i < mt.size(); i++) {
                dadosTabela[i][0] = mt.get(i).getDescricao();

                BigDecimal custoKG = mt.get(i).getPrecokg();
                double custoKgProduto = percentual / 100 * custoKG.doubleValue();
                double umidade = percentual / 100 * mt.get(i).getUmidade().doubleValue();
                double gordura = percentual / 100 * mt.get(i).getGordura().doubleValue();
                double proteina = percentual / 100 * mt.get(i).getProteina().doubleValue();

                row[0] = mt.get(i).getId();
                row[1] = mt.get(i).getDescricao();
                row[2] = roundToDecimals(percentual, 2);
                row[3] = roundToDecimals(kg, 2);
                row[4] = roundToDecimals(custoKG.doubleValue(), 2);
                row[5] = roundToDecimals(custoKgProduto, 2);
                row[6] = roundToDecimals(umidade, 2);
                row[7] = roundToDecimals(gordura, 2);
                row[8] = roundToDecimals(proteina, 2);

            }

        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            Log.geraLogBD(UsuarioLogado.getUsuarioLogadoEmail(), "query", hibEx.toString());
        } finally {
            sessao.close();
        }
        // permite seleção de apenas uma linha da tabela
        tabela.setSelectionMode(0);

        //Centraliza o texto nas colunas
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();

        centralizado.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < tabela.getColumnCount(); i++) {
            tabela.getColumnModel().getColumn(i).setCellRenderer(centralizado);
        }

        DefaultTableModel model = (DefaultTableModel) tabela.getModel();

        model.addRow(row);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < tabela.getColumnCount(); i++) {
            column = tabela.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(20);
                    break;
                case 1:
                    column.setPreferredWidth(170);
                    break;
            }
        }
    }

    //Formata dados como números decimais 00,00
    public static double roundToDecimals(double d, int c) {
        int temp = (int) (d * Math.pow(10, c));
        return ((double) temp) / Math.pow(10, c);
    }

    //retorna o id do item selecionado na lista de MP/condimentos
    public int getId(String material) {
        Session sessao = null;
        Transaction transacao = null;
        List<Material> resultado = null;

        try {

            sessao = Util.HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            org.hibernate.Query query = sessao.createQuery("FROM Material WHERE descricao = '" + material + "'");
            resultado = query.list();

            for (int i = 0; i < resultado.size(); i++) {
                Material m = resultado.get(i);
                return m.getId();
            }
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            Log.geraLogBD(UsuarioLogado.getUsuarioLogadoEmail(), "query", hibEx.toString());
        } finally {
            sessao.close();
        }
        return 0;
    }

    //realiza a soma dos itens presentes em cada coluna da tabela
    public void somaSubtotal(JTable tabela, JTextField campo, int coluna) {
        double sum = 0.0;
        for (int i = 0; i < tabela.getRowCount(); i++) {
            sum = sum + Double.parseDouble(tabela.getValueAt(i, coluna).toString());
        }
        campo.setText(Double.toString(ItemFormulacaoDAO.roundToDecimals(sum, 2)));
        campo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    }
//
    //realiza a soma dos campos de sub total

    public void somaTotal(JTextField total, JTextField mp, JTextField cond) {
        if (mp.getText().isEmpty()) {
            mp.setText(String.valueOf(0));
        } else if (cond.getText().isEmpty()) {
            cond.setText(String.valueOf(0));
        }
        total.setText(String.valueOf(ItemFormulacaoDAO.roundToDecimals(Double.parseDouble(mp.getText()) + Double.parseDouble(cond.getText()), 2)));
        total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    }

    @Override
    public ItemFormulacao consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void popularTabela(JTable tabela, String criterio, boolean box) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Atualizar(ItemFormulacao o) {
       
        return null;
    }
}
