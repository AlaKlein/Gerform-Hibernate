/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entidade.Formulacao;
import Entidade.FormulacaoTable;
import Entidade.ItemFormulacaoTable;
import Entidade.Produto;
import Entidade.UsuarioLogado;
import Util.Audita;
import static Util.HibernateUtil.sessionFactory;
import Util.Log;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
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
 * @author klein
 */
public class FormulacaoDAO implements IDAO_T<Formulacao> {

    private static int formulacaoId = 0;
    ResultSet resultadoQ = null;

    public int getFormualacaoId() {
        return formulacaoId;
    }

    public void setFormualacaoId(int id) {
        formulacaoId = id;
    }

    @Override
    public String Salvar(Formulacao o) {
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

//
    public String definirFormulacao(int id, String campo) {
        Session sessao = null;
        List<Produto> resultado = null;
        sessao = Util.HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        org.hibernate.Query query = sessao.createQuery("FROM Produto WHERE id = " + id);

        try {

            resultado = query.list();
            
            for (int i = 0; i < resultado.size(); i++) {
                Produto p = resultado.get(i);
                p.setTem_formulacao(campo.charAt(0));
                sessao.update(p);
            }
            transacao.commit();

            if (TelaPrincipal.ligaAuditoria) {
                Audita.salvarAuditoria("Update", "formulacao", UsuarioLogado.getUsuarioLogadoID());
            }
            
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            transacao.rollback();
            Log.geraLogBD(UsuarioLogado.getUsuarioLogadoEmail(), "Update", hibEx.toString());
            return hibEx.toString();
        } finally {
            sessao.close();
        }
        return null;
    }

    public String adicionarCusto(int id, double custo) {
         Session sessao = null;
        List<Formulacao> resultado = null;
        sessao = Util.HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        org.hibernate.Query query = sessao.createQuery("FROM Formulacao WHERE produto_id = " + id);

        try {

            resultado = query.list();
            
            for (int i = 0; i < resultado.size(); i++) {
                Formulacao f = resultado.get(i);
                f.setCustoElaborado(custo);
                sessao.update(f);
            }
            transacao.commit();

            if (TelaPrincipal.ligaAuditoria) {
                Audita.salvarAuditoria("Update", "Formulacao", UsuarioLogado.getUsuarioLogadoID());
            }
            
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            transacao.rollback();
            Log.geraLogBD(UsuarioLogado.getUsuarioLogadoEmail(), "Update", hibEx.toString());
            return hibEx.toString();
        } finally {
            sessao.close();
        }
        return null;
    }

    public void popularTabela(JTable tabela, String criterio) {
        String sql = "";

        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[3];
        cabecalho[0] = "Código";
        cabecalho[1] = "Descrição";
        cabecalho[2] = "Data de Cadastro";

        sql = "SELECT a.produto_id, p.descricao, a.data\n"
                + "FROM formulacao a\n "
                + "JOIN produto p ON a.produto_id=p.id\n"
                + "WHERE p.descricao ILIKE '%" + criterio + "%'\n"
                + "ORDER BY a.produto_id";

        Session sessao = null;
        try {

            sessao = Util.HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction transacao = sessao.beginTransaction();

            List<FormulacaoTable> mt = (List<FormulacaoTable>) sessionFactory
                    .getCurrentSession()
                    .createSQLQuery(sql)
                    .setResultTransformer(Transformers.aliasToBean(FormulacaoTable.class))
                    .list();

            dadosTabela = new Object[mt.size()][3];

            for (int i = 0; i < mt.size(); i++) {
                dadosTabela[i][0] = mt.get(i).getProduto_id();
                dadosTabela[i][1] = mt.get(i).getDescricao();
                dadosTabela[i][2] = Util.Formatacao.formatarDataHora(mt.get(i).getData());

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
//                    return ImageIcon.class;
                }
                return Object.class;
            }
        });

        // permite seleção de apenas uma linha da tabela
        tabela.setSelectionMode(0);

        //Centraliza o texto nas colunas
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();

        centralizado.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < tabela.getColumnCount(); i++) {
            tabela.getColumnModel().getColumn(i).setCellRenderer(centralizado);
        }
    }

    public void popularTabelaConsultaFormulacao(JTable tabela, int id, String criterio, int materialId) {
        String sql = "";
        Object[][] dadosTabela = null;
        Object[] cabecalho = new Object[9];

        cabecalho[0] = "Código";
        cabecalho[1] = "Descrição";
        cabecalho[2] = "Percentual";
        cabecalho[3] = "KG";
        cabecalho[4] = "R$/KG";
        cabecalho[5] = "R$/KG Prod";
        cabecalho[6] = "Umidade";
        cabecalho[7] = "Gordura";
        cabecalho[8] = "Proteína";

        sql = "SELECT m.id, m.descricao, a.percentual, a.kg, a.precokg, a.precokgprod, a.umidade, a.gordura, a.proteina "
                + "FROM produto p JOIN item_formulacao a ON p.id=a.formulacao_produto_id "
                + "JOIN material m "
                + "ON a.material_id=m.id "
                + "WHERE p.id= " + id + " AND tipo_material_id = " + materialId + " AND formulacao_produto_id= " + id + " "
                + "ORDER BY p.id";

        Session sessao = null;
        try {

            sessao = Util.HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction transacao = sessao.beginTransaction();

            List<ItemFormulacaoTable> mt = (List<ItemFormulacaoTable>) sessionFactory
                    .getCurrentSession()
                    .createSQLQuery(sql)
                    .setResultTransformer(Transformers.aliasToBean(ItemFormulacaoTable.class))
                    .list();

            dadosTabela = new Object[mt.size()][9];

            for (int i = 0; i < mt.size(); i++) {
                dadosTabela[i][0] = mt.get(i).getId();
                dadosTabela[i][1] = mt.get(i).getDescricao();
                dadosTabela[i][2] = mt.get(i).getPercentual();
                dadosTabela[i][3] = mt.get(i).getKg();
                dadosTabela[i][4] = mt.get(i).getPrecokg();
                dadosTabela[i][5] = mt.get(i).getPrecokgprod();
                dadosTabela[i][6] = mt.get(i).getUmidade();
                dadosTabela[i][7] = mt.get(i).getGordura();
                dadosTabela[i][8] = mt.get(i).getProteina();
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
//                    return ImageIcon.class;
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
                    column.setPreferredWidth(20);
                    break;
                case 1:
                    column.setPreferredWidth(170);
                    break;
            }
        }

        //Centraliza o texto nas colunas
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();

        centralizado.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < tabela.getColumnCount(); i++) {
            tabela.getColumnModel().getColumn(i).setCellRenderer(centralizado);
        }
    }

    @Override
    public String Atualizar(Formulacao o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Excluir(int id) {
         List resultado = null;
        Session sessao = null;
        Transaction transacao = null;
        
        try {
            sessao = Util.HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            org.hibernate.Query query = sessao.createQuery("FROM Formulacao WHERE produto_id = " + id);

            resultado = query.list();
            for (Object obj : resultado) {
                Formulacao formulacao = (Formulacao) obj;
                sessao.delete(formulacao);
            }
            transacao.commit();
        } catch (HibernateException hibEx) {
            transacao.rollback();
            Log.geraLogBD(UsuarioLogado.getUsuarioLogadoEmail(), "Exclude", hibEx.toString());
            hibEx.printStackTrace();
            return hibEx.toString();
        }
        return null;
    }

    @Override
    public void popularTabela(JTable tabela, String criterio, boolean box) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Formulacao consultarId(int id) {
        Formulacao formulacao = null;
        Session sessao = null;
        Transaction transacao = null;
        List<Formulacao> resultado = new ArrayList();

        try {

            sessao = Util.HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            org.hibernate.Query query = sessao.createQuery("FROM Formulacao WHERE produto_id = " + id);
            resultado = query.list();

            for (int i = 0; i < resultado.size(); i++) {
                Formulacao f = resultado.get(i);
                formulacao = new Formulacao();

                formulacao.setProdutoID(id);

            }
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            Log.geraLogBD(UsuarioLogado.getUsuarioLogadoEmail(), "query", hibEx.toString());
        } finally {
            sessao.close();
        }
        return formulacao;
    }
}
