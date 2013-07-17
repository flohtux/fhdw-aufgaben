package view;

import view.visitor.*;

public interface NoLimitStateView extends AccountLimitStateView {
    
    
    public void accept(AccountLimitStateVisitor visitor) throws ModelException;
    public <R> R accept(AccountLimitStateReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AccountLimitStateExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AccountLimitStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

