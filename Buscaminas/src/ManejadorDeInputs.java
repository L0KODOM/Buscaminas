package tarea_buscaminas;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class ManejadorDeInputs {
	
	private Scanner sc;

    public ManejadorDeInputs(Scanner sc) {
        this.sc = sc;
    }
    
    
    public int obtenerValor(String palabra, int tamañoBoard) {
		
	    int valor = -1;
	    boolean valorCorrecto = false;

	    do {
	        try {
	            valor = manejarIntroduccionDatos(palabra, tamañoBoard);

	            valorCorrecto= validarDatos(valor, true, tamañoBoard);
	            
	        } catch (InputMismatchException e) {
	            System.out.println("Por favor introduce un número válido.\n");
	            sc.nextLine(); 
	        }
	    } while (!valorCorrecto);

	    return valor;
	}
    
    private int manejarIntroduccionDatos(String palabra, int tamañoBoard) {
		
		System.out.println("\nIntroduce una "+ palabra +" (del 1 al " + tamañoBoard+ "): ");
		int val = sc.nextInt() -1;
		sc.nextLine();
		
		return val;
	}
    
    private boolean validarDatos(int dato, boolean usoParaIntroduccion, int tamañoBoard) {
		if (dato <0 || dato >= tamañoBoard ) {
			if (usoParaIntroduccion){
				System.out.println("Por favor, introduce un número válido.\n");
			}
			return false;
		}
		return true;
	}
    
    public boolean volverAJugar() {
		

		boolean respondido = false;
		
		boolean end = false;
		do {
			System.out.println("¿Quieres volver a jugar?");
			String respuesta = sc.nextLine();
			
			if (respuesta.equalsIgnoreCase("si") || respuesta.equalsIgnoreCase("no")) {
				end = respuesta.equalsIgnoreCase("si")? false : true;
				respondido = true;
			}
			else {
				System.out.println("Por favor responde si o no");
			}
		}while(!respondido);
		
		return end;
	}
    
    public void close() {
    	sc.close();
    }

}
