package ru.hse.soundmapping.services;

import org.springframework.stereotype.Service;
import ru.hse.soundmapping.models.MusicalInstrument;
import ru.hse.soundmapping.daos.UserDAO;

@Service
public class UserService {
    public void addFavouriteInstrument(UserDAO user, MusicalInstrument instrument) {
        user.getFavouriteMusicalInstruments().add(instrument);
        if (user.getFavouriteMusicalInstruments().size() >= 3) {
            user.getAchievements().add(UserDAO.Achievement.TALENTED_MUSICIAN);
        }
    }
}
