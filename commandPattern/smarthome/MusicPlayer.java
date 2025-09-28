package smarthome;

public class MusicPlayer implements Device {
    private final String name;
    private int volume;
    private String currentTrack;
    private boolean playing;

    public MusicPlayer(String name) 
    {
        this.name = name;
        this.volume = 50;
        this.currentTrack = "Unknown Track";
        this.playing = false;
    }

    public void play(String playlist) 
    {
        currentTrack = playlist;
        playing = true;
        System.out.printf("%s: Playing playlist '%s' at volume %d\n", name, playlist, volume);
    }

    public void pause() 
    {
        playing = false;
        System.out.printf("%s: Paused\n", name);
    }

    public void stop() 
    {
        playing = false;
        System.out.printf("%s: Stopped\n", name);
    }

    public void setVolume(int v) 
    {
        volume = Math.max(0, Math.min(100, v));
        System.out.printf("%s: Volume set to %d%%\n", name, volume);
    }

    @Override
    public String getName() { return name; }
    public String getCurrentTrack() { return currentTrack; }
    public boolean isPlaying() { return playing; }
}