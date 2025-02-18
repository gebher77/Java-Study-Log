package main;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        File file = new File("C:\\Windows\\Temp\\in.txt");
        Scanner sc = null;

        //Necessário try/catch para capturar uma possível exceção ao tentar abrir o arquivo
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        // Boa prática fechar o recurso no bloco finally para garantir que o Scanner seja fechado
        // independentemente do que acontecer no try/catch. Apenas verificamos se ele não é nulo antes de fechá-lo.
        finally {
            if (sc != null) {
                sc.close();
            }
        }
    }
}
