import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // FileOutputStream Class
        System.out.println("\n------Using FileInputStream Class------\n");
        try {
            // opening files
            FileInputStream file1 = new FileInputStream("X:\\Java-undergrad-course\\Assignments\\Assignment_4\\files\\File1.txt");
            FileInputStream file2 = new FileInputStream("X:\\Java-undergrad-course\\Assignments\\Assignment_4\\files\\File2.txt");
            FileOutputStream file3Out = new FileOutputStream("X:\\Java-undergrad-course\\Assignments\\Assignment_4\\files\\File3_FOS.txt");

            // calculating size of file 1, 2
            int sizeFile1 = file1.available()/2;
            int sizeFile2 = file2.available()/2;

            // copying from file 1, 2
            byte[] file1bytes = new byte[sizeFile1];
            file1.read(file1bytes, 0, sizeFile1);
            
            byte[] file2bytes = new byte[sizeFile2];
            file2.skip(sizeFile2);
            file2.read(file2bytes, 0, sizeFile2);

            // First n bytes of file 1, 2
            System.out.println(file1bytes);
            System.out.println(file2bytes);
            
            // reading files
            file3Out.write(file1bytes);
            file3Out.write('\n');
            file3Out.write(file2bytes);

            // closing files
            file1.close();
            file2.close();
            file3Out.close();


            // Opening File3
            FileInputStream file3In = new FileInputStream("X:\\Java-undergrad-course\\Assignments\\Assignment_4\\files\\File3.txt");

            // printing file3
            System.out.println("\nFile3: " + file3In.readAllBytes());
            System.out.println();

            // closing file 3
            file3In.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();

        // FileWriter Class
        System.out.println("\n------Using FileWriter Class------\n");
        try {            // opening files
            FileInputStream file1 = new FileInputStream("X:\\Java-undergrad-course\\Assignments\\Assignment_4\\files\\File1.txt");
            FileInputStream file2 = new FileInputStream("X:\\Java-undergrad-course\\Assignments\\Assignment_4\\files\\File2.txt");
            FileWriter file3Out = new FileWriter("X:\\Java-undergrad-course\\Assignments\\Assignment_4\\files\\File3_FW.txt");

            // calculating size of file 1, 2
            int sizeFile1 = file1.available()/2;
            int sizeFile2 = file2.available()/2;

            // copying from file 1, 2
            byte[] file1bytes = new byte[sizeFile1];
            file1.read(file1bytes, 0, sizeFile1);
            
            byte[] file2bytes = new byte[sizeFile2];
            file2.skip(sizeFile2);
            file2.read(file2bytes, 0, sizeFile2);

            int ch;
            for( int i = 0 ; i < sizeFile1 && (ch = file1.read()) != -1; i++ ){
                file3Out.append((char)ch);
            }
            boolean write = false;
            for( int i = 0 ; i < sizeFile2*2 && (ch = file2.read()) != -1; i++ ){
                if( i == sizeFile2 ){
                    write = true;
                }
                if( write ){
                    file3Out.append((char)ch);
                }
            }

            // closing files
            file1.close();
            file2.close();
            file3Out.close();

            // Opening File3
            FileInputStream file3In = new FileInputStream("X:\\Java-undergrad-course\\Assignments\\Assignment_4\\files\\File3.txt");

            // printing file3
            System.out.println("\nFile3: " + file3In.readAllBytes());
            System.out.println();

            // closing file 3
            file3In.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        sc.close();
    }
}
