/**
 * 
 */
package ro.tm.siit.classroom.w19d2.persons;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author mco
 *
 */
public class Persistence {

	/**
	 * logger for this class
	 */
	public static final Logger LOGGER = Logger.getGlobal();
	
	private Path file = Paths.get("persons.data");	

	public void savePersons(List<Person> persons) {
		try (OutputStream os = Files.newOutputStream(file); 
				ObjectOutputStream oos = new ObjectOutputStream(os)) {
			oos.writeObject(persons);
		} catch (IOException e) {
		}
	}

	public List<Person> loadPersons() {
		List<Person> persons = null;
		if (Files.exists(file)) {
			try (InputStream is = Files.newInputStream(file); 
					ObjectInputStream ois = new ObjectInputStream(is)) {
				persons = (List<Person>) ois.readObject();
			} catch (IOException | ClassNotFoundException e) {
			}
		}
		return persons;
	}

}
