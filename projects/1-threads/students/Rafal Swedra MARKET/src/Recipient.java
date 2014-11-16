import java.util.Vector;


public class Recipient implements Runnable {
	private String name;
	private static int nextId = 1;
	private Vector<Item> wonItems;
 	
	public Recipient(String name)
	{
		wonItems = new Vector<Item>();
		this.name = (name + " " + nextId);
		nextId++;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void registerOnAuction()
	{
		try
		{
			int itemsSize = wonItems.size();
			if(Market.getRecipientsQueue().offer(this))
			{
				System.out.println("Registering " + this.getName());
				while(!Market.getRecipientsQueue().isEmpty())
				{
					if (Thread.currentThread().isInterrupted())  break;
				}
				Thread.sleep(100);
			}
			if(itemsSize < wonItems.size())
			{
				System.out.println(this.getName() + " won " + wonItems.get(wonItems.size() - 1).getName());
				int sleepTime = (int)(Math.random()*11+5);
				sleepTime = sleepTime * 1000;
				Thread.sleep(sleepTime);
			}
		}
		catch (InterruptedException e)
		{
		}
		
	}
	
	public void addWonItem(Item won)
	{
		wonItems.add(won);
	}
	
	public void run()
	{
		try
		{	
			while(!Thread.currentThread().isInterrupted())
			{
				if(!Market.getItemsQueue().isEmpty()) 
				{
					registerOnAuction();
					Thread.sleep(5000);
				}
			}
			
			System.out.println(this.getName() + " says good bye leaving with items: ");
			if(wonItems.size() != 0)
				for(int i = 0; i < wonItems.size(); i++)
				{
					System.out.println(wonItems.get(i).getName());
				}
			else
				System.out.println("NO ITEMS");
		}
		catch (InterruptedException e)
		{}
	}
	
	
}
