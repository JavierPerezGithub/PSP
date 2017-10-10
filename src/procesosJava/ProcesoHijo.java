package procesosJava;

import java.util.Scanner;

public class ProcesoHijo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String texto=null;
		System.out.println("Introduzca texto");
		texto = sc.nextLine();		
		System.out.println("El texto es:"+texto.toUpperCase());
		sc.close();
	}
}
