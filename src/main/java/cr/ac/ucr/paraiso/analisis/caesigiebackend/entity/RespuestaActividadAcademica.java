package cr.ac.ucr.paraiso.analisis.caesigiebackend.entity;

import jakarta.persistence.*;

@Entity
public class RespuestaActividadAcademica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRespuesta;
    @Column(name = "observacion", unique = false, length = 50, nullable = false)
    private String observacion;
    @Column(name = "confirmacionInteres", unique = false, nullable = false)
    private boolean confirmacionInteres;

    // 2 - Respuestas vienen de una persona 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPersonaGraduada")
    private PersonaGraduada personaGraduada;

    // 3 - Respuestas para una actividad academica
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idConsultaActividadAcademica")
    private ConsultaActividadAcademica actividadAcademica;
}
