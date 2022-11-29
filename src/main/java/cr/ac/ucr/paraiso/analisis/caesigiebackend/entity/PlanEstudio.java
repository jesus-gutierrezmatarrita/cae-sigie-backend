package cr.ac.ucr.paraiso.analisis.caesigiebackend.entity;

import java.util.ArrayList;

import jakarta.persistence.*;

@Entity
public class PlanEstudio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlanEstudio;
    @Column(name = "codCarrera", unique = false, length = 50, nullable = false)
    private String codCarrera;
    @Column(name = "nombreCarrera", unique = false, length = 50, nullable = false)
    private String nombreCarrera;
    @Column(name = "annoAprobacion", unique = false, nullable = false)
    private int annoAprobacion;

    // 1.2 - Un PlanEstudio tiene muchos ItemGraduacion
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planEstudio", orphanRemoval = true)
    private ArrayList<ItemGraduacion> itemnesGraduacion;
}
