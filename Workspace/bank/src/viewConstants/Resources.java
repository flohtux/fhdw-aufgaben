package viewConstants;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Resources {

	private static final String Resources = "viewResources";

	private static final String BankIcon = Resources + "/bank.gif";
	private static final String KontostandIcon = Resources + "/money.png";

	private static ImageIcon bankIcon;
	private static ImageIcon kontostandIcon;

	//TODO PREREQUISITES: Icon: how to provide icons
	public static Icon getBankIcon() {
		if (bankIcon == null)
			bankIcon = new ImageIcon(getURL(BankIcon));
		return bankIcon;
	}
	
	public static Icon getKontostandIcon() {
		if (kontostandIcon == null)
			kontostandIcon = new ImageIcon(getURL(KontostandIcon));
		return kontostandIcon;
		}
	private static URL getURL(String path) {
		return Resources.class.getClassLoader().getResource(path);
	}
	private Resources() {
	}

}