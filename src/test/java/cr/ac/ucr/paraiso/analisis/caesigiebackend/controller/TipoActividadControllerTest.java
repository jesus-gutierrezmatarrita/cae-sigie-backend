package cr.ac.ucr.paraiso.analisis.caesigiebackend.controller;

import cr.ac.ucr.paraiso.analisis.caesigiebackend.entity.Recinto;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.entity.TipoDeActividad;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.service.RecintoService;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.service.TipoActividadService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = TipoActividadController.class)
class TipoActividadControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TipoActividadService service;

    private ArrayList<TipoDeActividad> actividades;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        TipoDeActividad actividad1 = new TipoDeActividad(1,"Taller");
        TipoDeActividad actividad2 = new TipoDeActividad(2,"Charla");

        actividades= new ArrayList<TipoDeActividad>();
        actividades.add(actividad1);
        actividades.add(actividad2);

    }

    @Test
    void obtenerTipoActividades() throws Exception {
        Mockito.when(service.obtenerTipoDeActividades()).thenReturn(actividades);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/tipoactividad").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "[{\"idTipo\":1,\"nombreTipo\":\"Taller\"},{\"idTipo\":2,\"nombreTipo\":\"Charla\"} ]";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);

    }

    @Test
    void guardarTipoActividad() {
    }
}