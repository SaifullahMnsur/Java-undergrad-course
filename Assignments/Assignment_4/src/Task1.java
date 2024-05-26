import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Scanner;

public class Task1{
    public static void printBytes(byte[] bytes ){
        for( int i = 0 ; i < bytes.length ; i++ ){
            System.out.print(bytes[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // FileInputStream Class
        System.out.println("\n------Using FileInputStream Class------\n");
        try {
            FileInputStream file1 = new FileInputStream("X:\\Java-undergrad-course\\Assignments\\Assignment_4\\files\\File1.txt");
            System.out.println("File size: " + file1.available() );
            System.out.print("Enter n (to read first n bytes of the file): ");
            int n = sc.nextInt();

            // read first n bytes
            byte[] file1bytes = new byte[n];
            file1.read(file1bytes);
            System.out.print("First " + n + " bytes: ");
            printBytes(file1bytes);
            file1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();


        // FileReader Class
        System.out.println("\n------Using FileReader Class------\n");
        try {
            FileReader file1 = new FileReader("X:\\Java-undergrad-course\\Assignments\\Assignment_4\\files\\File1.txt");
            int fileSize = 0;
            while ( file1.read() != -1) {
                fileSize++;
            }
            System.out.println("File size: " + fileSize);
            file1.close();
            
            file1 = new FileReader("X:\\Java-undergrad-course\\Assignments\\Assignment_4\\files\\File1.txt");
            System.out.print("Enter n (to read first n charecters of the file): ");
            int n = sc.nextInt();
            
            int ch;
            while ( n > 0 && (ch = file1.read() ) != -1 ) {
                System.out.print((char)ch);
                n--;
            }
            
            file1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println();
        sc.close();
    }
    
}