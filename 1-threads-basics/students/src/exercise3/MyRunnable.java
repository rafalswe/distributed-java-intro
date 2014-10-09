package exercise3;

public class MyRunnable implements Runnable {

	public  MyRunnable(String parname)
	{
		new Thread(this).setName(parname);
	}
	public void run()
	{
		Thread x = new Thread(this);
		for (int i=1; i<=10; i++)
		{
			System.out.println(i + ": " + x.getName());
		}
	}
}
