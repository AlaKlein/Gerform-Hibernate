
package Dao;

import Entidade.Usuario;
import Util.Audita;
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
import Entidade.UsuarioLogado;
import Util.Log;


public class UsuarioDAO implements IDAO_T<Usuario>{

    @Override
    public Usuario consultarId(int id) {
        Usuario usuario = null;
        Session sessao = null;
        Transaction transacao = null;
        List<Usuario> resultado = new ArrayList();

        try {

            sessao = Util.HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            org.hibernate.Query query = sessao.createQuery("FROM Usuario WHERE id = " + id);
            resultado = query.list();

            for (int i = 0; i < resultado.size(); i++) {
                Usuario user = resultado.get(i);
                usuario = new Usuario();

                usuario.setId(id);
                usuario.setEmail(user.getEmail());
                usuario.setPermissao(user.getPermissao());
                usuario.setStatus(user.getStatus());
            }
        } catch (HibernateException hibEx) {
            Log.geraLogBD(UsuarioLogado.getUsuarioLogadoEmail(), "Query", hibEx.toString());
            hibEx.toString();
        } finally {
            sessao.close();
        }
        return usuario;
    }

    @Override
    public String Salvar(Usuario u) {
        Session sessao = null;
        sessao = Util.HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();

        try {
            sessao = Util.HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            sessao.save(u);
            transacao.commit();

            Audita.salvarAuditoria("Insert", "usuario", UsuarioLogado.getUsuarioLogadoID());
            
        } catch (HibernateException hibEx) {
            Log.geraLogBD(UsuarioLogado.getUsuarioLogadoEmail(), "Insert", hibEx.toString());
            return hibEx.toString();
        } finally {
            sessao.close();
        }
        return null;
    }

    @Override
    public String Atualizar(Usuario u) {
        Session sessao = null;
        List resultado = null;
        sessao = Util.HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        org.hibernate.Query query = sessao.createQuery("FROM Usuario WHERE id = " + u.getId());

        try {

            resultado = query.list();
            for (Object obj : resultado) {
                Usuario usuario = (Usuario) obj;
                usuario.setId(u.getId());
                usuario.setEmail(u.getEmail());
                usuario.setPermissao(u.getPermissao());
                usuario.setSenha(u.getSenha());
                usuario.setStatus(u.getStatus());
                sessao.update(usuario);
                transacao.commit();
            }
            Audita.salvarAuditoria("Update", "usuario", UsuarioLogado.getUsuarioLogadoID());

        } catch (HibernateException hibEx) {
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

        try {
            sessao = Util.HibernateUtil.getSessionFactory().openSession();
            Transaction transacao = sessao.beginTransaction();
            org.hibernate.Query query = sessao.createQuery("FROM Usuario WHERE id = " + id);
            resultado = query.list();

            for (Object object : resultado) {
                Usuario user = (Usuario) object;
                user.setStatus("Inativo");
                sessao.update(user);
                transacao.commit();
            }
            Audita.salvarAuditoria("Inactivate", "usuario", UsuarioLogado.getUsuarioLogadoID());

        } catch (HibernateException hibEx) {
            Log.geraLogBD(UsuarioLogado.getUsuarioLogadoEmail(), "Inactivate", hibEx.toString());
            return hibEx.toString();
        } finally {
            sessao.close();
        }
        return null;
    }
    
    public boolean checkExist (Usuario u) {
        boolean a = false;
        List resultado = null;
        Session sessao = null;

        try {
            sessao = Util.HibernateUtil.getSessionFactory().openSession();
            Transaction transacao = sessao.beginTransaction();
            org.hibernate.Query query = sessao.createQuery("SELECT COUNT(*) FROM Usuario WHERE NOT id = " + u.getId() +
                    " AND email = '" + u.getEmail() + "'");
            
            resultado = query.list();

            if (Integer.parseInt(resultado.get(0).toString()) > 0) {
                a = true;
            }

        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            Log.geraLogBD(UsuarioLogado.getUsuarioLogadoEmail(), "Query", hibEx.toString());
        } finally {
            sessao.close();
        }
        return a;
    }

    @Override
    public void popularTabela(JTable tabela, String criterio, boolean box) {

        List<Usuario> resultado = new ArrayList();
        String sql = "";
        if (box) {
            sql = "FROM Usuario WHERE email LIKE '%" + criterio + "%' ORDER BY id";
        } else {
            sql = "FROM Usuario WHERE email LIKE '%" + criterio + "%' AND status='Ativo' ORDER BY id";
        }
        
        int lin = 0;
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[4];
        cabecalho[0] = "Código";
        cabecalho[1] = "Email";
        cabecalho[2] = "Permissão";
        cabecalho[3] = "Status";

        Session sessao = null;
        try {

            sessao = Util.HibernateUtil.getSessionFactory().openSession();
            Transaction transacao = sessao.beginTransaction();

            org.hibernate.Query query = sessao.createQuery(sql);
            resultado = query.list();

            dadosTabela = new Object[resultado.size()][4];

            for (int i = 0; i < resultado.size(); i++) {
                Usuario user = resultado.get(i);
                dadosTabela[i][0] = user.getId();
                dadosTabela[i][1] = user.getEmail();
                dadosTabela[i][2] = user.getPermissao();
                dadosTabela[i][3] = user.getStatus();
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
