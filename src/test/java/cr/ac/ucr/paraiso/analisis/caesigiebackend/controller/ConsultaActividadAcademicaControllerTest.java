package cr.ac.ucr.paraiso.analisis.caesigiebackend.controller;

import cr.ac.ucr.paraiso.analisis.caesigiebackend.entity.ConsultaActividadAcademica;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.entity.PersonaCoordinadora;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.entity.PersonaGraduada;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.entity.TipoDeActividad;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.repository.ConsultaActividadAcademicaRepository;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.service.ConsultaActividadAcademicaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;


@ExtendWith(SpringExtension.class)
@WebMvcTest(value = ConsultaActividadAcademicaController.class)
class ConsultaActividadAcademicaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConsultaActividadAcademicaService service;

    ArrayList<ConsultaActividadAcademica> consultasActividadesAcademicas;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        TipoDeActividad tipoDeActivida = new TipoDeActividad(1,"Taller");
        ConsultaActividadAcademica consulta = new ConsultaActividadAcademica(1,"Taller de Github", "El siguiente taller busca que el estudiantado pueda conocer mas acerca del versionamiento de proyectos de software",
                LocalDateTime.of(2022,12,10,13,00),LocalDateTime.of(2022,12,12,17,00),
                LocalDateTime.of(2022,12,1,00,00),
                LocalDateTime.of(2022,12,6,12,00), "Virtual", "Recinto de Paraiso, Lab 14",tipoDeActivida);
        PersonaGraduada personaGraduada = new PersonaGraduada();

        consultasActividadesAcademicas = new ArrayList<ConsultaActividadAcademica>();
        consultasActividadesAcademicas.add(consulta);

    }

    @Test
    void obtenerConsultaActividadAcademicas() throws Exception {

        Mockito.when(service.obtenerConsultas()).thenReturn(consultasActividadesAcademicas);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/actividadacademica").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "[{\"idConsultaActividadAcademica\":1,\"titulo\":\"Taller de Github\",\"descripcion\":\"El siguiente taller busca que el estudiantado pueda conocer mas acerca del versionamiento de proyectos de software\",\"fecha1RealizacionDeActividad\":\"2022-12-10T13:00:00\",\"fecha2RealizacionDeActividad\":\"2022-12-12T17:00:00\",\"fechaInicio\":\"2022-12-01T00:00:00\",\"fechaFin\":\"2022-12-06T12:00:00\",\"modalidad\":\"Virtual\",\"lugarActividad\":\"Recinto de Paraiso, Lab 14\",\"tipoDeActividad\":{\"idTipo\":1,\"nombreTipo\":\"Taller\"}}]";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);

    }

    @Test
    void guardarConsultaActividadAcademica() throws Exception {

        TipoDeActividad tipoDeActivida = new TipoDeActividad(1,"Taller");
        ConsultaActividadAcademica consulta = new ConsultaActividadAcademica(1,"Taller de Github", "El siguiente taller busca que el estudiantado pueda conocer mas acerca del versionamiento de proyectos de software",
                LocalDateTime.of(2022,12,10,13,00),LocalDateTime.of(2022,12,12,17,00),
                LocalDateTime.of(2022,12,1,00,00),
                LocalDateTime.of(2022,12,6,12,00), "Virtual", "Recinto de Paraiso, Lab 14",tipoDeActivida);

        Mockito.when(service.guardarConsulta(Mockito.any(ConsultaActividadAcademica.class))).thenReturn(consulta);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/actividadacademica")
                .accept(MediaType.APPLICATION_JSON).content("{\"idConsultaActividadAcademica\":1,\"titulo\":\"Taller de Github\",\"descripcion\":\"El siguiente taller busca que el estudiantado pueda conocer mas acerca del versionamiento de proyectos de software\",\"fecha1RealizacionDeActividad\":\"2022-12-10T13:00:00\",\"fecha2RealizacionDeActividad\":\"2022-12-12T17:00:00\",\"fechaInicio\":\"2022-12-01T00:00:00\",\"fechaFin\":\"2022-12-06T12:00:00\",\"modalidad\":\"Virtual\",\"lugarActividad\":\"Recinto de Paraiso, Lab 14\",\"tipoDeActividad\":{\"idTipo\":1,\"nombreTipo\":\"Taller\"}}")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());

    }


}