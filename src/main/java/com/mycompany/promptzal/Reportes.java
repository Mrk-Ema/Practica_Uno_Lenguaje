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
}