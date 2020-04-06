import models.Cart;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DataStore;

public class CartTest {

    @Test(groups = {"Items", "Price"})
    public void emptyCartCostZero() {
        DataStore store = new DataStore();
        Cart cart = store.getCartFromDataStore();
        Assert.assertEquals(cart.getTotalCost(), 0);
    }
}
