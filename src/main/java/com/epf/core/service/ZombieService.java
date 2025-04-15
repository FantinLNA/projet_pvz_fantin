package com.epf.core.service;

import com.epf.api.DTO.ZombieDTO;
import com.epf.api.DTO.Zombiemapper;
import com.epf.core.Model.Zombies;
import com.epf.infra.persistance.ZombieDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ZombieService implements interfaceZombieService {
    private final ZombieDAO zombieDAO;

    @Autowired
    public ZombieService(ZombieDAO zombieDAO) {
        this.zombieDAO = zombieDAO;
    }

    @Override
    public List<ZombieDTO> getAllZombies() {
        return zombieDAO.getAllZombies().stream().map(Zombiemapper::toZombieDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<ZombieDTO> getZombieById(int id) {
        Zombies zombie = zombieDAO.getZombieById(id);
        if (zombie == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Zombie non trouvée");
        }
        return Optional.of(Zombiemapper.toZombieDTO(zombie));
    }

    @Override
    public ZombieDTO addZombie(ZombieDTO dto) {
        Zombies zombie = Zombiemapper.toZombieEntity(dto);
        Zombies savedZombie = zombieDAO.addZombie(zombie);
        return Zombiemapper.toZombieDTO(savedZombie);
    }

    @Override
    public ZombieDTO updateZombie(ZombieDTO dto, int id) {
        Zombies existingZombie = zombieDAO.getZombieById(id);

        if (existingZombie == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "zombie non trouvée");
        }

        // Met à jour les champs
        existingZombie.setNom(dto.getNom());
        existingZombie.setPoint_de_vie(dto.getPoint_de_vie());
        existingZombie.setDegat_attaque(dto.getDegat_attaque());
        existingZombie.setAttaque_par_seconde(dto.getAttaque_par_seconde());
        existingZombie.setVitesse_de_deplacement(dto.getVitesse_de_deplacement());
        existingZombie.setChemin_image(dto.getChemin_image());
        existingZombie.setId_map(dto.getId_map());

        zombieDAO.updateZombie(existingZombie, id);

        return Zombiemapper.toZombieDTO(existingZombie);
    }

    @Override
    public void deleteZombie(int id) {
        zombieDAO.deleteZombie(id);
    }

}
