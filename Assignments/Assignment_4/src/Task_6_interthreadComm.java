import java.util.Scanner;

public class Task_6_interthreadComm {
    public static void main(String[] args) {
        // Counter counter = new Counter();
        // Thread incThread = new Thread(() -> counter.increament("Thread 1"));
        // Thread decThread = new Thread(() -> counter.decreament("Thread 2"));
        // incThread.start();
        // decThread.start();
        // try {
        //     incThread.join();
        //     decThread.join();
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        // System.out.println("Final count: " + counter.getCount());

        Chat chat = new Chat();
        new Questioner(chat);
        new Answerer(chat);

    }
}

class Counter{
    private int count;
    public Counter(){
        this.count = 0;
    }
    public synchronized void increament(String name){
            System.out.println("Increament running!");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Increament resumed");
            notify();
    }

    public synchronized void decreament(String name){
            System.out.println("Decreament running!");
            System.out.println("Press enter to continue!");
            Scanner sc = new Scanner(System.in);
            sc.nextLine();
            sc.close();
            System.out.println("Enter pressed!");
            notify();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Ending decreament!");
    }

    public int getCount(){
        return count;
    }
}



// Chatting system

class Chat{
    boolean doAsk;
    public Chat(){
        doAsk = false;
    } 
    public synchronized void ask(String msg){
        if( doAsk ){
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.print(msg);
        doAsk = true;
        notify();   
    }

    public synchronized void ans(String msg){
        if( !doAsk ){
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(msg);
        doAsk = false;
        notify();
    }
}

class Questioner implements Runnable {

    Chat chat;
    String[] questions;
    
    public Questioner(Chat chat){
        this.chat = chat;
        questions = new String[]{"Uni: ", "Dept: ", "Session: ", "Year: "};
        new Thread(this, "Questions").start();;
    }

    @Override
    public void run() {
        for( int i = 0 ; i < questions.length ; i++ ){
            chat.ask(questions[i]);
        }
    }
    
}

class Answerer implements Runnable {

    Chat chat;
    String[] answers;

    public Answerer(Chat chat){
        this.chat = chat;
        answers = new String[]{"RU", "ICE", "20-21", "3rd"};
        new Thread(this, "Answers").start();
    }

    @Override
    public void run() {
        for( int i = 0 ; i < answers.length ; i++ ){
            chat.ans(answers[i]);
        }
    }
    
}