package com.song.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepository {
    private List<Song> list = new ArrayList<Song>();

    public List<Song> getAllSongs() {
        return list;
    }

    public Song getSongById(Integer id) {
       list = getAllSongs();
        for (Song song : list) {
            if (song.getId().equals(id)) {
                return song;
            }
        }
        return null;
    }

    public void addSong(Song s) {
        if(s != null) {
            list.add(s);
        }
    }

    public void updateSong(Song s) {
        Song song = getSongById(s.getId());
        list.set(list.indexOf(song), s );
    }

    public void removeSong(Song s) {
        if (list.contains(s)) {
            list.remove(s);
        }
    }
}
