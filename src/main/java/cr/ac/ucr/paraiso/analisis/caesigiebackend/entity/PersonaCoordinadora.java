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

    public PersonaCoordinadora() {
    }

    public PersonaCoordinadora(int idPersonaCoordinadora, String nombre, String apellidos, String correoElectronico, int telefono, String carnet, String contrasenna, List<ConsultaActividadAcademica> consultas) {
        this.idPersonaCoordinadora = idPersonaCoordinadora;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.carnet = carnet;
        this.contrasenna = contrasenna;
        this.consultas = consultas;
    }

    public int getIdPersonaCoordinadora() {
        return idPersonaCoordinadora;
    }

    public void setIdPersonaCoordinadora(int idPersonaCoordinadora) {
        this.idPersonaCoordinadora = idPersonaCoordinadora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }


}
