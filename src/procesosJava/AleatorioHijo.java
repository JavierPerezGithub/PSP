package procesosJava;
import java.util.Random;
import java.util.Scanner;

public class AleatorioHijo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String padre = sc.nextLine();
		
		while(!padre.equalsIgnoreCase("fin")){
			Random rand = new Random();
			int randNumber = rand.nextInt(10);
			System.out.println("hijo: "+randNumber);
			padre=sc.nextLine();
			
		}	
		sc.close();
	}
}
