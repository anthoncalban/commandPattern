package smarthome.commands;

import smarthome.Command;
import smarthome.Light;

public class TurnOff implements Command {
    private final Light light;
    private int prevBrightness;
    private boolean wasOn;

    public TurnOff(Light light) 
    {
        this.light = light;
    }

    @Override
    public void execute() 
    {
        prevBrightness = light.getBrightness();
        wasOn = light.isOn();
        light.turnOff();
    }

    @Override
    public void undo() 
    {
        if (wasOn) 
        {
            light.turnOn();
        }
        light.setBrightness(prevBrightness);
    }
}