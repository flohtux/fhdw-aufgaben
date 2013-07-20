package view;

import view.objects.*;

import view.visitor.*;

public interface DebitNoteTransferStateView extends Anything, AbstractViewRoot {
    
    public DebitNoteTransferStateView getState()throws ModelException;
    public void setState(DebitNoteTransferStateView newValue) throws ModelException ;
    public StornoStateView getStornoState()throws ModelException;
    public void setStornoState(StornoStateView newValue) throws ModelException ;
    public DebitNoteTransferStateView getDebitNoteTransfer()throws ModelException;
    
    public void accept(DebitNoteTransferStateVisitor visitor) throws ModelException;
    public <R> R accept(DebitNoteTransferStateReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(DebitNoteTransferStateExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(DebitNoteTransferStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

