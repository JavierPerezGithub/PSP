package palindromoSusana;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class ProcesoPadre {

	public static void main(String[] args) {

		Runtime r = Runtime.getRuntime();
		Process p = null;
		/*
		 * Con el m�todo exec de la clase Runtime ejecutamos un subproceso.
		 * Vamos a ejecutar PalindromoSusana.
		 * Este m�todo exec devolver� un objeto de la clase Process.
		 * A trav�s de este objeto se comunicar�n el proceso Padre que es
		 * ProcesoPadre y el proceso hijo ProcesoHijoPalindromo.
		 */
		Scanner sc = new Scanner(System.in);
		String cadena;
		System.out.println("Introduzca cadena");
		cadena = sc.nextLine();
		/*
		 * mediante el m�todo capturamos la entrada estandar del proceso hijo que es el teclado.
		 * A partir de ese momento, los datos que el hijo espera recibir del teclado, ya no los va
		 * a recibir de esa fuente, sino que los recibir� del padre con el m�todo println de la
		 * clase PrintStream, as�: ps.println(cadena) y despu�s ps.flush();
		 */
		try {
			p = r.exec("java -jar PalindromoSusana.jar");
			PrintStream ps = new PrintStream(p.getOutputStream());
			/*
			 * Mediante el m�todo getInputStream() capturamos la salida est�ndar de proceso hijo que
			 * es la pantalla. A partir de este momento lo que el proceso hijo escriba en la pantalla, el 
			 * proceso padre lo recupera con el m�todo readLine() de la clase BufferedReader,asi: 
			 * br.readLine()
			 */
			BufferedReader br = new BufferedReader
					(new InputStreamReader(p.getInputStream()));
			while(!cadena.equalsIgnoreCase("fin")){
				ps.println(cadena);
				ps.flush();
				System.out.println(br.readLine());
				System.out.println("Introduzca cadena");
				cadena = sc.nextLine();
			}
			System.out.println("Finalizando la uni�n de Espa�a seg�n Crist�bal");
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
