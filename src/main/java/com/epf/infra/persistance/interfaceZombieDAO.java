package com.epf.infra.persistance;

import com.epf.core.Model.Zombies;

import java.util.List;

public interface interfaceZombieDAO {
    List<Zombies> getAllZombies();
    Zombies getZombieById(int id);
    Zombies addZombie(Zombies zombie);
    Zombies updateZombie(Zombies zombie, int id);
    void deleteZombie(int id);
    List<Zombies> getZombiesByMap(int id);
}
