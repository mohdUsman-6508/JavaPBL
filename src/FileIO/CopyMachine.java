package FileIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyMachine {
    public static void main(String[] args) {

        FileInputStream input = null;
        FileOutputStream output = null;
        
        try {
            input = new FileInputStream("src/FileIO/original.txt");
            output = new FileOutputStream("src/FileIO/copied.txt");
            byte[] data = input.readAllBytes();
            output.write(data);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                input.close();
                output.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }


    }
}
