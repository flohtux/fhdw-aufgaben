package view;

import view.objects.*;

import view.visitor.*;

public interface LimitAccountView extends Anything, AbstractViewRoot {
    
    public LimitTypeView getMinLimit()throws ModelException;
    public void setMinLimit(LimitTypeView newValue) throws ModelException ;
    public LimitTypeView getMaxLimit()throws ModelException;
    public void setMaxLimit(LimitTypeView newValue) throws ModelException ;
    public AccountView getAccount()throws ModelException;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

