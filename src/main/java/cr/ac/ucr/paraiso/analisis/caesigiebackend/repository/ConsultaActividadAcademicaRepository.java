package cr.ac.ucr.paraiso.analisis.caesigiebackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cr.ac.ucr.paraiso.analisis.caesigiebackend.entity.ConsultaActividadAcademica;

@Repository
public interface ConsultaActividadAcademicaRepository extends CrudRepository<ConsultaActividadAcademica, Integer>{}
