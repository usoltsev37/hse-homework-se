package ru.hse.soundmapping.services;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import ru.hse.soundmapping.models.Music;

@Service
public class MusicService {

    public List<Music> sortMusicsByRating(List<Music> songs) {
        return songs.stream()
                .sorted(Comparator.comparingInt(Music::getSheetsRating).reversed())
                .collect(Collectors.toList());
    }

    public Set<String> getUniqueGenres(List<Music> songs) {
        return songs.stream()
                .map(Music::getGenre)
                .collect(Collectors.toSet());
    }
}
