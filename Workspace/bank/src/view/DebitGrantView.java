package view;

import view.objects.*;

import view.visitor.*;

public interface DebitGrantView extends Anything, AbstractViewRoot {
    
    public AccountPxView getPermittedAccount()throws ModelException;
    public void setPermittedAccount(AccountPxView newValue) throws ModelException ;
    public LimitTypeView getLimits()throws ModelException;
    public void setLimits(LimitTypeView newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

