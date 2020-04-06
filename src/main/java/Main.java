import models.Cart;
import models.items.Bicycle;
import models.items.Item;
import models.items.Laptop;
import utils.DataStore;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Item> items = new ArrayList<>();
    static Cart cart;
    static DataStore dataStore = new DataStore();

    public static void main(String[] args) {
        System.out.println("=================== Добро пожаловать в магазин! ===================");
        initData();
        initShop();
        System.out.println("====================== Всего доброго! ======================");
    }

    public static void initShop() {
        showAllGoods();
        System.out.println("Выберите действие:");
        System.out.println("1 - Просмотреть содержимое корзины");
        System.out.println("2 - Добавление товаров в корзину");
        System.out.println("3 - Удаление товаров из корзины");
        System.out.println("0 - Выйти из магазина");
        Scanner sc = new Scanner(System.in);
        int number;
        number = sc.nextInt();
        switch (number) {
            case (1):
                getCartContent();
                break;
            case (2):
                addItemIntoCart();
                break;
            case (3):
                removeItemFromCart();
                break;
            case (0):
                break;
            default:
                System.out.println("====================== Такой команды нет! ======================");
                initShop();
        }
    }

    public static void showAllGoods() {
        System.out.println("====================== Общий список товаров: ======================");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(
                    "ID: " + i + " | " + items.get(i).getDescription());
        }
        System.out.println("===================================================================");
    }

    public static void getCartContent() {
        System.out.println("======================== Товары в корзине: ========================");
        System.out.println(cart.getFullDescription());
        System.out.println("===================================================================");
        initShop();
    }

    public static void addItemIntoCart() {
        System.out.println("======== Вы в меню добавления товара. Введите номер товара ========");
        showAllGoods();
        Scanner sc = new Scanner(System.in);
        int number;
        number = sc.nextInt();
        cart.addItem(items.get(number));
        dataStore.writeCartContent(cart);
        System.out.println("===================================================================");
        initShop();
    }

    public static void removeItemFromCart() {
        System.out.println("========= Вы в меню удаления товара. Введите номер товара =========");
        System.out.println(cart.getFullDescription());
        Scanner sc = new Scanner(System.in);
        int number;
        number = sc.nextInt();
        cart.removeItem(number);
        dataStore.writeCartContent(cart);
        System.out.println("===================================================================");
        initShop();
    }

    public static void initData() {
        items.add(new Bicycle("04-02-2020", "Велосипед Aist", 30.00, 18, 20));
        items.add(new Bicycle("04-02-2020", "Велосипед Stels", 33.00, 21, 24));
        items.add(new Laptop("03-02-2020", "Планшет HP", 100.00, "MediaTech", 4));
        items.add(new Laptop("03-02-2020", "Планшет Asus", 150.00, "SnapDragon", 6));
        cart = dataStore.getCartFromDataStore();
    }
}