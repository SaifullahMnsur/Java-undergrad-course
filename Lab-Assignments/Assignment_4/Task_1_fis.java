import java.io.FileInputStream;

public class Task_1_fis{
    public static void main(String[] args) throws Exception{
        // File path
        String filePath = ".\\text-files\\sample.txt";
        
        // open file using file input stream to read / take input from
        FileInputStream fis = new FileInputStream(filePath);

        // Get the file size
        int fileSize = fis.available();
        System.out.println("File size: " + fileSize);
        
        // take n as half of the file size
        int n = fileSize/2;

        // making a byte array to byte stream
        byte []buffer = new byte[n];

        // reads n bytes from fis file
        fis.read(buffer);

        // print bytes
        System.out.println("First " + n + " bytes: ");
        for (int i = 0; i < n; i++) {
            System.out.print(buffer[i] + " ");
        }
        System.out.println();

        // File close
        fis.close();
    }
}