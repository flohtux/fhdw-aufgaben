package view.objects;

import view.*;
import viewClient.*;

public abstract class TriggerStateProxi extends ViewProxi implements TriggerStateView{
    
    public TriggerStateProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public TriggerView getMaster()throws ModelException{
        return ((TriggerState)this.getTheObject()).getMaster();
    }
    
    
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
