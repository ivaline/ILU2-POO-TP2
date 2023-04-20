package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;
	//private Chef chef;
	//private Gaulois gal;
	
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
		
		
	}

	@Test
	void testControlPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite,village);
		assertNotNull(controlPrendreEtal, "Constructeur ne renvoie pas null");
	}

	@Test
	void testResteEtals() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite,village);
		assertTrue(controlPrendreEtal.resteEtals(), "il reste un");
		Gaulois gal2 = new Gaulois("Obelix", 10);
		village.ajouterHabitant(gal2);
		village.installerVendeur(gal2, "fruits",10);
		assertFalse(controlPrendreEtal.resteEtals(), "il reste rien");
	}

	@Test
	void testPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite,village);
		assertEquals(controlPrendreEtal.prendreEtal("Asterix", "fruits", 6), 1);
		assertNotEquals(controlPrendreEtal.prendreEtal("Obelix", "fruits", 6), 1);
		
	}

	@Test
	void testVerifierIdentite() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertTrue(controlPrendreEtal.verifierIdentite("Asterix"));
		assertFalse(controlPrendreEtal.verifierIdentite("Obelix"),"no gaulois");
	}

}
