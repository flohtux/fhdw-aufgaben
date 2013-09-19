package view.objects;

import view.*;
import viewClient.*;

public abstract class CompensationRequestStateProxi extends ViewProxi implements CompensationRequestStateView{
    
    public CompensationRequestStateProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    
    
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
