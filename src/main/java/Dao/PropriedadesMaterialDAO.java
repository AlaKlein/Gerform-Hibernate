package Dao;

import Entidade.PropriedadesMaterial;
import Entidade.PropriedadesMaterialTable;
import Entidade.UsuarioLogado;
import Util.Audita;
import static Util.HibernateUtil.sessionFactory;
import Util.Log;
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
import tela.TelaPrincipal;

public class PropriedadesMaterialDAO implements IDAO_T<PropriedadesMaterial> {

    @Override
    public String Salvar(PropriedadesMaterial pm) {
        Session sessao = null;
        sessao = Util.HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();

        try {
            sessao = Util.HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            sessao.save(pm);
            
            if (TelaPrincipal.ligaAuditoria) {
                Audita.salvarAuditoria("Insert", "propriedades_material", UsuarioLogado.getUsuarioLogadoID());
            }
            
        } catch (HibernateException hibEx) {
            transacao.rollback();
            Log.geraLogBD(UsuarioLogado.getUsuarioLogadoEmail(), "Insert", hibEx.toString());
            hibEx.printStackTrace();
            return hibEx.toString();
        } finally {
            
            transacao.commit();
            sessao.close();
        }
        return null;
    }

    @Override
    public String Atualizar(PropriedadesMaterial pm) {
        Session sessao = null;
        List resultado = null;
        sessao = Util.HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        org.hibernate.Query query = sessao.createQuery("FROM PropriedadesMaterial WHERE id = " + pm.getId());

        try {

            resultado = query.list();
            for (Object obj : resultado) {
                PropriedadesMaterial pmat = (PropriedadesMaterial) obj;
                pmat.setId(pm.getId());
                pmat.setUsuario_id(pm.getUsuario_id());
                pmat.setMaterial_id(pm.getMaterial_id());
                pmat.setUmidade(pm.getUmidade());
                pmat.setGordura(pm.getGordura());
                pmat.setProteina(pm.getProteina());
                pmat.setStatus(pm.getStatus());
                sessao.update(pmat);
                transacao.commit();
            }
            
            if (TelaPrincipal.ligaAuditoria) {
                Audita.salvarAuditoria("Update", "propriedades_material", UsuarioLogado.getUsuarioLogadoID());
            }
            
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            transacao.rollback();
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
            org.hibernate.Query query = sessao.createQuery("FROM PropriedadesMaterial WHERE id = " + id);
            resultado = query.list();

            for (Object object : resultado) {
                PropriedadesMaterial pm = (PropriedadesMaterial) object;
                pm.setStatus("Inativo");
                sessao.update(pm);
                transacao.commit();
            }
            
            if (TelaPrincipal.ligaAuditoria) {
                Audita.salvarAuditoria("Inactivate", "propriedades_material", UsuarioLogado.getUsuarioLogadoID());
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

    @Override
    public PropriedadesMaterial consultarId(int id) {
        PropriedadesMaterial pmat = null;
        Session sessao = null;
        Transaction transacao = null;
        List<PropriedadesMaterial> resultado = new ArrayList();

        try {

            sessao = Util.HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            org.hibernate.Query query = sessao.createQuery("FROM PropriedadesMaterial WHERE id = " + id);
            resultado = query.list();

            for (int i = 0; i < resultado.size(); i++) {
                PropriedadesMaterial pm = resultado.get(i);
                pmat = new PropriedadesMaterial();

                pmat.setId(id);
                pmat.setUsuario_id(pm.getUsuario_id());
                pmat.setMaterial_id(pm.getMaterial_id());
                pmat.setUmidade(pm.getUmidade());
                pmat.setGordura(pm.getGordura());
                pmat.setProteina(pm.getProteina());
                pmat.setStatus(pm.getStatus());

            }
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            Log.geraLogBD(UsuarioLogado.getUsuarioLogadoEmail(), "query", hibEx.toString());
        } finally {
            sessao.close();
        }
        return pmat;
    }
    
    @Override
    public void popularTabela(JTable tabela, String criterio, boolean box) {

        //List<PropriedadesMaterialTable> resultado = new ArrayList<PropriedadesMaterialTable>();
        String sql = "";
        /*if (box) {
            sql = "SELECT pm.id, m.descricao, pm.umidade, pm.gordura, pm.proteina, u.email, pm.status "
                    + "FROM Propriedades_material pm INNER JOIN Material m ON m.id = pm.material_id "
                    + "INNER JOIN Usuario u ON u.id=pm.usuario_id "
                    + "WHERE m.descricao ILIKE '%" + criterio + "%' ORDER BY pm.id";
        } else {
            sql = "SELECT pm.id, m.descricao, pm.umidade, pm.gordura, pm.proteina, u.email, pm.status "
                    + "FROM Propriedades_material pm INNER JOIN Material m ON m.id = pm.material_id "
                    + "INNER JOIN Usuario u ON u.id=pm.usuario_id "
                    + "WHERE m.descricao ILIKE '%" + criterio + "%' AND pm.status='Ativo' ORDER BY pm.id";
        }*/
        
        sql = "SELECT * FROM show_propriedades('" + criterio + "', " + box + ");";

        int lin = 0;
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[7];
        cabecalho[0] = "Código";
        cabecalho[1] = "Material";
        cabecalho[2] = "Umidade";
        cabecalho[3] = "Gordura";
        cabecalho[4] = "Proteína";
        cabecalho[5] = "Cadastrado por";
        cabecalho[6] = "Status";

        Session sessao = null;
        try {

            //sessao = Util.HibernateUtil.getSessionFactory().openSession();
            sessao = Util.HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction transacao = sessao.beginTransaction();
            
            List<PropriedadesMaterialTable> pmt = (List<PropriedadesMaterialTable>) sessionFactory
            .getCurrentSession()
            .createSQLQuery(sql)
            .setResultTransformer(Transformers.aliasToBean(PropriedadesMaterialTable.class))
            .list();

            /*org.hibernate.Query query = sessao.createSQLQuery(sql);
            resultado = query.list();
            
            List<PropriedadesMaterialTable> pmt = new ArrayList<PropriedadesMaterialTable>();
            
            pmt = transformList(resultado);

            dadosTabela = new Object[resultado.size()][7];*/
            dadosTabela = new Object[pmt.size()][7];
            
            for (int i = 0; i < pmt.size(); i++) {
                //System.out.println(pmt.get(i).getDescricao());
                dadosTabela[i][0] = pmt.get(i).getId();
                dadosTabela[i][1] = pmt.get(i).getDescricao();
                dadosTabela[i][2] = pmt.get(i).getUmidade();
                dadosTabela[i][3] = pmt.get(i).getGordura();
                dadosTabela[i][4] = pmt.get(i).getProteina();
                dadosTabela[i][5] = pmt.get(i).getEmail();
                dadosTabela[i][6] = pmt.get(i).getStatus();
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
    
    /*public void popularTabela1(JTable tabela, String criterio, boolean box) {

        List<PropriedadesMaterialTable> resultado = new ArrayList();
        String sql = "";
        if (box) {
            sql = "SELECT pm.id, m.descricao, pm.umidade, pm.gordura, pm.proteina, u.email, pm.status "
                    + "FROM PropriedadesMaterial pm, Material m, "
                    + "Usuario u "
                    + "WHERE u.id=pm.usuario_id AND m.id = pm.material_id AND m.descricao LIKE '%" + criterio + "%' ORDER BY m.descricao";
        } else {
            sql = "SELECT pm.id, m.descricao, pm.umidade, pm.gordura, pm.proteina, u.email, pm.status "
                    + "FROM PropriedadesMaterial pm, Material m, "
                    + "Usuario u "
                    + "WHERE u.id=pm.usuario_id AND m.id = pm.material_id AND m.descricao LIKE '%" + criterio + "%' AND pm.status='Ativo' ORDER BY m.descricao";
        }

        int lin = 0;
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[7];
        cabecalho[0] = "Código";
        cabecalho[1] = "Material";
        cabecalho[2] = "Umidade";
        cabecalho[3] = "Gordura";
        cabecalho[4] = "Proteína";
        cabecalho[5] = "Cadastrado por";
        cabecalho[6] = "Status";

        Session sessao = null;
        
        try {

            sessao = Util.HibernateUtil.getSessionFactory().openSession();
            Transaction transacao = sessao.beginTransaction();
            
            System.out.println(sql);
            
            org.hibernate.Query query = sessao.createQuery(sql);
            resultado = query.list();
            
            dadosTabela = new Object[resultado.size()][7];
            
            for (int i = 0; i < resultado.size(); i++) {
                PropriedadesMaterialTable pmt = resultado.get(i);
                dadosTabela[i][0] = pmt.getId();
                dadosTabela[i][1] = pmt.getDescricao();
                dadosTabela[i][2] = pmt.getUmidade();
                dadosTabela[i][3] = pmt.getGordura();
                dadosTabela[i][4] = pmt.getProteina();
                dadosTabela[i][5] = pmt.getEmail();
                dadosTabela[i][6] = pmt.getStatus();
            }

        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
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
    }*/
}
