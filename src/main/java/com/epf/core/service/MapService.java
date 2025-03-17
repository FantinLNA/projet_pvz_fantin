package com.epf.core.service;

import com.epf.core.Model.Maps;
import com.epf.persistance.MapDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapService implements interfaceMapService {
    private final MapDAO mapDAO;

    @Autowired
    public MapService(MapDAO mapDAO) {
        this.mapDAO = mapDAO;
    }

    @Override
    public List<Maps> getAllMaps() {
        return mapDAO.getAllMaps();
    }

    @Override
    public Maps getMapByID(int id) {
        return mapDAO.getMapByID(id);
    }

    @Override
    public void addMap(Maps map) {
        mapDAO.addMap(map);
    }

    @Override
    public void updateMap(Maps map, int id) {
        mapDAO.updateMap(map, id);
    }

    @Override
    public void deleteMap(int id) {
        mapDAO.deleteMap(id);
    }
}
