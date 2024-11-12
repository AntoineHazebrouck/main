package antoine;

import java.util.List;

import org.junit.jupiter.api.Test;

import antoine.pojos.Ble;
import antoine.pojos.Produit;
import antoine.pojos.unites.UniteCereale;

public class CamionTest {
	@Test
	public void camion() {
		Camion<UniteCereale> camion = new Camion<>(
			List.of(
				new Ble(100),
				new Ble(200)
			)
		);

		Camion<String> camion2 = new Camion<>(
			List.of(
				new Produit<String>("toto", 200) {},
				new Produit<String>("toto", 300) {}
			)
		);
	}
}
