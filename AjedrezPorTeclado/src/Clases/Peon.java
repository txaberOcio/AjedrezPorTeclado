package Clases;

import java.util.ArrayList;
import java.util.Scanner;

public class Peon extends Pieza {

	public boolean mover(int origenEjeX, int origenEjeY) {
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
				lista[listaPosibles.get(movi+movi)][listaPosibles.get(movi+movi+1)]=new Peon();
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

		if (obj.getNombre() == "peon") {
			// si es blanco
			if (obj.getColor() == "blanco") {
				// un paso palante

				if (lista[origenEjeX][origenEjeY + 1].getColor() == "gris") {

					listaPosibles.add(origenEjeX);
					listaPosibles.add(origenEjeY + 1);

				}
				// movimiento 2 casillas
				if (origenEjeY == 1) {
					if (lista[origenEjeX][origenEjeY + 1].getColor() == "gris"
							&& lista[origenEjeX][origenEjeY + 2].getColor() == "gris") {

						listaPosibles.add(origenEjeX);
						listaPosibles.add(origenEjeY + 2);
					}
				}

				// comer
				// Come a la izquierda
				if (origenEjeX > 0) {
					if (lista[origenEjeX - 1][origenEjeY + 1].getColor() == "negro") {

						listaPosibles.add(origenEjeX - 1);
						listaPosibles.add(origenEjeY + 1);
					}}
					// come a la derecha
					if (origenEjeX < 7) {
						if (lista[origenEjeX + 1][origenEjeY + 1].getColor() == "negro") {

							listaPosibles.add(origenEjeX + 1);
							listaPosibles.add(origenEjeY + 1);
						}
					}

				
				// si es nigga

			} else if (obj.getColor() == "negro") {
				// un paso palante

				if (lista[origenEjeX][origenEjeY - 1].getColor() == "gris") {

					listaPosibles.add(origenEjeX);
					listaPosibles.add(origenEjeY - 1);

				}
				// movimiento 2 casillas
				if (origenEjeY == 6) {
					if (lista[origenEjeX][origenEjeY - 1].getColor() == "gris"
							&& lista[origenEjeX][origenEjeY - 2].getColor() == "gris") {

						listaPosibles.add(origenEjeX);
						listaPosibles.add(origenEjeY - 2);
					}
				}

				// comer
				// Come a la izquierda
				if (origenEjeX >= 0) {
					if (lista[origenEjeX - 1][origenEjeY - 1].getColor() == "blanco") {

						listaPosibles.add(origenEjeX - 1);
						listaPosibles.add(origenEjeY - 1);
					}}
					// come a la derecha
					if (origenEjeX <= 7) {
						if (lista[origenEjeX + 1][origenEjeY - 1].getColor() == "blanco") {

							listaPosibles.add(origenEjeX + 1);
							listaPosibles.add(origenEjeY - 1);
						}
					}

				

			}

		}
		return listaPosibles;
	}
	public Peon() {
		super();
	}

}
