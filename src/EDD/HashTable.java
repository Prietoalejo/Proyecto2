/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Prietoalejo
 */
public class HashTable {
    private Nodo[] tabla;
    private int capacidad;

    public HashTable(int capacidad) {
        this.capacidad = capacidad;
        this.tabla = new Nodo[capacidad];
    }

    private int hash(String clave) {
        return Math.abs(clave.hashCode()) % capacidad;
    }

    public void insertar(String clave) {
        int indice = hash(clave);

        if (tabla[indice] == null) {
            tabla[indice] = new Nodo(clave);
        } else {

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

    public boolean buscar(String clave) {
        int indice = hash(clave);
        if (tabla[indice] != null && tabla[indice].dato.equals(clave)) {
            return true; 
        }

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
