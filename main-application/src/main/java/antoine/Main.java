package antoine;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
	public static void main(String[] args) throws JsonProcessingException {
		person();
		persons();
	}

	static void person() throws JsonProcessingException {
		var person = new Person(1, "Hazebrouck", "Antoine");
		String inputPerson = "{\"id\":1,\"nom\":\"Hazebrouck\",\"prenom\":\"Antoine\"}";

		String asJson = new ObjectMapper().writeValueAsString(person);
		var asObject = new ObjectMapper().readValue(inputPerson, Person.class);

		System.out.println("object as json : " + asJson);
		System.out.println("json as object : " + asObject);
	}

	static void persons() throws JsonProcessingException {
		var persons = List.of(
				new Person(1, "Hazebrouck", "Antoine"),
				new Person(2, "Hazebrouck", "Victor"),
				new Person(3, "Hazebrouck", "Gouguaqsd"));
		String asJson = new ObjectMapper().writeValueAsString(persons);
		System.out.println("object as json : " + asJson);

		String inputPersons = "[{\"id\":1,\"nom\":\"Hazebrouck\",\"prenom\":\"Antoine\"},{\"id\":2,\"nom\":\"Hazebrouck\",\"prenom\":\"Victor\"},{\"id\":3,\"nom\":\"Hazebrouck\",\"prenom\":\"Gouguaqsd\"}]";
		var asObjects = new ObjectMapper().readValue(inputPersons, new TypeReference<List<Person>>() {});

		System.out.println("json as object : " + asObjects);
	}
}