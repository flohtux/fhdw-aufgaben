package view;

import view.visitor.*;

public interface DebitNoteView extends DebitNoteTransactionView {
    
    
    public void accept(DebitNoteTransactionVisitor visitor) throws ModelException;
    public <R> R accept(DebitNoteTransactionReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(DebitNoteTransactionExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(DebitNoteTransactionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

