package palindromo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class PalindromosPSP {
/*
 * Crear una aplicación que solicite al usuario cadenas de texto. Tendrá que utilizar la funcionalidad de otro
 *  proceso que lee cadenas de texto y muestra en pantalla si son palíndromo o si son números capicúas. 
Ejemplo de ejecución del proceso padre;
Hola
No es un palíndromo
Ana
Es un palíndromo
121
Es capicúa
115 
No es capicúa
 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Runtime rt = Runtime.getRuntime();
		Process p = null;
		String linea;

		try {
			p = rt.exec("java -jar PalindromoPSPHijo.jar");
			InputStream is = p.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			OutputStream os = p.getOutputStream();
			System.out.print("Padre: ");
			linea = sc.nextLine() + "\n";

			while (!linea.equalsIgnoreCase("fin\n")) {
				
				os.write(linea.getBytes());
				os.flush();
				System.out.println(br.readLine());
				System.out.print("Padre: ");
				linea = sc.nextLine() + "\n";
			}
			br.close();
			sc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
