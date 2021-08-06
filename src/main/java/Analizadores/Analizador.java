/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizadores;

import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author Marco Munguia <@markomannder>
 */
public class Analizador {

    private String cadenaCaracteres;
    private String espacio = "";
    private ArrayList<String> caracteresSeparados = new ArrayList<>();
    private int contador = 0;

    public void Analizar(JTextArea areaInfo) {

        for (char tmpChar : cadenaCaracteres.toCharArray()) {
            contador++;
            if (tmpChar != ' ') {
                espacio += tmpChar;
            }
            if (contador >= cadenaCaracteres.toCharArray().length || tmpChar == ' ') {
                caracteresSeparados.add(espacio);
                espacio = "";
            }
        }
        for (String string : caracteresSeparados) {
            areaInfo.setText(areaInfo.getText() + "\n---------------------\n Tipo: " + asignadorTipo(string) + "\n Cadena: " + string);
        }
    }

    public static String asignadorTipo(String tipo) {
        boolean banderaChar = false;
        boolean banderaNumero = false;
        boolean banderaDecimal = false;
        final String esNumero = "Numero";
        final String esID = "ID";
        final String esDecimal = "Decimal";
        final String esChar = "Char";
        final String noSoportado = "No Identificado";
        int contadorPuntos = 0;

        //Analiza el texto del arraylist para determinar que tipos de caracteres contiene
        for (char tmp : tipo.toCharArray()) {
            if (Character.isLetter(tmp)) {
                banderaChar = true;
            } else if (Character.isDigit(tmp)) {
                banderaNumero = true;
            } else if (tmp == '.') {
                banderaDecimal = true;
                contadorPuntos++;
            }
        }

        if (tipo.length() == 1) {
            return esChar;
        }

        //Contiene todos los caracteres por tanto es no soportado
        if (banderaDecimal) {
            if (banderaNumero) {
                if (banderaChar) {
                    return noSoportado;
                }
            }
        }
        //Retorna ID en caso de que detecte solo char
        if (banderaChar) {
            return esID;
        }

        //Retorna Numero o Decimal dependiendo de la evaluacion
        if (banderaNumero) {
            if ((banderaDecimal) && (contadorPuntos == 1)) {
                return esDecimal;
            } else if ((banderaDecimal) && (contadorPuntos > 1)) {
                return noSoportado;
            }
            return esNumero;
        }

        return noSoportado;
    }

    public void setCadenaCaracteres(String cadenaCaracteres) {
        this.cadenaCaracteres = cadenaCaracteres;
    }
    

}
