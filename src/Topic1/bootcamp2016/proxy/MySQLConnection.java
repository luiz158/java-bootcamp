package src.Topic1.bootcamp2016.proxy;

public class MySQLConnection implements DBConnection {

    public MySQLConnection() {
        resourcefulTask();
    }

    @Override
    public void connect() {
        System.out.println("Connecting...");
    }

    public void resourcefulTask() {
        System.out.println("Resourceful task has been executed.");
    }
}
