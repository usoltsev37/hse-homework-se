package ru.hse.soundmapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.hse.soundmapping.models.Music;

public interface MusicRepository extends JpaRepository<Music, Long>, JpaSpecificationExecutor<Music> {

}
