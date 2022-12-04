package cr.ac.ucr.paraiso.analisis.caesigiebackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cr.ac.ucr.paraiso.analisis.caesigiebackend.entity.TipoDeActividad;

@Repository
public interface TipoActividadRepository extends CrudRepository<TipoDeActividad, Integer>{}
