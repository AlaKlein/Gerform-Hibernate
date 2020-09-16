
package Entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")


public class Produto implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "descricao")
    private String descricao;
    
    @Column(name = "tipo_produto_id")
    private int tipo_produto_id;
    
    @Column(name = "tem_formulacao")
    private char tem_formulacao;
    
    @Column(name = "status")
    private String status;
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

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

    public int getTipo_produto_id() {
        return tipo_produto_id;
    }

    public void setTipo_produto_id(int tipo_produto_id) {
        this.tipo_produto_id = tipo_produto_id;
    }

    public char getTem_formulacao() {
        return tem_formulacao;
    }

    public void setTem_formulacao(char tem_formulacao) {
        this.tem_formulacao = tem_formulacao;
    }
}
