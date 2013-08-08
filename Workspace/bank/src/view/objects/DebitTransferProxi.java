package view.objects;

import view.*;
import viewClient.*;

public abstract class DebitTransferProxi extends DebitTransferTransactionProxi implements DebitTransferView{
    
    public DebitTransferProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public long getReceiverAccountNumber()throws ModelException{
        return ((DebitTransfer)this.getTheObject()).getReceiverAccountNumber();
    }
    public void setReceiverAccountNumber(long newValue) throws ModelException {
        ((DebitTransfer)this.getTheObject()).setReceiverAccountNumber(newValue);
    }
    public long getReceiverBankNumber()throws ModelException{
        return ((DebitTransfer)this.getTheObject()).getReceiverBankNumber();
    }
    public void setReceiverBankNumber(long newValue) throws ModelException {
        ((DebitTransfer)this.getTheObject()).setReceiverBankNumber(newValue);
    }
    public AccountView getSender()throws ModelException{
        return ((DebitTransfer)this.getTheObject()).getSender();
    }
    public void setSender(AccountView newValue) throws ModelException {
        ((DebitTransfer)this.getTheObject()).setSender(newValue);
    }
    public MoneyView getMoney()throws ModelException{
        return ((DebitTransfer)this.getTheObject()).getMoney();
    }
    public void setMoney(MoneyView newValue) throws ModelException {
        ((DebitTransfer)this.getTheObject()).setMoney(newValue);
    }
    public String getSubject()throws ModelException{
        return ((DebitTransfer)this.getTheObject()).getSubject();
    }
    public void setSubject(String newValue) throws ModelException {
        ((DebitTransfer)this.getTheObject()).setSubject(newValue);
    }
    public DebitTransferStateView getState()throws ModelException{
        return ((DebitTransfer)this.getTheObject()).getState();
    }
    public void setState(DebitTransferStateView newValue) throws ModelException {
        ((DebitTransfer)this.getTheObject()).setState(newValue);
    }
    public StornoStateView getStornoState()throws ModelException{
        return ((DebitTransfer)this.getTheObject()).getStornoState();
    }
    public void setStornoState(StornoStateView newValue) throws ModelException {
        ((DebitTransfer)this.getTheObject()).setStornoState(newValue);
    }
    
    
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
