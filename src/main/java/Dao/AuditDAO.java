/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entidade.AuditoriaTable;
import Entidade.UsuarioLogado;
import static Util.HibernateUtil.sessionFactory;
import Util.Log;
import java.sql.ResultSet;
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
public class AuditDAO {

    ResultSet resultadoQ;

    public void popularTabela(JTable tabela, String email, String tab, String acao, String dataIni, String dataFim) {
        if (email.equals("Selecione")) {
            email = "";
        }
        if (tabela.equals("Selecione")) {
            tab = "";
        }
        if (acao.equals("Selecione")) {
            acao = "";
        }

        String sql = "";

        sql = "SELECT a.id, u.email, a.tabela, a.data, a.acao from usuario u JOIN auditoria a\n"
                + "ON u.id=a.usuario_id\n"
                + "WHERE u.email ILIKE '%" + email + "%'\n"
                + "AND a.tabela ILIKE '%" + tab + "%'\n"
                + "AND a.acao ILIKE '%" + acao + "%'\n"
                + "AND DATE(a.data) BETWEEN '" + dataIni + "' AND '" + dataFim + "'"
                + "ORDER BY a.id";

        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[5];
        cabecalho[0] = "Código";
        cabecalho[1] = "E-mail";
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
                dadosTabela[i][3] = Util.Formatacao.formatarDataHora(mt.get(i).getData());
                dadosTabela[i][4] = mt.get(i).getAcao();
            }

        } catch (HibernateException hibEx) {
            Log.geraLogBD(UsuarioLogado.getUsuarioLogadoEmail(), "Query", hibEx.toString());
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

    public void popularTabela2(JTable tabela, String campo, String tab) {

        String cabecalho2 = null;
        String and = null;
        switch (campo) {
            case "email":
                cabecalho2 = "E-mail";
                break;
            case "tabela":
                cabecalho2 = "Tabela";
                and = " ";
                break;
            case "acao":
                cabecalho2 = "Ação";
                break;
        }

        String sql = "";

        sql = "Select * FROM " + tab + "";

        int lin = 0;

        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[2];
        cabecalho[0] = "Código";
        cabecalho[1] = cabecalho2;

        Session sessao = null;
        try {

            sessao = Util.HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction transacao = sessao.beginTransaction();

            List<AuditoriaTable> mt = (List<AuditoriaTable>) sessionFactory
                    .getCurrentSession()
                    .createSQLQuery(sql)
                    .setResultTransformer(Transformers.aliasToBean(AuditoriaTable.class))
                    .list();

            dadosTabela = new Object[2][2];

            for (int i = 0; i < 2; i++) {
                dadosTabela[i][0] = mt.get(i).getId();
                if (campo.equals("email")) {
                    dadosTabela[i][1] = mt.get(i).getEmail();
                } else if (campo.equals("tabela")) {
                    dadosTabela[i][1] = mt.get(i).getTabela();
                } else if (campo.equals("acao")) {
                    dadosTabela[i][1] = mt.get(i).getAcao();
                }
            }

        } catch (HibernateException hibEx) {
            Log.geraLogBD(UsuarioLogado.getUsuarioLogadoEmail(), "Query", hibEx.toString());
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
                /*  
                 if (column == 3) {  // apenas a coluna 3 sera editavel
                 return true;
                 } else {
                 return false;
                 }
                 */
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

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < tabela.getColumnCount(); i++) {
            column = tabela.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(22);
                    break;
                case 1:
                    column.setPreferredWidth(140);
                    break;
            }
        }
    }

    public void popEmail(JTable tab) {
        new UsuarioDAO().popularTabela(tab, "", false);
        DefaultTableModel model = (DefaultTableModel) tab.getModel();
        
        tab.removeColumn(tab.getColumnModel().getColumn(0));
        tab.removeColumn(tab.getColumnModel().getColumn(1));
        tab.removeColumn(tab.getColumnModel().getColumn(1));
        
        //Centraliza o texto nas colunas
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();

        centralizado.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < tab.getColumnCount(); i++) {
            tab.getColumnModel().getColumn(i).setCellRenderer(centralizado);
        }
    }

    public void popTabela(JTable tab) {
        new AuditoriaDAO().popularTabela(tab,"tabela");
        DefaultTableModel model = (DefaultTableModel) tab.getModel();
        
        tab.removeColumn(tab.getColumnModel().getColumn(0));
        tab.removeColumn(tab.getColumnModel().getColumn(0));
        tab.removeColumn(tab.getColumnModel().getColumn(1));
        tab.removeColumn(tab.getColumnModel().getColumn(1));
        
        //Centraliza o texto nas colunas
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();

        centralizado.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < tab.getColumnCount(); i++) {
            tab.getColumnModel().getColumn(i).setCellRenderer(centralizado);
        }
    }

   public void popAcao(JTable tab) {
        new AuditoriaDAO().popularTabela(tab,"acao");
        DefaultTableModel model = (DefaultTableModel) tab.getModel();
        
        tab.removeColumn(tab.getColumnModel().getColumn(0));
        tab.removeColumn(tab.getColumnModel().getColumn(0));
        tab.removeColumn(tab.getColumnModel().getColumn(0));
        tab.removeColumn(tab.getColumnModel().getColumn(0));
        //Centraliza o texto nas colunas
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();

        centralizado.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < tab.getColumnCount(); i++) {
            tab.getColumnModel().getColumn(i).setCellRenderer(centralizado);
        }
    }
  

}
