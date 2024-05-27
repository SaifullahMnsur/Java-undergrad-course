import java.io.FileReader;
import java.io.FileWriter;
public class Task_2_fw {
    public static void main(String[] args) throws Exception {
        // File paths
        String file1Path = "..\\files\\File1.txt";
        String file2Path = "..\\files\\File2.txt";
        String file3Path = "..\\files\\File3_FW.txt";

        // Open file1 and file2 using File reader to read / take input from
        FileReader fr1 = new FileReader(file1Path);
        FileReader fr2 = new FileReader(file2Path);
        
        // calculate files size
        int file1Size = 0;
        int file2Size = 0;
        while (fr1.read() != -1) {
            file1Size++;
        }
        while (fr2.read() != -1) {
            file2Size++;
        }
        
        // close files as the pointers are at the end now
        fr1.close();
        fr2.close();
        
        // reopen the files with filereader
        fr1 = new FileReader(file1Path);
        fr2 = new FileReader(file2Path);
        
        // char array for charecter streaming
        char []buffer1 = new char[file1Size/2];
        char []buffer2 = new char[file2Size/2];
        
        // read first half of file1
        fr1.read(buffer1);
        // read first half of file2
        fr2.read(buffer2);
        // now pointer is at the middle of file 2
        // read the last half of file2
        fr2.read(buffer2);

        // open file3 using file writer to write / give output into
        FileWriter fw = new FileWriter(file3Path);
        // write the data into file3.txt
        fw.write(buffer1);
        fw.write(buffer2);

        // close files
        fr1.close();
        fr2.close();
        fw.close();
        
        // writing first half of file1.txt and last half of file2.txt into file3.txt is completed
        System.out.println("C O M P L E T E D");


        // Open file3 using file reader to read / take input from
        FileReader fr = new FileReader(file3Path);
        // calculate file size
        int file3Size = 0;
        while( fr.read() != -1 ){
            file3Size++;
        }
        // close file as the pointer is at the end
        fr.close();

        // to start from the beginning
        // Reopen file3 using file reader to read / take input from
        fr = new FileReader(file3Path);
        // char array for charecter streaming
        char []buffer = new char[file3Size];
        // read file3
        fr.read(buffer);

        // print file3
        System.out.print("File 3: ");
        for (char c : buffer) {
            System.out.print(c);
        }

        // close file 3
        fr.close();
    }
}
