package viewConstants;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Resources {

	private static final String Resources = "viewResources";

	private static final String VorlagenIcon = Resources + "/archive.gif";
	private static final String BankIcon = Resources + "/bank.gif";
	private static final String HistorieIcon = Resources + "/exam.gif";
	private static final String KontostandIcon = Resources + "/money.png";
	private static final String LimitsIcon = Resources +"/configure-2.png";

	private static ImageIcon vorlagenIcon;
	private static ImageIcon bankIcon;
	private static ImageIcon historieIcon;
	private static ImageIcon kontostandIcon;
	private static ImageIcon limitsIcon;

	//TODO PREREQUISITES: Icon: how to provide icons
	public static Icon getBankIcon() {
		if (bankIcon == null)
			bankIcon = new ImageIcon(getURL(BankIcon));
		return bankIcon;
	}
	
	public static Icon getHistorieIcon() {
		if (historieIcon == null)
			historieIcon = new ImageIcon(getURL(HistorieIcon));
		return historieIcon;
	}
	
	public static Icon getKontostandIcon() {
		if (kontostandIcon == null)
			kontostandIcon = new ImageIcon(getURL(KontostandIcon));
		return kontostandIcon;
		}
	
	public static Icon getLimitsIcon() {
		if (limitsIcon == null)
			limitsIcon = new ImageIcon(getURL(LimitsIcon));
		return limitsIcon;
		}
	
	public static Icon getVorlagenIcon() {
		if (vorlagenIcon == null)
			vorlagenIcon = new ImageIcon(getURL(VorlagenIcon));
		return vorlagenIcon;
		}
	
	private static URL getURL(String path) {
		return Resources.class.getClassLoader().getResource(path);
	}
	private Resources() {
	}

}