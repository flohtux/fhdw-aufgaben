package view.objects;

import view.*;
import viewClient.*;

public abstract class DebitNoteTransferStateProxi extends ViewProxi implements DebitNoteTransferStateView{
    
    public DebitNoteTransferStateProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public DebitNoteTransferStateView getState()throws ModelException{
        return ((DebitNoteTransferState)this.getTheObject()).getState();
    }
    public void setState(DebitNoteTransferStateView newValue) throws ModelException {
        ((DebitNoteTransferState)this.getTheObject()).setState(newValue);
    }
    public StornoStateView getStornoState()throws ModelException{
        return ((DebitNoteTransferState)this.getTheObject()).getStornoState();
    }
    public void setStornoState(StornoStateView newValue) throws ModelException {
        ((DebitNoteTransferState)this.getTheObject()).setStornoState(newValue);
    }
    public DebitNoteTransferStateView getDebitNoteTransfer()throws ModelException{
        return ((DebitNoteTransferState)this.getTheObject()).getDebitNoteTransfer();
    }
    
    
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
