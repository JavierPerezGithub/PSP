package palindromoSusana;

import java.util.Scanner;

public class ProcesoHijoPalindromo {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String linea;
		int numero;
		boolean esPalindromo;
		boolean esNumerico;
		while((linea = sc.nextLine())!=null) {
			esNumerico = false;
			esPalindromo = esPalindromo(linea);
			try {
				numero = Integer.parseInt(linea);
			}catch (NumberFormatException e) {
				esNumerico = true;
			}
			//Imprimimos en pantalla los resultados
			if (esPalindromo) {
				if(esNumerico) {
					System.out.println("Es un palíndromo");
				}else {
					System.out.println("Es capicúa");
				}
			}else {
				if(esNumerico) {
				System.out.println("No es un palíndromo");				
			}else {
				System.out.println("No es capicúa");
			}			
		}
	}
}

	private static boolean esPalindromo(String s) {
		/*
		 * Recorre la cadena mediante un bucle while, para cuando se encuentran dos caracteres diferentes
		 * La variable palindromo acaba tomando el valor true si no se modifica en el bucle
		 */
		
		boolean palindromo = true;
		int i = 0;
		int j = s.length()-1;
		
		while(palindromo && i<j) {
			if(s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			}else {
				palindromo = false;
			}
		return palindromo;
		}
		return false;
		}
		
	}

