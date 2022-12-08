package cr.ac.ucr.paraiso.analisis.caesigiebackend.controller;

import cr.ac.ucr.paraiso.analisis.caesigiebackend.entity.ConsultaActividadAcademica;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.entity.PersonaGraduada;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.entity.Recinto;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.entity.TipoDeActividad;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.service.ConsultaActividadAcademicaService;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.service.RecintoService;
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

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@WebMvcTest(value = RecintoController.class)
class RecintoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecintoService service;

    private ArrayList<Recinto> recintos;




    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        recintos = new ArrayList<Recinto>();
        ArrayList<ConsultaActividadAcademica> consultasActividadesAcademicas = new ArrayList<ConsultaActividadAcademica>();
        ArrayList<PersonaGraduada> personasGraduadas = new ArrayList<PersonaGraduada>();

        Recinto recinto = new Recinto(1,"30","Recinto de Paraiso, Sede del Atlantico",2511-0000,"Cartago","Paraiso", "Paraiso","Paraiso de Cartago, del parque de Paraiso, un kilometro y medio carretera a Orosi" ,consultasActividadesAcademicas,personasGraduadas);
        recintos.add(recinto);
    }

    @Test
    void obtenerRecintos() throws Exception {
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
    void guardarRecinto() throws Exception {
        ArrayList<ConsultaActividadAcademica> consultasActividadesAcademicas = new ArrayList<ConsultaActividadAcademica>();
        ArrayList<PersonaGraduada> personasGraduadas = new ArrayList<PersonaGraduada>();
        Recinto recinto = new Recinto(1,"30","Recinto de Paraiso, Sede del Atlantico",2511-0000,"Cartago","Paraiso", "Paraiso","Paraiso de Cartago, del parque de Paraiso, un kilometro y medio carretera a Orosi" ,consultasActividadesAcademicas,personasGraduadas);

        Mockito.when(service.guardarRecinto(Mockito.any(Recinto.class))).thenReturn(recinto);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/recinto")
                .accept(MediaType.APPLICATION_JSON).content("{\"idRecinto\":1,\"codigoRecinto\":\"30\",\"nombre\":\"Recinto de Paraiso, Sede del Atlantico\",\"contacto\":2511,\"provincia\":\"Cartago\",\"canton\":\"Paraiso\",\"distrito\":\"Paraiso\",\"direccion\":\"Paraiso de Cartago, del parque de Paraiso, un kilometro y medio carretera a Orosi\",\"consultas\":[],\"personasGraduadas\":[]}")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
}