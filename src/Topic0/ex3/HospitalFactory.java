package src.Topic0.ex3;

public class HospitalFactory {

    public Hospital createHospital(String type) {
        Hospital hospital = null;

        if (type.equals("Children")) {
            hospital = new ChildrenHospital();
        } else if (type.equals("Heart")) {
            hospital = new HeartHospital();
        }
        return hospital;
    }


}
