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
public class PanelPrincipal extends JPanel implements ActionListener{

    // Atributos de la clase (privados)
    private PanelBotones botonera;
    private JTextArea areaTexto;
    private int tipoOperacion;

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
            boton.addActionListener((ActionListener) this);
        }

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
