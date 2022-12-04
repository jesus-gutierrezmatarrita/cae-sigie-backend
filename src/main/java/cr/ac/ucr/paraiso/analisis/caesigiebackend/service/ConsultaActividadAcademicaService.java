package cr.ac.ucr.paraiso.analisis.caesigiebackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.ac.ucr.paraiso.analisis.caesigiebackend.repository.ConsultaActividadAcademicaRepository;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.entity.ConsultaActividadAcademica;

@Service
public class ConsultaActividadAcademicaService {
    @Autowired
    ConsultaActividadAcademicaRepository consultaRepository;

    public List<ConsultaActividadAcademica> obtenerConsulta() {
        return (List<ConsultaActividadAcademica>) this.consultaRepository.findAll();
    }

    public ConsultaActividadAcademica guardadConsulta(ConsultaActividadAcademica actividadAcademica) {
        return this.consultaRepository.save(actividadAcademica);
    }
    
}
