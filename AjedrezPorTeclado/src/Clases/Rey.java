package Clases;

import java.util.ArrayList;
import java.util.Scanner;

public class Rey extends Pieza {
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
		if(listaPosibles.size()!=0) {
			puede = true;
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
				lista[listaPosibles.get(movi+movi)][listaPosibles.get(movi+movi+1)]=new Rey();
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
		}
		

		return puede;

	}

	
	public ArrayList<Integer> consultarMovimiento(Pieza obj, int origenEjeX, int origenEjeY, Pieza[][] lista) {
		ArrayList<Integer> listaPosibles = new ArrayList<Integer>();
		// si es peon

		if (obj.getNombre() == "rey") {
			// si es blanco
			if (obj.getColor() == "blanco") {
				// arriba
				if(origenEjeY<7) {
					if (lista[origenEjeX][origenEjeY + 1].getColor() == "gris"||lista[origenEjeX][origenEjeY + 1].getColor() == "negro") {
						listaPosibles.add(origenEjeX);
						listaPosibles.add(origenEjeY + 1);
					}}
				// arriba a la izquierda
					if (origenEjeX > 0 && origenEjeY<6) {
						if (lista[origenEjeX - 1][origenEjeY + 1].getColor() == "gris"||lista[origenEjeX - 1][origenEjeY + 1].getColor() == "negro") {
							listaPosibles.add(origenEjeX - 1);
							listaPosibles.add(origenEjeY + 1);
						}}
				// arriba a la derecha
					if (origenEjeX < 6 &&origenEjeY<6) {
						if (lista[origenEjeX + 1][origenEjeY + 1].getColor() == "gris"||lista[origenEjeX + 1][origenEjeY + 1].getColor() == "negro") {
							listaPosibles.add(origenEjeX + 1);
							listaPosibles.add(origenEjeY + 1);
						}
					}
					
					// abajo
					if (origenEjeX > 0 && origenEjeY>0) {
					if (lista[origenEjeX][origenEjeY - 1].getColor() == "gris"||lista[origenEjeX][origenEjeY - 1].getColor() == "negro") {
						listaPosibles.add(origenEjeX);
						listaPosibles.add(origenEjeY - 1);
					}}
					//abajo derecha
					if (origenEjeX > 0 && origenEjeY>0) {
						if (lista[origenEjeX - 1][origenEjeY - 1].getColor() == "gris"||lista[origenEjeX - 1][origenEjeY - 1].getColor() == "negro") {
							listaPosibles.add(origenEjeX - 1);
							listaPosibles.add(origenEjeY - 1);
						}}
					//abajo izquierda
					if (origenEjeX <7 && origenEjeY>0) {
						if (lista[origenEjeX + 1][origenEjeY - 1].getColor() == "gris"||lista[origenEjeX + 1][origenEjeY - 1].getColor() == "negro") {
							listaPosibles.add(origenEjeX + 1);
							listaPosibles.add(origenEjeY - 1);
						}}
					// derecha
					if (origenEjeX <7) {
					if (lista[origenEjeX+1][origenEjeY ].getColor() == "gris"||lista[origenEjeX+1][origenEjeY].getColor() == "negro") {
						listaPosibles.add(origenEjeX+1);
						listaPosibles.add(origenEjeY);
					}}
					// izquierda
					if (origenEjeX >0) {
					if (lista[origenEjeX-1][origenEjeY ].getColor() == "gris"||lista[origenEjeX-1][origenEjeY].getColor() == "negro") {
						listaPosibles.add(origenEjeX-1);
						listaPosibles.add(origenEjeY);
					}}
				// si es nigga

			} else if (obj.getColor() == "negro") {
	
			}
		}
		return listaPosibles;
	}
	public Rey() {
		super();
	}
	

}
