package antoine;

import lombok.ToString;

@ToString(callSuper = true)
public class Camion extends Vehicule implements Motorise, Entreprise {
	private final String entreprise;

	public Camion(int vitesseMax, String entreprise) {
		super(vitesseMax);
		this.entreprise = entreprise;
	}

	@Override
	public void remplirReservoir() {
		System.out.println("camion reservoir");
	}

	@Override
	public void roule() {
		System.out.println("camion roule");
	}

	@Override
	public void afficheNomEntreprise() {
		System.out.println(entreprise);
	}

}
