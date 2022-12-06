package cr.ac.ucr.paraiso.analisis.caesigiebackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cr.ac.ucr.paraiso.analisis.caesigiebackend.entity.ConsultaActividadAcademica;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.service.ConsultaActividadAcademicaService;

@RestController
@RequestMapping("/actividadacademica")
public class ConsultaActividadAcademicaController {
    @Autowired
    ConsultaActividadAcademicaService actividadAcademicaService;

    @GetMapping
    public List<ConsultaActividadAcademica> obtenerConsultaActividadAcademicas() {
        return this.actividadAcademicaService.obtenerConsultas();
    }

    @PostMapping
    public ConsultaActividadAcademica guardarConsultaActividadAcademica
        (@RequestBody ConsultaActividadAcademica consultaActividadAcademica) {
        return this.actividadAcademicaService.guardarConsulta(consultaActividadAcademica);
    }

}
