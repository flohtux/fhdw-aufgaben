package view.objects;

import view.*;
import viewClient.*;

public abstract class RuleProxi extends ViewProxi implements RuleView{
    
    public RuleProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public TriggerView getMasterTrigger()throws ModelException{
        return ((Rule)this.getTheObject()).getMasterTrigger();
    }
    
    
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
