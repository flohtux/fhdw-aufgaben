package view;

import view.visitor.*;

public interface LimitStateView extends AccountLimitStateView {
    
    public AmountView getBalance()throws ModelException;
    public void setBalance(AmountView newValue) throws ModelException ;
    
    public void accept(LimitStateVisitor visitor) throws ModelException;
    public <R> R accept(LimitStateReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(LimitStateExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(LimitStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

