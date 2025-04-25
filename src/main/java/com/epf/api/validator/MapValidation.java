package com.epf.api.validator;

import com.epf.api.DTO.MapDTO;
import org.springframework.stereotype.Component;

@Component
public class MapValidation {

    public void MapValidation(MapDTO mapDTO) {
        if (mapDTO.getLigne() != null && mapDTO.getLigne() < 0) {
            throw new IllegalArgumentException("les Ligne ne peuvent pas etre nulle");
        }
        if (mapDTO.getColonne() != null && mapDTO.getColonne() < 0) {
            throw new IllegalArgumentException("les Colonne ne peuvent pas etre nulle");
        }
    }
}
