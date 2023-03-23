package frontiere;

import java.util.Scanner;
import villagegaulois.Village;
import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (controlPrendreEtal.verifierIdentite(nomVendeur)) {
			StringBuilder estvendeur = new StringBuilder();
			estvendeur.append("Bonjour ");
			estvendeur.append(nomVendeur);
			estvendeur.append(", je vais regarder si je peux vous trouver un étal");
			System.out.println(estvendeur);
			if (controlPrendreEtal.resteEtals()) {
				installerVendeur(nomVendeur);

			}

			else {
				StringBuilder pasEtals = new StringBuilder();
				pasEtals.append("Desolee ");
				pasEtals.append(nomVendeur);
				pasEtals.append("je n'ai plus d'etal qui ne sont pas deja occupee.");
				System.out.println(pasEtals);
			}
		} else {
			StringBuilder pasvendeur = new StringBuilder();
			pasvendeur.append("Je suis desolée ");
			pasvendeur.append(nomVendeur);
			pasvendeur.append(" mais il faut être un habitant de notre village pour commercer ici");
			System.out.println(pasvendeur);
		}
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder installer = new StringBuilder();
		installer.append("C'est parfait, il me reste un étal\r\n");
		installer.append("pour vous !\r\n");
		installer.append("Il me faudrait quelques\r\n");
		installer.append("renseignements :\r\n Quel produit souhaitez-vous vendre ?");
		System.out.println(installer);
		String produit = scan.next();
		int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?\r\n");
		int nbEtal;
		nbEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		StringBuilder etal = new StringBuilder();
		etal.append("Le vendeur");
		etal.append(nomVendeur);
		etal.append("s'est inctalle a l'etal n*");
		etal.append(nbEtal);
		System.out.println(etal);
	}
}
