package com.epf;


import com.epf.Model.Plantes;
import com.epf.persistance.MapDAO;
import com.epf.Model.Maps;
import com.epf.persistance.PlanteDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class TestMapDAOApp {

    public static void main(String[] args) {
        // Charger le contexte Spring
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(com.epf.persistance.dbconfig.class);

        // Récupérer ton DAO depuis Spring
        MapDAO mapDAO = context.getBean(MapDAO.class);

        // Tester la méthode getMapByID
        Maps map = mapDAO.getMapByID(1); // ← change le 1 si tu veux un autre ID

        // Affichage pour vérification
        System.out.println("Ligne: " + map.getLigne());
        System.out.println("Colonne: " + map.getColonne());
        System.out.println("Chemin: " + map.getChemin_image());

        // Fermer le contexte Spring
        context.close();
    }
}