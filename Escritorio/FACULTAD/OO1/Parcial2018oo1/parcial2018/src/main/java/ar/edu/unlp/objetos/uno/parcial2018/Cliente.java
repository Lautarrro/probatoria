package ar.edu.unlp.objetos.uno.parcial2018;
import java.util.List;
import java.util.ArrayList;
public abstract class Cliente {
	private String docimicilio;
	private String nombre;
	protected List<Consumo> consumos;
	
	public Cliente(String dom,String name) {
		this.consumos= new ArrayList<Consumo>();
		this.docimicilio=dom;
		this.nombre=name;
		}

	public Consumo agregarConsumo(int mes, int anio,double ue) {
		Consumo cons = new Consumo(anio,mes,ue);
		this.consumos.add(cons);
		return cons;
	}
	public abstract Cliente actualizar(double precioP, double precioI);
	public abstract double montoFactura(int mes,int anio);
	public abstract double getTarifa();
	public Consumo consumoMes(int mes,int anio) {
		return this.consumos.stream()
				.filter(con -> con.getMes() == mes && con.getAnio() == anio)
				.findFirst().orElse(null);
		
	}
}
