package view.objects;

import view.*;
import viewClient.*;

public abstract class DebitTransferTransactionProxi extends ViewProxi implements DebitTransferTransactionView{
    
    public DebitTransferTransactionProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public java.util.Date getTimestamp()throws ModelException{
        return ((DebitTransferTransaction)this.getTheObject()).getTimestamp();
    }
    public void setTimestamp(java.util.Date newValue) throws ModelException {
        ((DebitTransferTransaction)this.getTheObject()).setTimestamp(newValue);
    }
    public String getSubject()throws ModelException{
        return ((DebitTransferTransaction)this.getTheObject()).getSubject();
    }
    public void setSubject(String newValue) throws ModelException {
        ((DebitTransferTransaction)this.getTheObject()).setSubject(newValue);
    }
    public AccountView getSender()throws ModelException{
        return ((DebitTransferTransaction)this.getTheObject()).getSender();
    }
    public void setSender(AccountView newValue) throws ModelException {
        ((DebitTransferTransaction)this.getTheObject()).setSender(newValue);
    }
    public DebitTransferStateView getState()throws ModelException{
        return ((DebitTransferTransaction)this.getTheObject()).getState();
    }
    public void setState(DebitTransferStateView newValue) throws ModelException {
        ((DebitTransferTransaction)this.getTheObject()).setState(newValue);
    }
    
    
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
