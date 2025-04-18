package com.epf.infra.persistance;
import com.epf.core.Model.Maps;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MapDAO extends DAO implements interfaceMapDAO {

    @Override
    public List<Maps> getAllMaps() {
        String sql = "SELECT id_map, ligne, colonne, chemin_image FROM Map";
        return jdbcTemplate.query(sql, new MapRowMapper());
    }

    @Override
    public Maps getMapByID(int id) {
        String sql = "SELECT id_map, ligne, colonne, chemin_image FROM Map WHERE id_map = ?";
        List<Maps> maps = jdbcTemplate.query(sql, new MapRowMapper(), id);
        return maps.isEmpty() ? null : maps.get(0);
    }

    private static class MapRowMapper implements RowMapper<Maps> {
        @Override
        public Maps mapRow(ResultSet rs, int rowNum) throws SQLException {
            Maps map = new Maps();
            map.setIdMap(rs.getInt("id_map"));
            map.setLigne(rs.getInt("ligne"));
            map.setColonne(rs.getInt("colonne"));
            map.setChemin_image(rs.getString("chemin_image"));
            return map;
        }
    }


    @Override
    public Maps addMap(Maps map) {
        jdbcTemplate.update("INSERT INTO Map(ligne, colonne, chemin_image) VALUES (?, ?, ?)",
                map.getLigne(),
                map.getColonne(),
                map.getChemin_image()
        );
        return map;
    }

    @Override
    public Maps updateMap(Maps map, int id) {
        jdbcTemplate.update("UPDATE map SET ligne = ?, colonne = ?, chemin_image = ? WHERE id_map = ?",
                map.getLigne(),
                map.getColonne(),
                map.getChemin_image(),
                id
        );
        return map;
    }

    @Override
    public void deleteMap(int id) {
        jdbcTemplate.update("DELETE FROM map WHERE id_map = ?", id);
    }

}

