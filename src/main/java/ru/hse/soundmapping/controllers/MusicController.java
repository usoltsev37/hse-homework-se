package ru.hse.soundmapping.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.hse.soundmapping.models.Music;
import ru.hse.soundmapping.repository.MusicRepository;

@RestController
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private MusicRepository musicRepository;

    @GetMapping("/{musicId}")
    public Music getMusic(@PathVariable Long musicId) {
        return musicRepository.getById(musicId);
    }

    @PostMapping("")
    public void addMusic(Music music) {
        musicRepository.save(music);
    }
}
