package ru.hse.soundmapping.controllers;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import ru.hse.soundmapping.models.Music;
import ru.hse.soundmapping.models.User;
import ru.hse.soundmapping.models.UserMusic;
import ru.hse.soundmapping.repository.MusicRepository;
import ru.hse.soundmapping.repository.UserMusicRepository;
import ru.hse.soundmapping.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMusicRepository userMusicRepository;
    @Autowired
    private MusicRepository musicRepository;

    @GetMapping("/mail={email}")
    public User getUserByMail(@PathVariable String email) {
        return userRepository.getUserByEmail(email);
    }

    @GetMapping("/music/{email}")
    public List<Music> getUsersMusic(@PathVariable String email) {
        List<Long> musicIds = userMusicRepository.getUserMusicByUserId(userRepository.getUserByEmail(email).getId()).stream()
                .map(UserMusic::getMusicId)
                .collect(Collectors.toList());
        return musicIds.stream().map(musicRepository::getById).collect(Collectors.toList());
    }

    @PostMapping("/music/collection/user={email}?music={musicId}")
    public void addMusicToUser(@PathVariable String email, @PathVariable Long musicId) {
        userMusicRepository.save(new UserMusic(userRepository.getUserByEmail(email).getId(), musicId));
    }

    @PostMapping("")
    public void addUser(User user) {
        userRepository.save(user);
    }
}
