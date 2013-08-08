package viewClient;

import view.Anything;

public class CustomDetailPanels {

}


@SuppressWarnings("serial")
class CustomTransferDetailPanel extends TransferDefaultDetailPanel {

	protected static final String DebitTransfer$$money$$balance = "DebitTransfer$$money$$balance";
	protected static final String DebitTransfer$$money$$currency = "DebitTransfer$$money$$currency";
	
	protected CustomTransferDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
		super(exceptionHandler, anything);
	}
	
	@Override
	protected void addFields() {
		super.addFields();
        try{
            BaseTypePanel panel = new FractionPanel(this, "Betrag", this.getAnything().getMoney().getAmount().getBalance());
            this.getScrollablePane().add(panel);
            this.panels.put(DebitTransfer$$money$$balance, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        try{
            BaseTypePanel panel = new StringPanel(this, "Währung", this.getAnything().getMoney().getCurrency().toString());
            this.getScrollablePane().add(panel);
            this.panels.put(DebitTransfer$$money$$currency, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
	}

}

class CustomMoneyDetailPanel extends MoneyDefaultDetailPanel {
	protected static final String DebitTransfer$$money = "DebitTransfer$$money";
	
	protected CustomMoneyDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
		super(exceptionHandler, anything);
	}
	
	@Override
	protected void addFields() {
		super.addFields();
        try{
            BaseTypePanel panel = new FractionPanel(this, "Betrag in " + this.getAnything().getCurrency().toString(), this.getAnything().getAmount().getBalance());
            this.getScrollablePane().add(panel);
            this.panels.put(DebitTransfer$$money, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
		
	}
}