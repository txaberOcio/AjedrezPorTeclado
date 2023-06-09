package Clases;

import java.util.ArrayList;
import java.util.Scanner;

public class Alfil extends Pieza {

	public Alfil() {
		super();
	}

	public ArrayList<Integer> consultarMovimiento(Pieza obj,int origenEjeX,int origenEjeY,Pieza[][] lista) {
		ArrayList<Integer> listaPosibles = new ArrayList<Integer>();
		// si es peon

		if (obj.getNombre() == "alfil") {
			// si es blanco
			if (obj.getColor() == "blanco") {
				// un paso palante

				for(int i=1;i<7;i++) {
					//todo como controlar el if para  qno se salga del tablero
					int limitey=origenEjeY,limitex=origenEjeX;
					
				if(origenEjeX+i<=7&&origenEjeY+i<=7) {
					if(lista[origenEjeX+i][origenEjeY +i].getColor()=="gris"||lista[origenEjeX+i][origenEjeY +i].getColor()=="negro") {
						listaPosibles.add(origenEjeX+i);
						listaPosibles.add(origenEjeY + i);
						if(lista[origenEjeX+i][origenEjeY +i].getColor()=="negro"||lista[origenEjeX+i][origenEjeY +i].getColor()=="blanco") {
							break;
						}
					}else {break;}
				}
				}
				for(int i=1;i<=7;i++) {
					//todo como controlar el if para  qno se salga del tablero
					int limitey=origenEjeY,limitex=origenEjeX;
				if(origenEjeX+i<7&&origenEjeY-i>=0) {
					if(lista[origenEjeX+i][origenEjeY -i].getColor()=="gris"||lista[origenEjeX+limitex][origenEjeY -limitey].getColor()=="negro") {
						listaPosibles.add(origenEjeX+i);
						listaPosibles.add(origenEjeY - i);
						if(lista[origenEjeX+limitex][origenEjeY -limitey].getColor()=="negro"||lista[origenEjeX+limitex][origenEjeY -limitey].getColor()=="blanco") {
							break;
						}
					}else {break;}
				}
				}
				for(int i=1;i<7;i++) {
					//todo como controlar el if para  qno se salga del tablero
					int limitey=origenEjeY,limitex=origenEjeX;
				if(origenEjeX-i>=0&&origenEjeY-i>=0) {
					if(lista[origenEjeX-i][origenEjeY -i].getColor()=="gris"||lista[origenEjeX-i][origenEjeY -i].getColor()=="negro") {
						listaPosibles.add(origenEjeX -i);
						listaPosibles.add(origenEjeY - i);
						if(lista[origenEjeX-i][origenEjeY -i].getColor()=="negro"||lista[origenEjeX-i][origenEjeY -i].getColor()=="blanco") {
							break;
						}
					}else {break;}
				}
				}
				for(int i=1;i<7;i++) {
					//todo como controlar el if para  qno se salga del tablero
					int limitey=origenEjeY,limitex=origenEjeX;
				if(origenEjeX-i>=0&&origenEjeY+i<=7) {
					if(lista[origenEjeX-i][origenEjeY +i].getColor()=="gris"||lista[origenEjeX-i][origenEjeY +i].getColor()=="negro") {
						listaPosibles.add(origenEjeX -i);
						listaPosibles.add(origenEjeY + i);
						if(lista[origenEjeX-i][origenEjeY +i].getColor()=="negro"||lista[origenEjeX-i][origenEjeY +i].getColor()=="blanco") {
							break;
						}
						
					}else {break;}
				}
				}

				
				System.out.println(listaPosibles.toString());
				// si es nigga

			} else if (obj.getColor() == "negro") {
				
					}

		}
		return listaPosibles;
	};

	public boolean mover(int origenEjeX, int origenEjeY) {
		
		ArrayList<Integer> listaPosibles;
		boolean puede = false;
		boolean salida = false;
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

				lista[listaPosibles.get(movi+movi)][listaPosibles.get(movi+movi+1)]=new Alfil();
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

}
