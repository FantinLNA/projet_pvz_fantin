package com.epf;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MapDAO extends DAO {
    public List<Maps> getAllMaps() {
        List<Maps> maps;
        maps = jdbcTemplate.query("SELECT * FROM map", (rs, rowNum) ->
                new Maps(rs.getInt("ligne"), rs.getInt("colonne"), rs.getString("chemin_image"))
        );
        return maps;
    }

    public Maps getMapByID(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM map WHERE id_map = ?",
                new Object[]{id},
                (rs, rowNum) -> new Maps(rs.getInt("ligne"), rs.getInt("colonne"), rs.getString("chemin_image"))
        );
    }

    public Maps getMapByZombieNom(String zombieNom) {
        // À implémenter : jointure sur la table zombie et map
        return new Maps(); // temporaire
    }
}

