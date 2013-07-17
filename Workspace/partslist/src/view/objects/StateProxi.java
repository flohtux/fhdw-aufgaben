package view.objects;

import view.*;
import viewClient.*;

public abstract class StateProxi extends ViewProxi implements StateView{
    
    public StateProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public ComponentView getMaster()throws ModelException{
        return ((State)this.getTheObject()).getMaster();
    }
    
    
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
