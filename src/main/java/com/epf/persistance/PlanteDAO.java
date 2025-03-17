package com.epf.persistance;
import com.epf.core.Model.Plantes;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlanteDAO extends DAO implements interfacePlanteDAO {

    @Override
    public List<Plantes> getAllPlantes() {
        List<Plantes> plantes;
        plantes = jdbcTemplate.query("SELECT * FROM plante", (rs, rowNum) ->
                new Plantes(rs.getString("nom"), rs.getInt("point_de_vie"), rs.getFloat("attaque_par_seconde"), rs.getInt("degat_attaque"), rs.getInt("cout"), rs.getFloat("soleil_par_seconde"), rs.getString("effet"), rs.getString("chemin_image"))
        );
        return plantes;
    }

    @Override
    public Plantes getPlanteById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM plante WHERE id_plante = ?",
                new Object[]{id},
                (rs, rowNum) -> new Plantes(rs.getString("nom"), rs.getInt("point_de_vie"), rs.getFloat("attaque_par_seconde"), rs.getInt("degat_attaque"), rs.getInt("cout"), rs.getFloat("soleil_par_seconde"), rs.getString("effet"), rs.getString("chemin_image"))
        );
    }

    @Override
    public void addPlante(Plantes plante) {
        jdbcTemplate.update("INSERT INTO plante(nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                plante.getNom(),
                plante.getPoint_de_vie(),
                plante.getAttaque_par_seconde(),
                plante.getDegat_attaque(),
                plante.getCout(),
                plante.getSoleil_par_seconde(),
                plante.getEffet(),
                plante.getChemin_image()
        );
    }

    @Override
    public void updatePlante(Plantes plante, int id) {
        jdbcTemplate.update("UPDATE plante plante SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, cout = ?, soleil_par_seconde = ?, effet = ?, chemin_image = ? WHERE id_plante = ?",
                plante.getNom(),
                plante.getPoint_de_vie(),
                plante.getAttaque_par_seconde(),
                plante.getDegat_attaque(),
                plante.getCout(),
                plante.getSoleil_par_seconde(),
                plante.getEffet(),
                plante.getChemin_image(),
                id
        );
    }

    @Override
    public void deletePlante(int id) {
        jdbcTemplate.update("DELETE FROM plante WHERE id_plante = ?",
                id
        );
    }


}
