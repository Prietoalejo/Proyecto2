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
                                System.out.println("lklskdn.lkfnclsdkns");

                return nodo;
            } else if (!respuesta && padre.izq == null) {
                padre.izq = nodo;
                                System.out.println("ldsknl/sdkn/lkfds");

                return nodo;
            }else if(respuesta && padre.der != null){
                return padre.der;
            }else{
                return padre.izq;
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
        index += 1;
        if (buscarCamino(nodo.izq, dato, camino, index) || buscarCamino(nodo.der, dato, camino, index)) {
            return true;
        }
        camino[index - 1] = null;
        return false;
    }
    
    public void imprimirArbol() {
        imprimirNodo(raiz);
    }

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
