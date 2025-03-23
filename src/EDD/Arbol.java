/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Prietoalejo
 */
public class Arbol {
    Nodo raiz;

    public Arbol() {
        raiz = null;
    }
    
    public void insertar(Nodo nodo, Nodo padre, boolean respuesta){
        if(padre == null){
            this.raiz = nodo;
        }else{
            if(respuesta){
                padre.der = nodo;
            }else{
                padre.izq = nodo;
            }
        }
    }
    
    public void buscar(){
        
    }
}
