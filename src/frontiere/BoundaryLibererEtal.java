package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if (!controlLibererEtal.isVendeur(nomVendeur)) {
			StringBuilder isVend = new StringBuilder();
			isVend.append(" Mais vous n'etes pas inscrit sur notre marche auj! ");
		}
		else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			if (donneesEtal[0] == "true") {
				StringBuilder nbVend = new StringBuilder();
				nbVend.append("Vous avez vendu ");
				nbVend.append(donneesEtal[4]);
				nbVend.append( " sur ");
				nbVend.append(donneesEtal[3]+" ");
				nbVend.append("Vous avez vendu ");
				nbVend.append(donneesEtal[2]+ ".\nAu revoir" +nomVendeur+", passez une bonne journée.");
				donneesEtal[0] = "false";
				System.out.println(nbVend);
			}
	}

}
	}
