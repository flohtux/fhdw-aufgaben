package view;

import view.objects.*;

import view.visitor.*;

public interface CompensationStateView extends Anything, AbstractViewRoot {
    
    public CompensationView getCompensation()throws ModelException;
    
    public void accept(CompensationStateVisitor visitor) throws ModelException;
    public <R> R accept(CompensationStateReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(CompensationStateExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(CompensationStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

