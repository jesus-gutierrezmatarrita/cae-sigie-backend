package cr.ac.ucr.paraiso.analisis.caesigiebackend.entity;

import jakarta.persistence.*;

@Entity
public class ItemGraduacion {
    
    @EmbeddedId
    private ItemGraduacionId idItemGraduacion;

    @Column(name = "annoGraduacion", unique = false, nullable = false)
    private int annoGraduacion;

    // 1 - Muchos itemnesGraduacion son de una PersonaGraduada
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idPersonaGraduada")
    private PersonaGraduada persona;

    // 1.2 - Muchos itemnesGraduacion son de un PlanEstudio
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idPlanEstudio")
    private PlanEstudio planEstudio;

}
