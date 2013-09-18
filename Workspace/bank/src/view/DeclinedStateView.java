package view;

import view.visitor.*;

public interface DeclinedStateView extends CompensationRequestStateView {
    
    
    public void accept(CompensationRequestStateVisitor visitor) throws ModelException;
    public <R> R accept(CompensationRequestStateReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(CompensationRequestStateExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(CompensationRequestStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

