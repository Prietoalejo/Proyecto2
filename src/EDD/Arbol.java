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

    public Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    public void insertar(Nodo nodo, Nodo padre, boolean respuesta) {
        if (padre == null) {
            this.raiz = nodo;
        } else {
            if (respuesta) {
                padre.der = nodo;
            } else {
                padre.izq = nodo;
            }
        }
    }

    public Nodo[] encontrarCamino(String dato) {
        Nodo[] camino = new Nodo[20];
        if (buscarCamino(raiz, dato, camino, 0)) {
            return camino;
        } else {
            return null; 
        }
    }

    private boolean buscarCamino(Nodo nodo, String dato, Nodo[] camino, int index) {
        if (nodo == null) {
            return false;
        }
        camino[index] = nodo;
        if (nodo.dato.equals(dato)) {
            return true;
        }
        index +=1;
        if (buscarCamino(nodo.izq, dato, camino, index ) || buscarCamino(nodo.der, dato, camino, index )) {
            return true;
        }
        camino[index-1] = null;
        return false;
    }
}
