package antoine;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Person {
	private final int id;
	private final String nom;
	private final String prenom;

	@JsonCreator
	public Person(
		@JsonProperty("id") int id, 
		@JsonProperty("nom") String nom, 
		@JsonProperty("prenom") String prenom) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}
}
