package com.epf.core.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class testMaps {

    @Test
    public void should_create_Map_with_constructor() {
        Maps map = new Maps(7, 5, "gazon.png");

        assertEquals(7, map.getLigne());
        assertEquals(5, map.getColonne());
        assertEquals("gazon.png", map.getChemin_image());
    }

    @Test
    public void should_set_and_get_map_values_correctly() {
        Maps map = new Maps();

        map.setLigne(7);
        map.setColonne(5);
        map.setChemin_image("gazon.png");

        assertEquals(7, map.getLigne());
        assertEquals(5, map.getColonne());
        assertEquals("gazon.png", map.getChemin_image());
    }
}
