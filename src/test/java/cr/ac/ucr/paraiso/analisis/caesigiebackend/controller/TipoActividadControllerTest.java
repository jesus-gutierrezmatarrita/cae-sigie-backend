package cr.ac.ucr.paraiso.analisis.caesigiebackend.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import cr.ac.ucr.paraiso.analisis.caesigiebackend.entity.TipoDeActividad;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.service.TipoActividadService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = TipoActividadController.class)
class TipoActividadControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TipoActividadService service;

    private ArrayList<TipoDeActividad> actividades;
    TipoDeActividad actividad1;
    TipoDeActividad actividad2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        actividad1 = new TipoDeActividad(1, "Taller");
        actividad2 = new TipoDeActividad(2, "Charla");

        actividades = new ArrayList<TipoDeActividad>();
        actividades.add(actividad1);
        actividades.add(actividad2);

    }

    @Test
    void obtenerTipoActividades_DatosSonValidos_ListaTipoActividades() throws Exception {
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
    void guardarTipoActividad_InsercionEsCorrecta_TipoActividad() throws Exception {

        Mockito.when(service.guardarTipoDeActividad(Mockito.any(TipoDeActividad.class))).thenReturn(actividad1);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/tipoactividad")
                .accept(MediaType.APPLICATION_JSON).content("{\"idTipo\":1,\"nombreTipo\":\"Taller\"}")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());

    }
    
}