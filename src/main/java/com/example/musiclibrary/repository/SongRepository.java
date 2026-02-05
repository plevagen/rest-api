package com.example.musiclibrary.repository;
import com.example.musiclibrary.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {}
