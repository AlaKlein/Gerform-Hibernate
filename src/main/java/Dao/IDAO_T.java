
package Dao;

import javax.swing.JCheckBox;
import javax.swing.JTable;

public interface IDAO_T <T> {

    public String Salvar(T o);

    public String Atualizar(T o);

    public String Excluir(int id);

    public T consultarId(int id);
    
    public void popularTabela(JTable tabela, String criterio, boolean box);
}