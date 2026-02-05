package com.example.musiclibrary.service;

import com.example.musiclibrary.dto.PlaylistDTO;
import com.example.musiclibrary.dto.SongDTO;
import com.example.musiclibrary.model.Artist;
import com.example.musiclibrary.model.Playlist;
import com.example.musiclibrary.model.Song;
import com.example.musiclibrary.repository.ArtistRepository;
import com.example.musiclibrary.repository.PlaylistRepository;
import com.example.musiclibrary.repository.SongRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MusicService {
    private final ArtistRepository artistRepo;
    private final PlaylistRepository playlistRepo;
    private final SongRepository songRepo;

    public MusicService(ArtistRepository artistRepo, PlaylistRepository playlistRepo, SongRepository songRepo){
        this.artistRepo = artistRepo;
        this.songRepo = songRepo;
        this.playlistRepo = playlistRepo;
    }

    public List<SongDTO> getAllSongs() {
        return songRepo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }
    public List<PlaylistDTO> getAllPlaylists() {
        return playlistRepo.findAll().stream().map(this::toPlaylistDTO).collect(Collectors.toList());
    }
    public Optional<PlaylistDTO> getPlaylist(Long id) {
        return playlistRepo.findById(id).map(this::toPlaylistDTO);
    }

    @Transactional
    public PlaylistDTO createPlaylist(String name, List<Long> songIds){
        Playlist p = new Playlist(name);
        List<Song> songs = songRepo.findAllById(songIds);
        songs.forEach(p::addSong);
        Playlist saved = playlistRepo.save(p);
        return toPlaylistDTO(saved);
    }

    private SongDTO toDTO(Song s){
        Artist a = s.getArtist();
        Long artistId = a != null ? a.getId() : null;
        String artistName = a != null ? a.getName() : null;
        return new SongDTO(s.getId(), s.getTitle(), s.getDuration(), artistId, artistName);
    }

    private PlaylistDTO toPlaylistDTO(Playlist p){
        List<SongDTO> songs = p.getSongs().stream().map(this::toDTO).collect(Collectors.toList());
        return new PlaylistDTO(p.getId(), p.getName(), songs);
    }
}
