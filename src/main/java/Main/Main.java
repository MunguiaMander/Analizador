/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;
import Analizadores.Analizador;
import frontend.Principal;
/**
 * 
 * @author Marco Munguia <@markomannder>
 */
public class Main {
    
    public static void main(String[] args){
       //Principal iniciarAnalizador = new  Principal();
       //iniciarAnalizador.setVisible(true);
       Analizador iniciarAnalizador = new Analizador();
       iniciarAnalizador.Analizar();
    }

}
