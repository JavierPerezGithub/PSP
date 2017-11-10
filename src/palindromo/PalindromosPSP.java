package palindromo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class PalindromosPSP {
/*
 * Crear una aplicaci�n que solicite al usuario cadenas de texto. Tendr� que utilizar la funcionalidad de otro
 *  proceso que lee cadenas de texto y muestra en pantalla si son pal�ndromo o si son n�meros capic�as. 
Ejemplo de ejecuci�n del proceso padre;
Hola
No es un pal�ndromo
Ana
Es un pal�ndromo
121
Es capic�a
115 
No es capic�a
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
