package com.example.musiclibrary.web;

import com.example.musiclibrary.dto.PlaylistDTO;
import com.example.musiclibrary.dto.SongDTO;
import com.example.musiclibrary.model.Playlist;
import com.example.musiclibrary.model.Song;
import com.example.musiclibrary.service.MusicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.*;

@RestController
@RequestMapping("/api")
public class MusicController {
    private final MusicService service;

    public MusicController(MusicService service){
        this.service = service;
    }

    @GetMapping("/songs")
    public List<SongDTO> listSongs(){
        return service.getAllSongs();
    }

    @GetMapping("/playlists")
    public List<PlaylistDTO> listPlaylists(){
        return service.getAllPlaylists();
    }

    @GetMapping("/playlists/{id}")
    public ResponseEntity<PlaylistDTO> getPlaylist(@PathVariable Long id){
        return service.getPlaylist(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/playlists")
    public ResponseEntity<PlaylistDTO> createPlaylist(@RequestBody Map<String, Object> payload){
        String name = (String) payload.get("name");
        @SuppressWarnings("unchecked")
        List<Integer> songIdsInt = (List<Integer>) payload.get("songIds");
        List<Long> songIds = songIdsInt.stream().map(Integer::longValue).toList();

        PlaylistDTO created = service.createPlaylist(name, songIds);
        return ResponseEntity.created(URI.create("/api/playlists" + created.id)).body(created);
    }
}
