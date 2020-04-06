import models.Cart;
import models.items.Bicycle;
import models.items.Item;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import utils.DataStore;

import java.util.ArrayList;
import java.util.List;

public class DataStoreTest {

    @Ignore
    @Test
    public void test() {
        List<Item> items = new ArrayList<>();
        items.add(new Bicycle("04-02-2020", "Велосипед Aist", 30.00, 18, 20));
        items.add(new Bicycle("04-02-2020", "Велосипед Test", 30.00, 18, 20));
        Cart cart = new Cart();
        cart.addItem(items.get(0));
        cart.addItem(items.get(1));
        DataStore store = new DataStore();
        store.writeCartContent(cart);
    }

    @BeforeTest
    public void preTest() {
        test();
    }

    @Test(description = "Searching that all added bicycles are in DataStore")
    public void containsBicycles() {
        DataStore store = new DataStore();
        Assert.assertTrue(store.getCartFromDataStore().getFullDescription().contains("Велосипед Aist"), "Contains Aist");
        Assert.assertTrue(store.getCartFromDataStore().getFullDescription().contains("Велосипед Test"), "Contains Test");
    }

    @Test(description = "compare data from Cart to DataStore")
    public void compareWithCart() {
        DataStore store = new DataStore();
        Cart cart = store.getCartFromDataStore();
        Assert.assertEquals(cart.getFullDescription(), store.getCartFromDataStore().getFullDescription(), "Data is the same");
    }

    @AfterTest
    public void clearData() {
        DataStore store = new DataStore();
        store.getCartFromDataStore().removeItem(1);
        store.getCartFromDataStore().removeItem(0);
        Cart cart = new Cart();
        store.writeCartContent(cart);
    }

}
