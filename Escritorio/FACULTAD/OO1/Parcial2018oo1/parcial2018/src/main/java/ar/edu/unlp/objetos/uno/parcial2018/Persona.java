package ar.edu.unlp.objetos.uno.parcial2018;

public class Persona extends Cliente {
	private String apellido;
	private double tarifaPer;
	
	public Persona(String dom, String name, String apellido) {
		super(dom, name);
		this.apellido = apellido;
		this.tarifaPer=0;
	}
	@Override
	public Cliente actualizar(double pp, double pi) {
		this.tarifaPer=pp;
		return this;
	}
	@Override
	public double getTarifa() {
		return this.tarifaPer;
	}
	public Consumo consumoAnioAnterior(int mes, int anio) {
		return 	this.consumos.stream()
					.filter(con -> con.getMes() == mes && con.getAnio() == anio-1)
					.findFirst().orElse(null);
	}
	@Override
	public double montoFactura(int mes, int anio) {
		double total= consumoMes(mes, anio).getConsumo()
	* tarifaPer;
		if(consumoAnioAnterior(anio,mes) == null || ( consumoAnioAnterior(mes,anio).getConsumo() > consumoMes(mes,anio).getConsumo())) {
			double totalDesc = total - (total*0.10);
			return totalDesc;}
		else return total;
	}
	
}
