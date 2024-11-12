package antoine;

import lombok.ToString;

@ToString(callSuper = true)
public class Voiture extends Vehicule implements Motorise {
	private final boolean sport;

	public Voiture(int vitesseMax, boolean sport) {
		super(vitesseMax);
		this.sport = sport;
	}

	public boolean isSport() {
		return sport;
	}

	@Override
	public void roule() {
		System.out.println("voiture roule");
	}

	@Override
	public void remplirReservoir() {
		System.out.println("voiture reservoir");
	}
}
