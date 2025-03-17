package com.epf.core.service;

import com.epf.core.Model.Plantes;
import com.epf.persistance.PlanteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanteService implements interfacePlanteService {
    private final PlanteDAO planteDAO;

    @Autowired
    public PlanteService(PlanteDAO planteDAO) {
        this.planteDAO = planteDAO;
    }

    @Override
    public List<Plantes> getAllPlantes() {
        return planteDAO.getAllPlantes();
    }

    @Override
    public Plantes getPlanteById(int id) {
        return planteDAO.getPlanteById(id);
    }

    @Override
    public void addPlante(Plantes plante) {
        planteDAO.addPlante(plante);
    }

    @Override
    public void updatePlante(Plantes plante, int id) {
        planteDAO.updatePlante(plante, id);
    }

    @Override
    public void deletePlante(int id) {
        planteDAO.deletePlante(id);
    }
}
