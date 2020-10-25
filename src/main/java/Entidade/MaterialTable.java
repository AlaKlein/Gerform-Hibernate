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
public class MaterialTable {
    private int id;
    private String descricao;
    private BigDecimal precokg;
    private String tipo_material;
    private int tipo_material_id;
    private int fornecedor_id;
    private String razao_social;
    private String status;
    private char tempropriedades;


    public int getId() {
        return id;
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

    public BigDecimal getPrecokg() {
        return precokg;
    }

    public void setPrecokg(BigDecimal precokg) {
        this.precokg = precokg;
    }

    public String getTipoMaterial() {
        return tipo_material;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipo_material = tipoMaterial;
    }

    public String getFornecedor() {
        return razao_social;
    }

    public void setFornecedor(String fornecedor) {
        this.razao_social = fornecedor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}

