package com.epf.api.DTO;

import com.epf.core.Model.Plantes;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Plantemapper {
    public PlanteDTO toPlanteDTO(Plantes plante) {
        return new PlanteDTO(
                plante.getId_plante(),
                plante.getNom(),
                plante.getPoint_de_vie(),
                plante.getAttaque_par_seconde(),
                plante.getDegat_attaque(),
                plante.getCout(),
                plante.getSoleil_par_seconde(),
                plante.getEffet(),
                plante.getChemin_image()
        );
    }

    public List<PlanteDTO> ToListPlanteDTO(List<Plantes> plantes) {
        return plantes.stream().map(this::toPlanteDTO).collect(Collectors.toList());
    }

    public Plantes toPlanteEntity(PlanteDTO dto) {
        return new Plantes(
                dto.getId_plante(),
                dto.getNom(),
                dto.getPoint_de_vie(),
                dto.getAttaque_par_seconde(),
                dto.getDegat_attaque(),
                dto.getCout(),
                dto.getSoleil_par_seconde(),
                dto.getEffet(),
                dto.getChemin_image()
        );
    }

    public List<Plantes> ToListPlanteEntity(List<PlanteDTO> dto) {
        return dto.stream().map(this::toPlanteEntity).collect(Collectors.toList());
    }
}
