package view;

import view.objects.AbstractViewRoot;
import view.visitor.CompensationRequestStateExceptionVisitor;
import view.visitor.CompensationRequestStateReturnExceptionVisitor;
import view.visitor.CompensationRequestStateReturnVisitor;
import view.visitor.CompensationRequestStateVisitor;

public interface CompensationRequestStateView extends Anything, AbstractViewRoot {
    
    
    public void accept(CompensationRequestStateVisitor visitor) throws ModelException;
    public <R> R accept(CompensationRequestStateReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(CompensationRequestStateExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(CompensationRequestStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

