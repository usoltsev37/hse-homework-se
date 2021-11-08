package ru.hse.soundmapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.hse.soundmapping.daos.MusicDAO;
import ru.hse.soundmapping.models.MusicalInstrument;
import ru.hse.soundmapping.models.SynthPreset;
import ru.hse.soundmapping.daos.UserDAO;
import ru.hse.soundmapping.services.MusicService;
import ru.hse.soundmapping.services.PresetService;
import ru.hse.soundmapping.services.PriceService;
import ru.hse.soundmapping.services.UserService;

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
        Assertions.assertEquals(90, priceService.getMusicPriceForUser(song3, user2));
        Assertions.assertEquals(100, priceService.getMusicPriceForUser(song3, user3));
    }

    @Test
    void testEnoughMoneyToBuy() {
        PriceService priceService = new PriceService();
        Assertions.assertEquals(true, priceService.isEnoughMoneyToBuy(user2, 50));
        Assertions.assertEquals(false, priceService.isEnoughMoneyToBuy(user3, 100));
    }

    @Test
    void testBuyMusic() {
        PriceService priceService = new PriceService();
        UserDAO testUser = new UserDAO(6L, "fst@mail.ru", "password1", "Phil", "Green",
                presets, new ArrayList<>(), songs, 500L, 5L, new HashSet<>(Collections.singletonList(UserDAO.Achievement.RATING_5_BEGINNER)));
        priceService.buyMusicSheets(testUser, instrumental1);
        Assertions.assertEquals(200L, testUser.getBalance());
        priceService.buyMusicSheets(testUser, song2);
        Assertions.assertEquals(150L, testUser.getBalance());
        priceService.buyMusicSheets(testUser, instrumental2);
        Assertions.assertEquals(150L, testUser.getBalance());
    }

    @Test
    void testUniqueGenres() {
        MusicService musicService = new MusicService();
        Assertions.assertEquals(new HashSet<>(List.of("Pop", "Hip-Hop")), musicService.getUniqueGenres(songs));
    }

    @Test
    void testUserRating() {
        user3.addSong(song1);
        user3.addSong(song2);
        user3.addSong(song3);
        Assertions.assertEquals(3L, user3.getRating());
    }

    @Test
    void testBestRatingAchievement() {
        PriceService priceService = new PriceService();
        Assertions.assertEquals(UserDAO.Achievement.RATING_5_BEGINNER, priceService.getBestRatingAchievement(user1));
        Assertions.assertEquals(UserDAO.Achievement.RATING_10_TALENTED, priceService.getBestRatingAchievement(user2));
    }

    @Test
    void testWelcomeToTheJungle() {
        UserDAO user = new UserDAO(4L, "third@mail.ru", "jspj2ja2", "July", "Brown",
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), 0L, 0L, new HashSet<>());
        PriceService priceService = new PriceService();

        priceService.topUserBalance(user, 40);
        Assertions.assertFalse(user.getAchievements().contains(UserDAO.Achievement.WELCOME_THE_JUNGLE));
        priceService.topUserBalance(user, 150);
        Assertions.assertTrue(user.getAchievements().contains(UserDAO.Achievement.WELCOME_THE_JUNGLE));
    }

    @Test
    void testGetPremiumSynthPresets() {
        MusicService musicService = new MusicService();

        Assertions.assertTrue(musicService.getPremiumSynthPresets(presets).contains(preset2));
        Assertions.assertTrue(musicService.getPremiumSynthPresets(presets).contains(preset4));
    }

    @Test
    void testSortMusicsByAuthor() {
        MusicService musicService = new MusicService();
        Assertions.assertEquals(List.of(song3, song2, song1), musicService.sortMusicsByAuthor(songs));
    }

    @Test
    void testBuyMusicIfNotEnoughMoney() {
        PriceService priceService = new PriceService();
        UserDAO testUser = new UserDAO(6L, "fst@mail.ru", "password1", "Phil", "Green",
                presets, new ArrayList<>(), songs, 0L, 5L, new HashSet<>(Collections.singletonList((UserDAO.Achievement.RATING_5_BEGINNER))));
        Assertions.assertThrows(RuntimeException.class, () -> priceService.buyMusicSheets(testUser, song3));
    }

    @Test
    void testSheetsCreator() {
        MusicService musicService = new MusicService();
        String sheetsUrl = "";
        musicService.addSheetsUser(user1, sheetsUrl, instrumental2);
        Assertions.assertTrue(user1.getAchievements().contains(UserDAO.Achievement.CREATOR));
    }

    @Test
    void testSerializePreset() {
        PresetService presetService = new PresetService();
        String jsonString = presetService.serialize(preset1);
        SynthPreset deserializedPreset = presetService.deserialize(jsonString);
        Assertions.assertEquals(preset1, deserializedPreset);
    }

    @Test
    void testInstrumentsMusician() {
        UserService userService = new UserService();
        userService.addFavouriteInstrument(user3, in1);
        userService.addFavouriteInstrument(user3, in2);
        userService.addFavouriteInstrument(user3, in3);
        Assertions.assertTrue(user3.getAchievements().contains(UserDAO.Achievement.TALENTED_MUSICIAN));
    }

    private SynthPreset preset1 = new SynthPreset(0L, "Wave", 1.0, 1.0, 1.0, 1.0,
            1.0, 1.0, 1.0, "POLYPHONIC", false, 10);
    private SynthPreset preset2 = new SynthPreset(1L, "Smooth", 1.0, 1.0, 1.0, 1.0,
            1.0, 1.0, 1.0, "POLYPHONIC", true, 20);
    private SynthPreset preset3 = new SynthPreset(2L, "", 1.0, 1.0, 1.0, 1.0,
            1.0, 1.0, 1.0, "POLYPHONIC", false, 30);
    private SynthPreset preset4 = new SynthPreset(3L, "Wave", 1.0, 1.0, 1.0, 1.0,
            1.0, 1.0, 1.0, "POLYPHONIC", true, 35);
    private List<SynthPreset> presets = Arrays.asList(preset1, preset2, preset3, preset4);

    private MusicalInstrument in1 = new MusicalInstrument("Guitar", false);
    private MusicalInstrument in2 = new MusicalInstrument("Piano", false);
    private MusicalInstrument in3 = new MusicalInstrument("Synth", true);
    private List<MusicalInstrument> ins = Arrays.asList(in1, in2, in3);

    private MusicDAO song1 = new MusicDAO(0L, MusicDAO.MusicType.SONG, "Pop", presets, "Blinding Lights",
            "The Weeknd", Arrays.asList(in3), "https://example.com", 200, 5);
    private MusicDAO song2 = new MusicDAO(1L, MusicDAO.MusicType.SONG, "Hip-Hop", Arrays.asList(preset1, preset4), "Stronger",
            "Kanye West", Arrays.asList(in3), "https://example.com", 50, 3);
    private MusicDAO song3 = new MusicDAO(2L, MusicDAO.MusicType.SONG, "Hip-Hop", List.of(preset3), "Nonstop",
            "Drake", Arrays.asList(in3), "https://example.com", 100, 1);
    private List<MusicDAO> songs = Arrays.asList(song1, song2, song3);

    private MusicDAO instrumental1 = new MusicDAO(3L, MusicDAO.MusicType.INSTRUMENTAL, "Neoclassicism", presets, "Experience",
            "Ludovico Einaudi", Collections.singletonList(in2), "https://example.com", 300, 5);
    private MusicDAO instrumental2 = new MusicDAO(4L, MusicDAO.MusicType.INSTRUMENTAL, "Fonk", presets, "Close Eyes",
            "DVRST", Collections.singletonList(in3), "https://example.com", 0, 0);
    private List<MusicDAO> instrumentals = Arrays.asList(instrumental1, instrumental2);


    private UserDAO user1 = new UserDAO(1L, "fst@mail.ru", "password1", "Phil", "Green",
            presets, new ArrayList<>(), songs, 0L, 5L, new HashSet<>(Collections.singletonList(UserDAO.Achievement.RATING_5_BEGINNER)));
    private UserDAO user2 = new UserDAO(2L, "snd@mail.ru", "password2", "Jack", "Black",
            presets, ins, songs, 100L, 10L, new HashSet<>(Arrays.asList(UserDAO.Achievement.RATING_10_TALENTED, UserDAO.Achievement.WELCOME_THE_JUNGLE)));
    private UserDAO user3 = new UserDAO(2L, "thd@mail.ru", "password3", "Nick", "White",
            new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), 50L, 0L, new HashSet<>(Collections.singletonList(UserDAO.Achievement.WELCOME_THE_JUNGLE)));
    private final List<UserDAO> users = List.of(user1, user2, user3);

}
