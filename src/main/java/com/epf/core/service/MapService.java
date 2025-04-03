package com.epf.core.service;

import com.epf.DTO.MapDTO;
import com.epf.DTO.Mapmapper;
import com.epf.core.Model.Maps;
import com.epf.persistance.MapDAO;
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
    public List<MapDTO> getAllMaps() {
        return mapDAO.getAllMaps().stream().map(Mapmapper::toMapDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<MapDTO> getMapByID(int id) {
        Maps map = mapDAO.getMapByID(id);
        if (map == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Map non trouvée");
        }
        return Optional.of(Mapmapper.toMapDTO(map));
    }

    @Override
    public MapDTO addMap(MapDTO dto) {
        Maps map = Mapmapper.toMapEntity(dto);
        Maps savedMap = mapDAO.addMap(map);
        return Mapmapper.toMapDTO(savedMap);
    }

    @Override
    public MapDTO updateMap(MapDTO dto, int id) {
        Maps existingMap = mapDAO.getMapByID(id);

        if (existingMap == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Map non trouvée");
        }

        // Met à jour les champs
        existingMap.setLigne(dto.getLigne());
        existingMap.setColonne(dto.getColonne());
        existingMap.setChemin_image(dto.getChemin_image());


        mapDAO.updateMap(existingMap, id);

        return Mapmapper.toMapDTO(existingMap);
    }

    @Override
    public void deleteMap(int id) {
        mapDAO.deleteMap(id);
    }
}
