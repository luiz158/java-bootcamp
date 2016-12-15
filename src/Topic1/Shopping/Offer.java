package src.Topic1.Shopping;

import java.util.ArrayList;
import java.util.List;

public class Offer implements Product {

    public String name;
    public double price;
    public List<Item> itemList;

    public Offer(String name, double price, List<Item> itemList) {
        this.name = name;
        this.price = price;
        this.itemList = itemList;
    }

    public Offer(String name, double price) {
        this.name = name;
        this.price = price;
        this.itemList = new ArrayList<>();
    }

    public void addItem(Item item) {
        itemList.add(item);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String aux = name + " $" + price + "\n";
        for (Item item : itemList) {
            aux.concat("\n\t" + item.getName() + " $" + item.getPrice());
        }
        return aux;
    }


}
