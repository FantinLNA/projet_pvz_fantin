package com.epf.api.controller;

import com.epf.api.DTO.MapDTO;
import com.epf.core.service.MapService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/maps")
public class MapController {

    private final MapService mapService;

    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    @GetMapping
    public List<MapDTO> getAllMaps() {
        return mapService.getAllMaps();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<MapDTO>> getMapById(@PathVariable int id) {
        Optional<MapDTO> mapDTO = mapService.getMapByID(id);

        if (mapDTO == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Map non trouvée");
        }

        return ResponseEntity.ok(mapDTO);
    }

    @PostMapping
    public ResponseEntity<MapDTO> createMap(@RequestBody MapDTO mapDTO) {
        MapDTO newMap = mapService.addMap(mapDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMap);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateMap(@PathVariable int id, @RequestBody MapDTO mapDTO) {
        return ResponseEntity.ok(mapService.updateMap(mapDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMap(@PathVariable int id) {
        mapService.deleteMap(id);
        return ResponseEntity.ok("Map supprimée avec succès !");
    }
}
