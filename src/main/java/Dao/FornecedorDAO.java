
package Dao;

import Entidade.Fornecedor;
import Entidade.UsuarioLogado;
import Util.Audita;
import Util.Log;
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


public class FornecedorDAO implements IDAO_T<Fornecedor>{
    
    @Override
    public Fornecedor consultarId(int id) {
        Fornecedor fornecedor = null;
        Session sessao = null;
        Transaction transacao = null;
        List<Fornecedor> resultado = new ArrayList();

        try {

            sessao = Util.HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            org.hibernate.Query query = sessao.createQuery("FROM Fornecedor WHERE id = " + id);
            resultado = query.list();

            for (int i = 0; i < resultado.size(); i++) {
                Fornecedor forn = resultado.get(i);
                fornecedor = new Fornecedor();

                fornecedor.setId(id);
                fornecedor.setRazao_social(forn.getRazao_social());
                fornecedor.setCnpj(forn.getCnpj());
                fornecedor.setEndereco(forn.getEndereco());
                fornecedor.setTelefone(forn.getTelefone());
                fornecedor.setStatus(forn.getStatus());
            }
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            Log.geraLogBD(UsuarioLogado.getUsuarioLogadoEmail(), "Query", hibEx.toString());
        } finally {
            sessao.close();
        }
        return fornecedor;
    }
    
    @Override
    public String Salvar(Fornecedor f) {
        Session sessao = null;
        sessao = Util.HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();

        try {
            sessao = Util.HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            sessao.save(f);
            transacao.commit();
            
            if (TelaPrincipal.ligaAuditoria) {
                Audita.salvarAuditoria("Insert", "fornecedor", UsuarioLogado.getUsuarioLogadoID());
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
    public String Atualizar(Fornecedor f) {
        Session sessao = null;
        List resultado = null;
        sessao = Util.HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        org.hibernate.Query query = sessao.createQuery("FROM Fornecedor WHERE id = " + f.getId());

        try {

            resultado = query.list();
            for (Object obj : resultado) {
                Fornecedor fornecedor = (Fornecedor) obj;
                fornecedor.setId(f.getId());
                fornecedor.setRazao_social(f.getRazao_social());
                fornecedor.setCnpj(f.getCnpj());
                fornecedor.setEndereco(f.getEndereco());
                fornecedor.setTelefone(f.getTelefone());
                fornecedor.setStatus(f.getStatus());
                sessao.update(fornecedor);
                transacao.commit();
            }
            
            if (TelaPrincipal.ligaAuditoria) {
                Audita.salvarAuditoria("Update", "fornecedor", UsuarioLogado.getUsuarioLogadoID());
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
            org.hibernate.Query query = sessao.createQuery("FROM Fornecedor WHERE id = " + id);
            resultado = query.list();

            for (Object object : resultado) {
                Fornecedor forn = (Fornecedor) object;
                forn.setStatus("Inativo");
                sessao.update(forn);
                transacao.commit();
            }
            
            if (TelaPrincipal.ligaAuditoria) {
                Audita.salvarAuditoria("Inactivate", "fornecedor", UsuarioLogado.getUsuarioLogadoID());
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
    
    public boolean checkExist (Fornecedor f) {
        boolean a = false;
        List resultado = null;
        Session sessao = null;

        try {
            sessao = Util.HibernateUtil.getSessionFactory().openSession();
            Transaction transacao = sessao.beginTransaction();
            org.hibernate.Query query = sessao.createQuery("SELECT COUNT(*) FROM Fornecedor WHERE NOT id = " + f.getId() +
                    " AND "
                    + " (razao_social = '" + f.getRazao_social() + "' OR "
                            + "cnpj = '" + f.getCnpj() + "' OR "
                                    + "telefone = '" + f.getTelefone() + "')");
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

        List<Fornecedor> resultado = new ArrayList();
        String sql = "";
        if (box) {
            sql = "FROM Fornecedor WHERE razao_social LIKE '%" + criterio + "%' ORDER BY id";
        } else {
            sql = "FROM Fornecedor WHERE razao_social LIKE '%" + criterio + "%' AND status='Ativo' ORDER BY id";
        }

        int lin = 0;
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[6];
        cabecalho[0] = "Código";
        cabecalho[1] = "Razão Social";
        cabecalho[2] = "CNPJ";
        cabecalho[3] = "Telefone";
        cabecalho[4] = "Endereço";
        cabecalho[5] = "Status";

        Session sessao = null;
        try {

            sessao = Util.HibernateUtil.getSessionFactory().openSession();
            Transaction transacao = sessao.beginTransaction();

            org.hibernate.Query query = sessao.createQuery(sql);
            resultado = query.list();

            dadosTabela = new Object[resultado.size()][6];

            for (int i = 0; i < resultado.size(); i++) {
                Fornecedor forn = resultado.get(i);
                dadosTabela[i][0] = forn.getId();
                dadosTabela[i][1] = forn.getRazao_social();
                dadosTabela[i][2] = forn.getCnpj();
                dadosTabela[i][3] = forn.getTelefone();
                dadosTabela[i][4] = forn.getEndereco();
                dadosTabela[i][5] = forn.getStatus();
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
