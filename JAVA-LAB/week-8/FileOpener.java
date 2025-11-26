// 2. Write a program that asks the user for a filename and tries to open it. Handle the error if the file does not exist.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileOpener {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Enter the filename to open: ");
        String filename = inputScanner.nextLine().trim();

        try {
            File file = new File(filename);

       
            if (!file.exists()) {
                throw new FileNotFoundException("File not found: " + filename);
            }

           
            Scanner fileScanner = new Scanner(file);
            System.out.println("\n--- File Content ---");
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println( e.getMessage());
        } catch (Exception e) {
            // Catch any other unexpected errors
            System.err.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            inputScanner.close();
        }
    }
}

