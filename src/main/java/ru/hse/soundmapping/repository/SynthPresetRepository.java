package ru.hse.soundmapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.hse.soundmapping.models.SynthPreset;

public interface SynthPresetRepository extends JpaRepository<SynthPreset, Long>, JpaSpecificationExecutor<SynthPreset> {
}
