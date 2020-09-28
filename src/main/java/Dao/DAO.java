/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ala.klein
 */
public abstract class DAO<T> {

    public String Salvar(T t) {
        Session sessao = null;
        sessao = Util.HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();

        try {
            sessao = Util.HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.save(t);
            transacao.commit();

//            if (TelaPrincipal.ligaAuditoria) {
//                Audita.salvarAuditoria("Insert", "usuario", UsuarioLogado.getUsuarioLogadoID());
//            }
        } catch (HibernateException hibEx) {
            transacao.rollback();
            //Log.geraLogBD(UsuarioLogado.getUsuarioLogadoEmail(), "Insert", hibEx.toString());
            return hibEx.toString();
        } finally {
            sessao.close();
        }
        return null;
    }
}
