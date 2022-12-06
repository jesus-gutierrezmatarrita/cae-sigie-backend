package cr.ac.ucr.paraiso.analisis.caesigiebackend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.entity.ConsultaActividadAcademica;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.repository.ConsultaActividadAcademicaRepository;

/**
 * AAA Arrange - Act - Assert
 */

public class ConsultaActividadAcademicaServiceTest {

    @Mock
    private ConsultaActividadAcademicaRepository repository;

    @InjectMocks
    private ConsultaActividadAcademicaService service;

    private ConsultaActividadAcademica consulta;

    @BeforeEach
    void setUp() {
        // Arrange
        MockitoAnnotations.initMocks(this);

        consulta = new ConsultaActividadAcademica();
        consulta.setTitulo("Consulta test");
        consulta.setDescripcion("Esta es una consulta de prueba");

    }

    /**
     * If we give it a record, the response must not be null
     */
    @Test
    void findAll() {
        // Act
        when(repository.findAll()).thenReturn(Arrays.asList(consulta));

        // Assert
        assertNotNull(service.obtenerConsultas());
    }

    /**
     * If we give it three records, the size of response must be three
     */
    @Test
    void validSize(){
        // Act
        when(repository.findAll()).thenReturn(Arrays.asList(
            new ConsultaActividadAcademica(),
            new ConsultaActividadAcademica(),
            new ConsultaActividadAcademica(),
            new ConsultaActividadAcademica(),
            new ConsultaActividadAcademica()));
        List<ConsultaActividadAcademica> allCountries = service.obtenerConsultas();

        // Assert
        assertEquals(5, allCountries.size());
    }

}

