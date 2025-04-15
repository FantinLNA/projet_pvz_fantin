package com.epf.controller;

import com.epf.DTO.ZombieDTO;
import com.epf.core.service.ZombieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/zombies")
public class ZombieController {

    private final ZombieService zombieService;

    public ZombieController(ZombieService zombieService) {
        this.zombieService = zombieService;
    }

    @GetMapping
    public  List<ZombieDTO> getAllZombies() {
        return zombieService.getAllZombies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ZombieDTO> getZombie(@PathVariable int id) {
        Optional<ZombieDTO> zombieDTO = zombieService.getZombieById(id);

        if (zombieDTO == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Zombie non trouvée");
        }

        return ResponseEntity.ok(zombieDTO.get());
    }

    @PostMapping
    public ResponseEntity<ZombieDTO> createZombie(@RequestBody ZombieDTO zombieDTO) {
        ZombieDTO newZombie = zombieService.addZombie(zombieDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newZombie);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateZombie(@PathVariable int id, @RequestBody ZombieDTO zombieDTO) {
        return ResponseEntity.ok(zombieService.updateZombie(zombieDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteZombie(@PathVariable int id) {
        zombieService.deleteZombie(id);
        return ResponseEntity.ok("Zombie supprimée avec succès !");
    }
}

