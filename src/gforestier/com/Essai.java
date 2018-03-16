package gforestier.com;
/**
 * Première classe du programme
 * @author Gabriel
 * version 0.0.1
 */
import java.util.Scanner;

public class Essai {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner clavier = new Scanner (System.in);
		String nom;
		String prenom;
		String age;
		String date_de_naissance;
		String[] tableau = new String[4];
		int nbpersonne = 0;
		
		do { // faire
			
			System.out.println("Quel est ton nom?"); // Demande du nom
			nom = clavier.nextLine(); // Rentrer le nom
			//System.out.println(nom);
			tableau[0]= nom;
			System.out.println("Quel est ton prénom?"); //Demande du prénom
			prenom = clavier.nextLine(); //Rentrer le prénom
			//System.out.println(prenom);
			tableau[1]= prenom;
			System.out.println("quel est ton age?"); // Demande le l'age
			age = clavier.nextLine(); // Rentrer l'age
			//System.out.println(age);
			tableau[2]= age;
			System.out.println("Quelle est ta date de naissance"); // Demande de la date de naissance
			date_de_naissance = clavier.nextLine(); // Rentrer la date de naissance
			//System.out.println(date_de_naissance);
			tableau[3]= date_de_naissance;
			nbpersonne++; // Incrémenter nb de personne de 1 
			for (String x : tableau) {
				System.out.println(x); // Afficher le tableau
				}
				
				if (Integer.parseInt(age)>=18) { // comparaison de l'age par rapport à 18
					System.out.println(prenom + " " + nom +" est majeur");
				}
					else {
						System.out.println(prenom + " " + nom +  " est mineur");
					}
		} while (nbpersonne < 2); // faire tant que nb personne < 2
		

		
		
			
		}
	}

