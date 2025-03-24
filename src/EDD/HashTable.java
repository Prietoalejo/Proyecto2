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
 * Clase que representa una tabla hash utilizando un arreglo de nodos.
 */
public class HashTable {
    /** Arreglo que almacena los nodos de la tabla hash. */
    private Nodo[] tabla;
    
    /** Capacidad de la tabla hash. */
    private int capacidad;

    /**
     * Constructor de la clase HashTable.
     *
     * @param capacidad La capacidad de la tabla hash.
     */
    public HashTable(int capacidad) {
        this.capacidad = capacidad;
        this.tabla = new Nodo[capacidad];
    }

    /**
     * Calcula el índice de la tabla hash para una clave dada.
     *
     * @param clave La clave para la cual se calculará el índice.
     * @return El índice correspondiente en la tabla hash.
     */
    private int hash(String clave) {
        return Math.abs(clave.hashCode()) % capacidad;
    }

    /**
     * Inserta una clave en la tabla hash.
     *
     * @param clave La clave a insertar.
     */
    public void insertar(String clave) {
        int indice = hash(clave);

        if (tabla[indice] == null) {
            tabla[indice] = new Nodo(clave);
        } else {
            // Manejo de colisiones mediante sondeo lineal
            int nuevoIndice = (indice + 1) % capacidad; 
            while (tabla[nuevoIndice] != null) {
                nuevoIndice = (nuevoIndice + 1) % capacidad; 
                if (nuevoIndice == indice) {
                    System.out.println("Hashtable lleno, no se puede insertar: " + clave);
                    return;
                }
            }
            tabla[nuevoIndice] = new Nodo(clave);
        }
    }

    /**
     * Busca una clave en la tabla hash.
     *
     * @param clave La clave a buscar.
     * @return true si la clave se encuentra en la tabla, false en caso contrario.
     */
    public boolean buscar(String clave) {
        int indice = hash(clave);
        if (tabla[indice] != null && tabla[indice].dato.equals(clave)) {
            return true; 
        }

        // Manejo de colisiones mediante sondeo lineal
        int nuevoIndice = (indice + 1) % capacidad;
        while (tabla[nuevoIndice] != null) {
            if (tabla[nuevoIndice].dato.equals(clave)) {
                return true; 
            }
            nuevoIndice = (nuevoIndice + 1) % capacidad;
            if (nuevoIndice == indice) {
                break; 
            }
        }
        return false;
    }

    /**
     * Imprime el contenido de la tabla hash.
     * Muestra cada índice y el nodo almacenado en ese índice.
     */
    public void imprimir() {
        for (int i = 0; i < capacidad; i++) {
            if (tabla[i] != null) {
                System.out.println("Indice " + i + ": " + tabla[i].dato);
            } else {
                System.out.println("Indice " + i + ": null");
            }
        }
    }
}