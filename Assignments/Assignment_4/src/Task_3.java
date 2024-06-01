import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Task_3 {
    public static void main(String[] args) {
        File file = new File("..\\files\\File3_FOS.txt");
        System.out.println("Name: " + file.getName());
        System.out.println("Size: " + file.length());
        System.out.println("Is it a file: " + (file.isFile() ? "YES" : "NO"));
        System.out.println("Path: " + file.getPath());
        System.out.println("Last Modified: " + file.lastModified());
        System.out.println("Absolute Path: " + file.getAbsolutePath());
        System.out.println("Parent: " + file.getParent());
        System.out.println("Parent File: " + file.getParentFile());
        System.out.println("Total space: " + file.getTotalSpace());
        

        Scanner sc = new Scanner(System.in);
        long fileSize = file.length();
        try {
            FileReader fis = new FileReader(file);
            int n = (int) (fileSize/2);
            char []buffer = new char[n];
            fis.read(buffer);
            System.out.print("First " + n + " bytes: ");
            for (char c : buffer) {
                System.out.print(c);
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        sc.close();
    }
}
