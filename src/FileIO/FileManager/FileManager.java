package FileIO.FileManager;

import FileIO.FileInputStreamDemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {

    private ArrayList<String> files;

    public FileManager() {
        files = new ArrayList<>();
    }

    public ArrayList<String> getFiles() {
        return files;
    }

    public void showFiles() {
        System.out.println("___________________");
        System.out.println("|Files in Database|");
        System.out.println("-------------------");

        int i = 1;
        for (String file : this.files) {
            System.out.println(i + ". " + file);
        }
        System.out.println("-------*******--------");
    }

    boolean writeData(String fileName) {

        FileOutputStream output = null;
//        String filePath = "src/FileIO/FileManager/" + fileName + ".txt";

        String filePath = fileName + ".txt";

        System.out.println("___________________________");
        System.out.println("|-----START WRITING--------|");
        System.out.println("---------------------------");
        System.out.println("To save the file enter /");

        try {
            output = new FileOutputStream(filePath);
            int input = System.in.read();
            while (input != 47) {
                output.write(input);
                input = System.in.read();
            }
//            System.out.println("__________________________________________________________________");
//            System.out.println("|File saved " + filePath + "|");
//            System.out.println("------------------------------------------------------------------");
            files.add(fileName);
            System.out.println("file created successfully!");
            return true;
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

        return false;
    }

    byte[] readData(String fileName) {
        FileInputStream input = null;
//        String filePath = "src/FileIO/FileManager/" + fileName + ".txt";
        String filePath = fileName + ".txt";

        try {
            input = new FileInputStream(filePath);
            byte[] data;
            data = input.readAllBytes();
            System.out.flush();
//            System.out.println("___________________________");
//            System.out.println("|Data read successfully|");
//            System.out.println("---------------------------");
            return data;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return new byte[0];
    }

    void showFileContent(String fileName) {
        byte[] data = readData(fileName);
        System.out.println("=======================================================================");
        for (int i = 0; i < data.length; i++) {
            System.out.write(data[i]);
        }
        System.out.println("=======================================================================");
    }

    boolean copyData(String sourseFile, String destinationFile) {

        byte[] data = this.readData(sourseFile);
        FileOutputStream output = null;

        try {
            String path = destinationFile + ".txt";
            output = new FileOutputStream(path);
            System.out.println("File Copied Successfully!");
            output.write(data);
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
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

    void fileDetails(String fileName) {
        byte[] data = this.readData(fileName);
        int wordCount = 0;
        int charCount = 0;

        for (int i = 0; i < data.length; i++) {
            if (data[i] == 10) wordCount += 1;
            if (data[i] == 32) wordCount++;
            charCount++;
        }

        System.out.println("______________");
        System.out.println("|File Details|");
        System.out.println("--------------");

        System.out.println("Number of Words: " + wordCount);
        System.out.println("Number of Characters: " + charCount);
    }


    // ////////////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) throws IOException {
        FileManager fm = new FileManager();

        Scanner sc = new Scanner(System.in);
        System.out.println("___________________________");
        System.out.println("select an option to proceed:");
        System.out.println("---------------------------");

        while (true) {
            System.out.println("0. To exit");
            System.out.println("1. Write Data to File");
            System.out.println("2. Show Created Files");
            System.out.println("3. File Details(Word, Character Count");
            System.out.println("4. Copy File Content");
            System.out.println("5. View File Content");


            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1: {
                    System.out.println("Enter file name");
                    String fileName = sc.nextLine();
                    fm.writeData(fileName);
                }
                break;

                case 2: {
                    fm.showFiles();
                }
                break;

                case 3: {
                    System.out.println("Enter file name");
                    String fileName = sc.nextLine();
                    fm.fileDetails(fileName);
                }
                break;

                case 4: {
                    System.out.println("Enter source file name");
                    String sourceFile = sc.nextLine();
                    System.out.println("Enter destination file name");
                    String destinationFile = sc.nextLine();
                    fm.copyData(sourceFile, destinationFile);
                }
                break;

                case 5: {
                    System.out.println("Enter file name");
                    String fileName = sc.nextLine();
                    fm.showFileContent(fileName);
                }
                case 0:
                    break;
                default:
                    System.out.println("Invalid input");
            }

            if (choice == 0) {
                System.out.println("Thanks for using our app");
                break;
            }

        }


    }
}
