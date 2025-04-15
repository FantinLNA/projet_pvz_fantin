package com.epf.core.service;

import com.epf.api.DTO.PlanteDTO;
import com.epf.api.DTO.Plantemapper;
import com.epf.core.Model.Plantes;
import com.epf.infra.persistance.PlanteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlanteService implements interfacePlanteService {

    private final PlanteDAO planteDAO;

    @Autowired
    public PlanteService(PlanteDAO planteDAO) {
        this.planteDAO = planteDAO;
    }

    @Override
    public List<Plantes> getAllPlantes() {
        List<Plantes> plantes = planteDAO.getAllPlantes();
        return plantes;
    }

    @Override
    public Plantes getPlanteById(int id) {
        return planteDAO.getPlanteById(id);
    }

    @Override
    public Plantes addPlante(Plantes plante) {
        return planteDAO.addPlante(plante);
    }

    @Override
    public Plantes updatePlante(Plantes plantes, int id) {
        Plantes existingPlante = planteDAO.getPlanteById(id);

        if (existingPlante == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Plante non trouvée");
        }

        return planteDAO.updatePlante(plantes, id);
    }

    @Override
    public void deletePlante(int id) {
        planteDAO.deletePlante(id);
    }
}
