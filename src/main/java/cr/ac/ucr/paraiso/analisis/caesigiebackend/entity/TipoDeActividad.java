package cr.ac.ucr.paraiso.analisis.caesigiebackend.entity;

import jakarta.persistence.*;

@Entity
public class TipoDeActividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipo;
    @Column(name = "nombreTipo", unique = false, length = 50, nullable = false)
    private String nombreTipo;

    public int getIdTipo() {
        return idTipo;
    }
    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }
    public String getNombreTipo() {
        return nombreTipo;
    }
    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }
    @Override
    public String toString() {
        return "TipoDeActividad [idTipo=" + idTipo + ", nombreTipo=" + nombreTipo + "]";
    }

    public TipoDeActividad() {
    }

    public TipoDeActividad(int idTipo, String nombreTipo) {
        this.idTipo = idTipo;
        this.nombreTipo = nombreTipo;
    }
}
