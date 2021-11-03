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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        SynthPreset p = (SynthPreset)obj;
        return this.id.equals(p.id)
                && this.gate == p.gate
                && this.attack == p.attack
                && this.decay == p.decay
                && this.sustain == p.sustain
                && this.release == p.release
                && this.cutoff == p.cutoff
                && this.threshold == p.threshold
                && this.polyphony.equals(p.polyphony)
                && this.price == p.price;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

}
