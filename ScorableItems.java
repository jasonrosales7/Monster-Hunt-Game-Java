import java.util.*;

public class ScorableItems {
	private Map<String, Integer> inventory;
	
	public ScorableItems()
	{
		init(0, 0, 0);
	}
	
	public ScorableItems(int initGold, int initSilver, int initCopper)
	{
		init(initGold, initSilver, initCopper);
	}
	
	public void init(int initGold, int initSilver, int initCopper)
	{
		inventory = new HashMap<String, Integer>();
		
		inventory.put("Gold", initGold);
		inventory.put("Silver", initSilver);
		inventory.put("Copper", initCopper);
	}
	
	public void displayScorableItems()
	{
		Set<String> keySet = inventory.keySet();
		Iterator<String> it = keySet.iterator();
		
		//System.out.println("Current Inventory: ");
		while (it.hasNext())
		{
			String s = it.next();
			System.out.println(s + " : " + inventory.get(s));
		}
	}
	
	public int getItem(String key)
	{
		try
		{
			return inventory.get(key);
		}
		catch (Exception e)
		{
			return 0;
		}
	}
	
	public Map<String, Integer> removeItems()
	{
		Map<String, Integer> tempInventory = new HashMap<String, Integer>();
		
		tempInventory.put("Gold", inventory.get("Gold"));
		tempInventory.put("Silver", inventory.get("Silver"));
		tempInventory.put("Copper", inventory.get("Copper"));

		inventory.put("Gold", 0);
		inventory.put("Silver", 0);
		inventory.put("Copper", 0);
		
		return tempInventory;
	}
	
	public void addItems(Map<String, Integer> newInventory)
	{
		Set<String> keySet = newInventory.keySet();
		Iterator<String> it = keySet.iterator();
		
		while (it.hasNext())
		{
			String s = it.next();
			inventory.replace(s, inventory.get(s) + newInventory.get(s));
		}
		
	}
}