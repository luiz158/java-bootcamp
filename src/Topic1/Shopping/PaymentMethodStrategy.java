package src.Topic1.Shopping;

import java.util.List;

/**
 * Strategy design pattern. Interface for payment methods (credit card, PaypalStrategy, cash).
 */
public interface PaymentMethodStrategy {

    Ticket pay(List<Product> productList) throws ValidationException;
    // implementations may not throw new exceptions, but not more
}
