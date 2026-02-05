package com.example.musiclibrary.dto;

import java.util.List;

public class PlaylistDTO {
    public Long id;
    public String name;
    public List<SongDTO> songs;

    public PlaylistDTO(){}
    public PlaylistDTO(Long id, String name, List<SongDTO> songs){
        this.id = id;
        this.name = name;
        this.songs = songs;
    }
}
