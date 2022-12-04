package cr.ac.ucr.paraiso.analisis.caesigiebackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cr.ac.ucr.paraiso.analisis.caesigiebackend.entity.Recinto;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.service.RecintoService;

@RestController
@RequestMapping("/recinto")
public class RecintoController {
    @Autowired
    RecintoService recintoService;

    @GetMapping
    public List<Recinto> obtenerRecintos() {
        return this.recintoService.obtenerRecintos();
    }

    @PostMapping
    public Recinto guardarRecinto(@RequestBody Recinto recinto) {
        return this.recintoService.guardarRecinto(recinto);
    }

}
