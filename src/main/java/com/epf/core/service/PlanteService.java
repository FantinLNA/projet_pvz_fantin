package com.epf.core.service;

import com.epf.DTO.PlanteDTO;
import com.epf.DTO.Plantemapper;
import com.epf.core.Model.Plantes;
import com.epf.persistance.PlanteDAO;
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
    public List<PlanteDTO> getAllPlantes() {
        return planteDAO.getAllPlantes().stream().map(Plantemapper::toPlanteDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<PlanteDTO> getPlanteById(int id) {
        Plantes plante = planteDAO.getPlanteById(id);
        if (plante == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Plante non trouvée");
        }
        return Optional.of(Plantemapper.toPlanteDTO(plante));
    }

    @Override
    public PlanteDTO addPlante(PlanteDTO dto) {
        Plantes plante = Plantemapper.toPlanteEntity(dto);
        Plantes savedPlante = planteDAO.addPlante(plante);
        return Plantemapper.toPlanteDTO(savedPlante);
    }

    @Override
    public PlanteDTO updatePlante(PlanteDTO dto, int id) {
        Plantes existingPlante = planteDAO.getPlanteById(id);

        if (existingPlante == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Plante non trouvée");
        }

        // Met à jour les champs
        existingPlante.setNom(dto.getNom());
        existingPlante.setPoint_de_vie(dto.getPoint_de_vie());
        existingPlante.setAttaque_par_seconde(dto.getAttaque_par_seconde());
        existingPlante.setDegat_attaque(dto.getDegat_attaque());
        existingPlante.setCout(dto.getCout());
        existingPlante.setSoleil_par_seconde(dto.getSoleil_par_seconde());
        existingPlante.setEffet(dto.getEffet());
        existingPlante.setChemin_image(dto.getChemin_image());

        planteDAO.updatePlante(existingPlante, id);

        return Plantemapper.toPlanteDTO(existingPlante);
    }

    @Override
    public void deletePlante(int id) {
        planteDAO.deletePlante(id);
    }
}
