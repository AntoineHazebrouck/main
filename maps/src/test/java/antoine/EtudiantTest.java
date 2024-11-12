package antoine;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

public class EtudiantTest {
	Etudiant ETUDIANT() {
		return new Etudiant(1, "HAZEBROUCK", "Antoine");
	}

	@Test
	public void testAjouterNote() {
		var etu = ETUDIANT();

		assertThat(etu.getNotes()).isEmpty();

		etu.ajouterNote("Math", 1);
		etu.ajouterNote("Math", 11);

		assertThat(etu.getNotes().get("Math")).isEqualTo(List.of(1, 11));
	}

	@Test
	public void testToString() {
		var etu = ETUDIANT();
		etu.ajouterNote("Math", 1);
		etu.ajouterNote("Francais", 2);

		assertThat(etu).hasToString("Etudiant(id=1, nom=HAZEBROUCK, prenom=Antoine, moyenne=1.5)");
	}

	@Test
	public void testAfficheBulletin() {
		var etu = ETUDIANT();
		etu.ajouterNote("Math", 1);
		etu.ajouterNote("Math", 2);
		etu.ajouterNote("Francais", 3);
		etu.ajouterNote("Francais", 4);

		assertThat(etu.afficheBulletin()).isEqualTo("""
				Bulletin :
				Francais -> 3.5
				Math -> 1.5
					""");
	}

	@Test
	public void testCalculMoyenneMatiere() {
		var etu = ETUDIANT();
		etu.ajouterNote("Math", 1);
		etu.ajouterNote("Math", 2);
		etu.ajouterNote("Francais", 3);
		etu.ajouterNote("Francais", 4);

		assertThat(etu.calculMoyenneMatiere("Math")).isEqualTo(1.5);
		assertThat(etu.calculMoyenneMatiere("Francais")).isEqualTo(3.5);
	}

	@Test
	public void testMoyenne() {
		var etu = ETUDIANT();
		etu.ajouterNote("Math", 1);
		etu.ajouterNote("Math", 2);
		etu.ajouterNote("Francais", 3);
		etu.ajouterNote("Francais", 4);

		assertThat(etu.moyenne()).isEqualTo(2.5);
	}

	@Test
	public void comparable() {
		var etu1 = new Etudiant(1, "HAZEBROUCK", "Antoine");
		etu1.ajouterNote("Math", 1);
		etu1.ajouterNote("Francais", 5);
		var etu2 = new Etudiant(2, "HAZEBROUCK", "Kaka");
		etu2.ajouterNote("Math", 1);
		etu2.ajouterNote("Francais", 5);
		var etu3 = new Etudiant(3, "HAZEBROUCK", "Koko");
		etu3.ajouterNote("Math", 1);
		etu3.ajouterNote("Francais", 5);

		var set = new TreeSet<>(List.of(
				etu2, etu1, etu3));

		assertThat(set).containsExactly(etu1, etu2, etu3);
	}

	@Test
	public void comparator() {
		var etu1 = new Etudiant(1, "HAZEBROUCK", "Antoine");
		etu1.ajouterNote("Math", 1);
		etu1.ajouterNote("Francais", 5);
		var etu2 = new Etudiant(2, "HAZEBROUCK", "Kaka");
		etu2.ajouterNote("Math", 1);
		etu2.ajouterNote("Francais", 5);
		var etu3 = new Etudiant(3, "HAZEBROUCK", "Koko");
		etu3.ajouterNote("Math", 1);
		etu3.ajouterNote("Francais", 5);

		Set<Etudiant> set = new TreeSet<>((left, right) -> Integer.compare(right.getId(), left.getId()));
		set.addAll(List.of(etu2, etu1, etu3));

		assertThat(set).containsExactly(etu3, etu2, etu1);
	}
}
