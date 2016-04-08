package testpack;

public class Item {
	private int itemId;
	private String itemName;
	private int qty;
	private int userId;
	public Item(int itemId, String itemName, int qty, int userId) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.qty = qty;
		this.userId = userId;
	}
	public Item() {
		super();
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
