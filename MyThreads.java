import java.util.*;
import java.io.*;
import java.util.concurrent.*;
import java.lang.Thread.*;

public class MyThreads extends Thread   {
private Semaphore maySleep = new Semaphore(1);
boolean running = true;
 

public MyThreads () {
    
Sleepy s1 = new Sleepy(1);    
Thread t1 = new Thread(s1);

Sleepy s2 = new Sleepy(2);
Thread t2 = new Thread(s2);

Sleepy s3 = new Sleepy(3);
Thread t3 = new Thread(s3);

Sleepy s4 = new Sleepy(4);
Thread t4 = new Thread(s4);

Sleepy s5 = new Sleepy(5);
Thread t5 = new Thread(s5);

System.out.println("Constructor of Threads is completed");   
}

public class Sleepy implements Runnable {

private int id;
public Sleepy (int id) {
this.id=id;
}

public void run() {
while(running){
    try {
maySleep.acquire();
System.out.println("Thread " +id+ " has acquired a permit to sleep");

 
Thread.sleep(200);

} catch (InterruptedException e) {
System.out.println("Interrupted");
}
System.out.println("Thread " +id+ " has woken up");
maySleep.release();
}
System.out.println("Thread " +id+ " has completed its execution");
}
}
 protected void finalize() throws Throwable
    {
        
        running = false;
    }



}
