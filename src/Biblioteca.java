import java.util.Scanner;

	/*
	*
	* @author David Torralbo
	* 
	* Fes un programa que et demani quants llibres vols entrar i després entris la informació d'aquests llibres.
	* Un llibre està format de : Titol (String), Autor (String), ISBN (double), Pagines (int), Tipus (infantil/juvenil/adult/totes les edats)
	*
	* Un cop s'hagin entrat els llibres ha de sortir un menú. 
	* Una opció donarà la informació de tots els llibres que s'han entrat, 
	* la segona opció permetrà cercar un llibre segons una part del títol i donarà la informació dels llibres que hi concordin. 
	* La tercera opció permetrà sortir del programa.
	* 
	*/

class Llibre {
	String titol;
	String autor;
	double isbn;
	int pagines;
	String tipus;
	//Constructor de la classe
	public Llibre(String titol, String autor, double isbn, int pagines, String tipus) {
		this.titol = titol;
		this.autor = autor;
		this.isbn = isbn;
		this.pagines = pagines;
		this.tipus = tipus;
	}
}


public class Biblioteca {

	public static void main(String[] args) {
		
		//declarem variables
		int llibresaRegistrar = 0, i, menu;
		boolean fi = true;
		String cerca;
		
		//variables que utilitzarem per entrar dades dins Scanner.
		String titol, autor, tipus;
		double isbn;
		int pagines;
		
		//Creem objecte scanner
		Scanner sc = new Scanner(System.in);
		
		//Entrem una frase
		System.out.print("Benvingut/da a la biblioteca! Quants llibres vol registrar?: ");
		//Comprovem que s'entra un nombre enter
		
		//iniciem un bucle que seguirà fins que fi sigui true.
		do {
			//si les dades són int...
        if(sc.hasNextInt()){
    		llibresaRegistrar = sc.nextInt();
	        fi = false;
        }else{
            sc.nextLine();
            System.out.println("\nSi us plau, entra un valor enter més gran que zero.");
    		System.out.print("Benvingut/da a la biblioteca! Quants llibres vol registrar?: ");
        }
		} while(fi);
		
		//demanem línia nova
		sc.nextLine();


		//creem un array per guardar tots els llibres que entrem
		Llibre[] llibres = new Llibre[llibresaRegistrar];
		
		for (i = 0; i < llibresaRegistrar; i++) {
			
            System.out.print("Escriu el titol del llibre "+(i+1)+": ");
            
            titol = sc.nextLine();
            
            System.out.print("Escriu l'autor del llibre "+(i+1)+": ");
            
            //afegim l'autor.
            autor = sc.nextLine();
            
            System.out.print("Escriu l'ISBN del llibre "+(i+1)+": ");
            
            //afegim isbn.
            isbn = sc.nextDouble();
            
            System.out.print("Escriu el nombre de pàgines del llibre "+(i+1)+": ");
            
            //afegim nombre de pagines.
            pagines = sc.nextInt();
            //demanem línia nova.
            sc.nextLine();
            System.out.print("Escriu el tipus de llibre "+(i+1)+": ");
            
            //afegim tipus de llibre.
            tipus = sc.nextLine();
           
            
            //ingressem dins l'array un nou objecte Llibre.
            llibres[i] = new Llibre(titol, autor, isbn, pagines, tipus);
            
            System.out.print("\n");
		}
		
		//donem a escollir la opció del menú
		System.out.print("** MENÚ **\rEscrigui 1 per a veure la informació de tots els llibres ingressats.\rEscrigui 2 per a cercar un llibre mitjançant un títol o part d'ell\rEscrigui 3 per a sortir del programa.\r\rOpció: ");
        
        //afegim nombre de pagines.
        menu = sc.nextInt();
		
        //executem el menú segons l'opció triada.
		switch(menu){
		case 1: 
				//imprimim tots els llibres entrats.
				for (i = 0; i < llibresaRegistrar; i++) {
			        System.out.println("El titol del llibre "+(i+1)+" és: "+llibres[i].titol);
			        System.out.println("L'autor del llibre "+(i+1)+" és: "+llibres[i].autor);
			        System.out.println("L'ISBN del llibre "+(i+1)+" és: "+llibres[i].isbn);
			        System.out.println("Les pagines del llibre "+(i+1)+" és: "+llibres[i].pagines);
			        System.out.println("El tipus de llibre "+(i+1)+" és: "+llibres[i].tipus);
			        System.out.println("");
				}
				break;
				
		case 2: 
			
				//cerquem el titol mitjançant un string que escriurem...
				System.out.print("Cerqui un llibre a partir d'un títol o una part que coincideixi amb el mateix: ");
				cerca = sc.next();
				cerca = cerca+sc.nextLine();
			
				//imprimim tots els llibres entrats.
				for (i = 0; i < llibresaRegistrar; i++) {
					
					if (llibres[i].titol.contains(cerca)){
			        System.out.println("\rEl titol del llibre "+(i+1)+" és: "+llibres[i].titol);
			        System.out.println("L'autor del llibre "+(i+1)+" és: "+llibres[i].autor);
			        System.out.println("L'ISBN del llibre "+(i+1)+" és: "+llibres[i].isbn);
			        System.out.println("Les pagines del llibre "+(i+1)+" és: "+llibres[i].pagines);
			        System.out.println("El tipus de llibre "+(i+1)+" és: "+llibres[i].tipus);
			        System.out.println("");
					}
				}
				break;
				
		case 3: 
				System.out.println("Gràcies per utilitzar aquest programa. Fins aviat!");
				//Sortim del programa
				System.exit(0);
				break;
		}
		
	}

}