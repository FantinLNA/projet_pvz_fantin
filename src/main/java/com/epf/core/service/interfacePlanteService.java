package com.epf.core.service;

import com.epf.api.DTO.PlanteDTO;
import com.epf.core.Model.Plantes;

import java.util.List;
import java.util.Optional;

public interface interfacePlanteService {
    List<Plantes> getAllPlantes();
    Plantes getPlanteById(int id);

    Plantes addPlante(Plantes plante);

    Plantes updatePlante(Plantes plantes, int id);
    void deletePlante(int id);
}
