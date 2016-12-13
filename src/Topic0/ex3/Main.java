package src.Topic0.ex3;

public class Main {

    public static void main(String[] args) {
        HospitalFactory hospitalFactory = new HospitalFactory();
        Hospital children = hospitalFactory.createHospital("Children");
        System.out.println(children.getName());
    }
}
