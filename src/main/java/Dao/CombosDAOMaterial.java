/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entidade.Fornecedor;
import Util.ComboItem;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CombosDAOMaterial implements ComboDAO_T {

    @Override
    public void popularCombo(JComboBox combo) {
        List<Fornecedor> resultado = new ArrayList();
        String sql = "";
        combo.removeAllItems();

        ComboItem item = new ComboItem();
        item.setCodigo(0);
        item.setDescricao("Selecione");
        combo.addItem(item);

        sql = "FROM Fornecedor";

        Session sessao = null;
        try {

            sessao = Util.HibernateUtil.getSessionFactory().openSession();
            Transaction transacao = sessao.beginTransaction();

            org.hibernate.Query query = sessao.createQuery(sql);
            resultado = query.list();

            for (int i = 0; i < resultado.size(); i++) {
                Fornecedor f = resultado.get(i);

                item = new ComboItem();
                item.setCodigo(f.getId());
                item.setDescricao(f.getRazao_social());

                combo.addItem(item);
            }

        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
    }

    @Override
    public void definirItemCombo(JComboBox combo, ComboItem item) {
        for (int i = 0; i < combo.getItemCount(); i++) {
            if (Integer.parseInt(String.valueOf(((ComboItem) combo.getItemAt(i)).getCodigo())) == item.getCodigo()) {
                combo.setSelectedIndex(i);
                return;
            }
        }
    }
}
