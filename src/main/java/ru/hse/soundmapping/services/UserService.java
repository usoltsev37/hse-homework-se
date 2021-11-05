package ru.hse.soundmapping.services;

import org.springframework.stereotype.Service;
import ru.hse.soundmapping.models.MusicalInstrument;
import ru.hse.soundmapping.models.User;

@Service
public class UserService {
    public void addFavouriteInstrument(User user, MusicalInstrument instrument) {
        user.getFavouriteMusicalInstruments().add(instrument);
        if (user.getFavouriteMusicalInstruments().size() >= 3) {
            user.getAchievements().add(User.Achievement.TALENTED_MUSICIAN);
        }
    }
}
