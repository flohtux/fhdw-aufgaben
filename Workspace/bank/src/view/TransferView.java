package view;

import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;
import view.visitor.DebitTransferExceptionVisitor;
import view.visitor.DebitTransferReturnExceptionVisitor;
import view.visitor.DebitTransferReturnVisitor;
import view.visitor.DebitTransferTransactionExceptionVisitor;
import view.visitor.DebitTransferTransactionReturnExceptionVisitor;
import view.visitor.DebitTransferTransactionReturnVisitor;
import view.visitor.DebitTransferTransactionVisitor;
import view.visitor.DebitTransferVisitor;

public interface TransferView extends DebitTransferView {
    
    
    public void accept(DebitTransferVisitor visitor) throws ModelException;
    public <R> R accept(DebitTransferReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(DebitTransferExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(DebitTransferReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(DebitTransferTransactionVisitor visitor) throws ModelException;
    public <R> R accept(DebitTransferTransactionReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(DebitTransferTransactionExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(DebitTransferTransactionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

