public class Task_5_Enhanced {
    // UNICODE color codes
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public static final String GRAY = "\u001B[90m";
    public static final String RESET = "\u001B[0m";

    // FORMETTED ROW TEMPLATE
    public static String rowTemplate;

    public static void main(String[] args) {
        
        // Create a task object with a parameter of sleep time
        Task task = new Task(931);
        
        // pass the functions to run in each thread
        Thread t1 = new Thread(task::calChars);
        Thread t2 = new Thread(task::calAt);
        Thread t3 = new Thread(task::calInts);

        // create a formatted template to be used in each row!
        // Here we have 4 parametes: %4s, %7s, %7s, %7s, we will set these values by passing 4 arguments
        rowTemplate =  GREEN + "| " + GRAY + "%4s" + GREEN +" | " + YELLOW + "%7s" + GREEN + " | " + BLUE + "%7s" + GREEN + " | " + RED + "%7s" + GREEN + " |\n";
        
        // Shows thread started notification
        System.out.println(CYAN + "\n---------- Threads  Started ----------");

        // print the initial table
        printTable();

        // start threads
        t1.start();
        t2.start();
        t3.start();

        // until all the task is completed keep updating the table
        while( !task.isCharCompleted || !task.isAtCompleted || !task.isIntCompleted ){
            updateTable(task.currChar, task.currAt, task.currInt, task.charDuration, task.atDuration, task.intDuration); // update table
            task.sleeper(); // sleep
        }
        updateTable(task.currChar, task.currAt, task.currInt, task.charDuration, task.atDuration, task.intDuration); // final update of table

        // print Threads completed notification
        System.out.println(CYAN + "---------- Threads Completed ---------\n" + RESET);
    }

    private static void printTable(){
        // Print the table
        System.out.printf(GREEN + "--------------------------------------\n");
        System.out.printf(rowTemplate, "Task", "Task 1", "Task 2", "Task 3");
        System.out.printf("--------------------------------------\n");
        System.out.printf(rowTemplate, "Data", "A", "@", "1");
        System.out.printf("--------------------------------------\n");
        System.out.printf(rowTemplate, "Time", "0ms", "0ms", "0ms");
        System.out.printf("--------------------------------------\n");
    }

    private static void updateTable(char t1Data, char t2Data, int t3Data, long t1Time, long t2Time, long t3Time){
        // the row we have to update starts from 4th row of the main table, we are at 8th row from table top, so move the cursor 4 row above
        moveUp(); moveUp(); moveUp(); moveUp();

        // clear the content of 4th row of table and update with new data
        clearRow();
        System.out.printf(rowTemplate, "Data", t1Data, t2Data, t3Data);
        
        // move to 6th row of the table and clear and update data
        moveDown();
        clearRow();
        System.out.printf(rowTemplate, "Time", t1Time+"ms", t2Time+"ms", t3Time+"ms");
        
        // move to the 8th row from table top
        moveDown();
    }
        
    private static void moveUp(){
        // ANSII escape code to move the cursor to 1 row above
        System.out.print("\033[1A");
    }
    private static void moveDown(){
        // ANSII escape code to move the cursor to 1 row down
        System.out.print("\033[1B");
    }
            
    @SuppressWarnings("unused")
    private static void moveToFront(){
        // ANSII escape code to move the cursor to the front of the current row
        System.out.print("\033[1G");
    }

    private static void clearRow() {
        // ANSII escape code to clear the contents of current row
        System.out.print("\033[2K");
    }
}

class Task{
    public boolean isCharCompleted = false, isAtCompleted = false, isIntCompleted = false;
    public int currInt = 1, sleepTime;
    public char currChar = 'A', currAt = '@';
    public long charDuration, atDuration, intDuration;

    public Task(int sleepTime) {
        super();
        this.sleepTime = sleepTime;
    }

    public void sleeper(){
        try {
            Thread.sleep(sleepTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void calChars(){
        long start = System.currentTimeMillis();
        for( char i = 'A' ; i <= 'Z'; i++ ){
            currChar = i;
            charDuration = System.currentTimeMillis() - start;
            sleeper();
        }
        for( char i = 'a' ; i <= 'z'; i++ ){
            currChar = i;
            charDuration = System.currentTimeMillis() - start;
            sleeper();
        }
        isCharCompleted = true;
        return;
    }

    public void calAt(){
        long start = System.currentTimeMillis();
        for( int i = 1 ; i <= 100; i++ ){
            currAt = '@';
            atDuration = System.currentTimeMillis() - start;
            sleeper();
        }
        isAtCompleted = true;
        return;
    }

    public void calInts(){
        long start = System.currentTimeMillis();
        for( int i = 1 ; i <= 100; i++ ){
            currInt = i;
            intDuration = System.currentTimeMillis() - start;
            sleeper();
        }
        isIntCompleted = true;
        return;
    }
}