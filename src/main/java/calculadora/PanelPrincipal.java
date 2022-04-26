/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author GR6
 */
/*
En un nuevo proyecto, llamado tarea4GUI+tunombre y usando el ejemplo de la calculadora que hay en los apuntes, implementa la aplicación para que 
al menos se puedan realizar las operaciones aritméticas básicas con dos operandos.
Usa control de versiones en un repositorio público.
Sube el archivo en formato ZIP y el enlace de github.
 */
public class PanelPrincipal extends JPanel implements ActionListener {

    // Atributos de la clase (privados)
    private PanelBotones botonera;
    private JTextArea areaTexto;

    //Variables para almacenar el tipo de operacion, tanto con o sin decimales
    private int tipoOperacion;
    private static double tipoOperacionDecimales = 0;

    //Variables que almacenaran cada parte de la operacion, se incializaran vacias
    //Ejemlo: (operacion1 = numero ) (simbolo o simboloAux = +)  (operacion2 = numero)
    private static String operador1 = "";
    private static String simbolo = "";
    private static String simboloAux = "";
    private static String operador2 = "";

    // Constructor
    public PanelPrincipal() {
        initComponents();
        tipoOperacion = -1; // No hay operaciones en la calculadora

    }

    // Se inicializan los componentes gráficos y se colocan en el panel
    private void initComponents() {
        // Creamos el panel de botones
        botonera = new PanelBotones();
        // Creamos el área de texto
        areaTexto = new JTextArea(10, 50);
        areaTexto.setEditable(false);
        areaTexto.setBackground(Color.white);

        //Establecemos layout del panel principal
        this.setLayout(new BorderLayout());
        // Colocamos la botonera y el área texto
        this.add(areaTexto, BorderLayout.NORTH);
        this.add(botonera, BorderLayout.SOUTH);

        //Se recorre con un foreach la botonera creada en la clase PanelBotones
        for (JButton boton : this.botonera.getgrupoBotones()) {
            //Se añade al objeto JButton el controlador del evento ActionListener 
            boton.addActionListener(this);
        }

        //Se llama al metodo deshabilitarBotones de la clase PanelBotones para deshabilitar los botones al principio
        botonera.deshabilitarBotones();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // Se obtiene el objeto que desencadena el evento
        Object o = ae.getSource();
        // Si Object es un botón
        if (o instanceof JButton) {
            System.out.println(((JButton) o).getText());
            areaTexto.setText(((JButton) o).getText());

            //Si los botones son uno de los simbolos, suma, resta, multiplicacion, division, limpiar y resultado
            if (((JButton) o).getText().equals("+")
                    || ((JButton) o).getText().equals("-")
                    || ((JButton) o).getText().equals("/")
                    || ((JButton) o).getText().equals("*")
                    || ((JButton) o).getText().equals("C")
                    || ((JButton) o).getText().equals("=")) {

                // Si el boton es limpirar (C)
                if (((JButton) o).getText().equals("C")) {
                    // Se eliminara todo lo que se haya escrito en la calucladora
                    operador1 = "";
                    simbolo = "";
                    operador2 = "";
                    tipoOperacion = 0;
                    tipoOperacionDecimales = 0;
                    //El areaTexto establecera la operacion1 que estara ya eliminada
                    areaTexto.setText(operador1);
                    //Si el boton es igual a - (resta) y la operacio1 no tiene valor entrara
                } else if (((JButton) o).getText().equals("-") && operador1.isEmpty()) {
                    // Se Guardará el primer operador
                    operador1 += ((JButton) o).getText();
                    //Se establecera en el textArea
                    areaTexto.setText(operador1);
                    //Se muestra el operador1
                    System.out.println("Operador 1: " + operador1);

                    //En el caso contrario, solo guardará la información del simbolos
                } else {
                    // Se Guardará el simbolo
                    simbolo = ((JButton) o).getText();
                    //Se establece en el textArea el operador1 y el simbolo
                    areaTexto.setText(operador1 + simbolo);
                    //Se muestra por consola
                    System.out.println("Simbolo: " + simbolo);
                    // Si el simbolo no es el de resultado (=)
                    if (!simbolo.equals("=")) {
                        //Se guardara en la variable simboloAux
                        simboloAux = simbolo;
                    }

                }

                //Si los botones representan numeros
            } else {
                //Si la varible esimbolo esta vacia entra
                if (simbolo.isEmpty()) {
                    // Guardará el primer operador
                    operador1 += ((JButton) o).getText();
                    //Se establece en el textArea el operador1
                    areaTexto.setText(operador1);
                    //Se muestra por consola
                    System.out.println("Operador 1: " + operador1);
                    //Se llama al metodo habilitarBotones() de la clase PanelBotones para habilitar los botones +, *, / y  =
                    botonera.habilitarBotones();
                    // Si el simbolo contiene algo, se pasara al operador2
                } else {
                    // Guardará el segundo operador
                    operador2 += ((JButton) o).getText();
                    //Se establece en el textArea el operador1, el simboloAux y el operador2
                    areaTexto.setText(operador1 + simboloAux + operador2);
                    //Se muestra por consola
                    System.out.println("Operador 2: " + operador2);
                }

            }

        }

    }

}
