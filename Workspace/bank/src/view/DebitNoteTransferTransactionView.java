package view;

import view.objects.*;

import view.visitor.*;

public interface DebitNoteTransferTransactionView extends Anything, AbstractViewRoot {
    
    public java.util.Date getTimestamp()throws ModelException;
    public void setTimestamp(java.util.Date newValue) throws ModelException ;
    
    public void accept(DebitNoteTransferTransactionVisitor visitor) throws ModelException;
    public <R> R accept(DebitNoteTransferTransactionReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(DebitNoteTransferTransactionExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(DebitNoteTransferTransactionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

