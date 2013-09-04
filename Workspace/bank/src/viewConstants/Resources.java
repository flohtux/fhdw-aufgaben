package viewConstants;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Resources {

	private static final String Resources = "viewResources";

	private static final String BankIcon = Resources + "/bank.gif";
	private static final String HistorieIcon = Resources + "/exam.gif";
	private static final String KontostandIcon = Resources + "/money.png";
	private static final String LimitsIcon = Resources +"/configure-2.png";
	private static final String VorlagenIcon = Resources + "/archive.gif";
	private static final String AccountIcon = Resources + "/user.png";
	private static final String NochNichtErledigteAuftraegeIcon = Resources + "/wait.png";
	private static final String BankAccountIcon = Resources + "/bankAccount.png";
	private static final String RabattIcon = Resources + "/rabatt.png";
	private static final String FixeKostenIcon = Resources + "/fixeKosten.png";

	private static ImageIcon bankIcon;
	private static ImageIcon historieIcon;
	private static ImageIcon kontostandIcon;
	private static ImageIcon limitsIcon;
	private static ImageIcon vorlagenIcon;
	private static ImageIcon accountIcon;
	private static ImageIcon nochNichtErledigteAuftraegeIcon;
	private static ImageIcon bankAccountIcon;
	private static ImageIcon rabattIcon;
	private static ImageIcon fixeKostenIcon;

	//TODO PREREQUISITES: Icon: how to provide icons
	public static Icon getAccountIcon() {
		if (accountIcon == null)
			accountIcon = new ImageIcon(getURL(AccountIcon));
		return accountIcon;
	}
	
	public static Icon getBankAccountIcon() {
		if (bankAccountIcon == null)
			bankAccountIcon = new ImageIcon(getURL(BankAccountIcon));
		return bankAccountIcon;
	}
	
	public static Icon getBankIcon() {
		if (bankIcon == null)
			bankIcon = new ImageIcon(getURL(BankIcon));
		return bankIcon;
	}
	
	public static Icon getFixeKostenIcon() {
		if (fixeKostenIcon == null)
			fixeKostenIcon = new ImageIcon(getURL(FixeKostenIcon));
		return fixeKostenIcon;
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
	
	public static Icon getNochNichtErledigteAuftraegeIcon() {
		if (nochNichtErledigteAuftraegeIcon == null)
			nochNichtErledigteAuftraegeIcon = new ImageIcon(getURL(NochNichtErledigteAuftraegeIcon));
		return nochNichtErledigteAuftraegeIcon;
	}
	
	public static Icon getRabattIcon() {
		if (rabattIcon == null)
			rabattIcon = new ImageIcon(getURL(RabattIcon));
		return rabattIcon;
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