package com.example.musiclibrary;

import com.example.musiclibrary.model.Artist;
import com.example.musiclibrary.model.Playlist;
import com.example.musiclibrary.model.Song;
import com.example.musiclibrary.repository.ArtistRepository;
import com.example.musiclibrary.repository.PlaylistRepository;
import com.example.musiclibrary.repository.SongRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MusicLibraryApplication {

    public static void main(String[] args) {SpringApplication.run(MusicLibraryApplication.class, args);}

    @Bean
    CommandLineRunner seed(ArtistRepository artistRepo, SongRepository songRepo, PlaylistRepository playlistRepo){
        return args -> {
            Artist a1 = new Artist("Pixies");
            Artist a2 = new Artist("Pink Floyd");

            Song s1 = new Song("Where is my mind?",234);
            Song s2 = new Song("Bike", 304);
            Song s3 = new Song("Cactus", 137);
            Song s4 = new Song("Time", 427);

            a1.addSong(s1);
            a2.addSong(s2);
            a1.addSong(s3);
            a2.addSong(s4);

            artistRepo.save(a1);
            artistRepo.save(a2);

            Playlist pl = new Playlist("Best of Pink Floyd");
            pl.addSong(s1);
            pl.addSong(s3);
            playlistRepo.save(pl);

            Playlist pl2 = new Playlist("Best of Pixies");
            pl2.addSong(s2);
            pl2.addSong(s4);
            playlistRepo.save(pl2);
        };
    }

}
