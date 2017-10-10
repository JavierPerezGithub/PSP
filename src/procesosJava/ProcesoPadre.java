package procesosJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class ProcesoPadre {
	public static void main(String[] args) {
	
		Runtime r = Runtime.getRuntime();
		Process p = null;
		
		try {
			p = r.exec("java -jar ProcesoHijo2.jar");
			
			//capturamos el flujo de entrada de datos del proceso hijo
			OutputStream os = p.getOutputStream();
			os.write(" hola amigo\n".getBytes());
			os.flush();
			
			InputStream is = p.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String linea;
			while((linea=br.readLine()) !=null){
				System.out.println(linea);
			}
						
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
