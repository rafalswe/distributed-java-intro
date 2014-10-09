package exercise2;

public class MyThread extends Thread {
	public MyThread(String parName)
	{
		super.setName(parName);
	}
	public void run()
	{
		for (int i=1; i<=10; i++)
		{
			System.out.println(i + ": " + super.getName());
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
