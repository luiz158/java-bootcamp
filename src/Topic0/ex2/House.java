package src.Topic0.ex2;

public class House {

    private String address;
    private int zipCode;
    private int floors;

    public House() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        return "House{" +
                "address='" + address + '\'' +
                ", zipCode=" + zipCode +
                ", floors=" + floors +
                '}';
    }
}
