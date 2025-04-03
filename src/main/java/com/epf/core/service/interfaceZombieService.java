package com.epf.core.service;

import com.epf.DTO.ZombieDTO;
import com.epf.core.Model.Zombies;

import java.util.List;
import java.util.Optional;

public interface interfaceZombieService {
    List<ZombieDTO> getAllZombies();
    Optional<ZombieDTO> getZombieById(int id);
    ZombieDTO addZombie(ZombieDTO dto);
    ZombieDTO updateZombie(ZombieDTO dto, int id);
    void deleteZombie(int id);
    //List<Zombies> getZombiesByMap(int id);
}
