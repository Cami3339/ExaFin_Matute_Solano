// Paquete util donde se agrupan clases de utilidad general
package util;

// Importaciones necesarias para manejar archivos y objetos
import java.io.*;
import java.util.ArrayList;

// Clase utilitaria para guardar y cargar objetos serializables en archivos
public class ArchivoUtil {

    // Método genérico para guardar una lista de objetos en un archivo
    public static <T> void guardar(String nombreArchivo, ArrayList<T> lista) {
        // Usa try-with-resources para cerrar automáticamente el flujo
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            // Escribe el objeto (lista) en el archivo
            oos.writeObject(lista);
        } catch (IOException e) {
            // Si ocurre un error de entrada/salida, imprime la traza
            e.printStackTrace();
        }
    }

    // Método genérico para cargar una lista de objetos desde un archivo
    @SuppressWarnings("unchecked") // Suprime advertencia por el cast
    public static <T> ArrayList<T> cargar(String nombreArchivo) {
        // Crea una instancia de File para verificar si el archivo existe
        File archivo = new File(nombreArchivo);
        
        // Si el archivo no existe, se devuelve una lista vacía
        if (!archivo.exists()) return new ArrayList<>();

        // Usa try-with-resources para cerrar automáticamente el flujo
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            // Lee y devuelve el objeto casteado como ArrayList<T>
            return (ArrayList<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Si ocurre un error, imprime la traza y retorna una lista vacía
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
