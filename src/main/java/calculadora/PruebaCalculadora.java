/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import javax.swing.JFrame;

/**
 *
 * @author GR6
 */
/*
En un nuevo proyecto, llamado tarea4GUI+tunombre y usando el ejemplo de la calculadora que hay en los apuntes, implementa la aplicación para que al menos se puedan realizar las operaciones aritméticas básicas con dos operandos.
Usa control de versiones en un repositorio público.
Sube el archivo en formato ZIP y el enlace de github.
 */
public class PruebaCalculadora {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Calculadora");
        frame.setBounds(250, 250, 0, 0);
        frame.add(new PanelPrincipal());

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

    }

}
