package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //Vetor de string
        String[] lines = new String[]{"Good morning", "Good Afternoon", "Good night"};

        //Caminho do arquivo
        String path = "C:\\Windows\\Temp\\out.txt";

        //try-with-resources
        //parâmetro "true" indica que desejamos acrescentar ao arquivo existente, e não criar um novo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {

            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
