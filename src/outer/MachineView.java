package outer;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

public class MachineView {
	
	private static Scanner sc = new Scanner(System.in);
	private static LinkedHashMap<String, Data> hm = new LinkedHashMap<String, Data>();
	private static Iterator<String> iter;
	private static Set<String> set;
	private static Data data;
	private static final short PWD = 1004;
	private static int money;
	
	
	
	public static void main(String[] args) {
		initData();
		selling();
	}
	
	private static void initData(){
		
		Data data1 = new Data("커피", 1000, 10);
		Data data2 = new Data("주스", 2000, 20);
		Data data3 = new Data("콜라", 3000, 30);
		
		hm.put("커피", data1);
		hm.put("주스", data2);
		hm.put("콜라", data3);		
		
	}
	
	private static void selling() {
		while(true) {

			System.out.println("어서요세요, 음료수 자판기 입니다.\n");

			display();
			
			System.out.println("구매하실 음료수를 입력해 주세요.");
			String drink = sc.next();
			System.out.println("\n금액을 입력해 주세요.");
			int price = sc.nextInt();
			
			if(price == PWD) {
				management();
			}else {
				iter=iter();
				while(iter.hasNext()) {
					data = hm.get(iter.next());
					if(data.getDrink().equals(drink)) {		// 입력한 음료가 판매 음료와 같다면?
						if(data.getCount()>0) {				// 음료의 재고가 0 이상이라면?
							if(price >= data.getPrice()) {	// 입금 금액이 판매 가격보다 크다면?
																
								money += data.getPrice();	
								data.setMoney(money);		// 수익 증가								
								
								int count = data.getCount();
								data.setCount(count - 1);	// 재고 감소
								
								System.out.println("\n잔돈 "+ (price - data.getPrice())+ "원이 반환됩니다.\n");
								
							} else if(data.getPrice() == 0) {
								System.out.println("\n0원으로는 구매할 수 없습니다.");
							} else {
								System.out.println("\n금액이 부족합니다.");
							}
						} else {
							System.out.println("\n음료의 재고가 부족합니다.");
						}
					}
				}
				
			}
		}
	}
	
	private static void management() {
		while(true) {

			System.out.println("\n--------------------------------");
			System.out.println("\n어서요세요, 관리자 메뉴 입니다.");
			System.out.println("\n--------------------------------");

			System.out.println("1. 메뉴 보기");
			System.out.println("2. 메뉴 변경");
			System.out.println("3. 가격 변경");
			System.out.println("4. 재고 추가");
			System.out.println("5. 메뉴 추가");
			System.out.println("6. 현재 수익");
			System.out.println("7. 관리자 메뉴 종료");
			
			System.out.println("-------------------------------\n");

			System.out.println("사용하실 기능 번호를 입력해 주세요.");
			int func = sc.nextInt();
			
			switch(func){
			case 1:
				display();
				break;
			case 2:			// 2. 메뉴 변경
				changeMenu();
				break;
			case 3:			// 3. 가격 변경
				changePrice();
				break;
			case 4:			// 4. 재고 추가
				addCount();
				break;
			case 5:			// 5. 메뉴 추가
				addDrink();
				break;
			case 6:			// 6. 현재 수익
				showProfit();
				break;
			case 7:			// 7. 관리자 메뉴 종료
				return;
			default:
				
				return;
				
			}
		}
	}
	
	private static Iterator<String >iter() {
		set = hm.keySet();
		Iterator<String> iter = set.iterator();
		
		return iter;
	}
	
	private static void display() {		// 1. 메뉴 보기
		System.out.println("--------------------------------");
		System.out.println("음료\t가격\t재고");
		
		iter = iter();
		while(iter.hasNext()) {
			
			data = hm.get(iter.next());
			data.display();
			
		}
		System.out.println("--------------------------------\n");
	}
	
	private static void changeMenu() {	// 2. 메뉴 변경
		System.out.println("\n음료 이름을 입력해 주세요.");
		String drink = sc.next();
		System.out.println();
				
		iter=iter();
		
		while(iter.hasNext()) {
			data = hm.get(iter.next());
			
			if(data.getDrink().equals(drink)) {
				System.out.println(data);
				
				System.out.println("\n변경할 음료 이름을 입력해 주세요.");
				String cDrink = sc.next();
				data.setDrink(cDrink);
				
				System.out.println("음료 "+drink+"의 이름이 "+data.getDrink()+"(으)로 변경되었습니다.");
			}
		}
	}
	
	private static void changePrice() {	// 3. 가격 변경
		System.out.println("\n음료 이름을 입력해 주세요.");
		String drink = sc.next();
		System.out.println();
				
		iter=iter();
		
		while(iter.hasNext()) {
			data = hm.get(iter.next());
			
			if(data.getDrink().equals(drink)) {
				System.out.println(data);
				
				System.out.println("\n변경할 가격을 입력해 주세요.");
				int  price = sc.nextInt();
				data.setPrice(price);
				
				System.out.println("음료 "+drink+"의 가격이 "+data.getPrice()+"(으)로 변경되었습니다.");
			}
		}
	}
	
	private static void addCount() {	// 4. 재고 추가
		System.out.println("\n음료 이름을 입력해 주세요.");
		String drink = sc.next();
		System.out.println();
				
		iter=iter();
		
		while(iter.hasNext()) {
			data = hm.get(iter.next());
			
			if(data.getDrink().equals(drink)) {
				System.out.println(data);
				
				System.out.println("\n추가할 수량을 입력해 주세요.");
				int add = sc.nextInt();
				int	count = data.getCount();
				data.setCount(count+add);
				
				System.out.println("음료 "+drink+"의 재고가 "+data.getCount()+"(으)로 변경되었습니다.");
			}
		}
	}
	
	private static void addDrink() { 	// 5. 메뉴 추가
		System.out.println("\n음료 이름을 입력해 주세요.");
		String drink = sc.next();
		System.out.println("음료 가격을 입력해 주세요.");
		int price = sc.nextInt();
		System.out.println("음료 재고을 입력해 주세요.");
		int count = sc.nextInt();
		
		data = new Data(drink, price, count);
		
		if(hm.put(drink, data)!=null) {
			System.out.println("음료가 추가되었습니다.\n");
		}
	}
	
	private static void showProfit() {
		System.out.println("현재 수익은 "+ data.getMoney()+" 원 입니다.");
	}
	
}
