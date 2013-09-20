package view;

import view.visitor.*;

public interface DebitView extends DebitTransferView {
    
    
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

