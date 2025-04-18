package com.epf.infra.persistance;
import com.epf.core.Model.Zombies;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ZombieDAO extends DAO implements interfaceZombieDAO{

    public List<Zombies> getAllZombies() {
        String sql = "SELECT id_zombie, nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image, id_map FROM Zombie";
        return jdbcTemplate.query(sql, new ZombieRowMapper());
    }

    @Override
    public Zombies getZombieById(int id) {
        String sql = "SELECT id_zombie, nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image, id_map FROM Zombie WHERE id_zombie = ?";
        List<Zombies> list = jdbcTemplate.query(sql, new ZombieRowMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

    private static class ZombieRowMapper implements RowMapper<Zombies> {
        @Override
        public Zombies mapRow(ResultSet rs, int rowNum) throws SQLException {
            Zombies zombies = new Zombies();
            zombies.setIdZombie(rs.getInt("id_zombie"));
            zombies.setNom(rs.getString("nom"));
            zombies.setPoint_de_vie(rs.getInt("point_de_vie"));
            zombies.setAttaque_par_seconde(rs.getDouble("attaque_par_seconde"));
            zombies.setDegat_attaque(rs.getInt("degat_attaque"));
            zombies.setVitesse_de_deplacement(rs.getDouble("vitesse_de_deplacement"));
            zombies.setChemin_image(rs.getString("chemin_image"));
            zombies.setId_map(rs.getInt("id_map"));
            return zombies;
        }
    }

    @Override
    public Zombies addZombie(Zombies zombie) {
        jdbcTemplate.update("INSERT INTO Zombie(nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image, id_map) VALUES (?, ?, ?, ?, ?, ?, ?)",
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
    public Zombies updateZombie(Zombies zombie, int id) {
        jdbcTemplate.update("UPDATE Zombie SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, vitesse_de_deplacement = ?, chemin_image = ?, id_map = ? WHERE id_zombie = ?",
                zombie.getNom(),
                zombie.getPoint_de_vie(),
                zombie.getAttaque_par_seconde(),
                zombie.getDegat_attaque(),
                zombie.getVitesse_de_deplacement(),
                zombie.getChemin_image(),
                zombie.getId_map(),
                id
        );
        return zombie;
    }

    @Override
    public void deleteZombie(int id) {
        jdbcTemplate.update("DELETE FROM Zombie WHERE id_zombie = ?",
                id
        );
    }

    @Override
    public List<Zombies> getZombiesByMap(int id) {
        String sql = "SELECT id_zombie, nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image, id_map FROM Zombie WHERE id_map = ?";
        return jdbcTemplate.query(sql, new Object[]{id}, new ZombieRowMapper());
    }

}
