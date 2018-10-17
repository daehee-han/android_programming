//Implement Runnable Interface...
class ImplementsRunnable implements Runnable {
    private int counter = 0;
    public void run() {
        for (int i = 0; i < 5; i++) { 
            counter++;
            System.out.println("Counter " + counter);
        }
    }
}

//Extend Thread class...
class ExtendsThread extends Thread {
    private int counter = 0;
    public void run() {
        for (int i = 0; i < 5; i++) { 
            counter++;
            System.out.println("Counter " + counter);
        }
     }
}

public class ThreadVsRunnable {
public static void main(String args[]) throws Exception {
    ImplementsRunnable rc = new ImplementsRunnable();
    Thread[] t1 = new Thread[3];
    for (int i=0; i<3; i++) {
        t1[i] = new Thread(rc);
        t1[i].start();
        Thread.sleep(1000);
    }

    ExtendsThread[] t2 = new ExtendsThread[3];
    for (int i=0; i<3; i++) {
        t2[i] = new ExtendsThread();
        t2[i].start();
        Thread.sleep(1000);
    }
 }
}

