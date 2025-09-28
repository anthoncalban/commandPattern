package smarthome.commands;

import smarthome.Command;
import smarthome.Thermostat;

public class IncreaseTemp implements Command {
    private final Thermostat thermostat;
    private final double delta;

    public IncreaseTemp(Thermostat t, double delta) 
    {
        this.thermostat = t;
        this.delta = delta;
    }

    @Override
    public void execute() 
    {
        thermostat.increase(delta);
    }

    @Override
    public void undo() 
    {
        thermostat.decrease(delta);
    }
}