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
		 * Con el método exec de la clase Runtime ejecutamos un subproceso.
		 * Vamos a ejecutar PalindromoSusana.
		 * Este método exec devolverá un objeto de la clase Process.
		 * A través de este objeto se comunicarán el proceso Padre que es
		 * ProcesoPadre y el proceso hijo ProcesoHijoPalindromo.
		 */
		Scanner sc = new Scanner(System.in);
		String cadena;
		System.out.println("Introduzca cadena");
		cadena = sc.nextLine();
		/*
		 * mediante el método capturamos la entrada estandar del proceso hijo que es el teclado.
		 * A partir de ese momento, los datos que el hijo espera recibir del teclado, ya no los va
		 * a recibir de esa fuente, sino que los recibirá del padre con el método println de la
		 * clase PrintStream, así: ps.println(cadena) y después ps.flush();
		 */
		try {
			p = r.exec("java -jar PalindromoSusana.jar");
			PrintStream ps = new PrintStream(p.getOutputStream());
			/*
			 * Mediante el método getInputStream() capturamos la salida estándar de proceso hijo que
			 * es la pantalla. A partir de este momento lo que el proceso hijo escriba en la pantalla, el 
			 * proceso padre lo recupera con el método readLine() de la clase BufferedReader,asi: 
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
			System.out.println("Finalizando la unión de España según Cristóbal");
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
