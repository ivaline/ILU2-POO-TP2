package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	private Village village;
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation");
		village = new Village("le village des irreductibles", 10, 2);
		Chef chef = new Chef("Chefff", 10, village);
		village.setChef(chef);

	}


	@Test
	void testControlTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		assertNotNull(controlTrouverEtalVendeur, "Constructeur ne renvoie pas null");
	}

	@Test
	void testTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		Gaulois gal = new Gaulois("Asterix", 10);
		village.ajouterHabitant(gal);
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("Asterix"), "Asterix n'est pas enccore un vendeur");
		village.installerVendeur(gal, "fruits",10);
		assertNotNull(controlTrouverEtalVendeur.trouverEtalVendeur("Asterix"), "Asterix est un vendeur");
	}

}
