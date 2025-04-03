package com.epf.DTO;

import com.epf.core.Model.Plantes;

public class Plantemapper {
    public static PlanteDTO toPlanteDTO(Plantes plante) {
        return new PlanteDTO(
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

    public static Plantes toPlanteEntity(PlanteDTO dto) {
        return new Plantes(
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
}
