package com.mycompany.promptzal;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class PromptZal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 2) {
            System.out.println("\nANALIZADOR LEXICO PROMPTZAL");
            System.out.println("1. Cargar archivo .pz");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opcion: ");
            try {
                opcion = Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                opcion = 0;
            }
            if (opcion == 1) {
                System.out.print("Ingrese la ruta del archivo .pz: ");
                String ruta = sc.nextLine().trim();
                try {
                    String contenido = Files.readString(Paths.get(ruta));
                    Tokenizador t = new Tokenizador();
                    t.analizar(contenido);
                    Reportes.imprimirConsola(t.getTokens());
                    Reportes.imprimirErrores(t.getErrores());
                    String nombre = Paths.get(ruta).getFileName().toString();
                    String html = Reportes.generarHTML(t.getTokens(), t.getErrores(), nombre);
                    String base = ruta.endsWith(".pz") ? ruta.substring(0, ruta.length() - 3) : ruta;
                    java.nio.file.Path salida = Paths.get(base + ".html");
                    Files.writeString(salida, html);
                    System.out.println("\nReporte HTML generado en: " + salida.toAbsolutePath());
                } catch (Exception e) {
                    System.out.println("No se pudo leer el archivo: " + e.getMessage());
                }
                System.out.println("\nPresione ENTER para continuar...");
                sc.nextLine();
            } else if (opcion != 2) {
                System.out.println("Opcion invalida, intente de nuevo.");
            }
        }
        System.out.println("Hasta luego!");
    }
}