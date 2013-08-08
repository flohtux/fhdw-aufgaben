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
    
    
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
