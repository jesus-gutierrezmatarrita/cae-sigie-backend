package cr.ac.ucr.paraiso.analisis.caesigiebackend.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class PersonaCoordinadora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPersonaCoordinadora;
    @Column(name = "nombre", unique = false, length = 50, nullable = false)
    private String nombre;
    @Column(name = "apellidos", unique = false, length = 50, nullable = false)
    private String apellidos;
    @Column(name = "correoElectronico", unique = true, length = 100, nullable = false)
    private String correoElectronico;
    @Column(name = "telefono", unique = false, nullable = false)
    private int telefono;
    @Column(name = "carnet", unique = false, length = 20, nullable = true)
    private String carnet;
    @Column(name = "contrasenna", unique = false, length = 20, nullable = false)
    private String contrasenna;

    // 5 - Una PersonaCoordinadora publica muchas consultas
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaCoordinadora", orphanRemoval = true)
    private List<ConsultaActividadAcademica> consultas;
}
