package com.mycompany.promptzal;

import java.util.List;

public class Reportes {

    public static void imprimirConsola(List<Token> tokens) {
        System.out.printf("%-4s %-20s %-20s %-6s %-8s%n", "#", "Lexema", "Tipo", "Fila", "Columna");
        int n = 1;
        for (Token t : tokens) {
            System.out.printf("%-4d %-20s %-20s %-6d %-8d%n", n, t.getLexema(), t.getTipo(), t.getFila(), t.getColumna());
            n++;
        }
    }

    public static void imprimirErrores(List<Token> errores) {
        if (errores.isEmpty()) {
            System.out.println("\nERRORES LEXICOS: ninguno");
            return;
        }
        System.out.println("\nERRORES LEXICOS:");
        System.out.printf("%-4s %-20s %-30s %-6s %-8s%n", "#", "Lexema", "Tipo", "Fila", "Columna");
        int n = 1;
        for (Token e : errores) {
            System.out.printf("%-4d %-20s %-30s %-6d %-8d%n", n, e.getLexema(), e.getTipo(), e.getFila(), e.getColumna());
            n++;
        }
    }
}