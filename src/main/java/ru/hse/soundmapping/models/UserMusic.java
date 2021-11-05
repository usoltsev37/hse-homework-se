package ru.hse.soundmapping.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table (name = "UserMusic")
public class UserMusic {

    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "user_id")
    private Long userId;

    @Column (name = "music_id")
    private Long musicId;

    public UserMusic(Long userId, Long musicId) {
        this.userId = userId;
        this.musicId = musicId;
    }
}
