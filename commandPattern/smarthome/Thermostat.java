package smarthome;

public class Thermostat implements Device {
    private final String name;
    private double temperature;

    public Thermostat(String name, double initialTemperature) {
        this.name = name;
        this.temperature = initialTemperature;
    }

    public void increase(double delta) 
    {
        temperature += delta;
        System.out.printf("%s: Temperature increased to %.1f°C\n", name, temperature);
    }

    public void decrease(double delta) 
    {
        temperature -= delta;
        System.out.printf("%s: Temperature decreased to %.1f°C\n", name, temperature);
    }

    public void setTemperature(double temp) 
    {
        temperature = temp;
        System.out.printf("%s: Temperature set to %.1f°C\n", name, temperature);
    }

    public double getTemperature() { return temperature; }

    @Override
    public String getName() { return name; }
}