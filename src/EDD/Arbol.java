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

    // Método auxiliar para buscar el camino
    private boolean buscarCamino(Nodo nodo, String dato, Nodo[] camino, int index) {
        if (nodo == null) {
            return false;
        }

        // Agregar el nodo actual al camino
        camino[index] = nodo;

        // Verificar si el nodo actual es el que estamos buscando
        if (nodo.dato.equals(dato)) {
            return true;
        }
        index +=1;
        // Buscar en el subárbol izquierdo o derecho
        if (buscarCamino(nodo.izq, dato, camino, index ) || buscarCamino(nodo.der, dato, camino, index )) {
            return true;
        }

        // Si no se encontró el dato, eliminar el nodo del camino
        camino[index-1] = null;
        return false;
    }
}
