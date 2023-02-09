/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;
import Vistas.VistaTopicos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.Ahorcado;
import java.util.ArrayList;

/**
 *
 * @author rruz
 */
public class ControladorTopicos implements ActionListener{
    ControladorAhorcado ca;
    VistaTopicos vt;
    int topicoElegido;
    static String ruta;
    Ahorcado ahorcado;
    ArrayList<String> palabrasContexto;
    
    
    
    public void ControladorTopicos(){
        ahorcado= new Ahorcado();
        vt=new VistaTopicos();
        vt.setVisible(true);
        System.out.println("Vista Topicos creada");
        vt.agregarListener(this);
        System.out.println("Vista Topicos preparada");
    }
    public void actionPerformed(ActionEvent eve){
        System.out.println("Action performed topicos listo");
        if (vt.getButtonAnimales()== eve.getSource()){
            this.vt.dispose();
            System.out.println("Se ha seleccionado Animales");
            ControladorTopicos.ruta="src/Archivos/Animales.txt";
            ca = new ControladorAhorcado();
            ca.ControladorAhorcado();
            System.out.println("Se ha creado contr. Ahorcado");
            
            
        }
        else if (vt.getButtonCosasHogar()== eve.getSource()){
            this.vt.dispose();
            System.out.println("Se ha seleccionado Cosas del hogar");
            ControladorTopicos.ruta="src/Archivos/Cosas del hogar.txt";
            ca = new ControladorAhorcado();
            ca.ControladorAhorcado();
            System.out.println("Se ha creado contr. Ahorcado");
        }
    
    }
    public ArrayList<String> getPalabrasContexto(){
        return this.palabrasContexto;
        
    }
    
}
