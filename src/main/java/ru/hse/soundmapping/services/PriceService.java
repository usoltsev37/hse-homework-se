package ru.hse.soundmapping.services;

import java.util.List;
import java.util.Set;
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

    public boolean isEnoughMoneyToBuy(User user, int price) {
        return user.getBalance() >= price;
    }

    public void buyMusicSheets(User user, Music music) {
        if (!isEnoughMoneyToBuy(user, music.getPrice())) {
            throw new RuntimeException("");
        }
        user.setBalance(user.getBalance() - music.getPrice());
    }

    public User.Achievement getBestRatingAchievement(User user) {
        Set<User.Achievement> achievements = user.getAchievements();
        if (achievements.contains(User.Achievement.RATING_25_GOD)) {
            return User.Achievement.RATING_25_GOD;
        } else if (achievements.contains(User.Achievement.RATING_20_MASTER)) {
            return User.Achievement.RATING_20_MASTER;
        } else if (achievements.contains(User.Achievement.RATING_15_INTERMEDIATE)) {
            return User.Achievement.RATING_15_INTERMEDIATE;
        } else if (achievements.contains(User.Achievement.RATING_10_TALENTED)) {
            return User.Achievement.RATING_10_TALENTED;
        } else {
            return User.Achievement.RATING_5_BEGINNER;
        }
    }

    public void topUserBalance(User user, int balance) {
        user.setBalance(user.getBalance() + balance);

        if (user.getBalance() >= 100) {
            user.getAchievements().add(User.Achievement.WELCOME_THE_JUNGLE);
        }
    }
}
