package com.example.musiclibrary;
import com.example.musiclibrary.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {}
