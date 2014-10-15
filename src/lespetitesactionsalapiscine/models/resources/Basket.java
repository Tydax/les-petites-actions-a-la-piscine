package lespetitesactionsalapiscine.models.resources;

/**
 * This class represents a basket containing clothes.
 * @author Armand BOUR
 * @author Antoine PETIT
 *
 */
public class Basket implements Resource {

	@Override
	public String description() {
		return "Basket containing clothes";
	}
}
