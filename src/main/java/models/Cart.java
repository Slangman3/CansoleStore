package models;

import com.google.gson.annotations.Expose;
import models.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    @Expose
    private List<Item> items;
    @Expose
    private double totalCost;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
        totalCost += item.getPrice();
    }

    public void removeItem(int itemIndex) {
        Item item = items.get(itemIndex);
        totalCost -= item.getPrice();
        items.remove(itemIndex);
    }

    public String getFullDescription() {
        StringBuilder description = new StringBuilder();
        if (items.size() > 0) {
            for (int i = 0; i < items.size(); i++) {
                description
                        .append("ID: ")
                        .append(i)
                        .append(" | ")
                        .append(items.get(i).getDescription())
                        .append("\n");
            }
            description
                    .append("Общая цена товаров:")
                    .append(getTotalCost())
                    .append("\n");
        } else {
            description.append("Список товаров в корзине пуст!");
        }
        return description.toString();
    }

    public double getTotalCost() {
        return totalCost;
    }
}