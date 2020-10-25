/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Klein
 */
@Entity
@Table(name = "formulacao")
public class Formulacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    
    private int id;
    private int produto_id;
    private int ver;
    private Date data;
    private double custo_elaborado;
    private int usuario_id;
    

    public int getProdutoID() {
        return produto_id;
    }

    public void setProdutoID(int produtoID) {
        this.produto_id = produtoID;
    }

    public int getUserID() {
        return usuario_id;
    }

    public void setUserID(int userID) {
        this.usuario_id = userID;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    public int getVersao() {
        return ver;
    }

    public void setVersao(int versao) {
        this.ver = versao;
    }

    public double getCustoElaborado() {
        return custo_elaborado;
    }

    public void setCustoElaborado(double custoElaborado) {
        this.custo_elaborado = custoElaborado;
    }

    public int getVer() {
        return ver;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(int produto_id) {
        this.produto_id = produto_id;
    }
    
    
}
