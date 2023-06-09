package Clases;

import java.util.LinkedList;

public abstract class tablero {
	static Pieza tablero[][] = new Pieza[8][8];

	
	public static Pieza[][] getTablero() {
		return tablero;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	int turno = 0;

	public static void creartablero() {
		Pieza pie = new Pieza();
		// 8x8 lleno de piezas
		for (int i = 0; i < 8; i++) {
			LinkedList<Pieza> l = new LinkedList<Pieza>();

			for (int e = 0; e < 8; e++) {

				tablero[i][e] = new Pieza();
			}

		}
		// empezamos a crear peones
		for (int i = 0; i < 8; i++) {
			Pieza peonNegro = new Peon();
			Pieza peonBlanco = new Peon();
			peonNegro.setColor("negro");
			peonNegro.setNombre("peon");
			peonBlanco.setColor("blanco");
			peonBlanco.setNombre("peon");
			tablero[i][i].setNombre("nada");
			tablero[i][6] = peonNegro;
			tablero[i][1] = peonBlanco;
		//	tablero[2][2] = peonNegro;
		//	tablero[0][5] = peonBlanco;
		
		}
		// alfiles en su sitio
		Pieza AlfilNegro = new Alfil();
		AlfilNegro.setColor("negro");
		Pieza AlfilBlanco = new Alfil();
		AlfilBlanco.setColor("blanco");
		AlfilNegro.setNombre("alfil");
		AlfilBlanco.setNombre("alfil");
		tablero[2][7] = AlfilNegro;
		tablero[5][7] = AlfilNegro;
		tablero[2][0] = AlfilBlanco;
		tablero[5][0] = AlfilBlanco;
		// caballo en su sitio
		Pieza CaballoNegro = new Caballo();
		CaballoNegro.setColor("negro");
		CaballoNegro.setNombre("caballo");
		Pieza CaballoBlanco = new Caballo();
		CaballoBlanco.setColor("blanco");
		CaballoBlanco.setNombre("caballo");
		tablero[1][7] = CaballoNegro;
		tablero[6][7] = CaballoNegro;
		tablero[1][0] = CaballoBlanco;
		tablero[6][0] = CaballoBlanco;

		// torre en su sitio
		Pieza TorreNegro = new Torre();
		Pieza TorreBlanco = new Torre();
		TorreNegro.setColor("negro");
		TorreNegro.setNombre("torre");
		TorreBlanco.setColor("blanco");
		TorreBlanco.setNombre("torre");
		tablero[0][7] = TorreNegro;
		tablero[7][7] = TorreNegro;
		tablero[0][0] = TorreBlanco;
		tablero[7][0] = TorreBlanco;

		// reyna en su sitio
		Reina ReinaNegro = new Reina();
		Reina ReinaBlanco = new Reina();
		ReinaNegro.setNombre("reina");
		ReinaNegro.setColor("negro");
		ReinaBlanco.setColor("blanco");
		ReinaBlanco.setNombre("reina");
		tablero[3][7] = ReinaNegro;
		tablero[3][0] = ReinaBlanco;

		// rey en su sitio
		Rey ReyNegro = new Rey();
		Rey ReyBlanco = new Rey();
		ReyNegro.setColor("negro");
		ReyNegro.setNombre("rey");
		ReyBlanco.setColor("blanco");
		ReyBlanco.setNombre("rey");
		tablero[4][7] = ReyNegro;
		tablero[4][0] = ReyBlanco;
		tablero[4][6] = ReyBlanco;
		// Visualizar partida
		/*
		 * for(int i=0;i<8;i++) { for(int e=0;e<8;e++) {
		 * System.out.println(tablero.get(i).get(e)); } }
		 */
	}

	public static boolean movimiento(int origenY, int origenX, int destinoY, int destinoX) {
		// 1 para meter pieza
		Pieza p = new Pieza();

		return true;
	}

	public static boolean preguntarPeon(int origenX, int origenY, int destinoX, int destinoY) {

		boolean rsp = false;
		if (tablero[destinoX][destinoY].getNombre() == "nada") {
			System.out.println("puede moverse");
			rsp = true;
		}
		return rsp;
	}

	public static boolean preguntarComerPeon(int origenX, int origenY, int destinoX, int destinoY) {

		boolean rsp = false;
		if (tablero[destinoX][destinoY].getColor() == "negro") {
			rsp = true;
		}
		return rsp;
	}

	public tablero(Pieza tab[][]) {
		super();
		tablero = tab;
	}

	public tablero() {
		super();
	}

}
