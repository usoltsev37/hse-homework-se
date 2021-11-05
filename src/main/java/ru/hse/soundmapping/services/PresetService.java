package ru.hse.soundmapping.services;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import ru.hse.soundmapping.models.SynthPreset;

@Service
public class PresetService {
    public String serialize(SynthPreset preset) {
        Gson gson = new Gson();
        return gson.toJson(preset);
    }

    public SynthPreset deserialize(String preset) {
        Gson gson = new Gson();
        return gson.fromJson(preset, SynthPreset.class);
    }
}
