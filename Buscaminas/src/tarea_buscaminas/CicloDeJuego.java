package tarea_buscaminas;

import java.util.NoSuchElementException;

public class CicloDeJuego {
	
	private static volatile boolean running = true;
	
	private Game juego;

	public CicloDeJuego(Game juego) {
		this.juego = juego;
	}
	
	public void start() {

		System.out.println("Bienvenido al buscaminas. Presiona Ctrl + C para salir.\n\n");
		
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			running = false;
            System.out.println("El programa se está cerrando...");
        }));

		while(running) {
			try {
				running = !juego.play();
			}catch (NoSuchElementException e) {
                System.out.println("Se cerró la entrada. Saliendo del programa.\n");
                running = false; 
            }
		}
	}
	
	

}
