package RawData;

public class Car {
    private String model;
    private int power;
    private double pressTireOne;
    private double pressTireTwo;
    private double pressTireThree;
    private double pressTireFour;

    public Car(String model, int power, double pressTireOne, double pressTireTwo, double pressTireThree, double pressTireFour) {
        this.model = model;
        this.power = power;
        this.pressTireOne = pressTireOne;
        this.pressTireTwo = pressTireTwo;
        this.pressTireThree = pressTireThree;
        this.pressTireFour = pressTireFour;
    }

    public int getPower() {
        return power;
    }

    public double getPressTireOne() {
        return pressTireOne;
    }

    public double getPressTireTwo() {
        return pressTireTwo;
    }

    public double getPressTireThree() {
        return pressTireThree;
    }

    public double getPressTireFour() {
        return pressTireFour;
    }

    @Override
    public String toString() {
        return model;
    }
}
