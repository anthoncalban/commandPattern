package smarthome;

import smarthome.commands.*;

public class Main {
    public static void main(String[] args) {

        Light livingRoomLight = new Light("LivingRoom");
        Thermostat thermostat = new Thermostat("HallThermostat", 22.0);
        MusicPlayer music = new MusicPlayer("KitchenSpeaker");

        Command lightOn = new TurnOnLight(livingRoomLight);
        Command lightOff = new TurnOff(livingRoomLight);
        Command tempUp = new IncreaseTemp(thermostat, 1.5);
        Command tempDown = new DecreaseTemp(thermostat, 1.5);
        Command playJazz = new PlayMusic(music, "Brent Faiyaz");
        Command stopMusic = new StopMusic(music);

        RemoteControl remote = new RemoteControl();
        remote.setCommand("light:on", lightOn);
        remote.setCommand("light:off", lightOff);
        remote.setCommand("thermo:up", tempUp);
        remote.setCommand("thermo:down", tempDown);
        remote.setCommand("music:play:rnb", playJazz);
        remote.setCommand("music:stop", stopMusic);

        remote.send("light:on");
        remote.send("music:play:rnb");
        remote.send("thermo:up");

        remote.undoLast();
        remote.send("light:off");
        remote.undoLast();
    }
}