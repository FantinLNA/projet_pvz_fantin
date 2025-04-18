package com.epf.core.service;

import com.epf.api.DTO.MapDTO;
import com.epf.core.Model.Maps;

import java.util.List;
import java.util.Optional;

public interface interfaceMapService {
    List<Maps> getAllMaps();
    Maps getMapByID(int id);
    Maps addMap(Maps map);
    Maps updateMap(Maps map, int id);
    void deleteMap(int id);
}
