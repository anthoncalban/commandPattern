package smarthome.commands;

import smarthome.Command;
import smarthome.Light;

public class TurnOnLight implements Command {
    private final Light light;
    private int prevBrightness;
    private boolean wasOn;

    public TurnOnLight(Light light) 
    {
        this.light = light;
    }

    @Override
    public void execute() 
    {
        prevBrightness = light.getBrightness();
        wasOn = light.isOn();
        light.turnOn();
    }

    @Override
    public void undo() 
    {
        if (!wasOn) 
        {
            light.turnOff();
        }
        light.setBrightness(prevBrightness);
    }
}