
package Dao;

import Entidade.Produto;
import Entidade.UsuarioLogado;
import Util.Audita;
import Util.Log;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import tela.TelaPrincipal;


public class ProdutoDAO implements IDAO_T<Produto>{
    
    @Override
    public Produto consultarId(int id) {
        Produto produto = null;
        Session sessao = null;
        Transaction transacao = null;
        List<Produto> resultado = new ArrayList();

        try {

            sessao = Util.HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            org.hibernate.Query query = sessao.createQuery("FROM Produto WHERE id = " + id);
            resultado = query.list();

            for (int i = 0; i < resultado.size(); i++) {
                Produto prod = resultado.get(i);
                produto = new Produto();

                produto.setId(id);
                produto.setDescricao(prod.getDescricao());
                produto.setTipo_produto_id(prod.getTipo_produto_id());
                produto.setTem_formulacao(prod.getTem_formulacao());
                produto.setStatus(prod.getStatus());
            }
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            Log.geraLogBD(UsuarioLogado.getUsuarioLogadoEmail(), "Query", hibEx.toString());
        } finally {
            sessao.close();
        }
        return produto;
    }
    
    @Override
    public String Salvar(Produto p) {
        Session sessao = null;
        sessao = Util.HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();

        try {
            sessao = Util.HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            sessao.save(p);
            transacao.commit();
            
            if (TelaPrincipal.ligaAuditoria) {
                Audita.salvarAuditoria("Insert", "produto", UsuarioLogado.getUsuarioLogadoID());
            }
            
        } catch (HibernateException hibEx) {
            transacao.rollback();
            hibEx.printStackTrace();
            Log.geraLogBD(UsuarioLogado.getUsuarioLogadoEmail(), "Insert", hibEx.toString());
            return hibEx.toString();
        } finally {
            sessao.close();
        }
        return null;
    }

    @Override
    public String Atualizar(Produto p) {
        Session sessao = null;
        List resultado = null;
        sessao = Util.HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        org.hibernate.Query query = sessao.createQuery("FROM Produto WHERE id = " + p.getId());

        try {

            resultado = query.list();
            for (Object obj : resultado) {
                Produto produto = (Produto) obj;
                produto.setId(p.getId());
                produto.setDescricao(p.getDescricao());
                produto.setTipo_produto_id(p.getTipo_produto_id());
                produto.setTem_formulacao(p.getTem_formulacao());
                produto.setStatus(p.getStatus());
              
                sessao.update(produto);
                transacao.commit();
            }
            
            if (TelaPrincipal.ligaAuditoria) {
                Audita.salvarAuditoria("Update", "produto", UsuarioLogado.getUsuarioLogadoID());
            }
            
        } catch (HibernateException hibEx) {
            transacao.rollback();
            hibEx.printStackTrace();
            Log.geraLogBD(UsuarioLogado.getUsuarioLogadoEmail(), "Update", hibEx.toString());
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
            org.hibernate.Query query = sessao.createQuery("FROM Produto WHERE id = " + id);
            resultado = query.list();

            for (Object object : resultado) {
                Produto prod = (Produto) object;
                prod.setStatus("Inativo");
                sessao.update(prod);
                transacao.commit();
            }
            
            if (TelaPrincipal.ligaAuditoria) {
                Audita.salvarAuditoria("Inactivate", "produto", UsuarioLogado.getUsuarioLogadoID());
            }
            
        } catch (HibernateException hibEx) {
            transacao.rollback();
            hibEx.printStackTrace();
            Log.geraLogBD(UsuarioLogado.getUsuarioLogadoEmail(), "Inactivate", hibEx.toString());
            return hibEx.toString();
        } finally {
            sessao.close();
        }
        return null;
    }
    
    public boolean checkExist (Produto p) {
        boolean a = false;
        List resultado = null;
        Session sessao = null;

        try {
            sessao = Util.HibernateUtil.getSessionFactory().openSession();
            Transaction transacao = sessao.beginTransaction();
            org.hibernate.Query query = sessao.createQuery("SELECT COUNT(*) FROM Produto WHERE NOT id = " + p.getId() + 
                    " AND descricao = '" + p.getDescricao() + "'");
            resultado = query.list();

            if (Integer.parseInt(resultado.get(0).toString()) > 0) {
                a = true;
            }

        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            Log.geraLogBD(UsuarioLogado.getUsuarioLogadoEmail(), "Query", hibEx.toString());
            hibEx.toString();
        } finally {
            sessao.close();
        }
        return a;
    }

    @Override
    public void popularTabela(JTable tabela, String criterio, boolean box) {

        List<Produto> resultado = new ArrayList();
        String sql = "";
        if (box) {
            sql = "FROM Produto WHERE descricao LIKE '%" + criterio + "%' ORDER BY id";
        } else {
            sql = "FROM Produto WHERE descricao LIKE '%" + criterio + "%' AND status='Ativo' ORDER BY id";
        }

        int lin = 0;
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[5];
        cabecalho[0] = "Código";
        cabecalho[1] = "Descrição";
        cabecalho[2] = "Tipo do Produto";
        cabecalho[3] = "Tem Formulação";
        cabecalho[4] = "Status";

        Session sessao = null;
        try {

            sessao = Util.HibernateUtil.getSessionFactory().openSession();
            Transaction transacao = sessao.beginTransaction();

            org.hibernate.Query query = sessao.createQuery(sql);
            resultado = query.list();

            dadosTabela = new Object[resultado.size()][5];

            for (int i = 0; i < resultado.size(); i++) {
                Produto prod = resultado.get(i);
                dadosTabela[i][0] = prod.getId();
                dadosTabela[i][1] = prod.getDescricao();
                dadosTabela[i][2] = prod.getTipo_produto_id();
                dadosTabela[i][3] = prod.getTem_formulacao();
                dadosTabela[i][4] = prod.getStatus();
            }

        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            Log.geraLogBD(UsuarioLogado.getUsuarioLogadoEmail(), "Query", hibEx.toString());
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
            public Class
                    getColumnClass(int column) {

                if (column == 2) {
//                    return ImageIcon.class;
                }
                return Object.class;
            }
        });

        // permite seleção de apenas uma linha da tabela
        tabela.setSelectionMode(0);

        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();

        centralizado.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < tabela.getColumnCount(); i++) {
            tabela.getColumnModel().getColumn(i).setCellRenderer(centralizado);
        }

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

}
