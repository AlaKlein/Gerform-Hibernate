
package Dao;

import Util.ComboItem;
import java.util.List;
import javax.swing.JComboBox;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class CombosDAOMat {

    // construtor 1
    public void popularCombo(String tabela, JComboBox combo, String cond) {

        combo.removeAllItems();

        ComboItem item = new ComboItem();
        item.setCodigo(0);
        item.setDescricao("Selecione");
        combo.addItem(item);
        
        Session sessao = null;
        List resultado = null;
        sessao = Util.HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        org.hibernate.Query query = sessao.createQuery("SELECT id, descricao FROM Material WHERE tempropriedades='N'");

        try {

            resultado = query.list();
            for (Object obj : resultado) {
                item.setCodigo(Integer.parseInt(resultado.get(0).toString()));
                item.setDescricao(resultado.get(1).toString());
                transacao.commit();
            }

        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
    }

    // construtor 2
    /*public void popularCombo(String tabela, String campo1, String campo2, JComboBox combo, String complementoSQL) {

        combo.removeAllItems();

        ComboItem item = new ComboItem();
        item.setCodigo(0);
        item.setDescricao("Selecione");
        combo.addItem(item);

        try {
            resultado = new ConexaoBD().getConnection().createStatement().executeQuery("select * from " + tabela/*);
            + " WHERE status <> 'Excluído' AND status <> 'Inativo'");

            if (resultado.isBeforeFirst()) {
                while (resultado.next()) {
                    item = new ComboItem();
                    item.setCodigo(resultado.getInt(campo1));
                    item.setDescricao(resultado.getString(campo2));

                    combo.addItem(item);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao popular Combo = " + e.toString());
        }
    }*/

    public void definirItemCombo(JComboBox combo, ComboItem item) {
        for (int i = 0; i < combo.getItemCount(); i++) {
            if (((ComboItem) combo.getItemAt(i)).getCodigo() == (item.getCodigo())) {
                combo.setSelectedIndex(i);
                return;
            }
        }
    }
}
