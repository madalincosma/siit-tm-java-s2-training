package ro.tm.siit.homework.w14d2.trainingcatalog.person;

import ro.tm.siit.homework.w14d2.trainingcatalog.Messenger;
import ro.tm.siit.homework.w14d2.trainingcatalog.SiteManagerCatalogInterface;

public class SiteManager extends Person {

	private SiteManagerCatalogInterface siteManagerInterface;

	public SiteManager(String name, String email, SiteManagerCatalogInterface siteManager, Messenger messenger) {
		super(name, email, messenger);
		this.siteManagerInterface = siteManager;
	}

	public void printGrades(String string) {
		siteManagerInterface.printGrades(string);

	}

	public void printCatalog() {
		siteManagerInterface.printCatalog();
	}

}
