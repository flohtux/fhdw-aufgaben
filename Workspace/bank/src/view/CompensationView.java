package view;

import view.objects.*;

import view.visitor.*;

public interface CompensationView extends Anything, AbstractViewRoot {
    
    public AccountView getRequestingAccount()throws ModelException;
    public void setRequestingAccount(AccountView newValue) throws ModelException ;
    public java.util.Vector<CompensationRequestView> getPendingRequests()throws ModelException;
    public void setPendingRequests(java.util.Vector<CompensationRequestView> newValue) throws ModelException ;
    public CompensationStateView getState()throws ModelException;
    public void setState(CompensationStateView newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

