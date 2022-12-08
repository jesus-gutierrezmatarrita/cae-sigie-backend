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

import cr.ac.ucr.paraiso.analisis.caesigiebackend.entity.Recinto;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.repository.RecintoRepository;

/**
 * AAA Arrange - Act - Assert
 */

public class RecintoServiceTest {

    @Mock
    private RecintoRepository repository;

    @InjectMocks
    private RecintoService service;

    private Recinto recinto;

    @BeforeEach
    void setUp(){
        // Arrange
        MockitoAnnotations.initMocks(this);

        recinto=new Recinto();
        recinto.setNombre("Recinto prueba");

    }

    /**
     * Si le damos un registro, la respuesta no debería ser nula
     */
    @Test
    void obtenerRecintos_DatosSonValidos_NoEsNulo() {
        // Act
        when(repository.findAll()).thenReturn(Arrays.asList(recinto));

        // Assert
        assertNotNull(service.obtenerRecintos());
    }

    /**
     * Si le damos dos registros, el tamanno deberia ser dos
     */
    @Test
    void findAll_TamannoValido_EsDos() {
        // Act
        when(repository.findAll()).thenReturn(Arrays.asList(
            recinto,
            new Recinto()
        ));
        List<Recinto> recintos = service.obtenerRecintos();

        // Assert
        assertEquals(2, recintos.size());
    }
}
