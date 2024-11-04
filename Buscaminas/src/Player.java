package tarea_buscaminas;

public final class Player {
	
	private int aciertos; 
	
	private boolean ganador;

	public Player() {
		this.aciertos = 0;
		this.ganador = false;
	}

	public int getAciertos() {
		return aciertos;
	}

	public void setAciertos(int aciertos) {
		this.aciertos = aciertos;
	}

	public boolean isGanador() {
		return ganador;
	}

	public void setGanador(boolean ganador) {
		this.ganador = ganador;
	}

	public boolean checkWin(int casillasLimpias) {
		if (aciertos == casillasLimpias) {
			ganador = true;
			return true;
		}
		return false;
	}
}
