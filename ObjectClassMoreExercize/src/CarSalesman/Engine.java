package CarSalesman;

public class Engine {
    private String engin;//<EngineModel>:
    private int power;//Power: <EnginePower>
    private String displacement;// <EngineDisplacement>
    private String efficiency;//Efficiency: <EngineEfficiency>

        public Engine(String engin, int power, String displacement, String efficiency) {
        this.engin = engin;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }
    public String getEngin() {
        return engin;
    }

    public int getPower() {
        return power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }
}
