package com.epf.controller;


import com.epf.DTO.PlanteDTO;
import com.epf.core.service.PlanteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/plantes")
public class PlanteController {

    private final PlanteService planteService;

    public PlanteController(PlanteService planteService) {
        this.planteService = planteService;
    }

    // ✅ 1. Endpoint pour valider les données
//    @PostMapping("/validation")
//    public ResponseEntity<String> validatePlante(@Valid @RequestBody PlanteDTO planteDTO) {
//        return ResponseEntity.ok("Données valides !");
//    }

    // ✅ 2. Récupérer toutes les plantes
    @GetMapping
    public List<PlanteDTO> getAllPlantes() {
        return planteService.getAllPlantes();
    }

    // ✅ 3. Récupérer une plante par ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<PlanteDTO>> getPlanteById(@PathVariable int id) {
        Optional<PlanteDTO> planteDTO = planteService.getPlanteById(id);

        if (planteDTO == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Plante non trouvée");
        }

        return ResponseEntity.ok(planteDTO);
    }

    // ✅ 4. Créer une nouvelle plante
    @PostMapping
    public ResponseEntity<PlanteDTO> createPlante(@RequestBody PlanteDTO planteDTO) {
        PlanteDTO newPlante = planteService.addPlante(planteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPlante);
    }

    // ✅ 5. Modifier une plante existante
    @PutMapping("/{id}")
    public ResponseEntity updatePlante(@RequestBody PlanteDTO planteDTO ,@PathVariable int id) {
        return ResponseEntity.ok(planteService.updatePlante(planteDTO, id));
    }

    // ✅ 6. Supprimer une plante
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlante(@PathVariable int id) {
        planteService.deletePlante(id);
        return ResponseEntity.ok("Plante supprimée avec succès !");
    }

}
