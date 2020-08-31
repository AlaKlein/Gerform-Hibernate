/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author ala.klein
 */
import Entidade.Auditoria;
import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Audita {
    
    public static boolean salvarAuditoria(String acao, String tabela, int usuario_id) {
        Auditoria audita = new Auditoria();

        audita.setUsuario(usuario_id);
        audita.setTabela(tabela);
        audita.setData(new Date());
        audita.setAcao(acao);
        
        Session sessao = null;
        sessao = Util.HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();

        try {
            sessao = Util.HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.save(audita);
            transacao.commit();

        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            Log.geraLogBD(Entidade.UsuarioLogado.getUsuarioLogadoEmail(), "Auditoria", hibEx.toString());
        } finally {
            sessao.close();
        }
        return true;
    }
}
