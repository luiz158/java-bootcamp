package src.Topic0.ex2;

public class UglyHouseBuilder implements HouseBuilder {

    private House house;

    public UglyHouseBuilder() {
        this.house = new House();
    }

    @Override
    public void buildAddress() {
        this.house.setAddress("Ugly 1234");
    }

    @Override
    public void buildZipCode() {
        this.house.setZipCode(1020);
    }

    @Override
    public void buildfloors() {
        this.house.setFloors(1);
    }

    @Override
    public House getHouse() {
        return this.house;
    }
}
