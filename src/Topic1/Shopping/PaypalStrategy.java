package src.Topic1.Shopping;

import java.util.List;
import java.util.Scanner;

public class PaypalStrategy implements PaymentMethodStrategy {

    private String email;
    private String password;
    private List<Product> productList;

    public PaypalStrategy(String email, String password, List<Product> productList) {
        this.email = email;
        this.password = password;
        this.productList = productList;
    }

    @Override
    public Ticket pay(List<Product> productList) throws ValidationException {
        if (!validateEmailAndPassword()) {
            throw new ValidationException("Check your data");
        }
        CounterSingleton.getInstance().plusOne();
        Double cheapest = getCheapestItemPrice();
        double total = 0;
        for (Product item : productList) {
            total += item.getPrice();
        }
        return Utilities.getInstance().createTicket(CounterSingleton.getInstance().getCounter(), (total - cheapest));

    }

    public double getCheapestItemPrice() {
        Product tempItem = null;
        for (int i = 0; i < productList.size(); i++) {
            tempItem = productList.get(i);
            if (i > 0 && productList.get(i).getPrice() < tempItem.getPrice()) {
                tempItem = productList.get(i);
            }
        }
        return tempItem.getPrice();
    }

    public boolean validateEmailAndPassword() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter email:\n");
        String inputEmail = input.nextLine();
        System.out.println("Enter password:\n");
        String inputPassword = input.nextLine();
        if (email.equalsIgnoreCase(inputEmail.trim()) && password.equals(inputPassword.trim())) {
            return true;
        } else {
            System.out.println("Error. Please check your data.");
            return false;
        }
    }
}
