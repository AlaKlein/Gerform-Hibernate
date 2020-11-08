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
public class FormulacaoTableGraf {

    private int produto_id;
    private String descricao;
    private BigDecimal custo_elaborado;

    public int getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(int produto_id) {
        this.produto_id = produto_id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getCusto_elaborado() {
        return custo_elaborado;
    }

    public void setCusto_elaborado(BigDecimal custo_elaborado) {
        this.custo_elaborado = custo_elaborado;
    }
}
