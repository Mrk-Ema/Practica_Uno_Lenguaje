package com.mycompany.promptzal;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class PromptZal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ANALIZADOR LEXICO PROMPTZAL");
        System.out.print("Ingrese la ruta del archivo .pz: ");
        String ruta = sc.nextLine().trim();
        try {
            String contenido = Files.readString(Paths.get(ruta));
            Tokenizador t = new Tokenizador();
            t.analizar(contenido);
            Reportes.imprimirConsola(t.getTokens());
        } catch (Exception e) {
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
        }
    }
}