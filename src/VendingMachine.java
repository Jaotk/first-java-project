import java.util.HashMap;
import java.util.Scanner;

public class VendingMachine {
    Scanner sc = new Scanner(System.in);
    private int vmcMoney;
    HashMap<String, Drink> drinkMap = new HashMap<String, Drink>();

    public void mapPutNewDrink(String name, int price, int count){
        drinkMap.put(name, new Drink(name, price, count));
    }
    public void removeDrink(String name){
        drinkMap.remove(name);
    }
    public void changeDrink(){
        System.out.println("바꿀 메뉴를 적어주세요.");
        String change_name = sc.next();
        removeDrink(change_name);
        newMenu();
    }
    public void newMenu(){
        System.out.println("새로운 메뉴를 적어주세요.");
        String new_name = sc.next();
        System.out.println("가격을 적어주세요.");
        int price = sc.nextInt();
        System.out.println("재고를 적어주세요.");
        int count = sc.nextInt();
        mapPutNewDrink(new_name, price, count);
        System.out.println(new_name + "메뉴가 생성되었습니다.");

    }
    public void changePrice(){
        drinkShowInfo();
        System.out.println(("가격을 바꿀 메뉴를 적어주세요."));
        String name = sc.next();
        System.out.println("해당 메뉴의 변동가격을 적어주세요.");
        int price = sc.nextInt();
        if(price > 0 && drinkMap.get(name) != null){
        drinkMap.get(name).setPrice(price);}
        else{
            System.out.println("다시 적어주세요.");
            changePrice();
        }
    }

    public void changeCount(){
        drinkShowInfo();
        System.out.println(("재고를 바꿀 메뉴를 적어주세요."));
        String name = sc.next();
        System.out.println("해당 메뉴의 재고를 적어주세요.");
        int count = sc.nextInt();
        if(count > 0 && drinkMap.get(name) != null){
            drinkMap.get(name).setCount(count);}
        else{
            System.out.println("다시 적어주세요.");
            changePrice();
        }
    }

    public int getVmcMoney() {
        return vmcMoney;
    }

    public void setVmcMoney(int money) {
        this.vmcMoney = money;
    }

    public int getPrice(String name){
        return drinkMap.get(name).getPrice();
    }

    public void buyCount(String name) {
        if(drinkMap.get(name).getCount() > 0)
            drinkMap.get(name).setCount(drinkMap.get(name).getCount() - 1);
    }

    public void buyDrink(int money, String name){

            if(money >= getPrice(name) && drinkMap.get(name).getCount() > 0) {
                money = money - getPrice(name);
                vmcMoney += getPrice(name);
                buyCount(name);
                System.out.println("현재유저의 돈은 : " + money);
            }
        else{
            System.out.println("돈 또는 재고가 부족합니다.");
        }
    }

    public void drinkShowInfo(){
        System.out.println("============");
        for ( String key : drinkMap.keySet() ) {
            drinkMap.get(key).showInfo();
            }
        System.out.println("============");
    }
}

