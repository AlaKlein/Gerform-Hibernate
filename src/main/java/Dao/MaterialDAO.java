/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entidade.Material;
import Entidade.MaterialTable;
import static Util.HibernateUtil.sessionFactory;
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

/**
 *
 * @author ala.klein
 */
public class MaterialDAO implements IDAO_T<Material> {

    @Override
    public String Salvar(Material m) {
        Session sessao = null;
        sessao = Util.HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();

        try {
            sessao = Util.HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            sessao.save(m);
            transacao.commit();

        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }
    
    public String definirPropriedades(int id, String campo) {
        Session sessao = null;
        List<Material> resultado = null;
        sessao = Util.HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        org.hibernate.Query query = sessao.createQuery("FROM Material WHERE id = " + id);

        try {

            resultado = query.list();
            
            for (int i = 0; i < resultado.size(); i++) {
                Material m = resultado.get(i);
                m.setTemPropriedades(campo.charAt(0));
                sessao.update(m);
            }
            transacao.commit();

        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    @Override
    public String Atualizar(Material m) {
        Session sessao = null;
        List resultado = null;
        sessao = Util.HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        org.hibernate.Query query = sessao.createQuery("FROM Material WHERE id = " + m.getId());

        try {

            resultado = query.list();
            for (Object obj : resultado) {
                Material material = (Material) obj;

                material.setId(m.getId());
                material.setDescricao(m.getDescricao());
                material.setFornecedor(m.getFornecedor());
                material.setPrecokg(m.getPrecokg());
                material.setStatus(m.getStatus());
                material.setTemPropriedades(m.getTemPropriedades());
                material.setTipoMaterialId(m.getTipoMaterialId());
                sessao.update(material);
            }
            transacao.commit();

        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
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
            org.hibernate.Query query = sessao.createQuery("FROM Material WHERE id = " + id);
            resultado = query.list();

            for (Object object : resultado) {
                Material material = (Material) object;
                material.setStatus("Inativo");
                sessao.update(material);
            }
            transacao.commit();

        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    @Override
    public Material consultarId(int id) {
        Material material = null;
        Session sessao = null;
        Transaction transacao = null;
        List<Material> resultado = new ArrayList();

        try {

            sessao = Util.HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            org.hibernate.Query query = sessao.createQuery("FROM Material WHERE id = " + id);
            resultado = query.list();

            for (int i = 0; i < resultado.size(); i++) {
                Material m = resultado.get(i);
                material = new Material();

                material.setId(id);
                material.setDescricao(m.getDescricao());
                material.setFornecedor(m.getFornecedor());
                material.setPrecokg(m.getPrecokg());
                material.setStatus(m.getStatus());
                material.setTemPropriedades(m.getTemPropriedades());
                material.setTipoMaterialId(m.getTipoMaterialId());

            }
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return material;
    }
    
    public int consultarSomenteId(String material) {
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
        } finally {
            sessao.close();
        }
        return 0;
    }

    @Override
    public void popularTabela(JTable tabela, String criterio, boolean box) {

        String sql = "";
        if (box) {

            sql = "SELECT m.id, m.descricao , m.precokg, m.status, t.descricao as tipo_material, a.razao_social\n"
                    + "FROM material m JOIN tipo_material t ON m.tipo_material_id=t.id\n"
                    + "JOIN fornecedor a ON m.fornecedor_id=a.id\n"
                    + "WHERE m.descricao ILIKE '%" + criterio + "%' AND m.status <> 'Excluído'\n"
                    + "ORDER BY m.id";

        } else {

            sql = "SELECT m.id, m.descricao, m.precokg, m.status, t.descricao as tipo_material, a.razao_social\n"
                    + "FROM material m JOIN tipo_material t ON m.tipo_material_id=t.id\n"
                    + "JOIN fornecedor a ON m.fornecedor_id=a.id\n"
                    + "WHERE m.descricao ILIKE '%" + criterio + "%' AND m.status ILIKE 'ativo'\n"
                    + "ORDER BY m.id";
        }

        int lin = 0;
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[6];
        cabecalho[0] = "Id";
        cabecalho[1] = "Descrição";
        cabecalho[2] = "Preço/Kg";
        cabecalho[3] = "Tipo Material";
        cabecalho[4] = "Fornecedor";
        cabecalho[5] = "Status";

        Session sessao = null;
        try {

            sessao = Util.HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction transacao = sessao.beginTransaction();

            List<MaterialTable> mt = (List<MaterialTable>) sessionFactory
                    .getCurrentSession()
                    .createSQLQuery(sql)
                    .setResultTransformer(Transformers.aliasToBean(MaterialTable.class))
                    .list();

            dadosTabela = new Object[mt.size()][6];

            for (int i = 0; i < mt.size(); i++) {
                dadosTabela[i][0] = mt.get(i).getId();
                dadosTabela[i][1] = mt.get(i).getDescricao();
                dadosTabela[i][2] = mt.get(i).getPrecokg();
                dadosTabela[i][3] = mt.get(i).getTipoMaterial();
                dadosTabela[i][4] = mt.get(i).getFornecedor();
                dadosTabela[i][5] = mt.get(i).getStatus();

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
    }
}
