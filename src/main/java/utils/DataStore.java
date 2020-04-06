package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Cart;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class DataStore {

    public void writeCartContent(Cart cart) {
        try (Writer writer = new FileWriter(System.getProperty("user.dir") + "/src/main/resources/cart.json")) {
            new GsonBuilder().setPrettyPrinting().create().toJson(cart, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Cart getCartFromDataStore() {
        Gson gson = new Gson();
        String propertyFilePath = System.getProperty("user.dir") + "/src/main/resources/cart.json";
        Cart cart = gson.fromJson(new FileUtils().getFileContent(propertyFilePath), Cart.class);
        if (null == cart) {
            cart = new Cart();
        }
        return cart;
    }
}