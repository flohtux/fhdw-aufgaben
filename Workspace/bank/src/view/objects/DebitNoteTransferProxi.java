package view.objects;

import view.*;
import viewClient.*;

public abstract class DebitNoteTransferProxi extends DebitNoteTransferTransactionProxi implements DebitNoteTransferView{
    
    public DebitNoteTransferProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public AccountView getSender()throws ModelException{
        return ((DebitNoteTransfer)this.getTheObject()).getSender();
    }
    public void setSender(AccountView newValue) throws ModelException {
        ((DebitNoteTransfer)this.getTheObject()).setSender(newValue);
    }
    public AccountView getReceiver()throws ModelException{
        return ((DebitNoteTransfer)this.getTheObject()).getReceiver();
    }
    public void setReceiver(AccountView newValue) throws ModelException {
        ((DebitNoteTransfer)this.getTheObject()).setReceiver(newValue);
    }
    public MoneyView getMoney()throws ModelException{
        return ((DebitNoteTransfer)this.getTheObject()).getMoney();
    }
    public void setMoney(MoneyView newValue) throws ModelException {
        ((DebitNoteTransfer)this.getTheObject()).setMoney(newValue);
    }
    
    
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
