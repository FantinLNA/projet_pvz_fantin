package com.epf.api.DTO;

import com.epf.core.Model.Zombies;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class Zombiemapper {
    public ZombieDTO toZombieDTO(Zombies zombie) {
        return new ZombieDTO(
                zombie.getIdZombie(),
                zombie.getNom(),
                zombie.getPoint_de_vie(),
                zombie.getAttaque_par_seconde(),
                zombie.getDegat_attaque(),
                zombie.getVitesse_de_deplacement(),
                zombie.getChemin_image(),
                zombie.getId_map()
        );
    }

    public List<ZombieDTO> ToListZombieDTO(List<Zombies> zombies) {
        return zombies.stream().map(this::toZombieDTO).collect(Collectors.toList());
    }

    public Zombies toZombieEntity(ZombieDTO zombieDTO) {
        return new Zombies(
                zombieDTO.getIdZombie(),
                zombieDTO.getNom(),
                zombieDTO.getPoint_de_vie(),
                zombieDTO.getAttaque_par_seconde(),
                zombieDTO.getDegat_attaque(),
                zombieDTO.getVitesse_de_deplacement(),
                zombieDTO.getChemin_image(),
                zombieDTO.getId_map()
        );
    }

    public List<Zombies> ToListZombieEntity(List<ZombieDTO> zombieDTOs) {
        return zombieDTOs.stream().map(this::toZombieEntity).collect(Collectors.toList());
    }
}
