package controleur;

import villagegaulois.Village;
import personnages.Gaulois;

public class ControlVerifierIdentite {
	private Village village;

	public ControlVerifierIdentite(Village village) {
		this.village = village;
	}

	public boolean verifierIdentite(String nomVendeur) {
		Gaulois gal = this.village.trouverHabitant(nomVendeur);
		if (gal != null)
			return true;
		return false;
	}
}
