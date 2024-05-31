import java.util.stream.IntStream;

public class Task_5 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> subtask_a());
        Thread thread2 = new Thread(() -> subtask_b());
        Thread thread3 = new Thread(() -> subtask_c());
        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void sleeper(){
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void subtask_a(){
        IntStream.rangeClosed('A', 'Z').mapToObj(c -> (char)c).forEach( c -> {
            System.out.print( c + " ");
            sleeper();
        });
        IntStream.rangeClosed('a', 'z').mapToObj(c -> (char)c).forEach( c -> {
            System.out.print( c + " ");
            sleeper();
        });
    }
    private static void subtask_b(){
        for( int i = 0 ; i < 100 ; i++ ){
            System.out.print("@ ");
            sleeper();
        }
    }
    private static void subtask_c(){
        for( int i = 0 ; i < 100 ; i++ ){
            System.out.print((int)(i+1) + " ");
            sleeper();
        }
    }
}
