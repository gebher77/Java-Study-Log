package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        //Os código comentados abaixo são códigos que foram eliminados com o uso do try-with-resources

        String path = "C:\\Windows\\Temp\\in.txt";

//        FileReader fr = null;
//        BufferedReader br = null;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

//            fr = new FileReader(path);
//            br = new BufferedReader(fr);

            String line = br.readLine();

            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }


        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

//        finally {
//            try {
//                if (br != null) {
//                    br.close();
//                }
//                if (fr != null) {
//                    fr.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
