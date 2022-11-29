package cr.ac.ucr.paraiso.analisis.caesigiebackend.entity;

import java.util.ArrayList;

import jakarta.persistence.*;

@Entity
public class Recinto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecinto;
    @Column(name = "codigoRecinto", unique = false, length = 50, nullable = false)
    private String codigoRecinto;
    @Column(name = "nombre", unique = true, length = 50, nullable = false)
    private String nombre;
    @Column(name = "contacto", unique = false, nullable = false)
    private int contacto;
    @Column(name = "provincia", unique = false, length = 50, nullable = false)
    private String provincia;
    @Column(name = "canton", unique = false, length = 50, nullable = false)
    private String canton;
    @Column(name = "distrito", unique = false, length = 50, nullable = false)
    private String distrito;
    @Column(name = "direccion", unique = false, length = 100, nullable = false)
    private String direccion;

    // 6 - Many to many
    @ManyToMany
    @JoinTable(name = "recinto_consulta", joinColumns = @JoinColumn(name = "idRecinto"), 
    inverseJoinColumns = @JoinColumn(name = "idConsultaActividadAcademica"))
    private ArrayList<ConsultaActividadAcademica> consultas;

    // 7 - En un recinto se graduaron muchas PersonasGraduadas
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recintoDeGraduado", orphanRemoval = true)
    private ArrayList<PersonaGraduada> personasGraduadas;
}
