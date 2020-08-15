/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entidade.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Klein
 */
public class UsuarioDAO {

    public Usuario consultarId(int id) {
        Usuario usuario = null;
        Session sessao = null;
        Transaction transacao = null;
        List<Usuario> resultado = new ArrayList();

        try {

            sessao = Util.HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            org.hibernate.Query query = sessao.createQuery("FROM Usuario WHERE id = " + id);
            resultado = query.list();

            for (int i = 0; i < resultado.size(); i++) {
                Usuario user = resultado.get(i);
                usuario = new Usuario();

                usuario.setId(id);
                usuario.setEmail(user.getEmail());
                usuario.setPermissao(user.getPermissao());
            }
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return usuario;
    }

    public String Salvar(Usuario u) {
        Session sessao = null;
        sessao = Util.HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();

        try {
            sessao = Util.HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            sessao.save(u);
            transacao.commit();

        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public String Atualizar(Usuario u) {
        Session sessao = null;
        List resultado = null;
        sessao = Util.HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        org.hibernate.Query query = sessao.createQuery("FROM Usuario WHERE id = " + u.getId());

        try {

            resultado = query.list();
            for (Object obj : resultado) {
                Usuario usuario = (Usuario) obj;
                usuario.setId(u.getId());
                usuario.setEmail(u.getEmail());
                usuario.setPermissao(u.getPermissao());
                sessao.update(usuario);
                transacao.commit();
            }

        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    
    
    
}
