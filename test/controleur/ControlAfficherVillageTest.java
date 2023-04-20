package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private Chef chef;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation");
		village = new Village("le village des irreductibles", 10, 5);
		chef = new Chef("Chefff", 10, village);
		village.setChef(chef);
		
	}
	
	@Test
	void testControlAfficherVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage, "Constructeur ne renvoie pas null");
	}

	@Test
	void testDonnerNomsVillageois() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage.donnerNomsVillageois(), "Constructeur ne renvoie pas null");
	}

	@Test
	void testDonnerNomVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage.donnerNomVillage(), "Constructeur ne renvoie pas null");
	
	}

	@Test
	void testDonnerNbEtals() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage.donnerNbEtals(), "Constructeur ne renvoie pas null");
	
	}

}
