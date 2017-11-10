package palindromo;
import java.util.Scanner;

public class PalindromoPSPHijo {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String p= sc.nextLine();
		while(!p.equalsIgnoreCase("fin")){		
			try{
				int n = Integer.parseInt(p);
				metodoCapicua(n);
			}catch(Exception e){
				metodoPalindromo(p);
			}	
			p= sc.nextLine();

		}
		sc.close();
	}

	private static void metodoCapicua(int n) {
		
		int faltante;
		int numeroInvertido;
		int restante;
		  
		faltante=n;
		numeroInvertido=0;
		restante=0;
		   
		while(faltante!=0) {
		        
		restante=faltante%10;
		numeroInvertido=numeroInvertido*10+restante;
		faltante=faltante/10;		   
		}
		if(numeroInvertido==n){
		
			System.out.println("El numero es capicua");    
			}else{		        
		         System.out.println("El numero no es capicua");		   
			}
	}

	private static void metodoPalindromo(String p) {
		int cont=0;	
		for (int i = 0,j=p.length()-1; i < p.length(); i++,j--)
		{
			if(p.toLowerCase().charAt(i)==p.toLowerCase().charAt(j))
			{
				cont++;
			}
		}
		if(cont/2==p.length()/2)
		{
			System.out.println("Palindromo");
		}
		else 
			System.out.println("No es palindromo");		
	}
}