/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manjedores;

import Analizadores.Analizador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Marco Munguia <@markomannder>
 */
public class ManjeadorAnalizador {

    public void iniciarAnalizar(JButton botonAnalizar, JTextField cadenaEscrita, JTextArea infoCadena) {
        botonAnalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Analizador iniciarComparaciones = new Analizador();
                cadenaEscrita.getText();
                iniciarComparaciones.setCadenaCaracteres(cadenaEscrita.getText());
                iniciarComparaciones.Analizar(infoCadena);

            }

        });
    }
}
