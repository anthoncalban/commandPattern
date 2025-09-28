package smarthome.commands;

import smarthome.Command;
import smarthome.Thermostat;

public class DecreaseTemp implements Command {
    private final Thermostat thermostat;
    private final double delta;

    public DecreaseTemp(Thermostat t, double delta) 
    {
        this.thermostat = t;
        this.delta = delta;
    }

    @Override
    public void execute() 
    {
        thermostat.decrease(delta);
    }

    @Override
    public void undo() 
    {
        thermostat.increase(delta);
    }
}