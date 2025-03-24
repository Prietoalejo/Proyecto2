/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Prietoalejo
 */
/**
 * Clase que representa un árbol binario.
 */
public class Arbol {

    /** Nodo raíz del árbol. */
    public Nodo raiz;

    /**
     * Constructor de la clase Arbol.
     * Inicializa el árbol estableciendo la raíz en null.
     */
    public Arbol() {
        raiz = null;
    }

    /**
     * Inserta un nodo en el árbol.
     *
     * @param nodo El nodo a insertar.
     * @param padre El nodo padre donde se insertará el nuevo nodo.
     * @param respuesta Indica si el nuevo nodo se debe insertar como hijo derecho (true) o izquierdo (false).
     * @return El nodo insertado o el nodo existente si ya hay un hijo en la dirección especificada.
     */
    public Nodo insertar(Nodo nodo, Nodo padre, boolean respuesta) {
        if (padre == null) {
            if (raiz == null) {
                this.raiz = nodo;
                return raiz;
            } else {
                return raiz;
            }
        } else {
            if (respuesta && padre.der == null) {
                padre.der = nodo;
                return nodo;
            } else if (!respuesta && padre.izq == null) {
                padre.izq = nodo;
                return nodo;
            } else if (respuesta && padre.der != null) {
                return padre.der;
            } else {
                return padre.izq;
            }
        }
    }

    /**
     * Encuentra un camino desde la raíz hasta un nodo que contiene el dato especificado.
     *
     * @param dato El dato que se busca en el árbol.
     * @return Un arreglo de nodos que representa el camino desde la raíz hasta el nodo que contiene el dato,
     *         o null si no se encuentra el dato.
     */
    public Nodo[] encontrarCamino(String dato) {
        Nodo[] camino = new Nodo[20];
        if (buscarCamino(raiz, dato, camino, 0)) {
            return camino;
        } else {
            return null;
        }
    }

    /**
     * Método recursivo que busca un camino desde un nodo dado hasta un nodo que contiene el dato especificado.
     *
     * @param nodo El nodo actual en la búsqueda.
     * @param dato El dato que se busca en el árbol.
     * @param camino El arreglo donde se almacenará el camino encontrado.
     * @param index El índice actual en el arreglo de camino.
     * @return true si se encuentra el dato, false en caso contrario.
     */
    private boolean buscarCamino(Nodo nodo, String dato, Nodo[] camino, int index) {
        if (nodo == null) {
            return false;
        }
        camino[index] = nodo;
        if (nodo.dato.equals(dato)) {
            return true;
        }
        index += 1;
        if (buscarCamino(nodo.izq, dato, camino, index) || buscarCamino(nodo.der, dato, camino, index)) {
            return true;
        }
        camino[index - 1] = null;
        return false;
    }

    /**
     * Imprime el árbol en la consola, mostrando cada nodo y sus hijos.
     */
    public void imprimirArbol() {
        imprimirNodo(raiz);
    }

    /**
     * Método recursivo que imprime un nodo y sus hijos.
     *
     * @param nodo El nodo a imprimir.
     */
    private void imprimirNodo(Nodo nodo) {
        if (nodo == null) {
            return;
        }

        // Imprimir el dato del nodo
        System.out.print("Nodo: " + nodo.dato);

        // Imprimir los hijos
        if (nodo.izq != null) {
            System.out.print(", Hijo Izquierdo: " + nodo.izq.dato);
        } else {
            System.out.print(", Hijo Izquierdo: null");
        }

        if (nodo.der != null) {
            System.out.print(", Hijo Derecho: " + nodo.der.dato);
        } else {
            System.out.print(", Hijo Derecho: null");
        }

        System.out.println(); // Nueva línea para el siguiente nodo

        // Recursivamente imprimir los hijos
        imprimirNodo(nodo.izq);
        imprimirNodo(nodo.der);
    }
}