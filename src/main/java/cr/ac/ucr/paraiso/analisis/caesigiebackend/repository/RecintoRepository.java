package cr.ac.ucr.paraiso.analisis.caesigiebackend.repository;

import org.springframework.data.repository.CrudRepository;

import cr.ac.ucr.paraiso.analisis.caesigiebackend.entity.Recinto;
import org.springframework.stereotype.Repository;

@Repository
public interface RecintoRepository extends CrudRepository<Recinto, Integer> {}
