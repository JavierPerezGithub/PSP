package procesosJava;

import java.util.Scanner;

public class ProcesoHijo2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String cadena;
		cadena = sc.nextLine();
		while(!cadena.equals("fin")) {
			System.out.println("Hijo: " + cadena.toUpperCase());
			cadena = sc.nextLine();
		}
	}
}