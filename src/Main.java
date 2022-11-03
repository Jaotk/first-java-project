import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean a = true;
        User cho = new User("11", 100000);
        VendingMachine vmc = new VendingMachine();

        vmc.mapPutNewDrink("powerAde", 3000 , 12);
        vmc.mapPutNewDrink("beer", 5500 ,20);
        vmc.mapPutNewDrink("coffee", 3500 ,15);

        while (a){
            vmc.drinkShowInfo();
            int index = sc.nextInt();

            if(index == 1){
                vmc.buyDrink(cho.getMoney(), "powerAde");
                cho.setMoney(cho.getMoney() - vmc.getPrice("powerAde"));
            } else if (index == 2) {
                vmc.buyDrink(cho.getMoney(), "coffee");
                cho.setMoney(cho.getMoney() - vmc.getPrice("coffee"));

            } else if (index == 3) {
                vmc.buyDrink(cho.getMoney(), "beer");
                cho.setMoney(cho.getMoney() - vmc.getPrice("beer"));
            } else if (index == 4) {

            }
            else if (index == 1004){
                System.out.println("1. 메뉴 변경");
                System.out.println("2. 메뉴 가격 변경");
                System.out.println("3. 메뉴 재고 추가");
                System.out.println("4. 메뉴 추가");
                System.out.println("5. 현재 수익");
                int i = sc.nextInt();
                if(i == 1) vmc.changeDrink();
                else if(i == 2) vmc.changePrice();
                else if(i == 3) vmc.changeCount();
                else if(i == 4) vmc.newMenu();
                else if(i == 5) System.out.println("현재 수익은 " + vmc.getVmcMoney());

            }



    }
}}