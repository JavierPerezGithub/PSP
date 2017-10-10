package procesosJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejemplo4 {

	public static void main(String[] args) {
		/*
		 * Hacer una aplicación java que ejecuta otra aplicación java
		 */
		Runtime r = Runtime.getRuntime();
		BufferedReader bf = null;
		try {
			Process p = r.exec("java -jar Ejemplo3.jar");
			
			InputStream is = p.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			bf = new BufferedReader(isr);
			
			String linea = bf.readLine();
			
			while(linea!=null) {
				System.out.println(linea);
				linea = bf.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
}