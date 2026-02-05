package com.example.musiclibrary.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Song {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String title;
    private int duration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @ManyToMany(mappedBy = "songs")
    private Set<Playlist> playlists = new HashSet<>();

    public Song(){}
    public Song(String title, int duration){
        this.title = title;
        this.duration = duration;
    }

    public Long getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public int getDuration(){
        return duration;
    }
    public Artist getArtist(){
        return artist;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setDuration(int duration){
        this.duration = duration;
    }
    public void setArtist(Artist artist){
        this.artist = artist;
    }

}
