package tarea_buscaminas;

import java.util.ArrayList;
import java.util.HashSet;

public final class ManejadorDeTablero {

	private Board referencia;
    private Board playBoard;
    private Player player;

    public ManejadorDeTablero(Board referencia, Board playBoard, Player player) {
        this.referencia = referencia;
        this.playBoard = playBoard;
        this.player = player;
    }
    
    public void crearNuevoBoardReferencia(int numMinas, int tamaño) {
		
		referencia.reset();
		
		HashSet<ArrayList<Integer>> posicionesDeMinas = Utilidades.crearPosicionesDeMinas(numMinas, tamaño);
		
		addMinasToBoard(posicionesDeMinas);
		
	}
    
    public void addMinasToBoard(HashSet<ArrayList<Integer>> posicionesDeMinas) {
		
		for (ArrayList<Integer> posicion : posicionesDeMinas) {
			Mina mina = new Mina(posicion.get(0), posicion.get(1));
			
			referencia.addMina(mina);
		}
	}
    
    public void manejarJugada(int row, int col) {
		
		
		for (int [] posicion : Utilidades.posicionesAfectadas(row, col)) {
			
			int fallos = 0;
			
			for (Mina mina : referencia.getMinas()) {
				
				if (mina.getPosX() == posicion[0] && mina.getPosY()== posicion[1]) {
					Mina minaDescubierta = new Mina(posicion[0], posicion[1]);
					playBoard.addMina(minaDescubierta);
					fallos++;
				}
			}
			
			manejarCambiosEnBoard(posicion[0], posicion[1], fallos);
		}
		
		playBoard.show();
		
	}	
	
	public void manejarCambiosEnBoard(int row, int col, int fallos) {
		
		if ( validarDatos(row) && validarDatos(col) ) {
			
			if (fallos == 0 && playBoard.getAspecto()[row][col] == '-') {
				player.setAciertos(player.getAciertos() + 1);
			}
			
			char posicionSeleccionada = referencia.getAspecto()[row][col];
			
			playBoard.modificarAspecto(row, col, posicionSeleccionada);
		}
	}
	
	private boolean validarDatos(int dato) {
        return dato >= 0 && dato < referencia.getSize(); 
    }
	
	public void resetPlayBoard() {
		playBoard.reset();
	}
}
