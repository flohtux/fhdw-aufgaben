package view.objects;

import view.*;
import viewClient.*;

public abstract class DebitNoteTransactionProxi extends ViewProxi implements DebitNoteTransactionView{
    
    public DebitNoteTransactionProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public long getBankNumber()throws ModelException{
        return ((DebitNoteTransaction)this.getTheObject()).getBankNumber();
    }
    public void setBankNumber(long newValue) throws ModelException {
        ((DebitNoteTransaction)this.getTheObject()).setBankNumber(newValue);
    }
    public long getAccountNumber()throws ModelException{
        return ((DebitNoteTransaction)this.getTheObject()).getAccountNumber();
    }
    public void setAccountNumber(long newValue) throws ModelException {
        ((DebitNoteTransaction)this.getTheObject()).setAccountNumber(newValue);
    }
    public MoneyView getMoney()throws ModelException{
        return ((DebitNoteTransaction)this.getTheObject()).getMoney();
    }
    public void setMoney(MoneyView newValue) throws ModelException {
        ((DebitNoteTransaction)this.getTheObject()).setMoney(newValue);
    }
    
    
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
