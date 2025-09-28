package smarthome;

public class Light implements Device {
    private final String name;
    private int brightness;
    private boolean on;

    public Light(String name) 
    {
        this.name = name;
        this.brightness = 100;
        this.on = false;
    }

    public void turnOn() 
    {
        on = true;
        System.out.printf("%s: Light is ON at brightness %d%%\n", name, brightness);
    }

    public void turnOff() 
    {
        on = false;
        System.out.printf("%s: Light is OFF\n", name);
    }

    public void setBrightness(int level) 
    {
        brightness = Math.max(0, Math.min(100, level));
        System.out.printf("%s: Brightness set to %d%%\n", name, brightness);
        if (on) 
        {
            System.out.printf("%s: (applied immediately while ON)\n", name);
        }
    }

    public boolean isOn() { return on; }
    public int getBrightness() { return brightness; }

    @Override
    public String getName() { return name; }
}