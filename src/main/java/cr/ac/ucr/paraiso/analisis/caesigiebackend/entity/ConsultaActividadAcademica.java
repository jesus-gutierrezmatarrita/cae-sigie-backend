package cr.ac.ucr.paraiso.analisis.caesigiebackend.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

import jakarta.persistence.*;

@Entity
public class ConsultaActividadAcademica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "titulo", unique = false, length = 100, nullable = false)
    private String titulo;
    @Column(name = "descripcion", unique = false, length = 200, nullable = false)
    private String descripcion;
    @Column(name = "fecha1RealizacionDeActividad", unique = false, nullable = false)
    private LocalDateTime fecha1RealizacionDeActividad;
    @Column(name = "fecha2RealizacionDeActividad", unique = false, nullable = false)
    private LocalDateTime fecha2RealizacionDeActividad;
    @Column(name = "modalidad", unique = false, length = 50, nullable = false)
    private String modalidad;
    @Column(name = "lugarActividad", unique = false, length = 50, nullable = false)
    private String lugarActividad;
    
    // 3 - Una ConsultaActividadAcademica tiene muchas respuestas 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actividadAcademica", orphanRemoval = true)
    private ArrayList<RespuestaActividadAcademica> respuestas;

    // 4 - Las ConsultaActividadAcademica tienen un TipoDeActividad
    @ManyToOne
    @JoinColumn(name = "idTipo")
    private TipoDeActividad tipoDeActividad;

    // 5 - Las ConsultaActividadAcademica son publicadas por una PersonaCoordinadora
    @ManyToOne
    @JoinColumn(name = "idPersonaCoordinadora")
    private PersonaCoordinadora personaCoordinadora;

    // 6 - 
    
}
