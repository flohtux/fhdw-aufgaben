package view;

import view.objects.*;

import view.visitor.*;

public interface DebitTransferTransactionView extends Anything, AbstractViewRoot {
    
    public java.util.Date getTimestamp()throws ModelException;
    public void setTimestamp(java.util.Date newValue) throws ModelException ;
    public AccountView getSender()throws ModelException;
    public void setSender(AccountView newValue) throws ModelException ;
    public DebitTransferStateView getState()throws ModelException;
    public void setState(DebitTransferStateView newValue) throws ModelException ;
    
    public void accept(DebitTransferTransactionVisitor visitor) throws ModelException;
    public <R> R accept(DebitTransferTransactionReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(DebitTransferTransactionExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(DebitTransferTransactionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

