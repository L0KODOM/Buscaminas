package tarea_buscaminas;

import java.util.Scanner;

public final class Game {
	
	private int tamañoBoard;
	
	private int numMinas;
	
	private Board referencia;
	
	private Board playBoard;
	
	private Player player;
	
	private int intentos;
	
	private ManejadorDeInputs manejadorDeInputs;
	
	private ManejadorDeTablero manejadorDeTablero;
	
	private EstadoDeJuego estado;

	public Game(int tamañoBoard, int numMinas, int intentos) {
		this.numMinas = numMinas;
		this.tamañoBoard = tamañoBoard;
		this.referencia = new Board(tamañoBoard, tamañoBoard, true);
		this.playBoard = new Board(tamañoBoard, tamañoBoard, false);
		this.player = new Player();
		this.intentos = intentos;
		this.manejadorDeInputs = new ManejadorDeInputs(new Scanner(System.in));
		this.manejadorDeTablero = new ManejadorDeTablero(referencia, playBoard, player);
		this.estado = new EstadoDeJuego(intentos, player);
	}
	
	public boolean play() {
		
		boolean end = false;
		
		do {
			createGame();
			
			end = manejadorDeInputs.volverAJugar();
			
		}while(!end);
		
		manejadorDeInputs.close();
		
		System.out.println("\nGracias por jugar!");
		
		return end;
		
	}
	
	private void createGame() {
		
		estado.setIntentos(intentos);
		
		manejadorDeTablero.crearNuevoBoardReferencia(numMinas, tamañoBoard);
		
		boolean end = false;
		
		do {
			System.out.println("Tienes " + estado.getIntentos() + (estado.getIntentos() >1 ? " intentos.\n" : " intento.\n"));
			
			manejadorDeTablero.resetPlayBoard();;
			estado.reset();
			
			startGame();
			
			end = estado.isGameOver();
			
		}while(!end);
	}
	
	private void startGame() {	
		
		boolean end = false;
		
		do {
			int row = -1;
			int col = -1;
			
			boolean correct = false;
			do {
				row = manejadorDeInputs.obtenerValor("fila", tamañoBoard);
				
				col = manejadorDeInputs.obtenerValor("columna", tamañoBoard);
				
				correct = true;
				
			}while(!correct);
			
			Utilidades.clearConsole();
			
			manejadorDeTablero.manejarJugada(row, col);
			
			end = estado.checkFinal(tamañoBoard, numMinas, playBoard.getMinas().size());
			
		}while(!end);
		
	}
	
}
