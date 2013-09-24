package view.objects;

import view.CompensationStateView;
import view.CompensationView;
import view.ModelException;
import viewClient.ExceptionAndEventHandler;

public abstract class CompensationStateProxi extends ViewProxi implements CompensationStateView{
    
    public CompensationStateProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public CompensationView getCompensation()throws ModelException{
        return ((CompensationState)this.getTheObject()).getCompensation();
    }
    
    
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
