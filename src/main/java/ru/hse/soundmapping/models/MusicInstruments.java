package ru.hse.soundmapping.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table (name = "MusicInstruments")
public class MusicInstruments {

    @Id
    @Column (name = "id")
    private Long id;

    @Column (name = "music_id")
    private Long musicId;

    @Column (name = "instrument_name")
    private String instrumentName;
}
