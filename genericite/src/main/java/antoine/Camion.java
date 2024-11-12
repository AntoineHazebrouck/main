package antoine;

import java.util.List;

import antoine.pojos.Produit;
import lombok.Data;

@Data
public class Camion<T> {
	private final List<Produit<T>> produits;
}
