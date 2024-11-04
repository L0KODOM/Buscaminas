package tarea_buscaminas;

import java.io.IOException;

public class EstadoDeJuego {
	
	private int intentos;
	
	private Player player;

	public EstadoDeJuego(int intentos, Player player) {
		this.intentos = intentos;
		this.player = player;
	}
	
	public int getIntentos() {
		return intentos;
	}
	
	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}

	public boolean isGameOver() {
        return intentos < 1 || player.isGanador();
    }
	
	public void reset() {
        player.setAciertos(0);
        player.setGanador(false);
    }

	public boolean checkFinal(int tamaño, int minasTotales, int minasDescubiertas) {
		
		int casillasLimpias = ((tamaño * tamaño) - minasTotales);
		
		if (player.checkWin(casillasLimpias)) {
			System.out.println("Enhorabuena, has ganado!\n");
			return true;
		}
		else if (minasDescubiertas >=1) {
			System.out.println("Lo siento, has perdido\n");
			intentos--;
			if(intentos <1) {
				System.out.println("Se han acabado tus intentos.\n");
			}
			return true;
		}
		return false;
	}

}
