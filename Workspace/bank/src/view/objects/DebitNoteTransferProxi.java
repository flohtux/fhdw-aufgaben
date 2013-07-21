package view.objects;

import view.*;
import viewClient.*;

public abstract class DebitNoteTransferProxi extends DebitNoteTransferTransactionProxi implements DebitNoteTransferView{
    
    public DebitNoteTransferProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public long getReceiverAccountNumber()throws ModelException{
        return ((DebitNoteTransfer)this.getTheObject()).getReceiverAccountNumber();
    }
    public void setReceiverAccountNumber(long newValue) throws ModelException {
        ((DebitNoteTransfer)this.getTheObject()).setReceiverAccountNumber(newValue);
    }
    public long getReceiverBankNumber()throws ModelException{
        return ((DebitNoteTransfer)this.getTheObject()).getReceiverBankNumber();
    }
    public void setReceiverBankNumber(long newValue) throws ModelException {
        ((DebitNoteTransfer)this.getTheObject()).setReceiverBankNumber(newValue);
    }
    public AccountView getSender()throws ModelException{
        return ((DebitNoteTransfer)this.getTheObject()).getSender();
    }
    public void setSender(AccountView newValue) throws ModelException {
        ((DebitNoteTransfer)this.getTheObject()).setSender(newValue);
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
