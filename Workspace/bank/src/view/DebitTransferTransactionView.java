package view;

import view.objects.*;

import view.visitor.*;

public interface DebitTransferTransactionView extends Anything, AbstractViewRoot {
    
    public java.util.Date getTimestamp()throws ModelException;
    public void setTimestamp(java.util.Date newValue) throws ModelException ;
    
    public void accept(DebitTransferTransactionVisitor visitor) throws ModelException;
    public <R> R accept(DebitTransferTransactionReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(DebitTransferTransactionExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(DebitTransferTransactionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

