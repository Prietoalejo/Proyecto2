/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 * La clase Nodo representa un nodo en una estructura de árbol.
 * Cada nodo contiene un dato y referencias a sus nodos hijos izquierdo y derecho.
 * 
 * @author PrietoAlejo
 */
public class Nodo {
    /** El dato almacenado en el nodo. */
    public String dato;
    
    /** Referencia al nodo hijo izquierdo. */
    public Nodo izq;
    
    /** Referencia al nodo hijo derecho. */
    public Nodo der;

    /**
     * Constructor que inicializa un nuevo nodo con el dato especificado.
     * 
     * @param dato El dato que se almacenará en el nodo.
     */
    public Nodo(String dato) {
        this.dato = dato;
        this.der = this.izq = null;
    }
}
