package tarea_buscaminas;


public final class Mina {
	
	private int posX;
	
	private int posY;
	
	private char symbol;
	
	public Mina(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		this.symbol = 'X';
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public char getSymbol() {
		return symbol;
	}
	
}
