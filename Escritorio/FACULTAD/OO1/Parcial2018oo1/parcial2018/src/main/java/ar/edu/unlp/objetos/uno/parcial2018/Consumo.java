package ar.edu.unlp.objetos.uno.parcial2018;

public class Consumo {
	private int anio;
	private int mes;
	private double UnidadEnergia;
	public Consumo(int anio, int mes, double unidadEnergia) {
		super();
		this.anio = anio;
		this.mes = mes;
		UnidadEnergia = unidadEnergia;
	}
	public int getAnio() {
		return anio;
	}
	
	public int getMes() {
		return mes;
	}
	
	public double getConsumo() {
		return UnidadEnergia;
	}
	
}
