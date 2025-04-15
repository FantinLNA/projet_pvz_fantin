package com.epf.infra.persistance;
import com.epf.core.Model.Zombies;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ZombieDAO extends DAO implements interfaceZombieDAO{
    public List<Zombies> getAllZombies() {
        List<Zombies> zombies;
        zombies = jdbcTemplate.query("SELECT * FROM zombie", (rs, rowNum) ->
                new Zombies(rs.getString("nom"), rs.getInt("point_de_vie"), rs.getFloat("attaque_par_seconde"), rs.getInt("degat_attaque"), rs.getFloat("vitesse_de_deplacement"), rs.getString("chemin_image"), rs.getInt("id_map"))
        );
        return zombies;
    }

    @Override
    public Zombies getZombieById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM zombie WHERE id_zombie = ?",
                new Object[]{id},
                (rs, rowNum) -> new Zombies(rs.getString("nom"), rs.getInt("point_de_vie"), rs.getFloat("attaque_par_seconde"), rs.getInt("degat_attaque"), rs.getFloat("vitesse_de_deplacement"), rs.getString("chemin_image"), rs.getInt("id_map"))
        );
    }

    @Override
    public Zombies addZombie(Zombies zombie) {
        jdbcTemplate.update("INSERT INTO zombie(nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image, id_map) VALUES (?, ?, ?, ?, ?, ?, ?)",
                zombie.getNom(),
                zombie.getPoint_de_vie(),
                zombie.getAttaque_par_seconde(),
                zombie.getDegat_attaque(),
                zombie.getVitesse_de_deplacement(),
                zombie.getChemin_image(),
                zombie.getId_map()
        );
        return zombie;
    }

    @Override
    public void updateZombie(Zombies zombie, int id) {
        jdbcTemplate.update("UPDATE plante plante SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, vitesse_de_deplacement = ?, chemin_image = ?, id_map = ? WHERE id_map = ?",
                zombie.getNom(),
                zombie.getPoint_de_vie(),
                zombie.getAttaque_par_seconde(),
                zombie.getDegat_attaque(),
                zombie.getVitesse_de_deplacement(),
                zombie.getChemin_image(),
                zombie.getId_map(),
                id
        );
    }

    @Override
    public void deleteZombie(int id) {
        jdbcTemplate.update("DELETE FROM zombie WHERE id_zombie = ?",
                id
        );
    }

    @Override
    public List<Zombies> getZombiesByMap(int id) {
        List<Zombies> zombies;
        zombies = jdbcTemplate.query("SELECT * FROM zombie WHERE id_map = ?",new Object[]{id}, (rs, rowNum) ->
                new Zombies(rs.getString("nom"), rs.getInt("point_de_vie"), rs.getFloat("attaque_par_seconde"), rs.getInt("degat_attaque"), rs.getFloat("vitesse_de_deplacement"), rs.getString("chemin_image"), rs.getInt("id_map"))
        );
        return zombies;
    }
}
