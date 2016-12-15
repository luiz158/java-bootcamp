package src.Topic1.Shopping;

public class Utilities {

    private static Utilities ourInstance = new Utilities();

    public Ticket createTicket(int id, double amount) {
        Ticket ticket = new Ticket(id, amount);
        return ticket;
    }

    public static Utilities getInstance() {
        return ourInstance;
    }

    private Utilities() {
    }
}
