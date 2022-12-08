package cr.ac.ucr.paraiso.analisis.caesigiebackend.controller;

import cr.ac.ucr.paraiso.analisis.caesigiebackend.entity.PersonaCoordinadora;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.entity.Recinto;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.service.PersonaCoordinadoraService;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.service.RecintoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/personacoordinadora")
public class PersonaCoordinadoraController {

    @Autowired
    PersonaCoordinadoraService personaCoordinadoraService;

    @GetMapping
    public List<PersonaCoordinadora> obtenerPersonasCoordinadoras() {
        return this.personaCoordinadoraService.obtenerPersonasCoordinadoras();
    }

    @PostMapping
    public PersonaCoordinadora guardarRecinto(@RequestBody PersonaCoordinadora personaCoordinadora) {
        return this.personaCoordinadoraService.guardarPersonaCoordinadora(personaCoordinadora);
    }

    @GetMapping("/{email}")
    public ResponseEntity<PersonaCoordinadora> findPersonaByEmail(@PathVariable String email) {
        try {
            PersonaCoordinadora personaCoordinadora = this.personaCoordinadoraService.findPersonaByEmail(email);
            return new ResponseEntity<PersonaCoordinadora>(personaCoordinadora, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<PersonaCoordinadora>(HttpStatus.NOT_FOUND);
        }

    }


}
