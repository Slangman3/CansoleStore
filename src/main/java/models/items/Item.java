package models.items;

import com.google.gson.annotations.Expose;

public class Item {
    @Expose
    String addDate;
    @Expose
    String name;
    @Expose
    double price;

    public Item(String addDate, String name, double price) {
        this.addDate = addDate;
        this.name = name;
        this.price = price * 1.3;
    }

    public String getDescription() {
        return ("Дата обновления: " + addDate + " | " + " Наименование: " + name +
                " | " + " Стоимость: " + price);
    }

    public double getPrice() {
        return price;
    }
}