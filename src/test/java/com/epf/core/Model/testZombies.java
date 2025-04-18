package com.epf.core.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testZombies {

    @Test
    public void should_create_zombie_with_constructor() {
        Zombies zombie = new Zombies(100, "zombie du futur", 200, 0.75, 9, 0.45, "futurzombie.png", 1);

        assertEquals(100, zombie.getIdZombie());
        assertEquals("zombie du futur", zombie.getNom());
        assertEquals(200, zombie.getPoint_de_vie());
        assertEquals(0.75, zombie.getAttaque_par_seconde());
        assertEquals(9, zombie.getDegat_attaque());
        assertEquals(0.45, zombie.getVitesse_de_deplacement());
        assertEquals("futurzombie.png", zombie.getChemin_image());
        assertEquals(1, zombie.getId_map());

    }

    @Test
    public void should_set_and_get_zombie_values_correctly() {
        Zombies zombie = new Zombies();

        zombie.setNom("zombie du futur");
        zombie.setPoint_de_vie(200);
        zombie.setAttaque_par_seconde(0.75);
        zombie.setDegat_attaque(9);
        zombie.setVitesse_de_deplacement(0.45);
        zombie.setChemin_image("futurzombie.png");
        zombie.setId_map(1);

        assertEquals("zombie du futur", zombie.getNom());
        assertEquals(200, zombie.getPoint_de_vie());
        assertEquals(0.75, zombie.getAttaque_par_seconde());
        assertEquals(9, zombie.getDegat_attaque());
        assertEquals(0.45, zombie.getVitesse_de_deplacement());
        assertEquals("futurzombie.png", zombie.getChemin_image());
        assertEquals(1, zombie.getId_map());
    }
}

