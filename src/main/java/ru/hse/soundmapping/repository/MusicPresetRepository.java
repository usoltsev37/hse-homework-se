package ru.hse.soundmapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.hse.soundmapping.models.MusicPreset;

import java.util.List;

public interface MusicPresetRepository extends JpaRepository<MusicPreset, Long>, JpaSpecificationExecutor<MusicPreset> {
    List<MusicPreset> getMusicPresetByMusicId(Long musicId);
}
