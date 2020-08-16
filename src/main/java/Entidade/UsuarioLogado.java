/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

/**
 *
 * @author Klein
 */
public class UsuarioLogado {

    public static int usuarioLogadoID;
    public static String usuarioLogadoEmail;

    public static String getUsuarioLogadoEmail() {
        return usuarioLogadoEmail;
    }

    public static void setUsuarioLogadoEmail(String usuarioLogadoEmail) {
        UsuarioLogado.usuarioLogadoEmail = usuarioLogadoEmail;
    }

    public static int getUsuarioLogadoID() {
        return usuarioLogadoID;
    }

    public static void setUsuarioLogadoID(int usuarioLogadoID) {
        UsuarioLogado.usuarioLogadoID = usuarioLogadoID;
    }
}
