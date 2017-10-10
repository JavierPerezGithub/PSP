package procesosJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class Mayusculas {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Runtime r = Runtime.getRuntime();
		
		try {			
			//capturamos el flujo de entrada de datos del proceso hijoh		
			
			for (int i = 0; i < 2; i++) {
				Process p = null;
				String texto=null;
				p = r.exec("java -jar MayusHijo2.jar");
				texto =sc.nextLine()+"\n";
				OutputStream os =null;
				enviaFlujo(p, texto, os);
				InputStream is = p.getInputStream();
				InputStreamReader isr = null;
				BufferedReader br = null;
				recibeFlujo(p,is,isr,br);
			}						
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void recibeFlujo(Process p, InputStream is, InputStreamReader isr, BufferedReader br) throws IOException {
		
		isr = new InputStreamReader(is);
		br = new BufferedReader(isr);			
		String linea;
		while((linea=br.readLine()) !=null){				
			System.out.println(linea);				
		}
	}
	private static void enviaFlujo(Process p, String texto, OutputStream os) throws IOException {
		os = p.getOutputStream();
		os.write(texto.getBytes());
		os.flush();
	}
}