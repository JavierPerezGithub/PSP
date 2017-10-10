package procesosJava;

import java.io.*;

public class Ejemplo5 {

	public static void main(String[] args) {
		/*
		 * Vamos a crear un subproceso que ejecute la orden date.
		 * Este comando solicita al usuario un dato desde el teclado y muestra la
		 * informacion en pantalla
		 */
		
		Runtime r = Runtime.getRuntime();
		Process p =null;
		BufferedReader bf = null;
		try {
			p = r.exec("cmd /c date");
			
			InputStream is = p.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			bf = new BufferedReader(isr);
			
			InputStream iserror = p.getErrorStream();
			InputStreamReader isrerror = new InputStreamReader(iserror);
			BufferedReader brerror = new BufferedReader(isrerror);
			
			/*
			 * vamos a enviar datos al proceso hijo desde el proceso padre, para ello
			 * capturamos el flujo de datos de entrada del proceso hijo
			 */
			
			OutputStream os = p.getOutputStream();
			os.write("04/10/2017\n".getBytes());
			os.flush();
			
			String linea = bf.readLine();
			while(linea !=null) {
				System.out.println(linea);
				linea = bf.readLine();
			}
			linea = brerror.readLine();
			while(linea !=null) {
				System.out.println(linea);
				linea = brerror.readLine();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
	}
}
