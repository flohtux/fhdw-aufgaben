package view.objects;

import view.*;
import viewClient.*;

public abstract class ComponentProxi extends ViewProxi implements ComponentView{
    
    public ComponentProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public String getName()throws ModelException{
        return ((Component)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws ModelException {
        ((Component)this.getTheObject()).setName(newValue);
    }
    public StateView getCurrentState()throws ModelException{
        return ((Component)this.getTheObject()).getCurrentState();
    }
    public void setCurrentState(StateView newValue) throws ModelException {
        ((Component)this.getTheObject()).setCurrentState(newValue);
    }
    public java.util.Vector<QPartView> getPartOf()throws ModelException{
        return ((Component)this.getTheObject()).getPartOf();
    }
    
    
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
