/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entidade.Auditoria;
import Entidade.AuditoriaTable;
import Entidade.UsuarioLogado;
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

/**
 *
 * @author Klein
 */
public class AuditoriaDAO {

//    public void popularTabela(JTable tabela) {
//
//        List<Auditoria> resultado = new ArrayList();
//        String sql = "";
//        sql = "FROM Auditoria ORDER BY id";
//
//        int lin = 0;
//        // dados da tabela
//        Object[][] dadosTabela = null;
//
//        // cabecalho da tabela
//        Object[] cabecalho = new Object[5];
//        cabecalho[0] = "Código";
//        cabecalho[1] = "Código Usuário";
//        cabecalho[2] = "Tabela";
//        cabecalho[3] = "Data";
//        cabecalho[4] = "Ação";
//
//        Session sessao = null;
//        try {
//
//            sessao = Util.HibernateUtil.getSessionFactory().openSession();
//            Transaction transacao = sessao.beginTransaction();
//
//            org.hibernate.Query query = sessao.createQuery(sql);
//            resultado = query.list();
//
//            dadosTabela = new Object[resultado.size()][6];
//
//            for (int i = 0; i < resultado.size(); i++) {
//                Auditoria audit = resultado.get(i);
//                dadosTabela[i][0] = audit.getId();
//                dadosTabela[i][1] = audit.getUsuario();
//                dadosTabela[i][2] = audit.getTabela();
//                dadosTabela[i][3] = audit.getData();
//                dadosTabela[i][4] = audit.getAcao();
//            }
//
//        } catch (HibernateException hibEx) {
//            Log.geraLogBD(UsuarioLogado.getUsuarioLogadoEmail(), "Query", hibEx.toString());
//        } finally {
//            sessao.close();
//        }
//
//        // configuracoes adicionais no componente tabela
//        tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
//            @Override
//            // quando retorno for FALSE, a tabela nao é editavel
//            public boolean isCellEditable(int row, int column) {
//                return false;
//            }
//
//            // alteracao no metodo que determina a coluna em que o objeto ImageIcon devera aparecer
//            @Override
//            public Class
//                    getColumnClass(int column) {
//
//                if (column == 2) {
////                    return ImageIcon.class;
//                }
//                return Object.class;
//            }
//        });
//
//        // permite seleção de apenas uma linha da tabela
//        tabela.setSelectionMode(0);
//
//        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
//
//        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
//
//        for (int i = 0; i < tabela.getColumnCount(); i++) {
//            tabela.getColumnModel().getColumn(i).setCellRenderer(centralizado);
//        }
//
//        // redimensiona as colunas de uma tabela
//        TableColumn column = null;
//        for (int i = 0; i < tabela.getColumnCount(); i++) {
//            column = tabela.getColumnModel().getColumn(i);
//            switch (i) {
//                case 0:
//                    column.setPreferredWidth(17);
//                    break;
//                case 1:
//                    column.setPreferredWidth(140);
//                    break;
//            }
//        }
//    }
    public void popularTabela(JTable tabela) {

        String sql = "";
        /*if (box) {

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
        }*/

        sql = "SELECT * FROM vw_auditoria";

        int lin = 0;
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[5];
        cabecalho[0] = "Código";
        cabecalho[1] = "Código Usuário";
        cabecalho[2] = "Tabela";
        cabecalho[3] = "Data";
        cabecalho[4] = "Ação";

        Session sessao = null;
        try {

            sessao = Util.HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction transacao = sessao.beginTransaction();

            List<AuditoriaTable> mt = (List<AuditoriaTable>) sessionFactory
                    .getCurrentSession()
                    .createSQLQuery(sql)
                    .setResultTransformer(Transformers.aliasToBean(AuditoriaTable.class))
                    .list();

            dadosTabela = new Object[mt.size()][6];

            for (int i = 0; i < mt.size(); i++) {
                dadosTabela[i][0] = mt.get(i).getId();
                dadosTabela[i][1] = mt.get(i).getEmail();
                dadosTabela[i][2] = mt.get(i).getTabela();
                dadosTabela[i][3] = mt.get(i).getData();
                dadosTabela[i][4] = mt.get(i).getAcao();

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
