package HowToCreateThreads.Runnbale;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable thread is running.");
    }
}

public class Main {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}