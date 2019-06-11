/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoarchivos;

import java.io.File;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author royerjmasache
 */
public class LeerManejoArchivos {

    // Lee el registro del archivo
    public static void leerRegistros() {
        // Se abre el archivo
        try // Lee registros del archivo, usando el objeto Scanner
        {
            Scanner entrada = new Scanner(new File("tabula-FWC_2018_Squadlists"
                    + "_4.csv"));
            double suma = 0;
            double sumaDos = 0;
            int i = 0;

            while (entrada.hasNext()) {
                String linea = entrada.nextLine();
                // System.out.println(linea);
                ArrayList<String> linea_partes = new ArrayList<>(
                        Arrays.asList(linea.split("\\|")));
                // Da el valor a la variable y acumula
                double dato = Double.parseDouble(linea_partes.get(11));
                suma = suma + dato;
                double datoDos = Double.parseDouble(linea_partes.get(9));
                sumaDos = sumaDos + datoDos;
                i = i + 1;
            } // Fin del ciclo While
            entrada.close();
            double promedio = suma / i;
            double promedioDos = sumaDos / i;
            System.out.printf("Promedio Goals: %.2f\nPromedio Height: %.2f\n",
                    promedio, promedioDos);
        } // Fin de try
        catch (Exception e) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        } // Fin de catch
    } // Fin del método leerRegistros
    // Ciera el archivo y termina la aplicación
} // Fin de la clase LeerManejoArchivos
