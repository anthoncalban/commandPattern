package smarthome.commands;

import smarthome.Command;
import smarthome.MusicPlayer;

public class StopMusic implements Command {
    private final MusicPlayer player;
    private String prevTrack;
    private boolean wasPlaying;

    public StopMusic(MusicPlayer player) 
    {
        this.player = player;
    }

    @Override
    public void execute() 
    {
        prevTrack = player.getCurrentTrack();
        wasPlaying = player.isPlaying();
        player.stop();
    }

    @Override
    public void undo() 
    {
        if (wasPlaying) 
        {
            player.play(prevTrack);
        }
    }
}