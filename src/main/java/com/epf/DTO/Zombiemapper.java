package com.epf.DTO;

import com.epf.core.Model.Zombies;

public class Zombiemapper {
    public static ZombieDTO toZombieDTO(Zombies zombie) {
        return new ZombieDTO(
                zombie.getNom(),
                zombie.getPoint_de_vie(),
                zombie.getAttaque_par_seconde(),
                zombie.getDegat_attaque(),
                zombie.getVitesse_de_deplacement(),
                zombie.getChemin_image(),
                zombie.getId_map()
        );
    }

    public static Zombies toZombieEntity(ZombieDTO zombieDTO) {
        return new Zombies(
                zombieDTO.getNom(),
                zombieDTO.getPoint_de_vie(),
                zombieDTO.getAttaque_par_seconde(),
                zombieDTO.getDegat_attaque(),
                zombieDTO.getVitesse_de_deplacement(),
                zombieDTO.getChemin_image(),
                zombieDTO.getId_map()
        );
    }
}
