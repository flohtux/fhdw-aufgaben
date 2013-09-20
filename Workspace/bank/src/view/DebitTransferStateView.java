package view;

import view.objects.AbstractViewRoot;
import view.visitor.DebitTransferStateExceptionVisitor;
import view.visitor.DebitTransferStateReturnExceptionVisitor;
import view.visitor.DebitTransferStateReturnVisitor;
import view.visitor.DebitTransferStateVisitor;

public interface DebitTransferStateView extends Anything, AbstractViewRoot {
    
    public DebitTransferTransactionView getDebitTransfer()throws ModelException;
    
    public void accept(DebitTransferStateVisitor visitor) throws ModelException;
    public <R> R accept(DebitTransferStateReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(DebitTransferStateExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(DebitTransferStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

