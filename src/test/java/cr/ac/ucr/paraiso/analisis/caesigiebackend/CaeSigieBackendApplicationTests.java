package cr.ac.ucr.paraiso.analisis.caesigiebackend;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cr.ac.ucr.paraiso.analisis.caesigiebackend.controller.ConsultaActividadAcademicaController;

@SpringBootTest
class CaeSigieBackendApplicationTests {

	@Autowired
	private ConsultaActividadAcademicaController controller;
	
	/**
	 * @throws Exception
     * Simple sanity check test that will fail if the application context cannot start
	 */
	@Test
	void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
