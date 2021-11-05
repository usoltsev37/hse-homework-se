package ru.hse.soundmapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.hse.soundmapping.models.MusicInstruments;

import java.util.List;

public interface MusicInstrumentsRepository extends JpaRepository<MusicInstruments, Long>, JpaSpecificationExecutor<MusicInstruments> {

    List<MusicInstruments> getMusicInstrumentsByMusicId(Long musicId);
}
