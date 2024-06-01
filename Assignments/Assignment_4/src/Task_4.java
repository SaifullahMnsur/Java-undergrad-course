import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class Task_4 {
    public static void main(String[] args) {
        String filePath = "X:\\Java-undergrad-course\\Assignments\\Assignment_4\\files\\random_access.txt";

        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "rw");
            randomAccessFile.seek(0);
            Random random = new Random();
            for( int i = 0 ; i < 50 ; i++ ){
                int rand = 100 + random.nextInt(51);
                System.out.println("Rand: " + rand );
                randomAccessFile.writeInt(rand);
            }
            randomAccessFile.seek(0);
            System.out.print("File content: ");
            while (randomAccessFile.getFilePointer() < randomAccessFile.length()){
                System.out.print(randomAccessFile.readInt() + " ");
            }
            System.out.println();
            System.out.println();
            
            randomAccessFile.seek(0);
            // looping 50 times and randomly accessing to modify the values
            for (int i = 0; i < 50; i++) {
                randomAccessFile.seek(0);
                int index  = (int)random.nextLong(1, 50);
                int rand = 1 + random.nextInt(50);

                long position = (index - 1) * Integer.BYTES;
                randomAccessFile.seek(position);
                randomAccessFile.writeInt(rand);
                
                System.out.println("Modified to: " + rand);
            }
            randomAccessFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
