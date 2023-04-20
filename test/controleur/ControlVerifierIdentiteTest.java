package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private Village village;
	private Gaulois gal;
	private Chef chef;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation");
		village = new Village("le village des irreductibles", 10, 5);
		chef = new Chef("Chefff", 10, village);
		village.setChef(chef);
		gal = new Gaulois("galll", 10);
		village.ajouterHabitant(gal);
		
	}
	
	@Test
	void testControlVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		assertNotNull(controlVerifierIdentite, "Constructeur ne renvoie pas null");
	}

	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		assertTrue(controlVerifierIdentite.verifierIdentite("Chefff"));
		assertFalse(controlVerifierIdentite.verifierIdentite("existe pas"));
		assertTrue(controlVerifierIdentite.verifierIdentite("galll"));
	}

}
