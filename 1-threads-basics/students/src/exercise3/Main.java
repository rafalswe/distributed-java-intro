package exercise3;

import java.util.concurrent.TimeUnit;

import exercise2.MyThread;


public class Main {


    public static void main(String[] args) 
    {
    	Thread[] tab = new Thread[4];
    	tab[0] = new Thread(new MyRunnable("Thread-1"));
    	tab[1] = new Thread(new MyRunnable("Thread-2"));
    	tab[2] = new Thread(new MyRunnable("Thread-3"));
    	tab[3] = new Thread(new MyRunnable("Thread-4"));
    
	    for (int i=0; i<4; i++)
		{
			tab[i].start();
		}
	    try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("FINISHED");
    }
}
