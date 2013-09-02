package viewClient;

import javax.swing.Icon;

public class IconManager {
	
	private IconManager(){}

	//TODO PREREQUISITES: Icon: how to exploit icon information
	public static Icon getIcon(int iconInfo) {
		switch (iconInfo) {
		case common.IconInfoConstants.BankIconNumber:
			return viewConstants.Resources.getBankIcon();
		case common.IconInfoConstants.MoneyIconNumber:
			return viewConstants.Resources.getKontostandIcon();
		default:
			return null;
		}
	}

}
