package com.epf.core.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class testPlantes {

    @Test
    public void should_create_plante_with_constructor() {
        Plantes plante = new Plantes(100,"Tournesol", 100, 0.0, 0, 50, 25.0, "produit du soleil", "tournesol.png");

        assertEquals(100, plante.getIdPlante());
        assertEquals("Tournesol", plante.getNom());
        assertEquals(100, plante.getPoint_de_vie());
        assertEquals(0.0, plante.getAttaque_par_seconde());
        assertEquals(0, plante.getDegat_attaque());
        assertEquals(50, plante.getCout());
        assertEquals(25.0, plante.getSoleil_par_seconde());
        assertEquals("produit du soleil", plante.getEffet());
        assertEquals("tournesol.png", plante.getChemin_image());
    }

    @Test
    public void should_set_and_get_plante_values_correctly() {
        Plantes plante = new Plantes();

        plante.setNom("Pisto-pois");
        plante.setPoint_de_vie(150);
        plante.setAttaque_par_seconde(1.5);
        plante.setDegat_attaque(20);
        plante.setCout(100);
        plante.setSoleil_par_seconde(0.0);
        plante.setEffet("tire des pois");
        plante.setChemin_image("pisto-pois.png");

        assertEquals("Pisto-pois", plante.getNom());
        assertEquals(150, plante.getPoint_de_vie());
        assertEquals(1.5f, plante.getAttaque_par_seconde());
        assertEquals(20, plante.getDegat_attaque());
        assertEquals(100, plante.getCout());
        assertEquals(0.0f, plante.getSoleil_par_seconde());
        assertEquals("tire des pois", plante.getEffet());
        assertEquals("pisto-pois.png", plante.getChemin_image());
    }
}
