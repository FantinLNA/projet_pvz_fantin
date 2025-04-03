package com.epf.DTO;

import com.epf.core.Model.Maps;

import java.util.Map;

public class Mapmapper {
    public static MapDTO toMapDTO(Maps map) {
        return new MapDTO(
                map.getLigne(),
                map.getColonne(),
                map.getChemin_image()
        );
    }

    public static Maps toMapEntity(MapDTO mapDTO) {
        return new Maps(
                mapDTO.getLigne(),
                mapDTO.getColonne(),
                mapDTO.getChemin_image()
        );
    }
}
