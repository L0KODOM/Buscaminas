package tarea_buscaminas;

import java.util.ArrayList;

public final class Board {

	private int columns;
	
	private int rows;
	
	private ArrayList<Mina> minas;
	
	private char[][] aspecto;
	
	private boolean referencia;
	
	public Board(int columns, int rows, boolean referencia) {
		this.columns = columns;
		this.rows = rows;
		this.minas = new ArrayList<Mina>();
		this.aspecto = new char[rows][columns];
		this.referencia = referencia;
		crearBoardInicial();
	}
	
	public int getSize() {
		return rows;
	}

	public char[][] getAspecto() {
		return aspecto;
	}
	
	public void modificarAspecto(int row, int col, char symbol) {
		aspecto[row][col] = symbol;
	}
	
	public void reset() {
		minas.clear();
		crearBoardInicial();
	}

	public ArrayList<Mina> getMinas() {
		return minas;
	}
	
	public void addMina(Mina mina) {
		this.minas.add(mina);
	}
	
	public void show() {
		
		System.out.println("");
		for (int i = 0; i < rows; i++) {
		    for (int j = 0; j < columns; j++) {
		    	final int x = i; 
		        final int y = j;
		        minas.stream()
		             .filter(mina -> mina.getPosX() == x && mina.getPosY() == y)
		             .findFirst()  
		             .ifPresent(mina -> aspecto[x][y] = mina.getSymbol());  
		        
		        System.out.print(aspecto[i][j] + " ");
		    }
		    System.out.println();
		}
	}
	
	private void crearBoardInicial() {
		for (int i = 0; i< rows; i++) {
			for (int j = 0; j< columns; j++) {
				aspecto[i][j] = referencia? 'O' : '-';
			}
		}
	}
	
}
