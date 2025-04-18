package com.epf.api.DTO;

import com.epf.core.Model.Maps;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapmapper {
    public MapDTO toMapDTO(Maps map) {
        return new MapDTO(
                map.getIdMap(),
                map.getLigne(),
                map.getColonne(),
                map.getChemin_image()
        );
    }

    public List<MapDTO> ToListMapDTO(List<Maps> maps) {
        return maps.stream().map(this::toMapDTO).collect(Collectors.toList());
    }

    public Maps toMapEntity(MapDTO mapDTO) {
        return new Maps(
                mapDTO.getId_map(),
                mapDTO.getLigne(),
                mapDTO.getColonne(),
                mapDTO.getChemin_image()
        );
    }

    public List<Maps> ToListMapEntity(List<MapDTO> mapDTOs) {
        return mapDTOs.stream().map(this::toMapEntity).collect(Collectors.toList());
    }
}
