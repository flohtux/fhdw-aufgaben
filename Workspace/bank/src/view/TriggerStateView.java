package view;

import view.objects.*;

import view.visitor.*;

public interface TriggerStateView extends Anything, AbstractViewRoot {
    
    public TriggerView getMaster()throws ModelException;
    
    public void accept(TriggerStateVisitor visitor) throws ModelException;
    public <R> R accept(TriggerStateReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(TriggerStateExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(TriggerStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

