/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFormattedTextField;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

/**
 *
 * @author Fabricio Pretto
 */
public class Validacao {

    private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    private static int calcularDigito(String str, int[] peso) {
        int soma = 0;
        for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
            digito = Integer.parseInt(str.substring(indice, indice + 1));
            soma += digito * peso[peso.length - str.length() + indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }

    public static boolean validarCPF(String cpf) {
        if ((cpf == null) || (cpf.length() != 11)) {
            return false;
        }
        Integer digito1 = calcularDigito(cpf.substring(0, 9), pesoCPF);
        Integer digito2 = calcularDigito(cpf.substring(0, 9) + digito1, pesoCPF);
        return cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString());
    }

    public static boolean validarCNPJ(String cnpj) {
        if ((cnpj == null) || (cnpj.length() != 14)
                || cnpj.equals("00000000000000") || cnpj.equals("11111111111111")
                || cnpj.equals("22222222222222") || cnpj.equals("33333333333333")
                || cnpj.equals("44444444444444") || cnpj.equals("55555555555555")
                || cnpj.equals("66666666666666") || cnpj.equals("77777777777777")
                || cnpj.equals("88888888888888") || cnpj.equals("99999999999999")) {
            return false;
        }
        Integer digito1 = calcularDigito(cnpj.substring(0, 12), pesoCNPJ);
        Integer digito2 = calcularDigito(cnpj.substring(0, 12) + digito1, pesoCNPJ);
        return cnpj.equals(cnpj.substring(0, 12) + digito1.toString() + digito2.toString());
    }

    public static boolean validarDataDMA(int d, int m, int a) {
        boolean correto = true;
        int[] dias = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (a < 0 || m < 1 || m > 12) {
            correto = false;
        } else {
            // valida o dia
            if (a % 4 == 0 && (a % 100 != 0 || a % 400 == 0)) {
                dias[1] = 29;
            }
            if (d < 1 || d > dias[m - 1]) {
                correto = false;
            }
        }
        return (correto);
    }

    public static boolean validarDataFormatada(String dataComFormato) {
        String[] data = dataComFormato.split("/");
        return (validarDataDMA(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])));
    }

    public static void validarTelefone(JFormattedTextField campo) {
        if (campo.getText().trim().length() < 14) {
            Formatacao.formatarTelefone(campo);
        }
    }

    public static int validarRazaoSocial(String nome) {
        if (nome.equals("")) {
            return 2;
        } else if (nome.length() < 1 || nome.length() > 50) {
            return 1;
        }
        return 0;
    }

    public static int validarEndereco(String nome) {
        if (nome.equals("")) {
            return 2;
        } else if (nome.length() < 1 || nome.length() > 50) {
            return 1;
        }
        return 0;
    }

    public static int validarTelefoneNovo(JFormattedTextField campo) {
        if (campo.equals(null)) {
            return 1;
        } else if (campo.getText().trim().length() < 13) {
            return 2;
        }
        return 0;
    }

    public static boolean validarDescricao(String Desc) {
        if (Desc.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean validarPreco(String Preco) {
        if (Preco.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean validarSenha(String senha) {
        if (senha.isEmpty() || senha.length() < 8) {
            return false;
        }
        return true;
    }

    public static boolean validarEmail(String email) {
        if (!EmailValidator.getInstance().isValid(email.toLowerCase())) {
            return false;
        }
        return true;
    }

    public static boolean validarVariosEmails(String email) {
        String[] result = email.split(",");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i].trim());
            if (!EmailValidator.getInstance().isValid(result[i].trim().toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    public static Double validarLimites(String condimento) {
        Double valor = null;
        File file = new File("RDC-272.pdf");
        

        try ( PDDocument document = PDDocument.load(file)) {

            if (!document.isEncrypted()) {

                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);

                PDFTextStripper tStripper = new PDFTextStripper();

                String pdfFileInText = tStripper.getText(document);
                String lines[] = pdfFileInText.split("\\r?\\n");
                for (String line : lines) {
                    if (line.contains(condimento)) {
                        Pattern p = Pattern.compile("\\d+\\,\\d*");
                        Matcher m = p.matcher(line);

                        while (m.find()) {
                            String val = m.group().replace(",", ".");
                            valor = Double.parseDouble(val);
                        }
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Validacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }
}
