package cr.ac.ucr.paraiso.analisis.caesigiebackend.repository;


import cr.ac.ucr.paraiso.analisis.caesigiebackend.entity.PersonaCoordinadora;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaCoordinadoraRepository extends CrudRepository<PersonaCoordinadora, Integer> {

    @Query(value="SELECT u FROM PersonaCoordinadora u WHERE u.correoElectronico = :email")
     PersonaCoordinadora findPersonaByEmail(@Param("email")String email);

}
