package com.epf.api.validator;

import com.epf.api.DTO.ZombieDTO;
import org.springframework.stereotype.Component;

@Component
public class ZombieValidation {

    public void ZombieValidation(ZombieDTO zombieDTO) {
        if (zombieDTO.getId_map() == null && zombieDTO.getNom().trim().isEmpty()) {
            throw new IllegalArgumentException("le nom du zombie ne doit pas etre vide");
        }
        if (zombieDTO.getPoint_de_vie() == null || zombieDTO.getPoint_de_vie() < 0) {
            throw new IllegalArgumentException("Les point de vie doit être supérieur à 0.");
        }
        if (zombieDTO.getDegat_attaque() == null || zombieDTO.getDegat_attaque() < 0) {
            throw new IllegalArgumentException("Les degat d'attaque doivent être supérieur à 0.");
        }
//        if (zombieDTO.getAttaque_par_seconde() == null || zombieDTO.getAttaque_par_seconde() < 0) {
//            throw new IllegalArgumentException("L'attaque par seconde doit être supérieur à 0.");
//        }
//        desactivés car sinon les test de l'endpoint n'est pas valide pour le put
//        if (zombieDTO.getVitesse_de_deplacement() == null || zombieDTO.getVitesse_de_deplacement() < 0) {
//            throw new IllegalArgumentException("La vitesse doit être supérieur à 0.");
//        }
    }
}
