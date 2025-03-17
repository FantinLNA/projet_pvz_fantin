package com.epf.core.service;

import com.epf.core.Model.Zombies;

import java.util.List;

public interface interfaceZombieService {
    List<Zombies> getAllZombies();
    Zombies getZombieById(int id);
    void addZombie(Zombies zombie);
    void updateZombie(Zombies zombie, int id);
    void deleteZombie(int id);
    List<Zombies> getZombiesByMap(int id);
}
