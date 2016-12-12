package Topic0.ex2;

public class Rectangle {

    private double base;
    private double height;

    public Rectangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public static void main(String[] args) {
        Rectangle r = new Rectangle(2, 3);
        System.out.println(r.getArea());
    }

    public double getArea() {
        return this.getBase() * this.getHeight();
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}