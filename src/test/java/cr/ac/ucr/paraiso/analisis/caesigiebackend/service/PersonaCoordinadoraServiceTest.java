package cr.ac.ucr.paraiso.analisis.caesigiebackend.service;

import cr.ac.ucr.paraiso.analisis.caesigiebackend.entity.PersonaCoordinadora;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.entity.Recinto;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.repository.PersonaCoordinadoraRepository;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.repository.RecintoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PersonaCoordinadoraServiceTest {


    @Mock
    private PersonaCoordinadoraRepository repository;

    @InjectMocks
    private PersonaCoordinadoraService service;

    private PersonaCoordinadora personaCoordinadora;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        personaCoordinadora=new PersonaCoordinadora();
        personaCoordinadora.setNombre("John");
        personaCoordinadora.setApellidos("Doe");
    }

    @Test
    void obtenerPersonasCoordinadoras_DatosSonValidados_IsNotNull() {
        // Act
        when(repository.findAll()).thenReturn(Arrays.asList(personaCoordinadora));

        // Assert
        assertNotNull(service.obtenerPersonasCoordinadoras());
    }

    @Test
    void guardarPersonaCoordinadora_InsercionEsCorrecta_PersonaCoordinadora() {
        // Act
        when(repository.save(personaCoordinadora)).thenReturn(personaCoordinadora);

        // Assert
        assertEquals("John", personaCoordinadora.getNombre());
    }

    @Test
    void findPersonaByEmail() {

    }
}