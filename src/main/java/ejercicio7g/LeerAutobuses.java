/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio7g;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jorge
 */
public class LeerAutobuses {

    public static void main(String[] args) {

        String ruta = "./autobuses.txt";
        List<Autobus> autobuses = leerFichero(ruta);

        // Imprimo la lista de autobuses para comprobar
        autobuses.forEach(a -> System.out.println(a));

    }

    // Método para leer el fichero y guardarlo en una lista de autobuses
    private static List<Autobus> leerFichero(String ruta) {
        List<Autobus> autobuses = new ArrayList<>();
        String linea = "";
        String[] tokens;
        String[] tokensHoras;
        try ( Scanner flujo = new Scanner(new FileReader(ruta))) {
            while (flujo.hasNext()) {
                // Creo la lista de horas en cada iteracion
                List<LocalTime> horas = new ArrayList<>();

                linea = flujo.nextLine();
                tokens = linea.split("(\" \")|( - )|(\" )|(\")");
                // Cojo los tokens de horas de la linea si tiene horas
                if (tokens.length <= 4) {
                    tokensHoras = tokens[4].split(" ");
                    // Relleno la lista de horas con los tokens de horas
                    for (int i = 0; i < tokensHoras.length; i++) {
                        horas.add(LocalTime.parse(tokensHoras[i],
                                DateTimeFormatter.ofPattern("HH:mm")));
                    }
                }
                // Creo el autobus que toque y lo añado a la lista de autobuses
                autobuses.add(new Autobus(tokens[1], tokens[2], tokens[3], horas));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return autobuses;
    }

}
