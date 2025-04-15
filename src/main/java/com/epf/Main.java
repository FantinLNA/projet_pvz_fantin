package com.epf;

import com.epf.config.dbconfig;
import com.epf.core.Model.Zombies;
import com.epf.core.Model.Plantes;
import com.epf.core.Model.Maps;
import com.epf.infra.persistance.ZombieDAO;
import com.epf.infra.persistance.PlanteDAO;
import com.epf.infra.persistance.MapDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(dbconfig.class);

        // 🔹 Test MapDAO
        MapDAO mapDAO = context.getBean(MapDAO.class);

        System.out.println("\n--- ajout map ---");
        Maps newMap = new Maps();
        newMap.setLigne(7);
        newMap.setColonne(5);
        newMap.setChemin_image("chemin_test.png");

        // System.out.println("\n➡ Ajout d'une nouvelle map...");
        // mapDAO.addMap(newMap);


        System.out.println("\n--- Liste des maps ---");
        List<Maps> maps = mapDAO.getAllMaps();
        for (Maps map : maps) {
            System.out.println("ligne: " + map.getLigne() +
                    ", colonne: " + map.getColonne() +
                    ", chemin: " + map.getChemin_image());

        }

        System.out.println("\n--- Map avec ID 3 ---");
        Maps map1 = mapDAO.getMapByID(3);
        System.out.println("ligne: " + map1.getLigne() +
                ", colonne: " + map1.getColonne() +
                ", chemin: " + map1.getChemin_image());

        System.out.println("\n➡ Suppression de la map avec ID: 4" );
        mapDAO.deleteMap(13);


        // 🔹 Test ZombieDAO
        ZombieDAO zombieDAO = context.getBean(ZombieDAO.class);
        System.out.println("\n--- Liste des zombies ---");
        List<Zombies> zombies = zombieDAO.getAllZombies();
        for (Zombies zombie : zombies) {
            System.out.println("Nom : " + zombie.getNom() +
                    ", Point_de_vie" + zombie.getPoint_de_vie() +
                    ", Attaque_par_seconde" + zombie.getAttaque_par_seconde() +
                    ", Degat_attaque " + zombie.getDegat_attaque() +
                    ", Vitesse_de_deplacement " + zombie.getVitesse_de_deplacement() +
                    ", Chemin_image : " + zombie.getChemin_image() +
                    ", Id_map : " + zombie.getId_map());
        }

        System.out.println("\n--- Zombie avec ID 1 ---");
        Zombies zombie1 = zombieDAO.getZombieById(1);
        System.out.println("Nom : " + zombie1.getNom() +
                ", Point_de_vie" + zombie1.getPoint_de_vie() +
                ", Attaque_par_seconde" + zombie1.getAttaque_par_seconde() +
                ", Degat_attaque " + zombie1.getDegat_attaque() +
                ", Vitesse_de_deplacement " + zombie1.getVitesse_de_deplacement() +
                ", Chemin_image : " + zombie1.getChemin_image() +
                ", Id_map : " + zombie1.getId_map());

        System.out.println("\n--- Liste des zombies de la maps id 1---");
        List<Zombies> zombiesmap1 = zombieDAO.getZombiesByMap(1);
        for (Zombies zombie : zombiesmap1) {
            System.out.println("Nom : " + zombie.getNom() +
                    ", Point_de_vie" + zombie.getPoint_de_vie() +
                    ", Attaque_par_seconde" + zombie.getAttaque_par_seconde() +
                    ", Degat_attaque " + zombie.getDegat_attaque() +
                    ", Vitesse_de_deplacement " + zombie.getVitesse_de_deplacement() +
                    ", Chemin_image : " + zombie.getChemin_image() +
                    ", Id_map : " + zombie.getId_map());
        }

        // 🔹 Test PlanteDAO
        PlanteDAO planteDAO = context.getBean(PlanteDAO.class);
        System.out.println("\n--- Liste des plantes ---");
        List<Plantes> plantes = planteDAO.getAllPlantes();
        for (Plantes plante : plantes) {
            System.out.println("Nom : " + plante.getNom() +
                    ", Point_de_vie" + plante.getPoint_de_vie() +
                    ", Attaque_par_seconde" + plante.getAttaque_par_seconde() +
                    ", Degat_attaque " + plante.getDegat_attaque() +
                    ", soleil_par_seconde " + plante.getSoleil_par_seconde() +
                    ", effet : " + plante.getEffet() +
                    ", Chemin_image : " + plante.getChemin_image());
        }

        System.out.println("\n--- Plante avec ID 1 ---");
        Plantes plante1 = planteDAO.getPlanteById(1);
        System.out.println("Nom : " + plante1.getNom() +
                ", Point_de_vie" + plante1.getPoint_de_vie() +
                ", Attaque_par_seconde" + plante1.getAttaque_par_seconde() +
                ", Degat_attaque " + plante1.getDegat_attaque() +
                ", soleil_par_seconde " + plante1.getSoleil_par_seconde() +
                ", effet : " + plante1.getEffet() +
                ", Chemin_image : " + plante1.getChemin_image());

        context.close();
    }
}
