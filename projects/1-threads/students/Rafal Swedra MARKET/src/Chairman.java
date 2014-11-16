import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class Chairman implements Runnable {
	private final int MAX_CAPACITY = 10;
	private BlockingQueue<Recipient> recipientsQueue;
	private BlockingQueue<Item> itemsQueue;
	
	public Chairman(){
		recipientsQueue = new ArrayBlockingQueue<Recipient>(MAX_CAPACITY);
		itemsQueue = new ArrayBlockingQueue<Item>(MAX_CAPACITY);
	}
		
	public void closeMarket()
	{
		Market.getMenager().closeMarket();
	}
	public void drawWinner()
	{
		try
		{
			while(!itemsQueue.isEmpty())
			{					
				Item currentItem;
				currentItem = itemsQueue.poll();
				
				if(!recipientsQueue.isEmpty())
				{	
					int winnerIndex = 	((int)(Math.random() * 100)) % recipientsQueue.size();
					while(winnerIndex != recipientsQueue.size()-1)
						recipientsQueue.poll();
					Recipient winnerRecipient = recipientsQueue.poll();
					
					if(winnerRecipient == null) System.out.print("Rec problem");
					if(currentItem == null) System.out.print("Item problem");
					
					System.out.println("Winner for auction " + currentItem.getName() + " is " + winnerRecipient.getName());
					winnerRecipient.addWonItem(currentItem);
					recipientsQueue.clear();
					
				}
				else
				{
					System.out.println("There is no winner for " + currentItem.getName());
				}
				Thread.sleep(10000);
			}
		}
		catch (InterruptedException e) {
		}
	}
	
	public void run()
	{
		try 
		{
			while(!Thread.currentThread().isInterrupted())
			{
				Thread.sleep(5000);
				while(!itemsQueue.isEmpty())
				{
					drawWinner();
					Thread.sleep(5000);	
				}
				System.out.println("No auctions within 5 seconds. Closing the market.");
				if(Market.getMenager().closeMarket()) Thread.currentThread().interrupt();
			}
			System.out.println("Chairman says good bye.");
			
		}
		catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	public BlockingQueue<Item> getItemsQueue()
	{
		return itemsQueue;
	}
	public BlockingQueue<Recipient> getRecipientsQueue()
	{
		return recipientsQueue;
	}
}
