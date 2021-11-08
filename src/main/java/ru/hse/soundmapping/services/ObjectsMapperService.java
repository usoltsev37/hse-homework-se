package ru.hse.soundmapping.services;

import org.springframework.stereotype.Service;
import ru.hse.soundmapping.daos.MusicDAO;
import ru.hse.soundmapping.daos.UserDAO;
import ru.hse.soundmapping.models.Music;
import ru.hse.soundmapping.models.User;

@Service
public class ObjectsMapperService {

    public UserDAO mapUserToDao(User user) {
        return null;
    }

    public MusicDAO mapMusicToDao(Music music) {
        return null;
    }
}
