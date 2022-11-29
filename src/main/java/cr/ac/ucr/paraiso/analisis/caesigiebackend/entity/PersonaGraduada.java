package cr.ac.ucr.paraiso.analisis.caesigiebackend.entity;

import java.util.ArrayList;

import jakarta.persistence.*;

@Entity
public class PersonaGraduada {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPersonaGraduada;

    @Column(name = "nombre", unique = false, length = 50, nullable = false)
    private String nombre;

    @Column(name = "apellidos", unique = false, length = 50, nullable = false)
    private String apellidos;

    @Column(name = "correoElectronico", unique = true, length = 100, nullable = false)
    private String correoElectronico;

    @Column(name = "telefono", unique = false, nullable = false)
    private int telefono;
    
    @Column(name = "carnet", unique = true, length = 20, nullable = false)
    private String carnet;

    // 1 - Una PersonaGraduada tiene muchos itemnesGraduacion
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona", orphanRemoval = true)
    private ArrayList<ItemGraduacion> itemnesGraduacion;

    // 2 - Una persona tiene muchas respuestas
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaGraduada", orphanRemoval = true)
    private ArrayList<RespuestaActividadAcademica> respuestas;

    // 7 - Muchas personas se graduan en un recinto
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idRecinto")
    private Recinto recintoDeGraduado;

}
