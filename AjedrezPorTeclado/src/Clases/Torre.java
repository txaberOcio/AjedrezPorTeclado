package Clases;

import java.util.ArrayList;
import java.util.Scanner;

public class Torre extends Pieza {

	public ArrayList<Integer> consultarMovimiento(Pieza obj,int origenEjeX,int origenEjeY,Pieza[][] lista) {
		ArrayList<Integer> listaPosibles = new ArrayList<Integer>();
		// si es peon

		if (obj.getNombre() == "torre") {
			// si es blanco
			if (obj.getColor() == "blanco") {
				
				//fin diagonales
				
				//xquieta
				for(int i=1;i<7;i++) {
			
					if(origenEjeX>=0&&origenEjeY+i<=7) {
							if(lista[origenEjeX][origenEjeY +i].getColor()=="gris"||lista[origenEjeX][origenEjeY +i].getColor()=="negro") {
								listaPosibles.add(origenEjeX);
								listaPosibles.add(origenEjeY + i);
								
								if(lista[origenEjeX+i][origenEjeY +i].getColor()=="negro") {
									break;
								}
					}else {break;}
				}
				}
			
				for(int i=1;i<7;i++) {
		
					if(origenEjeY<=7&&origenEjeY-i>=0) {
							if(lista[origenEjeX][origenEjeY -i].getColor()=="gris"||lista[origenEjeX][origenEjeY -i].getColor()=="negro") {
								listaPosibles.add(origenEjeX);
								listaPosibles.add(origenEjeY - i);
								if(lista[origenEjeX+i][origenEjeY +i].getColor()=="negro") {
									break;
								}
					}else {break;}
				}
				}
				//yquita
				for(int i=1;i<7;i++) {
					
					if(origenEjeX+i>=0&&origenEjeY<=7) {
							if(lista[origenEjeX+i][origenEjeY ].getColor()=="gris"||lista[origenEjeX+ i][origenEjeY].getColor()=="negro") {
								listaPosibles.add(origenEjeX + i);
								listaPosibles.add(origenEjeY );
								if(lista[origenEjeX+i][origenEjeY +i].getColor()=="negro") {
									break;
								}
					}else {break;}
				}
				}
				//fin diagonales
				for(int i=1;i<7;i++) {
				
					if(origenEjeX-i>=0&&origenEjeY<=7) {
							if(lista[origenEjeX-i][origenEjeY ].getColor()=="gris"||lista[origenEjeX-i][origenEjeY].getColor()=="negro") {
								listaPosibles.add(origenEjeX-i);
								listaPosibles.add(origenEjeY);
								if(lista[origenEjeX+i][origenEjeY +i].getColor()=="negro") {
									break;
								}
					}else {break;}
				}
				}
				
				// si es nigga

			} else if (obj.getColor() == "negro") {
				
					}

		}
		return listaPosibles;
	};

	public boolean mover(int origenEjeX, int origenEjeY) {
		
		ArrayList<Integer> listaPosibles;
		boolean puede = false;
		Scanner myObj = new Scanner(System.in);
		Pieza lista[][] = tablero.getTablero();

		listaPosibles = lista[origenEjeX][origenEjeY].consultarMovimiento(lista[origenEjeX][origenEjeY], origenEjeX,
				origenEjeY, lista);
		int cont = 0;
		int movi;
		if(listaPosibles.size()==0) {
			puede=false;
			
		}else {
		for (int i = 0; i < listaPosibles.size(); i = i + 2) {
			System.out.println(cont + "- x: " + listaPosibles.get(i) + " y: " + listaPosibles.get(i + 1));
			cont++;
		}
		do {

			System.out.println("Introduce tu movimiento");
			movi = Integer.parseInt(myObj.nextLine());
			//
			if (movi < cont) {
				lista[listaPosibles.get(movi+movi)][listaPosibles.get(movi+movi+1)]=new Reina();
				lista[listaPosibles.get(movi+movi)][listaPosibles.get(movi+movi+1)].setColor(lista[origenEjeX][origenEjeY].getColor());
				lista[listaPosibles.get(movi+movi)][listaPosibles.get(movi+movi+1)].setNombre(lista[origenEjeX][origenEjeY].getNombre());
				lista[origenEjeX][origenEjeY].setColor("gris");
				lista[origenEjeX][origenEjeY].setNombre("nada");
			} else {
				System.out.println("numero incorrecto introduce otra vez.");
			}
		} while (movi >= cont);
		puede = true;
		}
		return puede;
	}
	
	public Torre() {
		super();
	}

}

