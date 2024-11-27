package tarea_buscaminas;

public class Main {
	

	public static void main(String[] args) {
		
		Game game = new Game(8, 6, 3);
		
		CicloDeJuego loop = new CicloDeJuego(game);
		
		loop.start();

	}

}
