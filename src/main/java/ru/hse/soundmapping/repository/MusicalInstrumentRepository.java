package ru.hse.soundmapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.hse.soundmapping.models.MusicalInstrument;

public interface MusicalInstrumentRepository extends
        JpaRepository<MusicalInstrument, String>, JpaSpecificationExecutor<MusicalInstrument> {
}
