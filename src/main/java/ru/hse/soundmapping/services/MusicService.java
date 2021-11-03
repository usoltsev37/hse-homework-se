package ru.hse.soundmapping.services;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import ru.hse.soundmapping.models.Music;
import ru.hse.soundmapping.models.SynthPreset;
import ru.hse.soundmapping.models.User;

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

    public List<SynthPreset> getPremiumSynthPresets(List<SynthPreset> presets) {
        return presets.stream()
                .filter(SynthPreset::isPremium)
                .collect(Collectors.toList());
    }

    public List<Music> sortMusicsByAuthor(List<Music> musicList) {
        return musicList.stream().sorted(Comparator.comparing(Music::getAuthor)).collect(Collectors.toList());
    }

    public void addSheetsUser(User user, String sheetsUrl, Music music) {
        user.getAchievements().add(User.Achievement.CREATOR);
        music.setSheetsUrl(sheetsUrl);
    }
}
