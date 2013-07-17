package view;

import view.visitor.*;

public interface MinLimitStateView extends LimitStateView {
    
    
    public void accept(LimitStateVisitor visitor) throws ModelException;
    public <R> R accept(LimitStateReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(LimitStateExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(LimitStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AccountLimitStateVisitor visitor) throws ModelException;
    public <R> R accept(AccountLimitStateReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AccountLimitStateExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AccountLimitStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

