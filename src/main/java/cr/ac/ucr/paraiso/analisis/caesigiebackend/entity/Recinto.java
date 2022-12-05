package cr.ac.ucr.paraiso.analisis.caesigiebackend.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Recinto {

    public Recinto() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecinto;
    @Column(name = "codigoRecinto", unique = false, length = 50, nullable = false)
    private String codigoRecinto;
    @Column(name = "nombre", unique = false, length = 50, nullable = false)
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

    public int getIdRecinto() {
        return idRecinto;
    }

    public void setIdRecinto(int idRecinto) {
        this.idRecinto = idRecinto;
    }

    public String getCodigoRecinto() {
        return codigoRecinto;
    }

    public void setCodigoRecinto(String codigoRecinto) {
        this.codigoRecinto = codigoRecinto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // 6 - Many to many
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "recinto_consulta", joinColumns = @JoinColumn(name = "idRecinto"), inverseJoinColumns = @JoinColumn(name = "idConsultaActividadAcademica"))
    private List<ConsultaActividadAcademica> consultas;

    public List<ConsultaActividadAcademica> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<ConsultaActividadAcademica> consultas) {
        this.consultas = consultas;
    }

    // 7 - En un recinto se graduaron muchas PersonasGraduadas
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recintoDeGraduado", orphanRemoval = true)
    private List<PersonaGraduada> personasGraduadas;

    public List<PersonaGraduada> getPersonasGraduadas() {
        return personasGraduadas;
    }

    public void setPersonasGraduadas(List<PersonaGraduada> personasGraduadas) {
        this.personasGraduadas = personasGraduadas;
    }

    public Recinto(int idRecinto, String codigoRecinto, String nombre, int contacto, String provincia, String canton,
            String distrito, String direccion, List<ConsultaActividadAcademica> consultas,
            List<PersonaGraduada> personasGraduadas) {
        this.idRecinto = idRecinto;
        this.codigoRecinto = codigoRecinto;
        this.nombre = nombre;
        this.contacto = contacto;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.direccion = direccion;
        this.consultas = consultas;
        this.personasGraduadas = personasGraduadas;
    }

}
