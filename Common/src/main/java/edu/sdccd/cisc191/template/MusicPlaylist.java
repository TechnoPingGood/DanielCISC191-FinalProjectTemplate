package edu.sdccd.cisc191.template;

import java.io.Serializable;
import java.util.LinkedList;
import lombok.Data;

@Data
public class MusicPlaylist implements Serializable
{
    private LinkedList<String> songs = new LinkedList<>();

    public void addSong(String song)
    {
        songs.add(song);
    }

    public void removeSong(String song)
    {
        songs.remove(song);
    }

    public void playNext()
    {
        if(!songs.isEmpty())
        {
            String song = songs.removeFirst();
            System.out.println("Playing: " + song);
        }
    }

    public void playPrevious()
    {
        if(!songs.isEmpty())
        {
            String song = songs.removeLast();
            System.out.println("Playing: " + song);
        }
    }
}
