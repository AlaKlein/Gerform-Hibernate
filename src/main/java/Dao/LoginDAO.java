/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entidade.Usuario;
import Entidade.UsuarioLogado;
import Util.Encoding;
import Util.Log;
import java.util.ArrayList;
import java.util.List;
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
        TelaPrincipal tp = new TelaPrincipal();
        List<Usuario> resultado = new ArrayList();
        String usuario = "";
        String pw = "";
        int id = 0;

        Session sessao = null;
        sessao = Util.HibernateUtil.getSessionFactory().openSession();

        try {

            org.hibernate.Query query = sessao.createQuery("FROM Usuario "
                    + "WHERE email = '" + email + "' "
                    + "AND senha = md5('" + senha + "') ");
            resultado = query.list();

            for (int i = 0; i < resultado.size(); i++) {
                Usuario user = resultado.get(i);
                usuario = user.getEmail();
                pw = (user.getSenha());
                id = user.getId();
            }
            uL.setUsuarioLogadoEmail(usuario);
            uL.setUsuarioLogadoID(id);

            if (usuario.equals(email) && pw.equals(Encoding.encodeToMD5(senha))) {
                tp.setVisible(true);
            } else {
                return "erro";
            }

        } catch (HibernateException hibEx) {
            Log.geraLogBD(UsuarioLogado.getUsuarioLogadoEmail(), "Login", hibEx.toString());
            //hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }
}
