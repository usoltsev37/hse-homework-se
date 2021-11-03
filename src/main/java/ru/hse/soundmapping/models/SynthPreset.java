package ru.hse.soundmapping.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SynthPreset {
    @Id
    private Long id;
    private String name;

    public enum Polyphony {
        MONOPHONIC,
        PARAPHONIC,
        DUOPHONIC,
        POLYPHONIC
    }

    private double gate;
    private double attack;
    private double decay;
    private double sustain;
    private double release;
    private double cutoff;
    private double threshold;
    private Polyphony polyphony;

    private boolean premium;
    private int price;

}
