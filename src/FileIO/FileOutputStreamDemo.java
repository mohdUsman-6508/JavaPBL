package FileIO;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {
    public static void main(String[] args) {
        FileOutputStream output = null;

        try {
            output = new FileOutputStream("src/FileIO/output.txt",true);
            while (true) {
                int data = System.in.read();
                if (data == 10) {
                    break;
                } else {
                    output.write(data);
                }
                System.out.flush();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (output != null) {
                    output.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
