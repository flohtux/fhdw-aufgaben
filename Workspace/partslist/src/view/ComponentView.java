package view;

import view.objects.*;

import view.visitor.*;

public interface ComponentView extends Anything, AbstractViewRoot {
    
    public String getName()throws ModelException;
    public void setName(String newValue) throws ModelException ;
    public StateView getCurrentState()throws ModelException;
    public void setCurrentState(StateView newValue) throws ModelException ;
    public java.util.Vector<QPartView> getPartOf()throws ModelException;
    
    public void accept(ComponentVisitor visitor) throws ModelException;
    public <R> R accept(ComponentReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(ComponentExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(ComponentReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

