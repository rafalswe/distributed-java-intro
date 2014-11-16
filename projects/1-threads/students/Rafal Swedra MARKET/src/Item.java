
public class Item {
	private String name;
	private int id;
	private static int nextId = 1;
	
	public Item(String name)
	{
		this.name = (name + " " + nextId);
		this.setId(nextId);
		nextId++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
