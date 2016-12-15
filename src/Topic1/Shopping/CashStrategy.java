package src.Topic1.Shopping;

import java.util.List;

public class CashStrategy implements PaymentMethodStrategy {

    private List<Product> productList;

    public CashStrategy(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public Ticket pay(List<Product> productList) throws ValidationException {
        CounterSingleton.getInstance().plusOne();
        Double mostExpensive = getMostExpensiveItemPrice();
        double total = 0;
        for (Product product : productList) {
            total += product.getPrice();
        }
        return Utilities.getInstance().createTicket(CounterSingleton.getInstance().getCounter(),
                (total - (mostExpensive * 0.9)));
    }

    public double getMostExpensiveItemPrice() {
        Product tempProduct = null;
        for (int i = 0; i < productList.size(); i++) {
            tempProduct = productList.get(i);
            if (i > 0 && productList.get(i).getPrice() > tempProduct.getPrice()) {
                tempProduct = productList.get(i);
            }
        }
        return tempProduct.getPrice();
    }
}
