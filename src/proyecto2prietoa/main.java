/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2prietoa;

import EDD.Arbol;
import EDD.LectorJSON;
import Ventanas.MenuInicio;

/**
 *
 * @author Prietoalejo
 */
public class main {

    public static void main(String[] args) {
        LectorJSON lector = new LectorJSON();
        Arbol a = lector.leerImprimirJson("familias_botanicas.json");
        a.imprimirArbol();
        MenuInicio mi = new MenuInicio(a);
    }

}
