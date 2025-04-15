package com.epf.infra.persistance;

import com.epf.core.Model.Plantes;
import java.util.List;

public interface interfacePlanteDAO {
    List<Plantes> getAllPlantes();
    Plantes getPlanteById(int id);
    Plantes addPlante(Plantes plante);
    Plantes updatePlante(Plantes plante, int id);
    void deletePlante(int id);
}
