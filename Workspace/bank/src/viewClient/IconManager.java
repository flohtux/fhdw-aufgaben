package viewClient;

import javax.swing.Icon;

public class IconManager {
	
	private IconManager(){}

	//TODO PREREQUISITES: Icon: how to exploit icon information
	public static Icon getIcon(int iconInfo) {
		switch (iconInfo) {
		case common.IconInfoConstants.AccountIconNumber:
			return viewConstants.Resources.getAccountIcon();
		
		case common.IconInfoConstants.BankIconNumber:
			return viewConstants.Resources.getBankIcon();
			
		case common.IconInfoConstants.HistorieIconNumber:
			return viewConstants.Resources.getHistorieIcon();
			
		case common.IconInfoConstants.KontostandIconNumber:
			return viewConstants.Resources.getKontostandIcon();
			
		case common.IconInfoConstants.LimitsIconNumber:
			return viewConstants.Resources.getLimitsIcon();
			
		case common.IconInfoConstants.VorlagenIconNumber:
			return viewConstants.Resources.getVorlagenIcon();
			
		default:
			return null;
		}
	}

}
