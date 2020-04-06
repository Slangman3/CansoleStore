import models.Cart;
import models.items.Bicycle;
import models.items.Item;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ItemTest {

    @Test(groups = {"Items", "Description"})
    public void itemContainsAllDescription() {
        List<Item> items = new ArrayList<>();
        items.add(new Bicycle("04-02-2020", "Велосипед Aist", 30.00, 18, 20));
        items.add(new Bicycle("04-02-2020", "Велосипед Test", 30.00, 18, 20));
        Cart cart = new Cart();
        cart.addItem(items.get(0));
        cart.addItem(items.get(1));
        Assert.assertEquals(items.size(), 2);
    }

    @Test(groups = {"Items"})
    public void trackHasTruePrice() {
        List<Item> items = new ArrayList<>();
        items.add(new Bicycle("04-02-2020", "Велосипед Track", 100.00, 18, 20));
        Assert.assertEquals(items.get(0).getPrice(), 130.00);
    }
}
