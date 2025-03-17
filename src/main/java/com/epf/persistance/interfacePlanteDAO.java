package com.epf.persistance;

import com.epf.core.Model.Plantes;
import java.util.List;

public interface interfacePlanteDAO {
    List<Plantes> getAllPlantes();
    Plantes getPlanteById(int id);
    void addPlante(Plantes plante);
    void updatePlante(Plantes plante, int id);
    void deletePlante(int id);
}
