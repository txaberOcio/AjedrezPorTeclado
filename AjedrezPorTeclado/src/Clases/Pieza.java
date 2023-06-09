package Clases;

import java.util.ArrayList;

public class Pieza {
	String color = "gris";
	String nombre = "nada";

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Pieza() {
		super();
	}

	public ArrayList<Integer> consultarMovimiento(Pieza pieza, int origenEjeX, int origenEjeY, Pieza[][] lista) {
		if (pieza.getNombre() == "peon") {
			Peon obj = new Peon();
			obj.consultarMovimiento(pieza, origenEjeX, origenEjeY, lista);
		}
		if (pieza.getNombre() == "alfil") {
			Alfil objA = new Alfil();
			
			objA.consultarMovimiento(pieza, origenEjeX, origenEjeY, lista);
		}
		if (pieza.getNombre() == "caballo") {
			Caballo objC = new Caballo();
			
			objC.consultarMovimiento(pieza, origenEjeX, origenEjeY, lista);
		}
		if (pieza.getNombre() == "reina") {
			Reina objN = new Reina();
			
			objN.consultarMovimiento(pieza, origenEjeX, origenEjeY, lista);
		}
		if (pieza.getNombre() == "rey") {
			Rey objR = new Rey();
			
			objR.consultarMovimiento(pieza, origenEjeX, origenEjeY, lista);
		}
		if (pieza.getNombre() == "torre") {
			Torre objT = new Torre();
			
			objT.consultarMovimiento(pieza, origenEjeX, origenEjeY, lista);
		}
		return null;
	}

}
