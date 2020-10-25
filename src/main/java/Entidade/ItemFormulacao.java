/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import java.io.Serializable;
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
@Table(name = "item_formulacao")
public class ItemFormulacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    private int id;
    private int material_id;
    private double percentual;
    private double kg;
    private double precoKg;
    private double precoKgProd;
    private double umidade;
    private double gordura;
    private double proteina;
    private double formulacao_produto_id;
    private int formulacao_ver;
    
    public double getProdutoID() {
        return formulacao_produto_id;
    }

    public void setProdutoID(double produtoID) {
        this.formulacao_produto_id = produtoID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaterialID() {
        return material_id;
    }

    public void setMaterialID(int materialID) {
        this.material_id = materialID;
    }

    public double getPercentual() {
        return percentual;
    }

    public void setPercentual(double percecntual) {
        this.percentual = percecntual;
    }

    public double getKg() {
        return kg;
    }

    public void setKg(double kg) {
        this.kg = kg;
    }

    public double getPrecoKg() {
        return precoKg;
    }

    public void setPrecoKg(double precoKg) {
        this.precoKg = precoKg;
    }

    public double getPrecoKgProd() {
        return precoKgProd;
    }

    public void setPrecoKgProd(double precoKgProd) {
        this.precoKgProd = precoKgProd;
    }

    public double getUmidade() {
        return umidade;
    }

    public void setUmidade(double umidade) {
        this.umidade = umidade;
    }

    public double getGordura() {
        return gordura;
    }

    public void setGordura(double gordura) {
        this.gordura = gordura;
    }

    public double getProteina() {
        return proteina;
    }

    public void setProteina(double proteina) {
        this.proteina = proteina;
    }

    public void setFormulacao_ver(int formulacao_ver) {
        this.formulacao_ver = formulacao_ver;
    }

    public int getFormulacao_ver() {
        return formulacao_ver;
    }
    
    
    
}
