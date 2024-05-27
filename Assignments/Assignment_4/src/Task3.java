import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        File file = new File("X:\\Java-undergrad-course\\Assignments\\Assignment_4\\files\\File3_FOS.txt");
        System.out.println("Name: " + file.getName());
        System.out.println("Size: " + file.length());
        System.out.println("Last Modified: " + file.lastModified());
        System.out.println("Path: " + file.getPath());
        System.out.println("Absolute Path: " + file.getAbsolutePath());
        System.out.println("Parent: " + file.getParent());

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        byte[] fileBytes = new byte[(int)file.length()];
        try {
            FileInputStream fis = new FileInputStream(file);
            fis.read(fileBytes);
            System.out.print("First " + n + " bytes: ");
            CommonMethods.printBytes(fileBytes);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        sc.close();
    }
}
