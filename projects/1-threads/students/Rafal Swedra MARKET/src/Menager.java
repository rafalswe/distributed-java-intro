import java.util.Vector;


public class Menager implements Runnable {
	private Vector<Donor> donors;
	private Vector<Recipient> recipients;
	private Vector<Thread> donorsThreads;
	private Vector<Thread> recipientsThreads;
	private int cDonors;
	private int cRecipients;
	
	
	
	public Menager (int cDonorsPar, int cRecipientsPar)
	{
		donors = new Vector<Donor>();
		recipients = new Vector<Recipient>();
		donorsThreads = new Vector<Thread>();
		recipientsThreads = new Vector<Thread>();
		cDonors = cDonorsPar;
		cRecipients = cRecipientsPar;
		//this.openMarket();
	}
	
	public void registerDonor(int parC)
	{
		
		for(int i = 1; i<=parC; i++)
		{
			donors.add(new Donor("Darczynca", i));
		}
		
	}
	public void registerRecipient(int parC)
	{
		for(int i = 1; i<=parC; i++)
		{
			recipients.add(new Recipient("Obdarowany"));
		}
	}
	public void openMarket()
	{
		for(int i = 0; i < donors.size(); i++)
		{
			donorsThreads.add(new Thread(donors.get(i)));
			donorsThreads.get(i).start();
		}
		for(int i = 0; i < recipients.size(); i++)
		{
			recipientsThreads.add(new Thread(recipients.get(i)));
			recipientsThreads.get(i).start();
		}
	}
	
	public boolean closeMarket() 
	{
		for(int i = 0; i < donorsThreads.size(); i++)
		{
			donorsThreads.get(i).interrupt();
		}
		for(int i = 0; i < recipientsThreads.size(); i++)
		{		
			recipientsThreads.get(i).interrupt();
		}
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Market.getThreadMenager().interrupt();
		return true;
		
	}
	
	public void run()
	{
			this.registerDonor(cDonors);
			this.registerRecipient(cRecipients);
			this.openMarket();
			while(!Thread.currentThread().isInterrupted())
			{}
			System.out.println("Menager says goodbye and closes the Market");
	}
}
