import java.lang.annotation.Retention;
import java.util.concurrent.BlockingQueue;


public class Market {

	/**
	 * @param args
	 */
	
	private static Menager menager;
	private static  Chairman chairman;
	private static Thread menagerThread;
	
	public Market(int cDonors, int cRecipients)
	{
		chairman = new Chairman();
		setMenager(new Menager(cDonors, cRecipients));
		menagerThread = new Thread(menager);
		Thread chairmanThread = new Thread(chairman);
		menagerThread.start();
		chairmanThread.start();
	}
	
	public static Thread getThreadMenager()
	{
		return menagerThread;
	}
	public static Menager getMenager() {
		return menager;
	}

	public void setMenager(Menager menagerPar) {
		menager = menagerPar;
	}
	public static BlockingQueue<Item> getItemsQueue()
	{
		return chairman.getItemsQueue();
	}
	
	public static BlockingQueue<Recipient> getRecipientsQueue()
	{
		return chairman.getRecipientsQueue();
	}

}
