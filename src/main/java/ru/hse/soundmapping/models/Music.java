package ru.hse.soundmapping.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Music {

    public enum MusicType {
        SONG,
        INSTRUMENTAL
    }

    @Id
    private Long id;
    private MusicType type;
    private String genre;
    private List<SynthPreset> presets;
    private String name;
    private String author;
    private List<MusicalInstrument> instruments;
    private String sheetsUrl;
    private int price;

    private int sheetsRating;

}
