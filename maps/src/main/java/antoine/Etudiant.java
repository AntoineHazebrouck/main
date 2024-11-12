package antoine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.ToString;

@Data
public class Etudiant implements Comparable<Etudiant> {
	private final int id;
	private final String nom;
	private final String prenom;

	@ToString.Exclude
	private final Map<String, List<Integer>> notes;

	public Etudiant(int id, String nom, String prenom) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.notes = new HashMap<>();
	}

	public void ajouterNote(String matiere, int note) {
		if (notes.containsKey(matiere)) {
			notes.get(matiere).add(note);
		} else {
			List<Integer> temp = new ArrayList<>();
			temp.add(note);
			notes.put(matiere, temp);
		}
	}

	public String afficheBulletin() {
		StringBuilder builder = new StringBuilder("Bulletin :\n");
		for (String matiere : notes.keySet()) {
			builder.append(matiere + " -> " + calculMoyenneMatiere(matiere) + "\n");
		}
		return builder.toString();
	}

	public double calculMoyenneMatiere(String matiere) {
		return notes.get(matiere)
				.stream()
				.mapToInt(value -> value)
				.average()
				.getAsDouble();
	}

	@ToString.Include
	public double moyenne() {
		return notes.values().stream()
				.flatMap(list -> list.stream())
				.mapToInt(value -> value)
				.average().getAsDouble();
	}

	@Override
	public int compareTo(Etudiant other) {
		return Integer.compare(this.id, other.id);
	}
}
