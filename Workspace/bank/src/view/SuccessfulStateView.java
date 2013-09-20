package view;

import view.visitor.*;

public interface SuccessfulStateView extends DebitTransferStateView {
    
    
    public void accept(DebitTransferStateVisitor visitor) throws ModelException;
    public <R> R accept(DebitTransferStateReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(DebitTransferStateExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(DebitTransferStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

