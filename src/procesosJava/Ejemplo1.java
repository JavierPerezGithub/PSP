package procesosJava;

import java.io.IOException;

public class Ejemplo1 {

	public static void main(String[] args) {
		/*Esto sirve para ejecutar otra aplicacion desde tu aplicación Java.
		 * Vamos a iniciar un subproceso para ejecutar la aplicación notepad.
		 * Mediante la clase Runtime podemos crear subprocesos
		 */
		Runtime r = Runtime.getRuntime();
		Process p = null;
		Process p2 = null;
		/*
		 * 
		 */
		try {
			p= r.exec("notepad");
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*
		 * Usamos la clase ProcessBuilder para crear un segundo subproceso
		 */
		//ProcessBuilder pb = new ProcessBuilder("C:\\Windows\\system32\\mspaint.exe");
		/*
		 * cuidado con los nombres que no tienen por qué coincidir con el del acceso directo.
		 */
		ProcessBuilder pb = new ProcessBuilder("mspaint");
		
		try {
			p2 = pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}