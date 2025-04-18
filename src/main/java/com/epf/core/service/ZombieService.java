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
    public List<Zombies> getAllZombies() {
        List<Zombies> zombies = zombieDAO.getAllZombies();
        return zombies;
    }

    @Override
    public Zombies getZombieById(int id) {
        return zombieDAO.getZombieById(id);
    }

    @Override
    public Zombies addZombie(Zombies zombie) {
        return zombieDAO.addZombie(zombie);
    }

    @Override
    public Zombies updateZombie(Zombies zombie, int id) {
        Zombies existingZombie = zombieDAO.getZombieById(id);

        if (existingZombie == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "zombie non trouvée");
        }

        return zombieDAO.updateZombie(zombie, id);
    }

    @Override
    public void deleteZombie(int id) {
        zombieDAO.deleteZombie(id);
    }

}
