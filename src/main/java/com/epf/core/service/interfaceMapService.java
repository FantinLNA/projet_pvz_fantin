package com.epf.core.service;

import com.epf.DTO.MapDTO;
import com.epf.core.Model.Maps;

import java.util.List;
import java.util.Optional;

public interface interfaceMapService {
    List<MapDTO> getAllMaps();
    Optional<MapDTO> getMapByID(int id);
    MapDTO addMap(MapDTO dto);
    MapDTO updateMap(MapDTO dto, int id);
    void deleteMap(int id);
}
