package view.objects;

import view.*;
import viewClient.*;

public abstract class DebitNoteTransferTransactionProxi extends ViewProxi implements DebitNoteTransferTransactionView{
    
    public DebitNoteTransferTransactionProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public java.util.Date getTimestamp()throws ModelException{
        return ((DebitNoteTransferTransaction)this.getTheObject()).getTimestamp();
    }
    public void setTimestamp(java.util.Date newValue) throws ModelException {
        ((DebitNoteTransferTransaction)this.getTheObject()).setTimestamp(newValue);
    }
    
    
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
