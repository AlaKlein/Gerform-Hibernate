/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerform;

import Entidade.Usuario;
import Tela.IfrUsuario;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Session;
import tela.TelaPrincipal;

/**
 *
 * @author Klein
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Session sessao = null;
        try {
            sessao = Util.HibernateUtil.getSessionFactory().openSession();
            Transaction transacao = sessao.beginTransaction();
            Usuario user = new Usuario();
            user.setEmail("jose");
            user.setPermissao("Administrador");
            user.setSenha("1234");

            sessao.save(user);
            transacao.commit();
            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
    }*/
        tela.TelaPrincipal telaprincipal = new TelaPrincipal();
        telaprincipal.setVisible(true);
    }
}
