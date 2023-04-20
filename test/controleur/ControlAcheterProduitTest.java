package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;
	private Village village;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation");
		village = new Village("le village des irreductibles", 10, 2);
		Chef chef = new Chef("Chefff", 10, village);
		village.setChef(chef);
		Gaulois gal = new Gaulois("Asterix", 10);
		village.ajouterHabitant(gal);
		village.installerVendeur(gal, "fruits",10);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		
	}

	@Test
	void testControlAcheterProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,controlTrouverEtalVendeur, village);
		assertNotNull(controlAcheterProduit, "Constructeur ne renvoie pas null");
	}

	@Test
	void testVerifierIdentite() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertTrue(controlPrendreEtal.verifierIdentite("Asterix"));
		assertFalse(controlPrendreEtal.verifierIdentite("Obelix"),"no gaulois");
	
	}

	@Test
	void testChercherProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,controlTrouverEtalVendeur, village);
		assertNotNull(controlAcheterProduit.chercherProduit("fruits"), "il y a des fruits a la marche");
		assertNull(controlAcheterProduit.chercherProduit("rien"), " il existe pas le produit rien");
		
}

	@Test
	void testTrouverEtalProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,controlTrouverEtalVendeur, village);
		assertNotNull(controlAcheterProduit.trouverEtalProduit("Asterix"));
		assertNull(controlAcheterProduit.trouverEtalProduit("O"));
	}

}
