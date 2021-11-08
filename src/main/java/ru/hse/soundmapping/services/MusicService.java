package ru.hse.soundmapping.services;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import ru.hse.soundmapping.daos.MusicDAO;
import ru.hse.soundmapping.models.SynthPreset;
import ru.hse.soundmapping.daos.UserDAO;

@Service
public class MusicService {

    public List<MusicDAO> sortMusicsByRating(List<MusicDAO> songs) {
        return songs.stream()
                .sorted(Comparator.comparingInt(MusicDAO::getSheetsRating).reversed())
                .collect(Collectors.toList());
    }

    public Set<String> getUniqueGenres(List<MusicDAO> songs) {
        return songs.stream()
                .map(MusicDAO::getGenre)
                .collect(Collectors.toSet());
    }

    public List<SynthPreset> getPremiumSynthPresets(List<SynthPreset> presets) {
        return presets.stream()
                .filter(SynthPreset::isPremium)
                .collect(Collectors.toList());
    }

    public List<MusicDAO> sortMusicsByAuthor(List<MusicDAO> musicList) {
        return musicList.stream().sorted(Comparator.comparing(MusicDAO::getAuthor)).collect(Collectors.toList());
    }

    public void addSheetsUser(UserDAO user, String sheetsUrl, MusicDAO music) {
        user.getAchievements().add(UserDAO.Achievement.CREATOR);
        music.setSheetsUrl(sheetsUrl);
    }
}
