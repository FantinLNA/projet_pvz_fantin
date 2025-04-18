package com.epf.infra.persistance;
import com.epf.core.Model.Plantes;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PlanteDAO extends DAO implements interfacePlanteDAO {

    @Override
    public List<Plantes> getAllPlantes() {
        String sql = "SELECT id_plante, nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image FROM Plante";
        return jdbcTemplate.query(sql, new PlanteRowMapper());
    }

    @Override
    public Plantes getPlanteById(int id) {
        String sql = "SELECT id_plante, nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image FROM Plante WHERE id_plante = ?";
        List<Plantes> plantes = jdbcTemplate.query(sql, new PlanteRowMapper(), id);
        return plantes.isEmpty() ? null : plantes.get(0);
    }

    private static class PlanteRowMapper implements RowMapper<Plantes> {
        @Override
        public Plantes mapRow(ResultSet rs, int rowNum) throws SQLException {
            Plantes plante = new Plantes();
            plante.setId_plante(rs.getInt("id_plante"));
            plante.setNom(rs.getString("nom"));
            plante.setPoint_de_vie(rs.getInt("point_de_vie"));
            plante.setAttaque_par_seconde(rs.getDouble("attaque_par_seconde"));
            plante.setDegat_attaque(rs.getInt("degat_attaque"));
            plante.setCout(rs.getInt("cout"));
            plante.setSoleil_par_seconde(rs.getDouble("soleil_par_seconde"));
            plante.setEffet(rs.getString("effet"));
            plante.setChemin_image(rs.getString("chemin_image"));
            return plante;
        }
    }

    @Override
    public Plantes addPlante(Plantes plante) {
        jdbcTemplate.update("INSERT INTO Plante(nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                plante.getNom(),
                plante.getPoint_de_vie(),
                plante.getAttaque_par_seconde(),
                plante.getDegat_attaque(),
                plante.getCout(),
                plante.getSoleil_par_seconde(),
                plante.getEffet(),
                plante.getChemin_image()
        );
        return plante;
    }

    @Override
    public Plantes updatePlante(Plantes plante, int id) {
        jdbcTemplate.update("UPDATE plante SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, cout = ?, soleil_par_seconde = ?, effet = ?, chemin_image = ? WHERE id_plante = ?",
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
        return plante;
    }

    @Override
    public void deletePlante(int id) {
        jdbcTemplate.update("DELETE FROM plante WHERE id_plante = ?", id);
    }


}
