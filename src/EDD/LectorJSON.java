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

public class LectorJSON {

    public static Arbol leerImprimirJson(String archivoJson) {
        StringBuilder contenido = new StringBuilder();
        Arbol arbol= new Arbol();
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
            System.out.println("Nombre Clave dicotómica: " + claveDicotomica);
            JSONArray especies = jsonObject.getJSONArray(claveDicotomica);

            // Iterar sobre las especies
            for (int i = 0; i < especies.length(); i++) {
                JSONObject especie = especies.getJSONObject(i);
                for (String nombreEspecie : especie.keySet()) {
                    System.out.println("  Especie: " + nombreEspecie);
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
                            arbol.insertar(preg, padre, respuesta);
                            padre = preg;
                            dir = respuesta;
                        }
                    }
                    arbol.insertar(esp, padre, dir);
                }
            }
            System.out.println(); // Línea en blanco para separar las claves dicotómicas
        }
        return arbol;
    }

    public static void main(String[] args) {
        String archivoJson = "ruta/al/archivo.json"; // Cambia esto a la ruta de tu archivo JSON
        leerImprimirJson(archivoJson);
    }
}