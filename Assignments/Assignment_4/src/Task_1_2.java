import java.util.*;
import java.io.*;

public class Task_1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // FileReader Class
        System.out.println("\n------Using FileReader Class------\n");
        try {
            // Open File1.txt
            FileReader file1 = new FileReader("X:\\Java-undergrad-course\\Assignments\\Assignment_4\\files\\File1.txt");

            // Count file size
            int fileSize = 0;
            while (file1.read() != -1) {
                fileSize++;
            }

            // Print file size
            System.out.println("File size: " + fileSize);

            // Close the file
            file1.close();
            
            // Open the file again
            file1 = new FileReader("X:\\Java-undergrad-course\\Assignments\\Assignment_4\\files\\File1.txt");

            // Take the input of n to print first n bytes
            System.out.print("Enter n (to read first n charecters of the file): ");
            int n = sc.nextInt();

            // Print first n bytes as charecter
            System.out.print("First " + n + " bytes: ");
            int ch;
            while ( n > 0 && (ch = file1.read() ) != -1 ) {
                System.out.print((char)ch);
                n--;
            }
            
            // close file
            file1.close();
        } catch (Exception e) {
            // handle exception
            e.printStackTrace();
        }

        // close scanner
        sc.close();
    }
}
