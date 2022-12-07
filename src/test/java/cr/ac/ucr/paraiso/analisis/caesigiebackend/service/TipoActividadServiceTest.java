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

import cr.ac.ucr.paraiso.analisis.caesigiebackend.entity.TipoDeActividad;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.repository.TipoActividadRepository;

/**
 * AAA Arrange - Act - Assert
 */

public class TipoActividadServiceTest {
    
    @Mock
    private TipoActividadRepository repository;

    @InjectMocks
    private TipoActividadService service;

    private TipoDeActividad tipoDeActividad;

    @BeforeEach
    void setUp(){
        // Arrange
        MockitoAnnotations.initMocks(this);

        tipoDeActividad=new TipoDeActividad();
    }

    /**
     * If we give it a record, the response must not be null
     */
    @Test
    void findAll_DataIsValid_IsNotNull() {
        // Act
        when(repository.findAll()).thenReturn(Arrays.asList(tipoDeActividad));

        // Assert
        assertNotNull(service.obtenerTipoDeActividades());
    }

    /**
     * If we give it four records, the size of response must be four
     */
    @Test
    void indAll_ValidSize_IsFour() {
        // Act
        when(repository.findAll()).thenReturn(Arrays.asList(
            tipoDeActividad,
            new TipoDeActividad(),
            new TipoDeActividad(),
            new TipoDeActividad()
        ));
        List<TipoDeActividad> tipoDeActividads = service.obtenerTipoDeActividades();

        // Assert
        assertEquals(4, tipoDeActividads.size());
    }
}
