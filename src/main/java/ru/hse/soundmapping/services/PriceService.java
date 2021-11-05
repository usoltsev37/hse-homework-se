package ru.hse.soundmapping.services;

import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;
import ru.hse.soundmapping.daos.MusicDAO;
import ru.hse.soundmapping.daos.UserDAO;

@Service
public class PriceService {

    public int getPrice(List<MusicDAO> songs) {
        int finalPrice = 0;

        for (MusicDAO music : songs) {
            finalPrice += music.getPrice();
        }

        return finalPrice;
    }

    public int getMusicPriceForUser(MusicDAO song, UserDAO user) {
        int percentDiscount = 0;

        for (UserDAO.Achievement achievement : user.getAchievements()) {
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

    public boolean isEnoughMoneyToBuy(UserDAO user, int price) {
        return user.getBalance() >= price;
    }

    public void buyMusicSheets(UserDAO user, MusicDAO music) {
        if (!isEnoughMoneyToBuy(user, music.getPrice())) {
            throw new RuntimeException("");
        }
        user.setBalance(user.getBalance() - music.getPrice());
    }

    public UserDAO.Achievement getBestRatingAchievement(UserDAO user) {
        Set<UserDAO.Achievement> achievements = user.getAchievements();
        if (achievements.contains(UserDAO.Achievement.RATING_25_GOD)) {
            return UserDAO.Achievement.RATING_25_GOD;
        } else if (achievements.contains(UserDAO.Achievement.RATING_20_MASTER)) {
            return UserDAO.Achievement.RATING_20_MASTER;
        } else if (achievements.contains(UserDAO.Achievement.RATING_15_INTERMEDIATE)) {
            return UserDAO.Achievement.RATING_15_INTERMEDIATE;
        } else if (achievements.contains(UserDAO.Achievement.RATING_10_TALENTED)) {
            return UserDAO.Achievement.RATING_10_TALENTED;
        } else {
            return UserDAO.Achievement.RATING_5_BEGINNER;
        }
    }

    public void topUserBalance(UserDAO user, int balance) {
        user.setBalance(user.getBalance() + balance);

        if (user.getBalance() >= 100) {
            user.getAchievements().add(UserDAO.Achievement.WELCOME_THE_JUNGLE);
        }
    }
}
