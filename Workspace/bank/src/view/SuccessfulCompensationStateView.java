package view;

import view.visitor.*;

public interface SuccessfulCompensationStateView extends CompensationStateView {
    
    
    public void accept(CompensationStateVisitor visitor) throws ModelException;
    public <R> R accept(CompensationStateReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(CompensationStateExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(CompensationStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

