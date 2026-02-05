package com.example.musiclibrary;

public class SongDTO {
    public Long id;
    public String title;
    public int duration;
    public Long artistId;
    public String artistName;

    public SongDTO(){}

    public SongDTO(Long id, String title, int duration, Long artistId, String artistName){
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.artistId = artistId;
        this.artistName = artistName;
    }
}
