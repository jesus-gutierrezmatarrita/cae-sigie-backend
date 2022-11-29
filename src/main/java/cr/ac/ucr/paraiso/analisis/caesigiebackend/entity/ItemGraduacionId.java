package cr.ac.ucr.paraiso.analisis.caesigiebackend.entity;


import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;

@Embeddable
public class ItemGraduacionId implements Serializable{


    @Column(name = "idPersonaGraduada")
    private int idPersonaGraduada;

    @Column(name = "idPlanEstudio")
    private int idPlanEstudio;

    public int getIdPersonaGraduada() {
        return idPersonaGraduada;
    }

    public void setIdPersonaGraduada(int idPersonaGraduada) {
        this.idPersonaGraduada = idPersonaGraduada;
    }

    public int getIdPlanEstudio() {
        return idPlanEstudio;
    }

    public void setIdPlanEstudio(int idPlanEstudio) {
        this.idPlanEstudio = idPlanEstudio;
    }

    public ItemGraduacionId(
        int idPersonaGraduada,
        int idPlanEstudio
    ) {
        this.idPersonaGraduada = idPersonaGraduada;
        this.idPlanEstudio = idPlanEstudio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
            ItemGraduacionId itemGraduacionId = (ItemGraduacionId) o;
        return Objects.equals(idPersonaGraduada, itemGraduacionId.idPersonaGraduada) &&
               Objects.equals(idPlanEstudio, itemGraduacionId.idPlanEstudio);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(idPersonaGraduada, idPlanEstudio);
    }

}
