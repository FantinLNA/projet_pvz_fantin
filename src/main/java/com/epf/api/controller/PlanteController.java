package com.epf.api.controller;


import com.epf.api.DTO.PlanteDTO;
import com.epf.api.DTO.Plantemapper;
import com.epf.core.Model.Plantes;
import com.epf.core.service.PlanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/plantes")
public class PlanteController {

    private final PlanteService planteService;
    private final Plantemapper plantemapper;

    @Autowired
    public PlanteController(PlanteService planteService, Plantemapper plantemapper) {
        this.planteService = planteService;
        this.plantemapper = plantemapper;
    }

    // ✅ 2. Récupérer toutes les plantes
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<PlanteDTO>> getAllPlantes() {
        List<Plantes> plantes = planteService.getAllPlantes();
        List<PlanteDTO> planteDTOS = plantemapper.ToListPlanteDTO(plantes);
        return ResponseEntity.ok(planteDTOS);
    }

    // ✅ 3. Récupérer une plante par ID
    @GetMapping(path = "/{id}")
    @ResponseBody
    public ResponseEntity<PlanteDTO> getPlanteById(@PathVariable("id") int id) {
        Plantes plante = planteService.getPlanteById(id);

        if (plante == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Plante non trouvée");
        }

        PlanteDTO planteDTO = plantemapper.toPlanteDTO(plante);

        return ResponseEntity.ok(planteDTO);
    }

    // ✅ 4. Créer une nouvelle plante
    @PostMapping
    public ResponseEntity<PlanteDTO> createPlante(@RequestBody PlanteDTO planteDTO) {
        Plantes plante = plantemapper.toPlanteEntity(planteDTO);
        Plantes newPlante = planteService.addPlante(plante);
        PlanteDTO newPlanteDTO = plantemapper.toPlanteDTO(newPlante);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPlanteDTO);
    }

    // ✅ 5. Modifier une plante existante
    @PutMapping("/{id}")
    public ResponseEntity<PlanteDTO> updatePlante(@PathVariable("id") int id, @RequestBody PlanteDTO planteDTO) {
        Plantes plante = plantemapper.toPlanteEntity(planteDTO);
        plante.setId_plante(id); // très important
        if (plante.getPoint_de_vie() == null) {
            plante.setPoint_de_vie(10);
        }
        Plantes updatedPlante = planteService.updatePlante(plante, id);
        PlanteDTO updatedPlanteDTO = plantemapper.toPlanteDTO(updatedPlante);
        return ResponseEntity.ok(updatedPlanteDTO);
    }


    // ✅ 6. Supprimer une plante
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlante(@PathVariable("id") int id) {
        planteService.deletePlante(id);
        return ResponseEntity.ok("Plante supprimée avec succès !");
    }

}
