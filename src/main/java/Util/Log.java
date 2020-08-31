/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 *
 * @author ala.klein
 */
public class Log {

    public static void geraLogIfr(String usuario, String tela, JButton botao, String erro) {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String space = System.lineSeparator();

        try {
            String filename = "logs.txt";

            FileWriter fw = new FileWriter(filename, true);

            fw.write("Usuário: " + usuario + space + "Tela: " + tela + space + "Ação executada: " + botao.getText() + space + "\nErro: " + erro + space + "\nHorário: " + dateFormat.format(new Date()) + space + space);
            fw.write("######################################################################################################################\n");
            
            fw.close();

        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    public static void geraLogBD(String email, String classe, String erro) {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String space = System.lineSeparator();

        try {
            String filename = "logs.txt";

            FileWriter fw = new FileWriter(filename, true);

            fw.write("Usuário: " + email + space +  "Classe: " + classe + space + "\nErro: " + erro + space + "\nHorário: " + dateFormat.format(new Date()) + space + space);
            fw.write("######################################################################################################################\n");
            fw.close();

        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }
}
