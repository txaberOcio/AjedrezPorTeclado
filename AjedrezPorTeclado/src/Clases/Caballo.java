package Clases;

import java.util.ArrayList;
import java.util.Scanner;

public class Caballo extends Pieza {

	public Caballo() {
		super();
	}

	public boolean mover(int origenEjeX, int origenEjeY) {
		//TODO hacer caballo
		ArrayList<Integer> listaPosibles;
		boolean puede = false;
		boolean salida=false;
		Scanner myObj = new Scanner(System.in);
		Pieza lista[][] = tablero.getTablero();

		listaPosibles = lista[origenEjeX][origenEjeY].consultarMovimiento(lista[origenEjeX][origenEjeY], origenEjeX,
				origenEjeY, lista);
		
		int cont = 0;
		int movi;
		for (int i = 0; i < listaPosibles.size(); i = i + 2) {
			System.out.println(cont + "- x: " + listaPosibles.get(i) + " y: " + listaPosibles.get(i + 1));
			cont++;
		}
		do {
			salida=false;
			System.out.println("Introduce tu movimiento");
			movi = Integer.parseInt(myObj.nextLine());
			//
			if (movi < cont) {
				lista[listaPosibles.get(movi+movi)][listaPosibles.get(movi+movi+1)]=new Caballo();
				lista[listaPosibles.get(movi+movi)][listaPosibles.get(movi+movi+1)].setColor(lista[origenEjeX][origenEjeY].getColor());
				lista[listaPosibles.get(movi+movi)][listaPosibles.get(movi+movi+1)].setNombre(lista[origenEjeX][origenEjeY].getNombre());
				lista[origenEjeX][origenEjeY]=new Pieza();
				lista[origenEjeX][origenEjeY].setColor("gris");
				lista[origenEjeX][origenEjeY].setNombre("nada");
				salida=true;
			} else {
				System.out.println("numero incorrecto introduce otra vez.");
			}
			
		} while (salida==false);
		puede = true;

		return puede;
		
	}

	public ArrayList<Integer> consultarMovimiento(Pieza obj, int origenEjeX, int origenEjeY, Pieza[][] lista) {
		ArrayList<Integer> listaPosibles = new ArrayList<Integer>();
		// si es peon

		if (obj.getNombre() == "caballo") {
			// si es blanco
			if (obj.getColor() == "blanco") {
				// un paso palante

				//X+2y-+1
				if(origenEjeX+2<7&&origenEjeY+1<7) {
					if (lista[origenEjeX+2][origenEjeY+1].getColor() == "gris"||lista[origenEjeX+2][origenEjeY+1].getColor() == "negro") {
	
						listaPosibles.add(origenEjeX+2);
						listaPosibles.add(origenEjeY + 1);
	
					}
				}
				if(origenEjeX+2<7&&origenEjeY-1>=0) {
					if (lista[origenEjeX+2][origenEjeY-1].getColor() == "gris"||lista[origenEjeX+2][origenEjeY-1].getColor() == "negro") {
	
						listaPosibles.add(origenEjeX+2);
						listaPosibles.add(origenEjeY - 1);
					}
				}
				//X-2y-+1
				if(origenEjeX-2>=0&&origenEjeY+1<7) {
					if (lista[origenEjeX-2][origenEjeY+1].getColor() == "gris"||lista[origenEjeX-2][origenEjeY+1].getColor() == "negro") {
	
						listaPosibles.add(origenEjeX-2);
						listaPosibles.add(origenEjeY + 1);
	
					}
				}
				if(origenEjeX-2>=0&&origenEjeY-1>=0) {
					if (lista[origenEjeX-2][origenEjeY-1].getColor() == "gris"||lista[origenEjeX-2][origenEjeY-1].getColor() == "negro") {
	
						listaPosibles.add(origenEjeX-2);
						listaPosibles.add(origenEjeY - 1);
					}
				}
				//X+-1y+2
				if(origenEjeX+1<7&&origenEjeY+2<7) {
					if (lista[origenEjeX+1][origenEjeY+2].getColor() == "gris"||lista[origenEjeX+1][origenEjeY+2].getColor() == "negro") {
	
						listaPosibles.add(origenEjeX+1);
						listaPosibles.add(origenEjeY + 2);
	
					}
				}
				if(origenEjeX-1>=0&&origenEjeY+2<7) {
					if (lista[origenEjeX-1][origenEjeY+2].getColor() == "gris"||lista[origenEjeX-1][origenEjeY+2].getColor() == "negro") {
	
						listaPosibles.add(origenEjeX-1);
						listaPosibles.add(origenEjeY + 2);
					}
				}
				//X+-1y-2
				if(origenEjeX+1<7&&origenEjeY-2>=0) {
				if (lista[origenEjeX+1][origenEjeY-2].getColor() == "gris"||lista[origenEjeX+1][origenEjeY-2].getColor() == "negro") {

					listaPosibles.add(origenEjeX+1);
					listaPosibles.add(origenEjeY - 2);

				}
				}
				if(origenEjeX-1>=0&&origenEjeY-2>=0){
					if (lista[origenEjeX-1][origenEjeY-2].getColor() == "gris"||lista[origenEjeX-1][origenEjeY-2].getColor() == "negro") {
	
						listaPosibles.add(origenEjeX-1);
						listaPosibles.add(origenEjeY - 2);
					}
				}
				
					}			
				// si es nigga

			} else if (obj.getColor() == "negro") {
	

				

			}

		
		return listaPosibles;
		
	}

}
