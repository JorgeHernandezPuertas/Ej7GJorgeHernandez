/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package ejercicio7g;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author jorge
 */
public class LeerEscribirJOption {

    public static void main(String[] args) {
        
        String ruta = "./fichero.txt";
        escribirFichero(ruta);
    }
    
    
    // Método para escribir un fichero a partir del usuario con joption
    private static void escribirFichero(String ruta) {
        String linea = "";
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(ruta))) {
            while (!linea.equalsIgnoreCase("terminar")){
                linea = JOptionPane.showInputDialog("Introduce una línea del archivo.");
                if (!linea.equalsIgnoreCase("terminar")){
                    flujo.write(linea + "\n");
                }
            }
            flujo.flush();
            System.out.println("Fichero generado con éxito.");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
    
}
