package view.objects;

import view.*;
import viewClient.*;

public abstract class DebitNoteTransferStateProxi extends ViewProxi implements DebitNoteTransferStateView{
    
    public DebitNoteTransferStateProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public DebitNoteTransferView getDebitNoteTransfer()throws ModelException{
        return ((DebitNoteTransferState)this.getTheObject()).getDebitNoteTransfer();
    }
    
    
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
