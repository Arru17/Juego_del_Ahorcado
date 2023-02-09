/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;
import Vistas.VistaPrincipal;
import Modelo.Ahorcado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author arru
 */
public class ControladorPrincipal implements ActionListener {
    VistaPrincipal vp;
    Ahorcado ahorcado;
    ControladorAhorcado ca;
    ControladorPrincipal cp;
    ControladorTopicos ct;
    
    /**
     *
     */
    public ControladorPrincipal(){
        vp=new VistaPrincipal();
        vp.setVisible(true);
        System.out.println("Vista Principal creada");
        vp.agregarListener(this);
        System.out.println("Vista principal preparada");
    }
        
           
           
    public void actionPerformed(ActionEvent ev){
        System.out.println("action performed principal listo");
        if(vp.getButtonJugar() == ev.getSource()){
            this.vp.dispose();
            System.out.println("Se ha selleccionado jugar");
            ct = new ControladorTopicos();
            ct.ControladorTopicos();
            System.out.println("Se ha creado contr. Topicos");
            
            
        }
        else if(vp.getButtonSalir()==ev.getSource()){
            this.vp.dispose();
            System.out.println("Se ha seleccionado salir");
        }
    }
}
       
        
       
    
        
    
    
   
    
        
    
        
        
         
        
    
    
    
    
    
            
    

