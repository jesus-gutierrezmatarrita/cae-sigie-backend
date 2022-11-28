package cr.ac.ucr.paraiso.analisis.caesigiebackend.entity;

import jakarta.persistence.*;

@Entity
public class TipoDeActividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipo;
    @Column(name = "nombreTipo", unique = false, length = 50, nullable = false)
    private String nombreTipo;
}
