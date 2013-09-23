package view.objects;

import view.*;
import viewClient.*;

public abstract class StornoStateProxi extends ViewProxi implements StornoStateView{
    
    public StornoStateProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public CompensationView getDebitTransfer()throws ModelException{
        return ((StornoState)this.getTheObject()).getDebitTransfer();
    }
    
    
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
