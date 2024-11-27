package tarea_buscaminas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public final class Utilidades {
	
	private Utilidades() {} 

    public static HashSet<ArrayList<Integer>> crearPosicionesDeMinas(int numeroMinas, int tamaño) {
        Random random = new Random();
        HashSet<ArrayList<Integer>> minaPositions = new HashSet<>();

        while (minaPositions.size() < numeroMinas) {
            ArrayList<Integer> position = new ArrayList<>();
            position.add(random.nextInt(tamaño));  // X
            position.add(random.nextInt(tamaño));  // Y
            minaPositions.add(position);
        }

        return minaPositions;
    }

    public static int[][] posicionesAfectadas(int row, int col) {
        return new int[][]{
            {row, col},
            {row + 1, col + 1},
            {row - 1, col - 1},
            {row + 1, col - 1},
            {row - 1, col + 1},
            {row + 1, col},
            {row - 1, col},
            {row, col + 1},
            {row, col - 1}
        };
    }
    
	public static void clearConsole() { // Limpiar la consola de windows
	    try {
	        if (System.getProperty("os.name").contains("Windows")) {
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        } else {
	            new ProcessBuilder("clear").inheritIO().start().waitFor();
	        }
	    } catch (IOException | InterruptedException e) {
	        e.printStackTrace();
	    }
	}

}
