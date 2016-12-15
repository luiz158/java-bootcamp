package src.Topic1.Shopping;

public class Ticket {

    private int id;
    private double amount;

    public Ticket(int id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Ticket #" + id + ": $" + amount;
    }
}
