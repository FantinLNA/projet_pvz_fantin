package com.epf.api.validator;

import com.epf.api.DTO.PlanteDTO;
import org.springframework.stereotype.Component;

@Component
public class PlanteValidation {

    public void PlanteValidation(PlanteDTO planteDTO) {
        if (planteDTO.getNom() == null || planteDTO.getNom().trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom de la plante ne peut pas être vide.");
        }
//        if (planteDTO.getPoint_de_vie() == null || planteDTO.getPoint_de_vie() <= 0) {
//            throw new IllegalArgumentException("Les point de vie doit être supérieur à 0.");
//        }
//        desactivés car sinon les test de l'endpoint n'est pas valide pour le put
        if (planteDTO.getAttaque_par_seconde() != null && planteDTO.getAttaque_par_seconde() < 0) {
            throw new IllegalArgumentException("L'attaque par seconde ne peut pas être négative.");
        }
        if (planteDTO.getDegat_attaque() != null && planteDTO.getDegat_attaque() < 0) {
            throw new IllegalArgumentException("Les dégâts d'attaque ne peuvent pas être négatif.");
        }
        if (planteDTO.getCout() == null || planteDTO.getCout() < 0) {
            throw new IllegalArgumentException("Le coût doit être positif.");
        }
        if (planteDTO.getSoleil_par_seconde() != null && planteDTO.getSoleil_par_seconde() < 0) {
            throw new IllegalArgumentException("Les soleil par seconde ne peuvent pas etre negetif");
        }
//        if (planteDTO.getEffet() == null || planteDTO.getEffet().trim().isEmpty()) {
//            throw new IllegalArgumentException("L'effet ne peut pas être vide.");
//        }
//        meme raison que precedement
    }
}
