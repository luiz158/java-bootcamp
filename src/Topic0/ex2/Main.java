package src.Topic0.ex2;

public class Main {

    public static void main(String[] args) {
        HouseBuilder builderFancy = new FancyHouseBuilder();
        HouseBuilder builderUgly = new UglyHouseBuilder();

        HouseDirector director1 = new HouseDirector(builderFancy);
        HouseDirector director2 = new HouseDirector(builderUgly);

        director1.constructHouse();
        System.out.println(director1.getHouse().toString());

        director2.constructHouse();
        System.out.println(director2.getHouse().toString());
    }
}
