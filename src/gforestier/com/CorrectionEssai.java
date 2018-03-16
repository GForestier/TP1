package gforestier.com;

import java.util.Scanner;

/**
 * Premi�re classe du programme
 * @author R�becca
 *version 0.0.2
 */
public class CorrectionEssai {

	public static void main(String[] args) {

		// Tableau 2D qui repr�sente les utilisateurs
		Object[][] informationsUtilisateur = new Object [2][4];
		
		// Cr�ation du clavier
		Scanner clavier = new Scanner (System.in);
		
		// Je d�clare sans initialiser 4 variables du m�me type
		String nom, prenom, dateDeNaissance;
		
		// Je fais une boucle pour cr�er mes 2 utilisateurs
		// Je delimitte les bornes de ma boucle ==> [0;2[
		for (int utilisateursCrees = 0; utilisateursCrees < 2; utilisateursCrees++) {
			prenom = recupererPrenom(clavier);
			nom = recupererNom(clavier);
			dateDeNaissance = recupererDate(clavier);
			String  dateAujourdHui = "15/03/2018";
			byte age = calculerAge(dateAujourdHui, dateDeNaissance);
			System.out.println(age);
			
			// Je v�rifie que l'utilisateur est majeur
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
	 * Permet de v�rifier si la personne est majeure
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
	 * Calcule la diff�rence d'ann�e entre 2 dates
	 * @param dateAujourdHuiCopie Objet type de Scanner
	 * @param dateDeNaissanceCopie Objet type de Scanner
	 * @return Age de l'utilisateur
	 */
	private static byte calculerAge(String dateAujourdHuiCopie, String dateDeNaissanceCopie) {
		short anneeDeNaissance = Short.parseShort(dateDeNaissanceCopie.split("/")[2]); // Convertir une chaine de caract�re en short et selectionner uniquement que la derni�re partie du tableau avec split
		short anneeAujourdHui = Short.parseShort(dateAujourdHuiCopie.split("/")[2]);
		return (byte) (anneeAujourdHui - anneeDeNaissance);
	}
	/**
	 * Permet de r�cuperer la date de naissance
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
	 * Permet de r�cuperer un nom
	 * @param clavierCopie Objet type de Scanner
	 * @return Nom de l'utilisateur
	 */
	private static String recupererNom(Scanner clavierCopie) {
		// V�rifier qu'un nom est bien �crit
		boolean verificateur = false;
		String lastName;
		
		// On doit au moins rentrer un fois dans la boucle
		// On boucle tant que le v�rificateur est faux
		do {
			System.out.print("Entrer votre nom : ");
			// Je demande � l'utilisateur de rentrer son nom
			lastName = clavierCopie.nextLine();
			
			if (lastName.length() >= 3) { // Si le nom dispose de 3 lettres minimum
			verificateur = lastName.chars().allMatch(Character::isLetter); // Je v�rifie si le nom est bien compos� de lettre
			
				/*if (verificateur == true) { // J'affiche que le nom est bon
					System.out.println("OK");
					verificateur = true;
				}*/
			}
		} while (verificateur != true);
		return lastName;
	}

	/**
	 * R�cup�rer le pr�nom d'une personne
	 * @param clavierCopie Objet de type Scanner
	 * @return Pr�nom de l'utilisateur
	 */
	static String recupererPrenom(Scanner clavierCopie) {
		
		// V�rifier qu'un pr�nom est bien �crit
		boolean verificateur = false;
		String firstName;
		
		// On doit au moins rentrer un fois dans la boucle
		// On boucle tant que le v�rificateur est faux
		do {
			System.out.print("Entrer votre prenom : ");
			// Je demande � l'utilisateur de rentrer son pr�nom
			firstName = clavierCopie.nextLine();
			
			if (firstName.length() >= 3) { // Si le prenom dispose de 3 lettres minimum
			verificateur = firstName.chars().allMatch(Character::isLetter); // Je v�rifie si le pr�nom est bien compos� de lettre
			
				/*if (verificateur == true) { // J'affiche que le pr�nom est bon
					System.out.println("OK");
					verificateur = true;
				}*/
			}
		} while (verificateur != true);
		

		
		return firstName;
	}
}