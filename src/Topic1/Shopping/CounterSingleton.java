package src.Topic1.Shopping;

public class CounterSingleton {

    private static CounterSingleton ourInstance = new CounterSingleton();

    private int counter = 0;

    public void plusOne() {
        this.counter += 1;
    }

    public int getCounter() {
        return counter;
    }

    public static CounterSingleton getInstance() {
        return ourInstance;
    }

    private CounterSingleton() {
    }
}
