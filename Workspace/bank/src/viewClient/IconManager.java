package viewClient;

import javax.swing.Icon;

public class IconManager {
	
	private IconManager(){}

	//TODO PREREQUISITES: Icon: how to exploit icon information
	public static Icon getIcon(int iconInfo) {
		switch (iconInfo) {
		case common.IconInfoConstants.AccountIconNumber:
			return viewConstants.Resources.getAccountIcon();
			
		case common.IconInfoConstants.BankAccountIconNumber:
			return viewConstants.Resources.getBankAccountIcon();
		
		case common.IconInfoConstants.BankIconNumber:
			return viewConstants.Resources.getBankIcon();
			
		case common.IconInfoConstants.EinzugInIconNumber:
			return viewConstants.Resources.getEinzugInIcon();
			
		case common.IconInfoConstants.EinzugOutIconNumber:
			return viewConstants.Resources.getEinzugOutIcon();
			
		case common.IconInfoConstants.FixeKostenIconNumber:
			return viewConstants.Resources.getFixeKostenIcon();
			
		case common.IconInfoConstants.FolgebuchungIconNumber:
			return viewConstants.Resources.getFolgebuchungIcon();
			
		case common.IconInfoConstants.GebührenIconNumber:
			return viewConstants.Resources.getGebührenIcon();
			
		case common.IconInfoConstants.HistorieIconNumber:
			return viewConstants.Resources.getHistorieIcon();
			
		case common.IconInfoConstants.KontostandIconNumber:
			return viewConstants.Resources.getKontostandIcon();
			
		case common.IconInfoConstants.LimitIconNumber:
			return viewConstants.Resources.getLimitIcon();
			
		case common.IconInfoConstants.LimitsIconNumber:
			return viewConstants.Resources.getLimitsIcon();
			
		case common.IconInfoConstants.MixKostenIconNumber:
			return viewConstants.Resources.getMixKostenIcon();
			
		case common.IconInfoConstants.NeutralIconNumber:
			return viewConstants.Resources.getNeutralIcon();
			
		case common.IconInfoConstants.NegativeIconNumber:
			return viewConstants.Resources.getNegativeIcon();
			
		case common.IconInfoConstants.NochNichtErledigteAuftraegeIconNumber:
			return viewConstants.Resources.getNochNichtErledigteAuftraegeIcon();
			
		case common.IconInfoConstants.NoLimitIconNumber:
			return viewConstants.Resources.getNoLimitIcon();
			
		case common.IconInfoConstants.PositiveIconNumber:
			return viewConstants.Resources.getPositiveIcon();
		
		case common.IconInfoConstants.ProzentualeKostenIconNumber:
			return viewConstants.Resources.getProzentualeKostenIcon();
		
		case common.IconInfoConstants.RabattIconNumber:
			return viewConstants.Resources.getRabattIcon();
			
		case common.IconInfoConstants.VorlagenIconNumber:
			return viewConstants.Resources.getVorlagenIcon();
			
		case common.IconInfoConstants.WarningIconNumber:
			return viewConstants.Resources.getWarningIcon();
			
		default:
			return null;
		}
	}

}
