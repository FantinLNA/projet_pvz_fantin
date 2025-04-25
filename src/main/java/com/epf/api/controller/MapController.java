package com.epf.api.controller;

import com.epf.api.DTO.MapDTO;
import com.epf.api.DTO.Mapmapper;
import com.epf.api.DTO.Plantemapper;
import com.epf.api.validator.MapValidation;
import com.epf.core.Model.Maps;
import com.epf.core.service.MapService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/maps")
public class MapController {

    private final MapService mapService;
    private final Mapmapper mapmapper;
    private final MapValidation mapValidation;

    public MapController(MapService mapService, Mapmapper mapmapper, MapValidation mapValidation) {
        this.mapService = mapService;
        this.mapmapper = mapmapper;
        this.mapValidation = mapValidation;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<MapDTO>> getAllMaps() {
        List<Maps> maps = mapService.getAllMaps();
        List<MapDTO> mapDTOs = mapmapper.ToListMapDTO(maps);
        return ResponseEntity.ok(mapDTOs);
    }

    @GetMapping(path = "/{id}")
    @ResponseBody
    public ResponseEntity<MapDTO> getMapById(@PathVariable("id") int id) {
        Maps map = mapService.getMapByID(id);

        if (map == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        MapDTO mapDTO = mapmapper.toMapDTO(map);

        return ResponseEntity.ok(mapDTO);
    }

    @PostMapping
    public ResponseEntity<MapDTO> createMap(@RequestBody MapDTO mapDTO) {
        mapValidation.MapValidation(mapDTO);
        Maps map = mapmapper.toMapEntity(mapDTO);
        Maps newMap = mapService.addMap(map);
        MapDTO newMapDTO = mapmapper.toMapDTO(newMap);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMapDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MapDTO> updateMap(@PathVariable("id") int id, @RequestBody MapDTO mapDTO) {
        mapValidation.MapValidation(mapDTO);
        Maps map = mapmapper.toMapEntity(mapDTO);
        Maps updatedMap = mapService.updateMap(map, id);
        MapDTO updatedMapDTO = mapmapper.toMapDTO(updatedMap);
        return ResponseEntity.ok(updatedMapDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMap(@PathVariable("id") int id) {
        mapService.deleteMap(id);
        return ResponseEntity.ok("Map supprimée avec succès !");
    }
}
