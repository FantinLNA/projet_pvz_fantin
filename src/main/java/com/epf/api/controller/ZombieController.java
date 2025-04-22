package com.epf.api.controller;

import com.epf.api.DTO.ZombieDTO;
import com.epf.api.DTO.Zombiemapper;
import com.epf.core.Model.Zombies;
import com.epf.core.service.ZombieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/zombies")
public class ZombieController {

    private final ZombieService zombieService;
    private final Zombiemapper zombiemapper;

    public ZombieController(ZombieService zombieService) {
        this.zombieService = zombieService;
        this.zombiemapper = new Zombiemapper();
    }

    @GetMapping
    @ResponseBody
    public  ResponseEntity<List<ZombieDTO>> getAllZombies() {
        List<Zombies> zombies = zombieService.getAllZombies();
        List<ZombieDTO> zombieDTOS = zombiemapper.ToListZombieDTO(zombies);
        return ResponseEntity.ok(zombieDTOS);
    }

    @GetMapping(path = "/{id}")
    @ResponseBody
    public ResponseEntity<ZombieDTO> getZombie(@PathVariable("id") int id) {
        Zombies zombie = zombieService.getZombieById(id);

        if (zombie == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        ZombieDTO zombieDTO = zombiemapper.toZombieDTO(zombie);

        return ResponseEntity.ok(zombieDTO);
    }

    @PostMapping
    public ResponseEntity<ZombieDTO> createZombie(@RequestBody ZombieDTO zombieDTO) {
        Zombies zombie = zombiemapper.toZombieEntity(zombieDTO);
        Zombies newzombie = zombieService.addZombie(zombie);
        ZombieDTO newzombieDTO = zombiemapper.toZombieDTO(newzombie);
        return ResponseEntity.status(HttpStatus.CREATED).body(newzombieDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ZombieDTO> updateZombie(@PathVariable("id") int id, @RequestBody ZombieDTO zombieDTO) {
        Zombies zombie = zombiemapper.toZombieEntity(zombieDTO);
        Zombies updatedZombie = zombieService.updateZombie(zombie,id);
        ZombieDTO updatedZombieDTO = zombiemapper.toZombieDTO(updatedZombie);
        return ResponseEntity.ok(updatedZombieDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteZombie(@PathVariable("id") int id) {
        zombieService.deleteZombie(id);
        return ResponseEntity.ok("Zombie supprimée avec succès !");
    }
}

