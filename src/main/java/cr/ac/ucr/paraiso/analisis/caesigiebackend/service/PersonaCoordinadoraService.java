package cr.ac.ucr.paraiso.analisis.caesigiebackend.service;

import cr.ac.ucr.paraiso.analisis.caesigiebackend.entity.PersonaCoordinadora;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.entity.Recinto;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.repository.PersonaCoordinadoraRepository;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.repository.RecintoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaCoordinadoraService {

    @Autowired
    PersonaCoordinadoraRepository personaCoordinadoraRepository;

    public List<PersonaCoordinadora> obtenerPersonasCoordinadoras() {
        return (List<PersonaCoordinadora>) this.personaCoordinadoraRepository.findAll();
    }

    public PersonaCoordinadora guardarPersonaCoordinadora(PersonaCoordinadora personaCoordinadora) {
        return this.personaCoordinadoraRepository.save(personaCoordinadora);
    }

    public PersonaCoordinadora findPersonaByEmail(String email){ return  this.personaCoordinadoraRepository.findPersonaByEmail(email);}

}
