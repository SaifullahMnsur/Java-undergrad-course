public class Task_6_thread {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread thread1 = new Thread(() -> counter.increament("Thread 1"));
        Thread thread2 = new Thread(() -> counter.increament("Thread 2"));
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + counter.getCount());
    }
}

class Counter{
    private int count;
    public Counter(){
        this.count = 0;
    }
    public synchronized void increament(String name){
        for( int i = 0 ; i < 1000 ; i++ ){
            count++;
            System.out.println(name);
        }
    }
    public int getCount(){
        return count;
    }
}