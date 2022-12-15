package ar.edu.unlp.objetos.uno.parcial2018;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.ArrayList;
public class Sistema {
	private List<Cliente> clientes;

	public Sistema() {
		this.clientes = new ArrayList<Cliente>();
		
	}
	public Cliente darAltaPersona(String name,String ape, String dom) {
		Persona per = new Persona(dom,name,ape);
		this.clientes.add(per);
		return per;
	}
	public Cliente darAltaIndustria(String name, String dom) {
		Industria ind = new Industria(dom,name);
		this.clientes.add(ind);
		return ind;
	}
	public Consumo regMedicion(Cliente cliente,int mes, int anio,double energia) {
		return cliente.agregarConsumo(mes,anio,energia);
	}
	public void actualizarTarifa(double precioPer, double precioInd) {
					this.clientes.stream()
					.map(cli -> cli.actualizar(precioPer,precioInd))
					.collect(Collectors.toList());
	}
	public double montoFactura(Cliente cliente, int mes, int anio) {
		return cliente.montoFactura(mes, anio);
	}
}
