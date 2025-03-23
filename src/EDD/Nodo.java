/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author PrietoAlejo
 */
public class Nodo {
    public String dato;
    public Nodo izq;
    public Nodo der;

    public Nodo(String dato) {
        this.dato = dato;
        this.der = this.izq = null;
    }
    
}
