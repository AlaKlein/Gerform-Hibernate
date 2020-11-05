/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entidade.Usuario;
import Entidade.UsuarioLogado;
import Util.Log;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;
import tela.TelaPrincipal;

/**
 *
 * @author Klein
 */
public class LoginDAO {

    public String login(String email, String senha) {
        UsuarioLogado uL = new UsuarioLogado();
        
        List<Usuario> resultado = new ArrayList();
        String usuario = "";
        String pw = "";
        String erro = "";
        int id = 0;
        String permissao = "";
        String status = "Ativo";

        Session sessao = null;
        sessao = Util.HibernateUtil.getSessionFactory().openSession();

        try {

            org.hibernate.Query query = sessao.createQuery("FROM Usuario "
                    + "WHERE email = '" + email + "' "
                    + "AND senha = '" + senha + "' ");
            resultado = query.list();

            for (int i = 0; i < resultado.size(); i++) {
                Usuario user = resultado.get(i);
                usuario = user.getEmail();
                pw = (user.getSenha());
                id = user.getId();
                permissao = user.getPermissao();
                status = user.getStatus();
            }
            uL.setUsuarioLogadoEmail(usuario);
            uL.setUsuarioLogadoID(id);
            uL.setUsuarioLogadoPermissao(permissao);

            if (usuario.equals(email) && pw.equals(senha) && (status.equals("Ativo"))) {
            new TelaPrincipal().setVisible(true);
            } else if (!status.equals("Ativo")) {
                erro = "usuarioinativo";
                return erro;
            } else {
                erro = "Erro ao fazer Login";
                Log.geraLogBD(UsuarioLogado.getUsuarioLogadoEmail(), "Login", erro);
                return erro;
            }

        } catch (HibernateException hibEx) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer login! Consulte o log de erros para mais informações.");
            Log.geraLogBD(UsuarioLogado.getUsuarioLogadoEmail(), "Login", hibEx.toString());
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }
}
