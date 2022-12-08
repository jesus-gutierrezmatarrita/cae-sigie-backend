package cr.ac.ucr.paraiso.analisis.caesigiebackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import cr.ac.ucr.paraiso.analisis.caesigiebackend.entity.ConsultaActividadAcademica;

@WebMvcTest(ConsultaActividadAcademica.class)
public class TestConsultaActividadAcademicaController {
 
  @Autowired
  private MockMvc mvc;
 
}
