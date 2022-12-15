package ar.edu.unlp.objetos.uno.parcial2018;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaTest {
	private Sistema sistema;
	private Cliente persona;
	private Cliente industria;
	private Consumo consumoMenorMes;
	private Consumo consumoMayorMes;
	private Consumo consumoMenorAnio;
	private Consumo consumoMayorAnio;
	
	
	@BeforeEach
	void setUp() {
		this.sistema= new Sistema();
		this.persona=sistema.darAltaPersona("Omar","Amor", "Diagonal 80 Nro 2456");
		this.industria= sistema.darAltaIndustria("La Sermonisima", "Calle Posadas Nro 2454");
		this.consumoMenorMes=sistema.regMedicion(industria, 7, 2022, 500);
		this.consumoMayorMes=sistema.regMedicion(industria, 6, 2022, 300);
		this.consumoMayorAnio=sistema.regMedicion(persona, 7, 2022, 500);
		this.consumoMenorAnio=sistema.regMedicion(persona, 7, 2021, 300);
		this.sistema.actualizarTarifa(2, 1.85);
	}
	
	@Test
	void actualizarTarifaTest() {
		assertEquals(2,this.persona.getTarifa());
		assertEquals(1.85,this.industria.getTarifa());
	}
	@Test
	void montoFacturaTest() {
		assertEquals(499.5,this.persona.montoFactura(7, 2021));
		assertEquals(588,this.industria.montoFactura(6, 2021));
		
	}
}
