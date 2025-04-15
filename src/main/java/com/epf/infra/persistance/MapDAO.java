package com.epf.infra.persistance;
import com.epf.core.Model.Maps;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MapDAO extends DAO implements interfaceMapDAO {
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

    @Override
    public Maps addMap(Maps map) {
        jdbcTemplate.update("INSERT INTO map(ligne, colonne, chemin_image) VALUES (?, ?, ?)",
                map.getLigne(),
                map.getColonne(),
                map.getChemin_image()
        );
        return map;
    }

    @Override
    public void updateMap(Maps map, int id) {
        jdbcTemplate.update("UPDATE map SET ligne = ?, colonne = ?, chemin_image = ? WHERE id_map = ?",
                map.getLigne(),
                map.getColonne(),
                map.getChemin_image(),
                id
        );
    }

    @Override
    public void deleteMap(int id) {
        jdbcTemplate.update("DELETE FROM map WHERE id_map = ?",
                id
        );
    }

}

