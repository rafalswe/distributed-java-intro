import java.util.Vector;


public class Donor implements Runnable {
	private String name;
	private static int nextId = 1;
	private Vector<Item> items;
	
	public Donor(String name, int cItems)
	{
		items = new Vector<Item>();
		this.name = (name + " " + nextId);
		nextId++;
		for(int i = 1; i<=cItems; i++)
		{
			items.add(new Item("Przedmiot"));
		}
	}
	
	public void registerItem()
	{
		try
		{
			Item currentItem;
			currentItem = items.remove(items.size()-1);
			while (!Market.getItemsQueue().offer(currentItem))
			{
					Thread.sleep(5000); 
			}
			int randomTime = (int)(Math.random()*26 + 5);
			randomTime = randomTime * 1000;
			Thread.sleep(randomTime);
		}
		catch (InterruptedException e)
		{			
		}
		
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void run()
	{
		
		while(!Thread.currentThread().isInterrupted())
		{
			while(!items.isEmpty())
			{
				registerItem();
			}
		}
		System.out.println(this.getName() + " says good bye");
		
	}
	
}
