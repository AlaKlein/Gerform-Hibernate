package Dao;

import Util.ComboItem;
import javax.swing.JComboBox;

public interface ComboDAO_T {

    public void popularCombo(JComboBox combo);
    
    public void definirItemCombo(JComboBox combo, ComboItem item);
}
