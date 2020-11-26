package CarSalesman;

public class Car {
    private String model;
    private String engin;
    private String weight;
    private String color;
    private int power;
    private String displacement;
    private String efficiency;

    public Car(String model, String engin, String weight, String color, int power, String displacement, String efficiency) {
        this.model = model;
        this.engin = engin;
        this.weight = weight;
        this.color = color;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getEngin() {
        return engin;
    }

    @Override
    public String toString() {
        return String.format("%s:%n%s:%nPower: %s%nDisplacement: %s%nEfficiency: %s%nWeight: %s%nColor: %s"
                , this.model, this.engin, this.power, this.displacement, this.efficiency, this.weight, this.color);
    }
}
