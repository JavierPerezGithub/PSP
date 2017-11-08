package procesosJava;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejecuta {	
	
	public static void main(String[] args) {
		
		Runtime r = Runtime.getRuntime();
		Process p = null;
		String linea = null;		
	
		try {
			//Ejecuta el argumento que le pasemos
			p = r.exec(args);
	
			InputStream is = p.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);			
			
			while((linea=br.readLine()) !=null){
				System.out.println(linea);
			}						
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
