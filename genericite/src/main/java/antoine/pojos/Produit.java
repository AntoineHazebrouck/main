package antoine.pojos;

import lombok.Data;

@Data
public abstract class Produit<T> {
	private final T typeUnite;
	private final int quantite;
}
