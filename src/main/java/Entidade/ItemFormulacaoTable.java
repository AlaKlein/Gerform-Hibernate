/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import java.math.BigDecimal;

/**
 *
 * @author ala.klein
 */
public class ItemFormulacaoTable {
    private int id;
    private String descricao;
    private BigDecimal percentual;
    private BigDecimal kg;
    private BigDecimal precokg;
    private BigDecimal precokgprod;
    private BigDecimal umidade;
    private BigDecimal gordura;
    private BigDecimal proteina;

    public int getId() {
        return id;
    }

    public void setId(int produto_id) {
        this.id = produto_id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPercentual() {
        return percentual;
    }

    public void setPercentual(BigDecimal percentual) {
        this.percentual = percentual;
    }

    public BigDecimal getKg() {
        return kg;
    }

    public void setKg(BigDecimal kg) {
        this.kg = kg;
    }

    public BigDecimal getPrecokg() {
        return precokg;
    }

    public void setPrecokg(BigDecimal precokg) {
        this.precokg = precokg;
    }

    public BigDecimal getPrecokgprod() {
        return precokgprod;
    }

    public void setPrecokgprod(BigDecimal precokgprod) {
        this.precokgprod = precokgprod;
    }

    public BigDecimal getUmidade() {
        return umidade;
    }

    public void setUmidade(BigDecimal umidade) {
        this.umidade = umidade;
    }

    public BigDecimal getGordura() {
        return gordura;
    }

    public void setGordura(BigDecimal gordura) {
        this.gordura = gordura;
    }

    public BigDecimal getProteina() {
        return proteina;
    }

    public void setProteina(BigDecimal proteina) {
        this.proteina = proteina;
    }
    
    
}

