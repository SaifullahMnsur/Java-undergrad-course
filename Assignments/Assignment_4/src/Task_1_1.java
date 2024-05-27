import java.util.*;
import java.io.*;

public class Task_1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // FileInputStream Class
        System.out.println("\n------Using FileInputStream Class------\n");
        try {
            // Open File1.txt
            FileInputStream file1 = new FileInputStream("X:\\Java-undergrad-course\\Assignments\\Assignment_4\\files\\File1.txt");

            // Print file size
            System.out.println("File size: " + file1.available() );

            // Take input for n to print n bytes
            System.out.print("Enter n (to read first n bytes of the file): ");
            int n = sc.nextInt();

            // Read first n bytes
            byte[] file1bytes = new byte[n];
            file1.read(file1bytes);

            // Print first n byte
            System.out.print("First " + n + " bytes: ");
            CommonMethods.printBytes(file1bytes);
            // Close the file
            file1.close();
        } catch (Exception e) {
            // Print exception is found
            e.printStackTrace();
        }
        System.out.println();
        sc.close();
    }
}
