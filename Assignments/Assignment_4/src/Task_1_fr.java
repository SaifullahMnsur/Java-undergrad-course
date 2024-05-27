import java.io.FileReader;

public class Task_1_fr {
    public static void main(String[] args) throws Exception{
        String filePath = "..\\files\\sample.txt";
        FileReader fr;

        fr = new FileReader(filePath);

        int fileSize = 0;
        while ( fr.read() != -1 ) {
            fileSize++;
        }
        System.out.println("File size: " + fileSize);
        fr.close();

        fr = new FileReader(filePath);
        int n = fileSize/2;

        // making char array to charecter stream
        char []buffer = new char[n];
        fr.read(buffer);

        System.out.println("First " + n + " bytes: ");
        for (int i = 0; i < n; i++) {
            System.out.print(buffer[i] + " ");
        }

        fr.close();
    }
}
