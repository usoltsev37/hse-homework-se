package ru.hse.soundmapping.services;

import java.util.List;
import org.springframework.stereotype.Service;
import ru.hse.soundmapping.models.Music;

@Service
public class PriceService {

    public int getPrice(List<Music> songs) {
        int finalPrice = 0;

        for (Music music : songs) {
            finalPrice += music.getPrice();
        }

        return finalPrice;
    }
}
