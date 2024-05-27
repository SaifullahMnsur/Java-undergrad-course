import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Task_2_fos {
    public static void main(String[] args) throws Exception {
        // File paths
        String file1Path = "..\\files\\File1.txt";
        String file2Path = "..\\files\\File2.txt";
        String file3Path = "..\\files\\File3_FOS.txt";

        // File input stream to read data from File1.txt and File2.txt
        FileInputStream fis1 = new FileInputStream(file1Path);
        FileInputStream fis2 = new FileInputStream(file2Path);
        
        // Get the file sizes
        int file1Size = fis1.available();
        int file2Size = fis2.available();
        
        // byte array for byte streaming
        byte []buffer1 = new byte[file1Size/2];
        byte []buffer2 = new byte[file2Size/2];
        
        // read first half of file1
        fis1.read(buffer1);
        // read first half of file2
        fis2.read(buffer2);
        // now pointer is at the middle of file 2
        // read the last half of file2
        fis2.read(buffer2);
        
        // open file3 with File output stream to write the data
        FileOutputStream fos = new FileOutputStream(file3Path);
        // write the data
        fos.write(buffer1);
        fos.write(buffer2);
        
        // close files
        fis1.close();
        fis2.close();
        fos.close();
        // writing first half of file1.txt and last half of file2.txt into file3.txt is completed
        System.out.println("C O M P L E T E D");



        // Reopen the file3.txt with File input stream object to print
        FileInputStream fis = new FileInputStream(file3Path);
        // byte array for byte streaming
        byte []buffer = new byte[fis.available()];
        // read data
        fis.read(buffer);

        // print file3.txt
        System.out.print("File 3: ");
        for (byte b : buffer) {
            System.out.print((char)b);
        }

        // close file
        fis.close();
    }
}