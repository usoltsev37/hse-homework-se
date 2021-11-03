package ru.hse.soundmapping.services;

import java.util.List;
import org.springframework.stereotype.Service;
import ru.hse.soundmapping.models.Music;
import ru.hse.soundmapping.models.User;

@Service
public class PriceService {

    public int getPrice(List<Music> songs) {
        int finalPrice = 0;

        for (Music music : songs) {
            finalPrice += music.getPrice();
        }

        return finalPrice;
    }

    public int getMusicPriceForUser(Music song, User user) {
        int percentDiscount = 0;

        for (User.Achievement achievement : user.getAchievements()) {
            switch (achievement) {
                case RATING_5_BEGINNER:
                    percentDiscount = Math.max(percentDiscount, 5);
                    break;
                case RATING_10_TALENTED:
                    percentDiscount = Math.max(percentDiscount, 10);
                    break;
                case RATING_15_INTERMEDIATE:
                    percentDiscount = Math.max(percentDiscount, 15);
                    break;
                case RATING_20_MASTER:
                    percentDiscount = Math.max(percentDiscount, 20);
                    break;
                case RATING_25_GOD:
                    percentDiscount = 25;
                    break;
                default:
                    break;
            }
        }

        return song.getPrice() * (100 - percentDiscount) / 100;
    }
}
