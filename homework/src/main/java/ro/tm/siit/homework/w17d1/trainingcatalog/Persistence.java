/**
 * 
 */
package ro.tm.siit.homework.w17d1.trainingcatalog;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

import ro.tm.siit.homework.w17d1.trainingcatalog.catalog.Catalog;

/**
 * @author mco
 *
 */
public class Persistence {

	/**
	 * logger for this class
	 */
	public static final Logger LOGGER = Logger.getGlobal();
	
	private Path file = Paths.get("catalog.data");	

	public void saveCatalog(Catalog catalog) {
		LOGGER.fine("started saving catalog " + catalog + " to file " + file);
		try (OutputStream os = Files.newOutputStream(file); 
				ObjectOutputStream oos = new ObjectOutputStream(os)) {
			oos.writeObject(catalog);
			LOGGER.info("catalog saved: " + catalog);
		} catch (IOException e) {
			LOGGER.warning("problem saving catalog data " + e.getMessage());
		}
	}

	public Catalog loadCatalog() {
		LOGGER.fine("started loading catalog from file " + file);
		Catalog catalog = null;
		if (Files.exists(file)) {
			try (InputStream is = Files.newInputStream(file); 
					ObjectInputStream ois = new ObjectInputStream(is)) {
				catalog = (Catalog) ois.readObject();
				LOGGER.info("catalog loaded: " + catalog);
			} catch (IOException e) {
				LOGGER.warning("problem loading catalog data " + e.getMessage());
			} catch (ClassNotFoundException e) {
				LOGGER.warning("problem loading catalog data " + e.getMessage());
			}
		}
		return catalog;
	}

}
