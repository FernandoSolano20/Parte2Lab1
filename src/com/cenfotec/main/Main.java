package com.cenfotec.main;

import com.cenfotec.logic.Password;

import java.util.Scanner;

public class Main {
    private static final Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Digite la longitud de la contraseña");
        int longitud = read.nextInt();

        Password password = new Password(longitud);
        password.generarPassword();
        System.out.println(password.getPassword());
        System.out.println("La contraseña es " + (password.esFuerte() ? "fuerte" : "debil"));
    }
}
