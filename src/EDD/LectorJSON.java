/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Prietoalejo
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * La clase LectorJSON se encarga de leer un archivo JSON y construir un árbol
 * a partir de su contenido. Este árbol representa una estructura jerárquica
 * basada en las especies y sus respectivas preguntas y respuestas.
 */
public class LectorJSON {

    /**
     * Lee un archivo JSON especificado y construye un árbol a partir de su contenido.
     * 
     * @param archivoJson La ruta del archivo JSON que se va a leer.
     * @return Un objeto de tipo Arbol que representa la estructura de datos
     *         construida a partir del archivo JSON. Si ocurre un error al leer
     *         el archivo, se devuelve null.
     */
    public Arbol leerImprimirJson(String archivoJson) {
        StringBuilder contenido = new StringBuilder();
        Arbol arbol = new Arbol();
        
        // Leer el archivo JSON
        try (BufferedReader br = new BufferedReader(new FileReader(archivoJson))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return null;
        }

        // Convertir el contenido a un objeto JSON
        JSONObject jsonObject = new JSONObject(contenido.toString());

        // Iterar sobre las claves del objeto JSON
        for (String claveDicotomica : jsonObject.keySet()) {
            JSONArray especies = jsonObject.getJSONArray(claveDicotomica);

            // Iterar sobre las especies
            for (int i = 0; i < especies.length(); i++) {
                JSONObject especie = especies.getJSONObject(i);
                for (String nombreEspecie : especie.keySet()) {
                    JSONArray preguntas = especie.getJSONArray(nombreEspecie);

                    Nodo esp = new Nodo(nombreEspecie);
                    Nodo padre = null;
                    boolean dir = false;

                    // Iterar sobre las preguntas
                    for (int j = 0; j < preguntas.length(); j++) {
                        JSONObject pregunta = preguntas.getJSONObject(j);
                        for (String textoPregunta : pregunta.keySet()) {
                            boolean respuesta = pregunta.getBoolean(textoPregunta);

                            System.out.println("    Pregunta: " + textoPregunta + ", Respuesta: " + respuesta);

                            Nodo preg = new Nodo(textoPregunta);
                            padre = arbol.insertar(preg, padre, dir);
                            dir = respuesta;
                        }
                    }
                    arbol.insertar(esp, padre, dir);
                    System.out.println("-------------------------------------------------------------------------");
                    arbol.imprimirArbol();
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                }
            }
            System.out.println(); // Línea en blanco para separar las claves dicotómicas
        }
        return arbol;
    }
}