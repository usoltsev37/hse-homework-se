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
@Table(name = "SynthPreset")
public class SynthPreset {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

    @Column(name = "gate")
    private double gate;
    @Column(name = "attack")
    private double attack;
    @Column(name = "decay")
    private double decay;
    @Column(name = "sustain")
    private double sustain;
    @Column(name = "release_synth")
    private double release;
    @Column(name = "cutoff")
    private double cutoff;
    @Column(name = "threshold")
    private double threshold;
    @Column(name = "polyphony")
    private String polyphony;

    private boolean premium;
    @Column(name = "price")
    private int price;

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        SynthPreset p = (SynthPreset) obj;
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
