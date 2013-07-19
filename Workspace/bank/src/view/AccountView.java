package view;

import view.objects.*;

import view.visitor.*;

public interface AccountView extends Anything, AbstractViewRoot {
    
    public long getAccountNumber()throws ModelException;
    public void setAccountNumber(long newValue) throws ModelException ;
    public MoneyView getMoney()throws ModelException;
    public void setMoney(MoneyView newValue) throws ModelException ;
    public AccountLimitStateView getFirstLimit()throws ModelException;
    public void setFirstLimit(AccountLimitStateView newValue) throws ModelException ;
    public AccountLimitStateView getSecondLimit()throws ModelException;
    public void setSecondLimit(AccountLimitStateView newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}
