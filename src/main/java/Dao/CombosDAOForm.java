/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entidade.Produto;
import Util.ComboItem;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author pretto
 */
public class CombosDAOForm {

    ResultSet resultado = null;

    // construtor 1
    public void popularCombo(String tabela, JComboBox combo, String cond) {
        List<Produto> resultado = new ArrayList();
        String sql = "";
        combo.removeAllItems();

        ComboItem item = new ComboItem();
        item.setCodigo(0);
        item.setDescricao("Selecione");
        combo.addItem(item);

        sql = "FROM Produto WHERE tem_formulacao = '" + cond + "' AND status <> 'Excluído'";

        Session sessao = null;
        try {

            sessao = Util.HibernateUtil.getSessionFactory().openSession();
            Transaction transacao = sessao.beginTransaction();

            org.hibernate.Query query = sessao.createQuery(sql);
            resultado = query.list();

            for (int i = 0; i < resultado.size(); i++) {
                Produto p = resultado.get(i);

                item = new ComboItem();
                item.setCodigo(p.getId());
                item.setDescricao(p.getDescricao());

                combo.addItem(item);
            }

        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
    }

    public void definirItemCombo(JComboBox combo, ComboItem item) {
        for (int i = 0; i < combo.getItemCount(); i++) {
            if (Integer.parseInt(String.valueOf(((ComboItem) combo.getItemAt(i)).getCodigo())) == item.getCodigo()) {
                combo.setSelectedIndex(i);
                return;
            }
        }
    }
}
