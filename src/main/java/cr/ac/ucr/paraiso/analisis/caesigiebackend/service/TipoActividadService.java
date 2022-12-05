package cr.ac.ucr.paraiso.analisis.caesigiebackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.ac.ucr.paraiso.analisis.caesigiebackend.entity.TipoDeActividad;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.repository.TipoActividadRepository;

@Service
public class TipoActividadService {
    @Autowired
    TipoActividadRepository tipoActividadRepository;

    public List<TipoDeActividad> obtenerTipoDeActividades() {
        return (List<TipoDeActividad>) this.tipoActividadRepository.findAll();
    }

    public TipoDeActividad guardarTipoDeActividad(TipoDeActividad tipoDeActividad) {
        return this.tipoActividadRepository.save(tipoDeActividad);
    }
}
