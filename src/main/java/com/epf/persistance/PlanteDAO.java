package com.epf.persistance;
import com.epf.Model.Plantes;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlanteDAO extends DAO{
    public List<Plantes> getAllPlantes() {
        List<Plantes> plantes;
        plantes = jdbcTemplate.query("SELECT * FROM plante", (rs, rowNum) ->
                new Plantes(rs.getString("nom"), rs.getInt("point_de_vie"), rs.getFloat("attaque_par_seconde"), rs.getInt("degat_attaque"), rs.getInt("cout"), rs.getFloat("soleil_par_seconde"), rs.getString("effet"), rs.getString("chemin_image"))
        );
        return plantes;
    }

    public Plantes getPlanteById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM plante WHERE id = ?",
                new Object[]{id},
                (rs, rowNum) -> new Plantes(rs.getString("nom"), rs.getInt("point_de_vie"), rs.getFloat("attaque_par_seconde"), rs.getInt("degat_attaque"), rs.getInt("cout"), rs.getFloat("soleil_par_seconde"), rs.getString("effet"), rs.getString("chemin_image"))
        );
    }

}
