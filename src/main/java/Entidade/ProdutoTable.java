package Entidade;

public class ProdutoTable {

    private int id;
    private String descricao;
    private String tipoproduto;
    private String tem_formulacao;
    private String status;

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

    public String getTipoproduto() {
        return tipoproduto;
    }

    public void setTipoproduto(String tipoproduto) {
        this.tipoproduto = tipoproduto;
    }

    public String getTem_formulacao() {
        return tem_formulacao;
    }

    public void setTem_formulacao(String tem_formulacao) {
        this.tem_formulacao = tem_formulacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
