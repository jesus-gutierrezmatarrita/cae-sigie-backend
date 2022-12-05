package cr.ac.ucr.paraiso.analisis.caesigiebackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.ac.ucr.paraiso.analisis.caesigiebackend.entity.Recinto;
import cr.ac.ucr.paraiso.analisis.caesigiebackend.repository.RecintoRepository;

@Service
public class RecintoService {
    @Autowired
    RecintoRepository recintoRepository;

    public List<Recinto> obtenerRecintos() {
        return (List<Recinto>) this.recintoRepository.findAll();
    }

    public Recinto guardarRecinto(Recinto recinto) {
        return this.recintoRepository.save(recinto);
    }

}
