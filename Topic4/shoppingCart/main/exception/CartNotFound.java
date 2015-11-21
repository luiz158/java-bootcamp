package shoppingCart.main.exception;

public class CartNotFound extends Exception {

	public CartNotFound() {
		super("Cart not found.");
	}

	public CartNotFound(String message) {
		super(message);
	}
}
