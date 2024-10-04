import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Task_2_fos {
    public static void main(String[] args) throws Exception {
        // File paths
        String file1Path = ".\\text-files\\File1.txt";
        String file2Path = ".\\text-files\\File2.txt";
        String file3Path = ".\\text-files\\File3_FOS.txt";

        // Open File1 and File2 using file input stream to read / take input from
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
        
        // open file3 using file output stream to write / give output into
        FileOutputStream fos = new FileOutputStream(file3Path);
        // write the data
        fos.write(buffer1);
        fos.write(buffer2);
        
        // close files
        fis1.close();
        fis2.close();
        fos.close();

        // writing first half of file1 and last half of file2 into file3 is completed
        System.out.println("C O M P L E T E D");



        // Reopen file3 using File input stream to read / take input from
        FileInputStream fis = new FileInputStream(file3Path);
        // byte array for byte streaming
        byte []buffer = new byte[fis.available()];
        // read data
        fis.read(buffer);

        // print file3
        System.out.print("File 3: ");
        for (byte b : buffer) {
            System.out.print((char)b);
        }

        // close file
        fis.close();
    }
}