/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author ala.klein
 */

@Entity
@Table(name = "auditoria")

public class Auditoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "usuario_id")
    private int usuario;

    @Column(name = "acao")
    private String acao;

    @Column(name = "tabela")
    private String tabela;

    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

   
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Auditoria other = (Auditoria) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
