package procesosJava;

import java.io.*;

public class Ejemplo3 {	

		public static void main(String[] args) {
			/**
			 * Modificamos el ejemplo anterior para poder visualizar la informacion
			 * generada por la orden dir
			 **/
			 
			Runtime r = Runtime.getRuntime();
			Process p = null;		
			
			try {
				p = r.exec("cmd /c dir c:\\");
				/*
				 * Con las siguientes tres sentencias capturamos el flujo o stream de datos que genera
				 * el proceso hijo cuando se ejecuta correctamente y creamos un buffer en memoria con dicha información
				 */
				InputStream is = p.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				
				/*
				 * Con las siguientes sentencias, capturamos el flujo o stream de datos que genera
				 * el proceso hijo como mensajes de error.
				 */
				InputStream isError = p.getErrorStream();
				InputStreamReader isrError = new InputStreamReader(isError);
				BufferedReader brError = new BufferedReader(isrError);
				
				
				String linea = br.readLine();
				
				while(linea !=null) {
					System.out.println(linea);
					linea = br.readLine();
				}
				
				String lineaError = brError.readLine();
				
				while(lineaError !=null) {
					System.out.println(lineaError);
					lineaError = brError.readLine();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int exitVal;
			
			try {
				exitVal = p.waitFor();
				System.out.println("Valor de salida: "+exitVal);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}