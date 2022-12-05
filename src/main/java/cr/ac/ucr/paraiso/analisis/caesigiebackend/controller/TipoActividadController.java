package cr.ac.ucr.paraiso.analisis.caesigiebackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cr.ac.ucr.paraiso.analisis.caesigiebackend.entity.TipoDeActividad;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.service.TipoActividadService;

@RestController
@RequestMapping("/tipoactividad")
public class TipoActividadController {
    @Autowired
    TipoActividadService tipoActividadService;

    @GetMapping
    public List<TipoDeActividad> obtenerTipoActividades() {
        return this.tipoActividadService.obtenerTipoDeActividades();
    }

    @PostMapping
    public TipoDeActividad guardarTipoActividad(@RequestBody TipoDeActividad tipoActividad) {
        return this.tipoActividadService.guardarTipoDeActividad(tipoActividad);
    }
}
