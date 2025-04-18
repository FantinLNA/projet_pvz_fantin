package com.epf.core.service;

import com.epf.api.DTO.ZombieDTO;
import com.epf.core.Model.Zombies;

import java.util.List;
import java.util.Optional;

public interface interfaceZombieService {
    List<Zombies> getAllZombies();
    Zombies getZombieById(int id);
    Zombies addZombie(Zombies zombie);
    Zombies updateZombie(Zombies zombie, int id);
    void deleteZombie(int id);
    //List<Zombies> getZombiesByMap(int id);
}
