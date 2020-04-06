package models.items;

import com.google.gson.annotations.Expose;

public class Laptop extends Item {
    @Expose
    String processorName;
    @Expose
    int ram;

    public Laptop(String addDate, String name, double price, String processorName, int ram) {
        super(addDate, name, price);
        this.processorName = processorName;
        this.ram = ram;
    }

    public String getDescription() {
        return ("Дата обновления: " + addDate + " | " + " Наименование: " + name +
                " | " + " Стоимость: " + price + " | " + " Процессор: " + processorName + " | " +
                " оперативная память: " + ram);
    }
}