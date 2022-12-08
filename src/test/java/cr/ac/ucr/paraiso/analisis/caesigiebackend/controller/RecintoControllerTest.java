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

import cr.ac.ucr.paraiso.analisis.caesigiebackend.entity.ConsultaActividadAcademica;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.entity.PersonaGraduada;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.entity.Recinto;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.service.RecintoService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = RecintoController.class)
class RecintoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecintoService service;

    private ArrayList<Recinto> recintos;
    ArrayList<ConsultaActividadAcademica> consultasActividadesAcademicas;
    ArrayList<PersonaGraduada> personasGraduadas;
    Recinto recinto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        recintos = new ArrayList<Recinto>();
        consultasActividadesAcademicas = new ArrayList<ConsultaActividadAcademica>();
        personasGraduadas = new ArrayList<PersonaGraduada>();
        recinto = new Recinto(1, "30", "Recinto de Paraiso, Sede del Atlantico", 2511 - 0000, "Cartago", "Paraiso",
                "Paraiso", "Paraiso de Cartago, del parque de Paraiso, un kilometro y medio carretera a Orosi",
                consultasActividadesAcademicas, personasGraduadas);
        recintos.add(recinto);
    }

    @Test
    void obtenerRecintos_DatosSonValidos_ListaRecintos() throws Exception {
        Mockito.when(service.obtenerRecintos()).thenReturn(recintos);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/recinto").accept(
                        MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "[{\"idRecinto\":1,\"codigoRecinto\":\"30\",\"nombre\":\"Recinto de Paraiso, Sede del Atlantico\",\"contacto\":2511,\"provincia\":\"Cartago\",\"canton\":\"Paraiso\",\"distrito\":\"Paraiso\",\"direccion\":\"Paraiso de Cartago, del parque de Paraiso, un kilometro y medio carretera a Orosi\",\"consultas\":[],\"personasGraduadas\":[]}]";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);

    }

    @Test
    void guardarRecinto_InsercionEsCorrecta_Recinto() throws Exception {
        Mockito.when(service.guardarRecinto(Mockito.any(Recinto.class))).thenReturn(recinto);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/recinto")
                .accept(MediaType.APPLICATION_JSON)
                .content(
                        "{\"idRecinto\":1,\"codigoRecinto\":\"30\",\"nombre\":\"Recinto de Paraiso, Sede del Atlantico\",\"contacto\":2511,\"provincia\":\"Cartago\",\"canton\":\"Paraiso\",\"distrito\":\"Paraiso\",\"direccion\":\"Paraiso de Cartago, del parque de Paraiso, un kilometro y medio carretera a Orosi\",\"consultas\":[],\"personasGraduadas\":[]}")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
    
}