package procesosJava;

import java.io.IOException;

public class Ejemplo2 {

	public static void main(String[] args) {
		/**
		 * Ejemplo ejecución orden DIR
		 */
		/*
		 * Vamos a crear un subproceso que ejecute la orden dir
		 */
		Runtime r = Runtime.getRuntime();
		Process p = null;
		
		/*
		 * Usamos el comando cmd para ejecutar dir porque este comando
		 * no dispone de fichero ejecutable
		 */
		
		try {
			p = r.exec("cmd /c dir");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int exitVal;
		/*
		 * El método waitFor hace que el padre espere a que el proceso hijo termine
		 * su ejecución y devuelve un valor entero que indica 0 si el hijo se ha ejecutado
		 * correctamente, 1 si no se ha ejecutado correctamente.
		 */
		try {
			exitVal = p.waitFor();
			System.out.println("Valor de salida: "+exitVal);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * El proceso cmd se ha ejecutado correctamente pero nuestra aplicación no muestra el
		 * resultado: la ejecución de la orden dir en pantalla. Esto es debido a que los
		 * subprocesos no pueden mostrar informacion en pantalla ni recibir datos del teclado.
		 */
		
	}
}