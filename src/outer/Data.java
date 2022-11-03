package outer;

public class Data {
	private String drink;	// 음료 
	private int price;		// 가격
	private int count;		// 재고;
	private int money;		// 잔액;
	
	public Data() {
		super();
	}
	
	
	
	public Data(String drink, int price, int count) {
		super();
		this.drink = drink;
		this.price = price;
		this.count = count;
	}

	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "MachineData [drink=" + drink + ", price=" + price + ", count=" + count + ", money=" + money + "]";
	}
	
	public void display() {
		System.out.println(drink+"\t"+price+"\t"+count);
	}
	
}
