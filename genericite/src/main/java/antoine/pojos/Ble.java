package antoine.pojos;

import antoine.pojos.unites.UniteCereale;

public class Ble extends Produit<UniteCereale> {
	public Ble(int quantite) {
		super(new UniteCereale(), quantite);
	}
}
