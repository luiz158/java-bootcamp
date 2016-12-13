package src.Topic0.ex3;

public abstract class Hospital {

    private String name;
    private int patients;

    public Hospital(String name, int patients) {
        this.name = name;
        this.patients = patients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPatients() {
        return patients;
    }

    public void setPatients(int patients) {
        this.patients = patients;
    }
}
