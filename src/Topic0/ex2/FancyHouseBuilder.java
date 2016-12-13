package src.Topic0.ex2;

public class FancyHouseBuilder implements HouseBuilder {

    private House house;

    public FancyHouseBuilder() {
        this.house = new House();
    }

    @Override
    public void buildAddress() {
        this.house.setAddress("Fancy 1234");
    }

    @Override
    public void buildZipCode() {
        this.house.setZipCode(1660);
    }

    @Override
    public void buildfloors() {
        this.house.setFloors(3);
    }

    @Override
    public House getHouse() {
        return this.house;
    }
}
