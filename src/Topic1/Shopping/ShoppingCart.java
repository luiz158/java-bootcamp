package src.Topic1.Shopping;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Product> productList;

    public ShoppingCart() {
        this.productList = new ArrayList<>();
    }

    public void addItem(Item item) {
        this.productList.add(item);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void printListOfProducs() {
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public void pay(PaymentMethodStrategy paymentMethod) throws ValidationException {
        paymentMethod.pay(productList);
    }

    public static void main(String[] args) {
        Item item1 = new Item("ABC", 10);
        Item item2 = new Item("XYZ", 50);

        //PaymentMethodStrategy paymentMethodStrategy = new PaypalStrategy("h@to.com","pass", total);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(item1);
        shoppingCart.addItem(item2);
        shoppingCart.printListOfProducs();

        PaymentMethodStrategy paymentMethodStrategy = new CreditCardStrategy("Pepe", 1234, shoppingCart.getProductList());
        try {
            shoppingCart.pay(paymentMethodStrategy);
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }
}
