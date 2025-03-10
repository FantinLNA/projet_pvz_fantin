package com.epf.persistance;
import com.epf.Model.Plantes;
import com.epf.Model.Zombies;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ZombieDAO extends DAO{
    public List<Zombies> getAllZombies() {
        List<Zombies> zombies;
        zombies = jdbcTemplate.query("SELECT * FROM zombie", (rs, rowNum) ->
                new Zombies(rs.getString("nom"), rs.getInt("point_de_vie"), rs.getFloat("attaque_par_seconde"), rs.getInt("degat_attaque"), rs.getFloat("vitesse_de_deplacement"), rs.getString("chemin_image"), rs.getInt("id_map"))
        );
        return zombies;
    }

    public Zombies getZombieById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM zombie WHERE id = ?",
                new Object[]{id},
                (rs, rowNum) -> new Zombies(rs.getString("nom"), rs.getInt("point_de_vie"), rs.getFloat("attaque_par_seconde"), rs.getInt("degat_attaque"), rs.getFloat("vitesse_de_deplacement"), rs.getString("chemin_image"), rs.getInt("id_map"))
        );
    }
}
