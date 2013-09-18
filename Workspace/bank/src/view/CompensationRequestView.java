package view;

import view.objects.*;

import view.visitor.*;

public interface CompensationRequestView extends Anything, AbstractViewRoot {
    
    public DebitTransferTransactionView getDebitTransferTransaction()throws ModelException;
    public void setDebitTransferTransaction(DebitTransferTransactionView newValue) throws ModelException ;
    public CompensationView getMasterCompensation()throws ModelException;
    public void setMasterCompensation(CompensationView newValue) throws ModelException ;
    public CompensationRequestStateView getState()throws ModelException;
    public void setState(CompensationRequestStateView newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

