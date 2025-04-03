package com.epf.core.service;

import com.epf.DTO.PlanteDTO;
import com.epf.core.Model.Plantes;

import java.util.List;
import java.util.Optional;

public interface interfacePlanteService {
    List<PlanteDTO> getAllPlantes();
    Optional<PlanteDTO> getPlanteById(int id);

    PlanteDTO addPlante(PlanteDTO dto);

    PlanteDTO updatePlante(PlanteDTO dto, int id);
    void deletePlante(int id);
}
