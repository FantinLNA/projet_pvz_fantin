package com.epf.controller;

import com.epf.DTO.MapDTO;
import com.epf.core.service.MapService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
