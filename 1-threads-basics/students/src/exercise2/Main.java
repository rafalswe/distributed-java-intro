package exercise2;

public class Main {

    public static void main(String[] args) 
    {
    	Thread[] tab = new Thread[4];
    	tab[0] = new MyThread("Thread-0");
    	tab[1] = new MyThread("Thread-1");
    	tab[2] = new MyThread("Thread-2");
    	tab[3] = new MyThread("Thread-3");
    	for (int i=0; i<4; i++)
    	{
    		tab[i].start();
    	}
    	
    }
}
