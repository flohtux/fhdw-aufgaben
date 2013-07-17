package viewConstants;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Resources {

	private static final String Resources = "viewResources";

	private static final String BankIcon = Resources + "/bank.gif";

	private static ImageIcon bankIcon;

	//TODO PREREQUISITES: Icon: how to provide icons
	public static Icon getBankIcon() {
		if (bankIcon == null)
			bankIcon = new ImageIcon(getURL(BankIcon));
		return bankIcon;
	}
	private static URL getURL(String path) {
		return Resources.class.getClassLoader().getResource(path);
	}
	private Resources() {
	}

}