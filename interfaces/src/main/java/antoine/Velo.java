package antoine;

import lombok.ToString;

@ToString(callSuper = true)
public class Velo extends Vehicule {
	public Velo(int vitesseMax) {
		super(vitesseMax);
	}

	@Override
	public void roule() {
		System.out.println("velo roule");
	}

}
