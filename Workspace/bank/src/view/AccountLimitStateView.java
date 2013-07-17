package view;

import view.objects.*;

import view.visitor.*;

public interface AccountLimitStateView extends Anything, AbstractViewRoot {
    
    
    public void accept(AccountLimitStateVisitor visitor) throws ModelException;
    public <R> R accept(AccountLimitStateReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AccountLimitStateExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AccountLimitStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

