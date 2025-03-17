package com.epf.core.service;

import com.epf.core.Model.Zombies;
import com.epf.persistance.ZombieDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZombieService implements interfaceZombieService {
    private final ZombieDAO zombieDAO;

    @Autowired
    public ZombieService(ZombieDAO zombieDAO) {
        this.zombieDAO = zombieDAO;
    }

    @Override
    public List<Zombies> getAllZombies() {
        return zombieDAO.getAllZombies();
    }

    @Override
    public Zombies getZombieById(int id) {
        return zombieDAO.getZombieById(id);
    }

    @Override
    public void addZombie(Zombies zombie) {
        zombieDAO.addZombie(zombie);
    }

    @Override
    public void updateZombie(Zombies zombie, int id) {
        zombieDAO.updateZombie(zombie, id);
    }

    @Override
    public void deleteZombie(int id) {
        zombieDAO.deleteZombie(id);
    }

    @Override
    public List<Zombies> getZombiesByMap(int id) {
        return zombieDAO.getZombiesByMap(id);
    }
}
