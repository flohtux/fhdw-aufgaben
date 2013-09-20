package view;

import view.objects.AbstractViewRoot;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;

public interface DebitTransferDoubleStateView extends Anything, AbstractViewRoot {
    
    public DebitTransferStateView getDebitTransferStateOld()throws ModelException;
    public void setDebitTransferStateOld(DebitTransferStateView newValue) throws ModelException ;
    public DebitTransferStateView getDebitTransferStateNew()throws ModelException;
    public void setDebitTransferStateNew(DebitTransferStateView newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

