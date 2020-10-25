
package Entidade;

import java.math.BigDecimal;


public class PropriedadesMaterialTable {
    
    private int id;
    private String descricao;
    private BigDecimal umidade;
    private BigDecimal gordura;
    private BigDecimal proteina;
    private String email;
    private String status;
    private BigDecimal precokg;
    

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getPrecokg() {
        return precokg;
    }

    public void setPrecokg(BigDecimal precokg) {
        this.precokg = precokg;
    }
    
    
    
}
