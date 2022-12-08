package cr.ac.ucr.paraiso.analisis.caesigiebackend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import cr.ac.ucr.paraiso.analisis.caesigiebackend.entity.PersonaCoordinadora;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.repository.PersonaCoordinadoraRepository;

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

    /**
     * Si le damos un registro, la respuesta no debería ser nula
     */
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

}