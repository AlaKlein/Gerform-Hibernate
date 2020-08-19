/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author ala.klein
 */
/**
 *
 * @author klein
 */
public class Material implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "precokg")
    private double precokg;

    @Column(name = "tipo_material_id")
    private int tipoMaterialId;

    @Column(name = "fornecedor_id")
    private int fornecedor;

    @Column(name = "status")
    private String status;

    @Column(name = "tempropriedades")
    private char temPropriedades;

    public char getTemPropriedades() {
        return temPropriedades;
    }

    public void setTemPropriedades(char temPropriedades) {
        this.temPropriedades = temPropriedades;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecokg() {
        return precokg;
    }

    @Override
    public String toString() {
        String s = Double.toString(precokg);
        return s.replace('.', ',');
    }

    public void setPrecokg(double precokg) {
        this.precokg = precokg;
    }

    public int getTipoMaterialId() {
        return tipoMaterialId;
    }

    public void setTipoMaterialId(int tipoMaterialId) {
        this.tipoMaterialId = tipoMaterialId;
    }

    public int getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(int fornecedor) {
        this.fornecedor = fornecedor;
    }
}
