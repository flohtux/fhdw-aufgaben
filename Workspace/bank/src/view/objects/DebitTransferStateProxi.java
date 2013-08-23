package view.objects;

import view.*;
import viewClient.*;

public abstract class DebitTransferStateProxi extends ViewProxi implements DebitTransferStateView{
    
    public DebitTransferStateProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public DebitTransferView getDebitTransfer()throws ModelException{
        return ((DebitTransferState)this.getTheObject()).getDebitTransfer();
    }
    
    
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
