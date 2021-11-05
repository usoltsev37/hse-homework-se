package ru.hse.soundmapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.hse.soundmapping.models.UserMusic;

import java.util.List;

@Repository
public interface UserMusicRepository extends JpaRepository<UserMusic, Long>, JpaSpecificationExecutor<UserMusic> {
    List<UserMusic> getUserMusicByUserId(Long userId);
}
