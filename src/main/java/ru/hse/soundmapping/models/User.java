package ru.hse.soundmapping.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Accessors(chain = true)
public class User {
    @Id
    private Long id;

    private String email;
    private String password;
    private String firstName;
    private String lastName;

    private List<SynthPreset> favouritePresets;
    private List<MusicalInstrument> favouriteMusicalInstruments;
    private List<Music> music;
    private Long balance;

    private Long rating;
    private Set<Achievement> achievements = new HashSet<>();

    public enum Achievement {
        RATING_5_BEGINNER,
        RATING_10_TALENTED,
        RATING_15_INTERMEDIATE,
        RATING_20_MASTER,
        RATING_25_GOD,
        WELCOME_THE_JUNGLE, // Пополнение баланса на >= 100
        CREATOR, // создал собственные ноты
        TALENTED_MUSICIAN
    }

    public void addSong(Music song) {
        music.add(song);
        rating++;
    }

}
