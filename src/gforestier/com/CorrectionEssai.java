package gforestier.com;

import java.util.Scanner;

/**
 * Première classe du programme
 * @author Rébecca
 *version 0.0.2
 */
public class CorrectionEssai {

	public static void main(String[] args) {

		// Tableau 2D qui représente les utilisateurs
		Object[][] informationsUtilisateur = new Object [2][4];
		
		// Création du clavier
		Scanner clavier = new Scanner (System.in);
		
		// Je déclare sans initialiser 4 variables du même type
		String nom, prenom, dateDeNaissance;
		
		// Je fais une boucle pour créer mes 2 utilisateurs
		// Je delimitte les bornes de ma boucle ==> [0;2[
		for (int utilisateursCrees = 0; utilisateursCrees < 2; utilisateursCrees++) {
			prenom = recupererPrenom(clavier);
			nom = recupererNom(clavier);
			dateDeNaissance = recupererDate(clavier);
			String  dateAujourdHui = "15/03/2018";
			byte age = calculerAge(dateAujourdHui, dateDeNaissance);
			System.out.println(age);
			
			// Je vérifie que l'utilisateur est majeur
			verifierMajorite(nom, prenom, age);
			
			// J'initialise le tableau en fonction de l'utilisateur
			informationsUtilisateur[utilisateursCrees][0] = nom;
			informationsUtilisateur[utilisateursCrees][1] = prenom;
			informationsUtilisateur[utilisateursCrees][2] = dateDeNaissance;
			informationsUtilisateur[utilisateursCrees][3] = age;
			
			
		}
		afficherTableau2D(informationsUtilisateur);
	}
	private static void afficherTableau2D(Object[][] informationsUtilisateur) {
		for (int index = 0; index < informationsUtilisateur.length; index++) {
			for (Object information : informationsUtilisateur[index]) {
				System.out.println(information);
			}
		}
	}
	/**
	 * Permet de vérifier si la personne est majeure
	 * @param nom
	 * @param prenom
	 * @param age
	 */
	private static void verifierMajorite(String nom, String prenom, byte age) {
		if (age < 18) {
			System.out.println(prenom + " " + nom + " est mineur");
		}
			else {

			System.out.println(prenom + " " + nom + " est majeur");
		}
	}
	/**
	 * Calcule la différence d'année entre 2 dates
	 * @param dateAujourdHuiCopie Objet type de Scanner
	 * @param dateDeNaissanceCopie Objet type de Scanner
	 * @return Age de l'utilisateur
	 */
	private static byte calculerAge(String dateAujourdHuiCopie, String dateDeNaissanceCopie) {
		short anneeDeNaissance = Short.parseShort(dateDeNaissanceCopie.split("/")[2]); // Convertir une chaine de caractère en short et selectionner uniquement que la dernière partie du tableau avec split
		short anneeAujourdHui = Short.parseShort(dateAujourdHuiCopie.split("/")[2]);
		return (byte) (anneeAujourdHui - anneeDeNaissance);
	}
	/**
	 * Permet de récuperer la date de naissance
	 * @param clavierCopie Objet type de Scanner
	 * @return Date de naissance de l'utilisateur
	 */
	private static String recupererDate(Scanner clavierCopie) {
		String date;
		
			System.out.println("Entrer votre date de naissance xx/xx/xxxx");
			date = clavierCopie.nextLine();
			
		return date;
	}

	/**
	 * Permet de récuperer un nom
	 * @param clavierCopie Objet type de Scanner
	 * @return Nom de l'utilisateur
	 */
	private static String recupererNom(Scanner clavierCopie) {
		// Vérifier qu'un nom est bien écrit
		boolean verificateur = false;
		String lastName;
		
		// On doit au moins rentrer un fois dans la boucle
		// On boucle tant que le vérificateur est faux
		do {
			System.out.print("Entrer votre nom : ");
			// Je demande à l'utilisateur de rentrer son nom
			lastName = clavierCopie.nextLine();
			
			if (lastName.length() >= 3) { // Si le nom dispose de 3 lettres minimum
			verificateur = lastName.chars().allMatch(Character::isLetter); // Je vérifie si le nom est bien composé de lettre
			
				/*if (verificateur == true) { // J'affiche que le nom est bon
					System.out.println("OK");
					verificateur = true;
				}*/
			}
		} while (verificateur != true);
		return lastName;
	}

	/**
	 * Récupérer le prénom d'une personne
	 * @param clavierCopie Objet de type Scanner
	 * @return Prénom de l'utilisateur
	 */
	static String recupererPrenom(Scanner clavierCopie) {
		
		// Vérifier qu'un prénom est bien écrit
		boolean verificateur = false;
		String firstName;
		
		// On doit au moins rentrer un fois dans la boucle
		// On boucle tant que le vérificateur est faux
		do {
			System.out.print("Entrer votre prenom : ");
			// Je demande à l'utilisateur de rentrer son prénom
			firstName = clavierCopie.nextLine();
			
			if (firstName.length() >= 3) { // Si le prenom dispose de 3 lettres minimum
			verificateur = firstName.chars().allMatch(Character::isLetter); // Je vérifie si le prénom est bien composé de lettre
			
				/*if (verificateur == true) { // J'affiche que le prénom est bon
					System.out.println("OK");
					verificateur = true;
				}*/
			}
		} while (verificateur != true);
		

		
		return firstName;
	}
}