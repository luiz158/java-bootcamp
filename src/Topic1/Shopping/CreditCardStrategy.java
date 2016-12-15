package src.Topic1.Shopping;

import java.util.List;
import java.util.Scanner;

public class CreditCardStrategy implements PaymentMethodStrategy {

    private String name;
    private int cardNumber;
    private List<Product> productList;

    public CreditCardStrategy(String name, int cardNumber, List<Product> productList) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.productList = productList;
    }

    @Override
    public Ticket pay(List<Product> productList) throws ValidationException {
        if (!validateNameAndNumber()) {
            throw new ValidationException("Check your data");
        }
        CounterSingleton.getInstance().plusOne();
        double total = 0;
        for (Product product : productList) {
            total += product.getPrice();
        }
        return Utilities.getInstance().createTicket(CounterSingleton.getInstance().getCounter(), (total * 0.9));
    }

    public boolean validateNameAndNumber() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter name:\n");
        String inputName = input.nextLine();
        System.out.println("Enter card number:\n");
        int inputCardNumber = input.nextInt();
        if (name.equals(inputName.trim()) && cardNumber == inputCardNumber) {
            return true;
        } else {
            System.out.println("Error. Please check your data.");
            return false;
        }
    }

}
