package smarthome.commands;

import smarthome.Command;
import smarthome.MusicPlayer;

public class PlayMusic implements Command {
    private final MusicPlayer player;
    private final String playlist;
    private String prevTrack;
    private boolean wasPlaying;

    public PlayMusic(MusicPlayer player, String playlist) 
    {
        this.player = player;
        this.playlist = playlist;
    }

    @Override
    public void execute() 
    {
        prevTrack = player.getCurrentTrack();
        wasPlaying = player.isPlaying();
        player.play(playlist);
    }

    @Override
    public void undo() 
    {
        player.stop();
        if (wasPlaying) 
        {
            player.play(prevTrack);
        }
    }
}