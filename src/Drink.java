import java.util.HashMap;

public class Drink {
    private String name;
    private int price;
    private int count;

    HashMap<String, Object> menuMap = new HashMap<String, Object>();

    public Drink(String name, int price, int count){
        this.name = name;
        this.price = price;
        this.count = count;
        putDrinkMap(name, price, count);
    }

    public void putDrinkMap(String name, int price, int count){
        menuMap.put("이름", name);
        menuMap.put("가격", price);
        menuMap.put("재고", count);
    }

    public HashMap<String, Object> getMenuMap() {
        return menuMap;
    }

    public void showInfo(){
        System.out.println("이름 : "+ menuMap.get("이름"));
        System.out.println("가격 : "+ menuMap.get("가격"));
        System.out.println("재고 : "+ menuMap.get("재고"));
        System.out.println();
    }

    public String getName() {
        return (String)menuMap.get("이름");
    }

    public void setName(String name) {
        menuMap.put("이름", name);
    }


    public int getPrice() {
        return (int)menuMap.get("가격");
    }

    public void setPrice(int price) {
        menuMap.put("가격", price);
    }

    public int getCount() {
        return (int)menuMap.get("재고");
    }

    public void setCount(int count) {
        menuMap.put("재고", count);
    }

    public void setMenuMap(HashMap<String, Object> menuMap) {
        this.menuMap = menuMap;
    }

}
