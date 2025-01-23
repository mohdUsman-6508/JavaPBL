package FileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {
    public static void main(String[] args) {

        //Reading file
        FileInputStream input = null;

        try {
            input = new FileInputStream("src/FileIO/input.txt");
            byte[] data = input.readAllBytes();

            for (int i = 0; i < data.length; i++) {
                System.out.write(data[i]);
            }

//            byte[] data = new byte[input.available()];
//            int i = 0;
//            for (int n = input.read(); n != -1; n = input.read()) {
//                System.out.write(n);
//                data[i] = (byte) n;
//                i++;
//            }

            System.out.flush();

        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                if (input != null)
                    input.close();
            } catch (IOException e) {
                System.out.println(e);
            }

        }
    }
}
