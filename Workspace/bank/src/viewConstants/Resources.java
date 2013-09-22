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
	private static final String ProzentualeKostenIcon = Resources + "/prozent.png";
	private static final String MixKostenIcon = Resources + "/mixKosten.png";
	private static final String PositiveIcon = Resources + "/positive.gif";
	private static final String NeutralIcon = Resources + "/neutral.gif";
	private static final String NegativeIcon = Resources + "/negativ.gif";
	private static final String WarningIcon = Resources + "/warning.png";
	private static final String EinzugInIcon = Resources + "/einzugEingehend.png";
	private static final String EinzugOutIcon = Resources + "/einzugAusgehend.png";
	private static final String GebührenIcon = Resources + "/coins.png";
	private static final String FolgebuchungIcon = Resources + "/folgebuchung.png";
	private static final String LimitIcon = Resources + "/limit.gif";
	private static final String NoLimitIcon = Resources + "/noLimit.gif";
	private static final String KompensationIcon = Resources + "/mailSendReceive.png";
	private static final String KompensationOutIcon = Resources + "/mailSend.png";
	private static final String KompensationInIcon = Resources + "/mailGet.png";
	private static final String AbgelehntIcon = Resources + "/abgelehnt.png";
	private static final String AngenommenIcon = Resources + "/angenommen.png";
	private static final String WartenIcon = Resources + "/warten.png";

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
	private static ImageIcon prozentualeKostenIcon;
	private static ImageIcon mixKostenIcon;
	private static ImageIcon positiveIcon;
	private static ImageIcon neutralIcon;
	private static ImageIcon negativeIcon;
	private static ImageIcon warningIcon;
	private static ImageIcon einzugInIcon;
	private static ImageIcon einzugOutIcon;
	private static ImageIcon gebührenIcon;
	private static ImageIcon folgebuchungIcon;
	private static ImageIcon limitIcon;
	private static ImageIcon noLimitIcon;
	private static ImageIcon kompensationIcon;
	private static ImageIcon kompensationOutIcon;
	private static ImageIcon kompensationInIcon;
	private static ImageIcon abgelehntIcon;
	private static ImageIcon angenommenIcon;
	private static ImageIcon wartenIcon;

	//TODO PREREQUISITES: Icon: how to provide icons
	public static Icon getWartenIcon() {
		if (wartenIcon == null)
			wartenIcon = new ImageIcon(getURL(WartenIcon));
		return wartenIcon;
	}
	
	public static Icon getAngenommenIcon() {
		if (angenommenIcon == null)
			angenommenIcon = new ImageIcon(getURL(AngenommenIcon));
		return angenommenIcon;
	}
	
	public static Icon getAbgelehntIcon() {
		if (abgelehntIcon == null)
			abgelehntIcon = new ImageIcon(getURL(AbgelehntIcon));
		return abgelehntIcon;
	}
	
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
	
	public static Icon getEinzugInIcon() {
		if (einzugInIcon == null)
			einzugInIcon = new ImageIcon(getURL(EinzugInIcon));
		return einzugInIcon;
	}
	
	public static Icon getEinzugOutIcon() {
		if (einzugOutIcon == null)
			einzugOutIcon = new ImageIcon(getURL(EinzugOutIcon));
		return einzugOutIcon;
	}
	
	public static Icon getFixeKostenIcon() {
		if (fixeKostenIcon == null)
			fixeKostenIcon = new ImageIcon(getURL(FixeKostenIcon));
		return fixeKostenIcon;
	}
	
	public static Icon getFolgebuchungIcon() {
		if (folgebuchungIcon == null)
			folgebuchungIcon = new ImageIcon(getURL(FolgebuchungIcon));
		return folgebuchungIcon;
	}
	
	public static Icon getGebührenIcon() {
		if (gebührenIcon == null)
			gebührenIcon = new ImageIcon(getURL(GebührenIcon));
		return gebührenIcon;
	}
	
	public static Icon getHistorieIcon() {
		if (historieIcon == null)
			historieIcon = new ImageIcon(getURL(HistorieIcon));
		return historieIcon;
	}
	
	public static Icon getKompensationIcon() {
		if (kompensationIcon == null)
			kompensationIcon = new ImageIcon(getURL(KompensationIcon));
		return kompensationIcon;
		}
	
	public static Icon getKompensationInIcon() {
		if (kompensationInIcon == null)
			kompensationInIcon = new ImageIcon(getURL(KompensationInIcon));
		return kompensationInIcon;
		}
	
	public static Icon getKompensationOutIcon() {
		if (kompensationOutIcon == null)
			kompensationOutIcon = new ImageIcon(getURL(KompensationOutIcon));
		return kompensationOutIcon;
		}
		
	public static Icon getKontostandIcon() {
		if (kontostandIcon == null)
			kontostandIcon = new ImageIcon(getURL(KontostandIcon));
		return kontostandIcon;
		}
	
	public static Icon getLimitIcon() {
		if (limitIcon == null)
			limitIcon = new ImageIcon(getURL(LimitIcon));
		return limitIcon;
	}
	
	public static Icon getLimitsIcon() {
		if (limitsIcon == null)
			limitsIcon = new ImageIcon(getURL(LimitsIcon));
		return limitsIcon;
	}
	
	public static Icon getMixKostenIcon() {
		if (mixKostenIcon == null)
			mixKostenIcon = new ImageIcon(getURL(MixKostenIcon));
		return mixKostenIcon;
	}
	
	public static Icon getNegativeIcon() {
		if (negativeIcon == null)
			negativeIcon = new ImageIcon(getURL(NegativeIcon));
		return negativeIcon;
	}
	
	public static Icon getNeutralIcon() {
		if (neutralIcon == null)
			neutralIcon = new ImageIcon(getURL(NeutralIcon));
		return neutralIcon;
	}
	
	public static Icon getNochNichtErledigteAuftraegeIcon() {
		if (nochNichtErledigteAuftraegeIcon == null)
			nochNichtErledigteAuftraegeIcon = new ImageIcon(getURL(NochNichtErledigteAuftraegeIcon));
		return nochNichtErledigteAuftraegeIcon;
	}
	
	public static Icon getNoLimitIcon() {
		if (noLimitIcon == null)
			noLimitIcon = new ImageIcon(getURL(NoLimitIcon));
		return noLimitIcon;
	}
	
	public static Icon getProzentualeKostenIcon() {
		if (prozentualeKostenIcon == null)
			prozentualeKostenIcon = new ImageIcon(getURL(ProzentualeKostenIcon));
		return prozentualeKostenIcon;
	}
	
	public static Icon getPositiveIcon() {
		if (positiveIcon == null)
			positiveIcon = new ImageIcon(getURL(PositiveIcon));
		return positiveIcon;
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
	
	public static Icon getWarningIcon() {
		if (warningIcon == null)
			warningIcon = new ImageIcon(getURL(WarningIcon));
		return warningIcon;
	}
	
	private static URL getURL(String path) {
		return Resources.class.getClassLoader().getResource(path);
	}
	private Resources() {
	}

}