package ru.hse.soundmapping.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "MusicalInstrument")
public class MusicalInstrument {
    @Id
    @Column(name = "name")
    private String name;

    @Column (name = "premium")
    private boolean premium;

}
