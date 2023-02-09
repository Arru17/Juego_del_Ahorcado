 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;
import Vistas.VistaAhorcado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.Ahorcado;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


/**
 *
 * @author arru
 */
public class ControladorAhorcado implements ActionListener {
    VistaAhorcado va;
    ControladorPrincipal cp;
    ControladorTopicos ct;
    Ahorcado ahorcado;
    ArrayList<String> palabras;
    String palabrita;
    char[] palabraSeparada;
    int contadorErrores;
    int[] repetidas;
    int contadorPistas;
    

   
    
    
    public void ControladorAhorcado(){
        ahorcado= new Ahorcado();
        palabras=ahorcado.leerArchivo(ControladorTopicos.ruta);
        repetidas= ahorcado.comprobarRepeticiones(palabras);
        System.out.println("repeticiones de letras");
        System.out.println(repetidas);
        palabrita = ahorcado.escogerPalabra(palabras);
        int num= palabrita.length();
        System.out.println("Palabras obtenidas");
        System.out.println(palabras);
        System.out.println("la palabra es:");
        System.out.println(palabrita);
        va=new VistaAhorcado();
        va.setVisible(true);
        System.out.println("Vista Ahorcado creada");
        va.agregarListener(this);
        System.out.println("Vista Ahorcado preparada");
        va.crearEspacios(num);
        System.out.println("Se han creado los espacios");
        va.crearMonito("src/Imagenes/NOAhorcado.png");
        System.out.println("ahi va el monyus");
        
    }
    public void actionPerformed(ActionEvent e){
        System.out.println("Action performed ahorcado listo");
        
        
        if (va.getButtoningresarLetra()== e.getSource()){
                System.out.println("Se ha selleccionado ingresar letra");
                String letraIngresada=va.getLetra().toUpperCase();
                //int contadorGanar= ahorcado.getContadorLetras();
                //System.out.println("contador ganar actual antes del if:");
                //System.out.println(contadorGanar);
                ArrayList<String> letrasGuardadas=ahorcado.getLetrasNoUsables();
                System.out.println("letras guardadas");
                System.out.println(letrasGuardadas);
                ahorcado.guardarLetra(letraIngresada);
                ArrayList<String> paProbar=ahorcado.getLetrasNoUsables();
                System.out.println(paProbar);
                if (ahorcado.verificarLargo(letraIngresada)== true){
                    System.out.println(letraIngresada);
                    ArrayList<Integer> posicion=ahorcado.verificarPosicion(letraIngresada, palabrita);
                    System.out.println(posicion);
                    int contadorGanar= ahorcado.getContadorLetras();
                    System.out.println("contador ganar actual antes del if:");
                    System.out.println(contadorGanar);
                    if (posicion.isEmpty()){
                        switch (contadorErrores) {
                            case 0:
                                contadorErrores++;
                                this.va.crearMonito("src/Imagenes/AhorcadoSCuerpo.png");
                                this.va.devolverBlanco();
                                break;
                            case 1:
                                contadorErrores++;
                                this.va.crearMonito("src/Imagenes/AhorcadoSBrazos.png");
                                this.va.devolverBlanco();
                                break;
                            case 2:
                                contadorErrores++;
                                this.va.crearMonito("src/Imagenes/AhorcadoSBrazo.png");
                                this.va.devolverBlanco();
                                break;
                            case 3:
                                contadorErrores++;
                                this.va.crearMonito("src/Imagenes/AhorcadoSPiernas.png");
                                this.va.devolverBlanco();
                                break;
                            case 4:
                                contadorErrores++;
                                this.va.crearMonito("src/Imagenes/AhorcadoSPIzquierda.png");
                                this.va.devolverBlanco();
                                break;
                            case 5:
                                this.va.crearMonito("src/Imagenes/AhorcadoCompleto.png");
                                this.va.devolverBlanco();
                                JOptionPane.showMessageDialog(null, "has perdido jajaja >:3");
                                this.va.dispose();
                                cp = new ControladorPrincipal();
                                break;
                        }
                        
                    }else{
                        //palabras=new ArrayList();
                        palabras=ahorcado.removerPalabra(palabras, letraIngresada);
                        System.out.println(palabras);
                        repetidas=ahorcado.comprobarRepeticiones(palabras);
                        System.out.println(repetidas[0]);
                        System.out.println(repetidas[1]);
                        System.out.println(repetidas[2]);
                        System.out.println(repetidas[3]);
                        JButton[][] espacitos=va.getEspacios();
                        System.out.println(espacitos);
                        JButton[][] espaciosCambiados= ahorcado.colocarLetra(posicion, espacitos, letraIngresada);
                        for(int i=0; i<palabrita.length();i++){
                            System.out.println(espaciosCambiados[0][i]);
                        }
                        
                        this.va.cambiarPanelVacio(espaciosCambiados, posicion, letraIngresada,palabrita);
                        System.out.println("contador ganar que entra al validar ganar:");
                        System.out.println(contadorGanar);
                        this.va.devolverBlanco();
                               
                        if(contadorGanar==palabrita.length()){
                            JOptionPane.showMessageDialog(null, "has gananyus jajaja :3");
                            this.va.dispose();
                            cp= new ControladorPrincipal();
                        }else{
                            
                        }
                    }
                
            }
                
            else {
                System.out.println("Ingrese solamente una letra");
                JOptionPane.showMessageDialog(null, "Ingrese solamente una letra!!!!!!!!!!!!!");
            }
                
        }
        if (va.getPista()== e.getSource()){
            contadorPistas++;
            if(contadorPistas==1){
                System.out.println(repetidas[0]);
                String letra= ahorcado.obtenerMayorRepeticion(repetidas);
                System.out.println("letra selected");
                System.out.println(letra);
                JOptionPane.showMessageDialog(null, "Te recomiendo usar la letra: ("+letra+") >:3");
            }else{
                if(contadorPistas==5){
                    System.out.println(repetidas[0]);
                    ArrayList<String> letrasGuardadas= ahorcado.getLetrasNoUsables();
                    int[] repetidasNuevas= ahorcado.comprobarRepeticiones2(palabras, letrasGuardadas);
                    String letra= ahorcado.obtenerMayorRepeticion(repetidasNuevas);
                    System.out.println("letra selected");
                    System.out.println(letra);
                    JOptionPane.showMessageDialog(null, "Te recomiendo usar la letra: ("+letra+") >:3");
                    JOptionPane.showMessageDialog(null, "Esa fue tu ultima pista :,c");
                    this.va.apagarBoton();
                }else{
                    System.out.println(repetidas[0]);
                    ArrayList<String> letrasGuardadas= ahorcado.getLetrasNoUsables();
                    int[] repetidasNuevas= ahorcado.comprobarRepeticiones2(palabras, letrasGuardadas);
                    String letra= ahorcado.obtenerMayorRepeticion(repetidasNuevas);
                    System.out.println("letra selected");
                    System.out.println(letra);
                    JOptionPane.showMessageDialog(null, "Te recomiendo usar la letra: ("+letra+") >:3");
                }
            }    
            
            
        }    
            
    }
    
    public String getPalabra(){
        return palabrita;
    }
    public int[] getRepetidas(){
        return repetidas;
    }
}
