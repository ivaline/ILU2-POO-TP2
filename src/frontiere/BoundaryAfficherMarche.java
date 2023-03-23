package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		if (infosMarche.length == 0) {
			StringBuilder infm = new StringBuilder();
			infm.append("Le marché est vide, revenez plus tard.");
			System.out.println(infm);
		} else {
			StringBuilder infoM = new StringBuilder();
			infoM.append(nomAcheteur + ", vous trouverez au marché :");
			System.out.println(infoM);
			for (int i=0; i<infosMarche.length; i++) {
				String vendeur = infosMarche[i];
				i += 1;
				String quantite = infosMarche[i];
				i += 1;
				String produit = infosMarche[i];

				StringBuilder march = new StringBuilder();
				march.append("- " + vendeur + " qui vend " + quantite + " " + produit);
				System.out.println(march);
			}
		}
	}
	}

