package view;

import view.objects.*;

import view.visitor.*;

public interface CompensationRequestStateView extends Anything, AbstractViewRoot {
    
    
    public void accept(CompensationRequestStateVisitor visitor) throws ModelException;
    public <R> R accept(CompensationRequestStateReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(CompensationRequestStateExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(CompensationRequestStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

