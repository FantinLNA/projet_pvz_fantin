package com.epf.core.service;

import com.epf.api.DTO.MapDTO;
import com.epf.api.DTO.Mapmapper;
import com.epf.core.Model.Maps;
import com.epf.infra.persistance.MapDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MapService implements interfaceMapService {
    private final MapDAO mapDAO;

    @Autowired
    public MapService(MapDAO mapDAO) {
        this.mapDAO = mapDAO;
    }

    @Override
    public List<Maps> getAllMaps() {
        List<Maps> maps = mapDAO.getAllMaps();
        return maps;
    }

    @Override
    public Maps getMapByID(int id) {
        Maps map = mapDAO.getMapByID(id);
        return map;
    }

    @Override
    public Maps addMap(Maps map) {
        return mapDAO.addMap(map);
    }

    @Override
    public Maps updateMap(Maps map, int id) {
        Maps existingMap = mapDAO.getMapByID(id);

        if (existingMap == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Map non trouvée");
        }

        return mapDAO.updateMap(map, id);
    }

    @Override
    public void deleteMap(int id) {
        mapDAO.deleteMap(id);
    }
}
