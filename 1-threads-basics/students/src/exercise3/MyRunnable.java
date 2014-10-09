package exercise3;

public class MyRunnable implements Runnable {
	
	public void run()
	{
		for (int i=1; i<=10; i++)
		{
			System.out.println(i + ": " + new Thread(this).getName());
		}
	}
}
