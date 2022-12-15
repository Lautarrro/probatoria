package ar.edu.unlp.objetos.uno.parcial2018;

public class Industria extends Cliente{
	private double tarifaInd;

	public Industria(String dom, String name) {
		super(dom, name);
		this.tarifaInd=0;
	}
	@Override
	public Cliente actualizar(double pp,double pi) {
		this.tarifaInd=pi;
		return this;
	}
	@Override
	public double getTarifa() {
		return this.tarifaInd;
	}
	public Consumo consumoMesAnterior(int mes, int anio) {
		return 	this.consumos.stream()
					.filter(con -> con.getMes() == mes-1 && con.getAnio() == anio)
					.findFirst().orElse(null);
	}
	@Override
	public double montoFactura(int mes, int anio) {
		double total= this.consumoMes(mes, anio).getConsumo() * tarifaInd;
		if(consumoMesAnterior(mes,anio) == null) {
			return total;
		}
		else if (consumoMesAnterior(mes,anio).getConsumo() > consumoMes(mes,anio).getConsumo()) {
				double totalDesc = total - (total*0.02);
				return totalDesc;
			}
		return total;
		
			
	}

}
