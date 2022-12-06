package cr.ac.ucr.paraiso.analisis.caesigiebackend.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class ConsultaActividadAcademica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idConsultaActividadAcademica;
    @Column(name = "titulo", unique = false, length = 100, nullable = false)
    private String titulo;
    @Column(name = "descripcion", unique = false, length = 200, nullable = false)
    private String descripcion;
    @Column(name = "fecha1RealizacionDeActividad", unique = false, nullable = false)
    private LocalDateTime fecha1RealizacionDeActividad;
    @Column(name = "fecha2RealizacionDeActividad", unique = false, nullable = false)
    private LocalDateTime fecha2RealizacionDeActividad;
    @Column(name = "fechaInicio", unique = false, nullable = false)
    private LocalDateTime fechaInicio;
    @Column(name = "fechaFin", unique = false, nullable = false)
    private LocalDateTime fechaFin;
    @Column(name = "modalidad", unique = false, length = 50, nullable = false)
    private String modalidad;
    @Column(name = "lugarActividad", unique = false, length = 50, nullable = false)
    private String lugarActividad;

    /* 
    public ConsultaActividadAcademica(int idConsultaActividadAcademica, String titulo, String descripcion,
            LocalDateTime fecha1RealizacionDeActividad, LocalDateTime fecha2RealizacionDeActividad,
            LocalDateTime fechaInicio, LocalDateTime fechaFin, String modalidad, String lugarActividad) {
        this.idConsultaActividadAcademica = idConsultaActividadAcademica;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha1RealizacionDeActividad = fecha1RealizacionDeActividad;
        this.fecha2RealizacionDeActividad = fecha2RealizacionDeActividad;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.modalidad = modalidad;
        this.lugarActividad = lugarActividad;
    }*/

    public int getIdConsultaActividadAcademica() {
        return idConsultaActividadAcademica;
    }

    public void setIdConsultaActividadAcademica(int idConsultaActividadAcademica) {
        this.idConsultaActividadAcademica = idConsultaActividadAcademica;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFecha1RealizacionDeActividad() {
        return fecha1RealizacionDeActividad;
    }

    public void setFecha1RealizacionDeActividad(LocalDateTime fecha1RealizacionDeActividad) {
        this.fecha1RealizacionDeActividad = fecha1RealizacionDeActividad;
    }

    public LocalDateTime getFecha2RealizacionDeActividad() {
        return fecha2RealizacionDeActividad;
    }

    public void setFecha2RealizacionDeActividad(LocalDateTime fecha2RealizacionDeActividad) {
        this.fecha2RealizacionDeActividad = fecha2RealizacionDeActividad;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getLugarActividad() {
        return lugarActividad;
    }

    public void setLugarActividad(String lugarActividad) {
        this.lugarActividad = lugarActividad;
    }

    // 3 - Una ConsultaActividadAcademica tiene muchas respuestas
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actividadAcademica", orphanRemoval = true)
    private List<RespuestaActividadAcademica> respuestas;

    // 4 - Las ConsultaActividadAcademica tienen un TipoDeActividad
    @ManyToOne
    @JoinColumn(name = "idTipo")
    private TipoDeActividad tipoDeActividad;

    // 5 - Las ConsultaActividadAcademica son publicadas por una PersonaCoordinadora
    @ManyToOne
    @JoinColumn(name = "idPersonaCoordinadora")
    private PersonaCoordinadora personaCoordinadora;

    // 6 - Many to many
    @ManyToMany
    private List<Recinto> recintos;

}
