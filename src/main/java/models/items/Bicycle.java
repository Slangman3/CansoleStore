package models.items;

import com.google.gson.annotations.Expose;

public class Bicycle extends Item {
    @Expose
    int gears;
    @Expose
    int maxSpeed;

    public Bicycle(String addDate, String name, double price, int gears, int maxSpeed) {
        super(addDate, name, price);
        this.gears = gears;
        this.maxSpeed = maxSpeed;
    }

    public String getDescription() {
        return ("Дата обновления: " + addDate + " | " + " Наименование: " + name +
                " | " + " Стоимость: " + price + " | " + " Кол-во передач: " + gears + " | " +
                " максимальная скорость: " + maxSpeed).toString();
    }
}