package cr.ac.ucr.paraiso.analisis.caesigiebackend.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
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
import cr.ac.ucr.paraiso.analisis.caesigiebackend.entity.PersonaCoordinadora;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.service.PersonaCoordinadoraService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = PersonaCoordinadoraController.class)
class PersonaCoordinadoraControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private PersonaCoordinadoraService service;

        ArrayList<PersonaCoordinadora> personasCoordinadoras;
        ArrayList<ConsultaActividadAcademica> consultaActividadesAcademicas;
        PersonaCoordinadora personaCoordinadora;

        @BeforeEach
        void setUp() {
                consultaActividadesAcademicas = new ArrayList<ConsultaActividadAcademica>();
                personaCoordinadora = new PersonaCoordinadora(1, "Alvaro", "Mena Monge", "alvaro@ucr.ac.cr", 88888888,
                                "A0000", "1234", consultaActividadesAcademicas);
                personasCoordinadoras = new ArrayList<PersonaCoordinadora>();
                personasCoordinadoras.add(personaCoordinadora);

        }

        @Test
        void obtenerPersonasCoordinadoras_DatosSonValidos_PersonasCoordinadorasList() throws Exception {
                Mockito.when(service.obtenerPersonasCoordinadoras()).thenReturn(personasCoordinadoras);

                RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                                "/personacoordinadora").accept(
                                                MediaType.APPLICATION_JSON);

                MvcResult result = mockMvc.perform(requestBuilder).andReturn();

                System.out.println(result.getResponse());
                String expected = "[{\"idPersonaCoordinadora\":1,\"nombre\":\"Alvaro\",\"apellidos\":\"Mena Monge\",\"correoElectronico\":\"alvaro@ucr.ac.cr\",\"telefono\":88888888,\"carnet\":\"A0000\",\"contrasenna\":\"1234\"}]";

                JSONAssert.assertEquals(expected, result.getResponse()
                                .getContentAsString(), false);

        }

        @Test
        void guardarPersona_InsercionEsCorrecta_InfoPersonaCoordinadora() throws Exception {

                Mockito.when(service.guardarPersonaCoordinadora(Mockito.any(PersonaCoordinadora.class)))
                                .thenReturn(personaCoordinadora);

                RequestBuilder requestBuilder = MockMvcRequestBuilders
                                .post("/personacoordinadora")
                                .accept(MediaType.APPLICATION_JSON)
                                .content("{\"idPersonaCoordinadora\":1,\"nombre\":\"John\",\"apellidos\":\"Doe\",\"correoElectronico\":\"john@ucr.ac.cr\",\"telefono\":12345678,\"carnet\":\"B0000\",\"contrasenna\":\"12345\"}")
                                .contentType(MediaType.APPLICATION_JSON);

                MvcResult result = mockMvc.perform(requestBuilder).andReturn();

                System.out.println(result.getResponse());
                MockHttpServletResponse response = result.getResponse();

                assertEquals(HttpStatus.OK.value(), response.getStatus());

        }

        @Test
        void findPersonaByEmail_PersonaCoordinadoraExiste_PersonaCoordinadora() throws Exception {
                ArrayList<ConsultaActividadAcademica> consultaActividadesAcademicas = new ArrayList<ConsultaActividadAcademica>();
                PersonaCoordinadora personaCoordinadora = new PersonaCoordinadora(1, "John", "Doe", "john@ucr.ac.cr",
                                12345678, "B0000", "12345", consultaActividadesAcademicas);

                Mockito.when(service.findPersonaByEmail(personaCoordinadora.getCorreoElectronico()))
                                .thenReturn(personaCoordinadora);

                RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                                "/personacoordinadora/john@ucr.ac.cr").accept(
                                                MediaType.APPLICATION_JSON);

                MvcResult result = mockMvc.perform(requestBuilder).andReturn();

                System.out.println(result.getResponse());
                String expected = "{\"idPersonaCoordinadora\":1,\"nombre\":\"John\",\"apellidos\":\"Doe\",\"correoElectronico\":\"john@ucr.ac.cr\",\"telefono\":12345678,\"carnet\":\"B0000\",\"contrasenna\":\"12345\"}";

                JSONAssert.assertEquals(expected, result.getResponse()
                                .getContentAsString(), false);

        }
        
}