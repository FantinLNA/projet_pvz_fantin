package com.epf.persistance;

import com.epf.core.Model.Maps;

import java.util.List;

public interface interfaceMapDAO {
    List<Maps> getAllMaps();
    Maps getMapByID(int id);
    void addMap(Maps map);
    void updateMap(Maps map, int id);
    void deleteMap(int id);
}
