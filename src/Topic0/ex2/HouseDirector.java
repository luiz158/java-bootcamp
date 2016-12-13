package src.Topic0.ex2;

public class HouseDirector {

    private HouseBuilder houseBuilder = null;

    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public void constructHouse() {
        houseBuilder.buildAddress();
        houseBuilder.buildfloors();
        houseBuilder.buildZipCode();
    }

    public House getHouse() {
        return houseBuilder.getHouse();
    }
}
