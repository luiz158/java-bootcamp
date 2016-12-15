package src.Topic1.bootcamp2016.proxy;

public class ProxyMySQLConnection implements DBConnection {

    private MySQLConnection connection;

    @Override
    public void connect() {
        if (connection == null) {
            connection = new MySQLConnection();
        }
        connection.connect();
    }
}
