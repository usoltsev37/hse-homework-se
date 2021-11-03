package ru.hse.soundmapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.hse.soundmapping.models.Music;
import ru.hse.soundmapping.models.MusicalInstrument;
import ru.hse.soundmapping.models.SynthPreset;
import ru.hse.soundmapping.models.User;
import ru.hse.soundmapping.services.MusicService;
import ru.hse.soundmapping.services.PriceService;

class SoundMappingApplicationTests {

    @Test
    void testMusicPrice() {
        PriceService priceService = new PriceService();
        Assertions.assertEquals(350, priceService.getPrice(songs));
    }

    @Test
    void testSortMusicsByRating() {
        MusicService musicService = new MusicService();
        Assertions.assertEquals(List.of(song1, song2, song3), musicService.sortMusicsByRating(songs));
    }

    @Test
    void testMusicPriceWithUserRating() {
        PriceService priceService = new PriceService();
        Assertions.assertEquals(95, priceService.getMusicPriceForUser(song3, user1));
        Assertions.assertEquals(80, priceService.getMusicPriceForUser(song3, user2));
        Assertions.assertEquals(100, priceService.getMusicPriceForUser(song3, user3));
    }

    @Test
    void testEnoughMoneyToBuy() {
        PriceService priceService = new PriceService();
        Assertions.assertEquals(true, priceService.isEnoughMoneyToBuy(user2, 50));
        Assertions.assertEquals(false, priceService.isEnoughMoneyToBuy(user2, 100));
    }

    private SynthPreset preset1 = new SynthPreset(0L, "Wave", 1.0, 1.0, 1.0, 1.0,
            1.0, 1.0, 1.0, SynthPreset.Polyphony.POLYPHONIC, false, 10);
    private SynthPreset preset2 = new SynthPreset(1L, "Smooth", 1.0, 1.0, 1.0, 1.0,
            1.0, 1.0, 1.0, SynthPreset.Polyphony.POLYPHONIC, true, 20);
    private SynthPreset preset3 = new SynthPreset(2L, "", 1.0, 1.0, 1.0, 1.0,
            1.0, 1.0, 1.0, SynthPreset.Polyphony.POLYPHONIC, false, 30);
    private SynthPreset preset4 = new SynthPreset(3L, "Wave", 1.0, 1.0, 1.0, 1.0,
            1.0, 1.0, 1.0, SynthPreset.Polyphony.POLYPHONIC, true, 35);
    private List<SynthPreset> presets = Arrays.asList(preset1, preset2, preset3, preset4);

    private MusicalInstrument in1 = new MusicalInstrument("Guitar", false);
    private MusicalInstrument in2 = new MusicalInstrument("Piano", false);
    private MusicalInstrument in3 = new MusicalInstrument("Synth", true);
    private List<MusicalInstrument> ins = Arrays.asList(in1, in2, in3);

    private Music song1 = new Music(0L, Music.MusicType.SONG, "Pop", presets, "Blinding Lights",
            "The Weeknd", Collections.singletonList(in3), "https://example.com", 200, 5);
    private Music song2 = new Music(1L, Music.MusicType.SONG, "Hip-Hop", Arrays.asList(preset1, preset4), "Stronger",
            "Kanye West", Collections.singletonList(in3), "https://example.com", 50, 3);
    private Music song3 = new Music(2L, Music.MusicType.SONG, "Hip-Hop", List.of(preset3), "Nonstop",
            "Drake", Collections.singletonList(in3), "https://example.com", 100, 1);
    private List<Music> songs = Arrays.asList(song1, song2, song3);

    private Music instrumental1 = new Music(3L, Music.MusicType.INSTRUMENTAL, "Neoclassicism", presets, "Experience",
            "Ludovico Einaudi", Collections.singletonList(in2), "https://example.com", 300, 5);
    private Music instrumental2 = new Music(4L, Music.MusicType.INSTRUMENTAL, "Fonk", presets, "Close Eyes",
            "DVRST", Collections.singletonList(in3), "https://example.com", 0, 0);
    private List<Music> instrumentals = List.of(instrumental1, instrumental2);


    private User user1 = new User(1L, "fst@mail.ru", "password1", "Phil", "Green",
            presets, new ArrayList<>(), songs, 0L, 5L, List.of(User.Achievement.RATING_5_BEGINNER));
    private User user2 = new User(2L, "snd@mail.ru", "password2", "Jack", "Black",
            presets, ins, songs, 100L, 10L, Arrays.asList(User.Achievement.RATING_20_MASTER,
            User.Achievement.RATING_10_TALENTED, User.Achievement.WELCOME_THE_JUNGLE));
    private User user3 = new User(2L, "thd@mail.ru", "password3", "Nick", "White",
            new ArrayList<>(), ins, new ArrayList<>(), 50L, 0L, List.of(User.Achievement.WELCOME_THE_JUNGLE));
    private final List<User> users = List.of(user1, user2, user3);

}
