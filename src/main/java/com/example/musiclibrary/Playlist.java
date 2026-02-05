package com.example.musiclibrary;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Playlist {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    public int id;
    public String name;

    @ManyToMany
    @JoinTable(
            name = "playlist_song",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    private Set<Song> songs = new HashSet<>();

    public Playlist(){}
    public Playlist(String name){
        this.name = name;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public Set<Song> getSongs(){
        return songs;
    }
    public void setName(String name){
        this.name = name;
    }

    public void addSong(Song s){
        songs.add(s);
    }

}
