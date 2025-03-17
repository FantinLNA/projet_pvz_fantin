package com.epf.core.service;

import com.epf.core.Model.Plantes;

import java.util.List;

public interface interfacePlanteService {
    List<Plantes> getAllPlantes();
    Plantes getPlanteById(int id);
    void addPlante(Plantes plante);
    void updatePlante(Plantes plante, int id);
    void deletePlante(int id);
}
