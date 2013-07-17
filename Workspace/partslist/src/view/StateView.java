package view;

import view.objects.*;

import view.visitor.*;

public interface StateView extends Anything, AbstractViewRoot {
    
    public ComponentView getMaster()throws ModelException;
    
    public void accept(StateVisitor visitor) throws ModelException;
    public <R> R accept(StateReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(StateExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(StateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

