package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlLibererEtalTest {

	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private Village village;
	
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation");
		Etal etal  = new Etal();
		village = new Village("le village des irreductibles", 10, 2);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		Chef chef = new Chef("Chefff", 10, village);
		village.setChef(chef);
	}

	@Test
	void testControlLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertNotNull(controlLibererEtal,"");
	}

	@Test
	void testIsVendeur() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		Gaulois asterix = new Gaulois("Asterix", 10);
		assertFalse(controlLibererEtal.isVendeur("Asterix"));
		village.ajouterHabitant(asterix);
		village.installerVendeur(asterix, "stuff", 10);
		assertTrue(controlLibererEtal.isVendeur("Asterix"));
	}

	@Test
	void testLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		Gaulois asterix = new Gaulois("Asterix", 10);
		village.ajouterHabitant(asterix);
		assertNull(controlLibererEtal.libererEtal("Asterix"));
		village.installerVendeur(asterix, "stuff", 10);
		assertNotNull(controlLibererEtal.libererEtal("Asterix"));
	}

}
