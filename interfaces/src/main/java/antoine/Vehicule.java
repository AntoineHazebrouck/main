package antoine;

import lombok.ToString;

@ToString
public abstract class Vehicule {
	private final int vitesseMax;

	public Vehicule(int vitesseMax) {
		this.vitesseMax = vitesseMax;
	}

	public int getVitesseMax() {
		return vitesseMax;
	}

	public abstract void roule();
}
