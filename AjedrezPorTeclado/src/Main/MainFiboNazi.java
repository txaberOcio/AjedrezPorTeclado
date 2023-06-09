package Main;

import java.util.Scanner;

import Clases.Alfil;
import Clases.Caballo;
import Clases.Peon;
import Clases.Pieza;
import Clases.Reina;
import Clases.Rey;
import Clases.Torre;
import Clases.tablero;

public class MainFiboNazi {
	public static void main(String[] args) {
		/* colores */
		final String ANSI_RESET = "\u001B[0m";
		final String ANSI_BLACK = "\u001B[30m";
		final String ANSI_BLUE = "\u001B[34m";
		final String ANSI_ORANGE = "\u001B[33m";
		final String BOLD = "\u001b[1m";
		
		final String BRIGHT_BLUE ="\u001b[34;1m";
		final String ANSI_CYAN = "\u001B[36m";
		final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
		final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
		final String BACKGROUNDBLUE = "\u001b[44;1m";
		/* intro */
		System.out.println(ANSI_CYAN_BACKGROUND+"  "+ANSI_YELLOW_BACKGROUND+"  "+ANSI_CYAN_BACKGROUND+"  "+ANSI_YELLOW_BACKGROUND+"  "+ANSI_CYAN_BACKGROUND+"  "+ANSI_YELLOW_BACKGROUND+"  "+ANSI_CYAN_BACKGROUND+"  "+ANSI_YELLOW_BACKGROUND+"  "+ANSI_CYAN_BACKGROUND+"  "+ANSI_YELLOW_BACKGROUND+"  "+ANSI_CYAN_BACKGROUND+"  "+ANSI_YELLOW_BACKGROUND+"  "+ANSI_CYAN_BACKGROUND+"  "+ANSI_YELLOW_BACKGROUND+"  "+ANSI_CYAN_BACKGROUND+"  "+ANSI_YELLOW_BACKGROUND+"  "+ANSI_CYAN_BACKGROUND+"  "+ANSI_YELLOW_BACKGROUND+"  "+ANSI_CYAN_BACKGROUND+"  "+ANSI_YELLOW_BACKGROUND+"  "+ ANSI_RESET);
		System.out.println(ANSI_ORANGE + BOLD + "                BLANCAS" + ANSI_RESET);
		System.out.println(ANSI_BLUE+BOLD + "                NEGRAS" + ANSI_RESET);
		System.out.println(ANSI_CYAN_BACKGROUND+"  "+ANSI_YELLOW_BACKGROUND+"  "+ANSI_CYAN_BACKGROUND+"  "+ANSI_YELLOW_BACKGROUND+"  "+ANSI_CYAN_BACKGROUND+"  "+ANSI_YELLOW_BACKGROUND+"  "+ANSI_CYAN_BACKGROUND+"  "+ANSI_YELLOW_BACKGROUND+"  "+ANSI_CYAN_BACKGROUND+"  "+ANSI_YELLOW_BACKGROUND+"  "+ANSI_CYAN_BACKGROUND+"  "+ANSI_YELLOW_BACKGROUND+"  "+ANSI_CYAN_BACKGROUND+"  "+ANSI_YELLOW_BACKGROUND+"  "+ANSI_CYAN_BACKGROUND+"  "+ANSI_YELLOW_BACKGROUND+"  "+ANSI_CYAN_BACKGROUND+"  "+ANSI_YELLOW_BACKGROUND+"  "+ANSI_CYAN_BACKGROUND+"  "+ANSI_YELLOW_BACKGROUND+"  "+ ANSI_RESET);
		System.out.println(ANSI_CYAN+BOLD+"EMPIEZA EL JUEGO"+ANSI_RESET);
		/* variables */
		boolean color = false;
		boolean partida = true;
		int turno = 1;
		tablero.creartablero();
		String rsp, rsp2;
		int numeroX = 1;
		int numeroY = 1;
		boolean reyB = false;
		boolean reyN = false;

//mientras el juego corre do
//comprobrar rey
		partida = comprobarRey();
		
		do {
			reyB = false;
			reyN = false;
			for (int e = 0; e < 8; e++) {
				for (int i = 0; i < 8; i++) {
					if (tablero.getTablero()[i][e].getNombre() == "rey"
							&& tablero.getTablero()[i][e].getColor() == "blanco") {
						reyB = true;
					}
					if (tablero.getTablero()[i][e].getNombre() == "rey"
							&& tablero.getTablero()[i][e].getColor() == "negro") {
						reyN = true;
					}
				}
			}
			if (reyB == false){
				System.out.println("negras ganan");
				partida = false;
				break;
			}
			if (reyN == false){
				System.out.println("blancas ganan");
				partida = false;
				break;
			}

//mientras no elijas una ficha de tu color
			do {
				if (turno % 2 == 1) {
					System.out.println("Turno de las blancas");
				} else {
					System.out.println("Turno de las negras");
				}
				// reina blanca 3 0
				Scanner myObj = new Scanner(System.in);
				try {
					System.out.println("Introduce eje x:");
					rsp = myObj.nextLine();
					numeroX = Integer.parseInt(rsp);
				} catch (Exception e) {

				}

				try {
					System.out.println("Introduce eje y:");
					rsp2 = myObj.nextLine();
					numeroY = Integer.parseInt(rsp2);
				} catch (Exception e) {
					numeroX = 500;
					numeroY = 500;
				}
				
				System.out.println(tablero.getTablero()[numeroX][numeroY].getNombre());
/* control de turnos */
				try {
					if (turno % 2 == 1) {
						if (tablero.getTablero()[numeroX][numeroY].getColor() == "blanco") {
							color = true;
						}
						if (tablero.getTablero()[numeroX][numeroY].getColor() == "negro") {
							System.out.println("La ficha seleccionada es negra");
							System.out.println("es el turno de las blancas");
							color=false;
						}
						if (tablero.getTablero()[numeroX][numeroY].getColor() == "gris") {
							System.out.println("no hay ficha en esa posicion");
							color=false;
						}
					}

					if (turno % 2 == 0) {
						if (tablero.getTablero()[numeroX][numeroY].getColor() == "negro") {
							color = true;
						}
							if (tablero.getTablero()[numeroX][numeroY].getColor() == "blanco") {
								System.out.println("La ficha seleccionada es blanca");
								System.out.println("es el turno de las negras");
								color=false;
							}
							if (tablero.getTablero()[numeroX][numeroY].getColor() == "gris") {
								System.out.println("no hay ficha en esa posicion");
								color=false;
							}
						}
					
				} catch (Exception e) {
					System.out.println("cordenadas incorrectas");
				}
			} while (color == false);

			
			
//mover peon
			if (tablero.getTablero()[numeroX][numeroY].getNombre() == "peon") {
				Peon obj = (Peon) tablero.getTablero()[numeroX][numeroY];
				if (obj.mover(numeroX, numeroY)) {
					System.out.println("pieza movida");
				}else {
					turno--;

				}
			}
//mover alfill
			if (tablero.getTablero()[numeroX][numeroY].getNombre() == "alfil") {
				Alfil obj = (Alfil) tablero.getTablero()[numeroX][numeroY];

				if (obj.mover(numeroX, numeroY)) {
					System.out.println("pieza movida");
				} else {
					turno--;

				}
				
			}
//mover rey
			if (tablero.getTablero()[numeroX][numeroY].getNombre() == "rey") {
				Rey obj = (Rey) tablero.getTablero()[numeroX][numeroY];
				if (obj.mover(numeroX, numeroY)) {
					System.out.println("pieza movida");
				} else {
					turno--;

				}
				
			}
//mover reina
			if (tablero.getTablero()[numeroX][numeroY].getNombre() == "reina") {
				Reina obj = (Reina) tablero.getTablero()[numeroX][numeroY];
				if (obj.mover(numeroX, numeroY)) {
			
					System.out.println("pieza movida");
				} else {
					turno--;

				}
			}
//mover torre
			if (tablero.getTablero()[numeroX][numeroY].getNombre() == "torre") {
				Torre obj = (Torre) tablero.getTablero()[numeroX][numeroY];
				if (obj.mover(numeroX, numeroY)) {
			
					System.out.println("pieza movida");
				} else {
					turno--;

				}
			}
//mover caballo
			if (tablero.getTablero()[numeroX][numeroY].getNombre() == "caballo") {
				Caballo obj = (Caballo) tablero.getTablero()[numeroX][numeroY];
				System.out.println(numeroX);
				System.out.println(numeroY);
				if (obj.mover(numeroX, numeroY)) {
			
					System.out.println("pieza movida");
				} else {
					turno--;

				}
			}
			
//mostrar tablero
			for (int e = 0; e < 8; e++) {
				for (int i = 0; i < 8; i++) {
					if (tablero.getTablero()[i][e].getColor() == "blanco") {
						System.out.print(ANSI_BLACK + "|" + ANSI_ORANGE + BOLD + tablero.getTablero()[i][e].getNombre()
								+ ANSI_BLACK);
						if (tablero.getTablero()[i][e].getNombre().length() == 3) {
							System.out.print("    ");
						}
						if (tablero.getTablero()[i][e].getNombre().length() == 4) {
							System.out.print("   ");
						}
						if (tablero.getTablero()[i][e].getNombre().length() == 5) {
							System.out.print("  ");
						}
						if (tablero.getTablero()[i][e].getNombre().length() == 6) {
							System.out.print(" ");
						}
					}

					if (tablero.getTablero()[i][e].getColor() == "negro") {
						System.out.print(ANSI_BLUE + "|" + BOLD + tablero.getTablero()[i][e].getNombre() + ANSI_BLACK);
						if (tablero.getTablero()[i][e].getNombre().length() == 3) {
							System.out.print("    ");
						}
						if (tablero.getTablero()[i][e].getNombre().length() == 4) {
							System.out.print("   ");
						}
						if (tablero.getTablero()[i][e].getNombre().length() == 5) {
							System.out.print("  ");
						}
						if (tablero.getTablero()[i][e].getNombre().length() == 6) {
							System.out.print(" ");
						}
					}
					if (tablero.getTablero()[i][e].getColor() == "gris") {
						System.out.print(ANSI_BLACK + "|" + tablero.getTablero()[i][e].getNombre() + ANSI_BLACK);
						if (tablero.getTablero()[i][e].getNombre().length() == 3) {
							System.out.print("    ");
						}
						if (tablero.getTablero()[i][e].getNombre().length() == 4) {
							System.out.print("   ");
						}
						if (tablero.getTablero()[i][e].getNombre().length() == 5) {
							System.out.print("  ");
						}
						if (tablero.getTablero()[i][e].getNombre().length() == 6) {
							System.out.print(" ");
						}
					}
					if (i == 7) {
						System.out.println("|\n");
					}
				}
			}
//cambio de turno
		turno++;
//fin partida
		} while (partida);
	}
	public static boolean comprobarRey() {
		boolean bol=false;
		Pieza[][] tabla=tablero.getTablero();
		//tabla es el tablero de seguridad(un paso atras)
		int reyNegroE;
		int reyNegroI;
		int reyBlancoE;
		int reyBlancoI;
		for (int e = 0; e < 8; e++) {
			for (int i = 0; i < 8; i++) {	
			if(tablero.getTablero()[e][i].getNombre()=="rey") {
				if(tablero.getTablero()[e][i].getColor()=="negro") {
					reyNegroE=e;
					reyNegroI=i;
				}
			}
			if(tablero.getTablero()[e][i].getNombre()=="rey") {
				if(tablero.getTablero()[e][i].getColor()=="blanco") {
					reyBlancoE=e;
					reyBlancoI=i;
				}
			}
			}
			//Recoger lista posibles movimientos de cada pieza del otro color
			//comprobar que no cocnida con posicion del rey
			//repetir antes de mover por si dejas a tu rey en jake
			//y despues para avisar dle jacke al enemigo
			
		}
		return bol;
	}
}
