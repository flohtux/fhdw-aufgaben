package viewClient;

import view.Anything;

@SuppressWarnings("serial")
public class CustomTransferDetailPanel extends TransferDefaultDetailPanel {

	protected static final String DebitNoteTransfer$$money = "DebitNoteTransfer$$money";
	
	protected CustomTransferDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
		super(exceptionHandler, anything);
	}
	
	@Override
	protected void addFields() {
		super.addFields();
        try{
            BaseTypePanel panel = new FractionPanel(this, "Betrag in " + this.getAnything().getMoney().getCurrency().toString(), this.getAnything().getMoney().getAmount().getBalance());
            this.getScrollablePane().add(panel);
            this.panels.put(DebitNoteTransfer$$money, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
		
	}

}
